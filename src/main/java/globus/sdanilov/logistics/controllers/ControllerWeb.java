package globus.sdanilov.logistics.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import globus.sdanilov.logistics.emulator.EmulatorConfig;
import globus.sdanilov.logistics.emulator.EmulatorService;
import globus.sdanilov.logistics.models.SensorSnapshotModel;
import globus.sdanilov.logistics.repositories.SensorValuesRepository;
import globus.sdanilov.logistics.structs.SensorValueCollectorReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

@RestController
public class ControllerWeb {
    @Autowired
    private SensorValuesRepository repository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private boolean emulatorActivated = false;

    @PostMapping("/sensors/setup")
    public String launchEmulators(@RequestBody EmulatorConfig config) throws HttpRequestMethodNotSupportedException {
        if (emulatorActivated){
            throw new HttpRequestMethodNotSupportedException("Emulator already started");
        }
        EmulatorService service = new EmulatorService(config);
        service.launchEmulator();
        emulatorActivated = true;
        return "ok";
    }

    @GetMapping("/sensors/values/filtered")
    public List<SensorSnapshotModel> getSensorsValues(@RequestBody long start, long end){
        return repository.findByTimeBetween(start, end);
    }

    @GetMapping("/sensors/values")
    public List<SensorSnapshotModel> getSensorsValues(){
        return repository.findAll();
    }

    @PostMapping( value = "/sensors/report")
    public String postSensorsReport(@RequestBody List<SensorValueCollectorReport> report) throws IOException {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, report);
        String result = writer.toString();
        kafkaTemplate.send("sensors-report", result);
        return "ok";
    }

}

package globus.sdanilov.logistics.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import globus.sdanilov.logistics.models.SensorSnapshotModel;
import globus.sdanilov.logistics.repositories.SensorValuesRepository;
import globus.sdanilov.logistics.structs.SensorValueCollectorReport;
import globus.sdanilov.logistics.structs.Snapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

@Service
public class KafkaService {

    @Autowired
    private SensorValuesRepository repository;

    @KafkaListener(topics = "sensors-report")
    public void listenSensorsReport(String jsonString) throws IOException {
        StringReader reader = new StringReader(jsonString);
        ObjectMapper mapper = new ObjectMapper();
        List<SensorValueCollectorReport> report = null;
        try {
            report = mapper.readValue(reader, mapper.getTypeFactory().constructCollectionType(List.class,SensorValueCollectorReport.class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (SensorValueCollectorReport ctr: report){
            for (Snapshot snp : ctr.getSnapshots()){
                for (int id = 0; id < snp.getValues().size(); id++){
                    repository.save(new SensorSnapshotModel(snp.getTime(),
                            ctr.getContainerId(),
                            id, snp.getValues().get(id)));
                }
            }
        }
    }
}

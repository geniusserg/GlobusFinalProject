package globus.sdanilov.logistics.controllers;

import globus.sdanilov.logistics.config.EmulatorConfig;
import globus.sdanilov.logistics.models.SensorSnapshotModel;
import globus.sdanilov.logistics.repositories.SensorValuesRepository;
import globus.sdanilov.logistics.structs.SensorValueCollectorReport;
import globus.sdanilov.logistics.structs.Snapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerWeb {
    @Autowired
    private SensorValuesRepository repository;

    @GetMapping("/sensors/values")
    public List<SensorSnapshotModel> getSensorsValues(){
        return repository.findAll();
    }

    @PostMapping( value = "/sensors/report")
    public String postSensorsReport(@RequestBody List<SensorValueCollectorReport> report){
        for (SensorValueCollectorReport ctr: report){
            for (Snapshot snp : ctr.getSnapshots()){
                for (int id = 0; id < snp.getValues().size(); id++){
                    repository.save(new SensorSnapshotModel(snp.getTime(),
                                                            ctr.getContainerId(),
                                                            id, snp.getValues().get(id)));
                }
            }
        }
        return "ok";
    }

}

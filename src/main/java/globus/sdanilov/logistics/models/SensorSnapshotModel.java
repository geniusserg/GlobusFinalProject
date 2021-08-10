package globus.sdanilov.logistics.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class SensorSnapshotModel {
    @Id
    @GeneratedValue
    private int id;
    private int sensorId;
    private float time;
    private float value;

    public SensorSnapshotModel() {

    }

    public SensorSnapshotModel(int id, int sensorId, float time, float value) {
        this.id = id;
        this.sensorId = sensorId;
        this.time = time;
        this.value = value;
    }
}

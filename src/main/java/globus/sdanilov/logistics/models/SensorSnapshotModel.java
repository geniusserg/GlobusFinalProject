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
    private int containerId;
    private int sensorId;
    private long time;
    private float value;

    public SensorSnapshotModel() {

    }

    public SensorSnapshotModel( long time, int containerId, int sensorId, float value) {
        this.containerId = containerId;
        this.sensorId = sensorId;
        this.time = time;
        this.value = value;
    }
}

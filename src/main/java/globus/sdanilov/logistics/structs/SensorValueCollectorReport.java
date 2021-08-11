package globus.sdanilov.logistics.structs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class SensorValueCollectorReport implements Serializable {
    private int containerId;
    private List<Snapshot> snapshots;
}

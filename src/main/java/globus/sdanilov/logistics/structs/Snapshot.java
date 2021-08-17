package globus.sdanilov.logistics.structs;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class Snapshot implements Serializable {
    private long time;
    private List<Float> values;
    Snapshot(){}
}

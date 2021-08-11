package globus.sdanilov.logistics.structs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class EmulatorParameters implements Serializable {
    private int containerValue;
    private float time;
    private float maxContainerOffset;
    private float frequency;
    private int stepsValue;
    private int syncInterval;
    private List<Parameter> parameters;
}

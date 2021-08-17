package globus.sdanilov.logistics.emulator;

import globus.sdanilov.logistics.structs.Parameter;
import lombok.Data;

import java.io.*;
import java.util.List;

@Data
public class EmulatorConfig implements Serializable {
    private int containerValue;
    private float maxContainerOffset;
    private float frequency;
    private int stepsValue;
    private float syncInterval;
    private List<Parameter> parameters;

    public EmulatorConfig(){
    }
}

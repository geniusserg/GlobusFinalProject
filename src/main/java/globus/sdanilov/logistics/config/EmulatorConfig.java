package globus.sdanilov.logistics.config;

import globus.sdanilov.logistics.structs.Parameter;
import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class EmulatorConfig {
    private int containerValue;
    private float time;
    private float maxContainerOffset;
    private float frequency;
    private int stepsValue;
    private float syncInterval;
    private List<Parameter> parameters;

    //TODO: load from config
    public EmulatorConfig(){
        containerValue = 1;
        time = 0.9f;
        maxContainerOffset = 2.3f;
        frequency = 5.0f;
        stepsValue = 10;
        syncInterval = 8.0f;
        parameters  = new ArrayList<Parameter>();
        parameters.add(new Parameter(0,"temperature", 15.0f, 10.0f));
        parameters.add(new Parameter(1,"vlazhnost", 15.0f, 10.0f));
    }
}

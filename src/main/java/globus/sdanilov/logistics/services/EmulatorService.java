package globus.sdanilov.logistics.services;

import globus.sdanilov.logistics.config.EmulatorConfig;
import globus.sdanilov.logistics.emulator.Emulator;
import globus.sdanilov.logistics.emulator.SensorValueCollector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmulatorService {

    @Autowired
    private EmulatorConfig config;

    private List<Emulator> containers;
    private SensorValueCollector collector;

    @Bean
    public void launchEmulator(){
        containers = new ArrayList<Emulator>();
        for (int container = 0; container < config.getContainerValue(); container++){
            Emulator emulator = new Emulator();
            containers.add(emulator);
        }
        collector = new SensorValueCollector(containers);
        new Thread(collector).start();
        for (Emulator container: containers){
            new Thread(container).start();
        }

    }
}

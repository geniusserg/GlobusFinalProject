package globus.sdanilov.logistics.emulator;

import java.util.ArrayList;
import java.util.List;

public class EmulatorService {

    private EmulatorConfig config;
    private List<Emulator> containers;
    private SensorValueCollector collector;

    public EmulatorService (EmulatorConfig config) {
        this.config = config;
    }

    public void launchEmulator(){
        containers = new ArrayList<Emulator>();
        System.out.println(config.getContainerValue());
        for (int container = 0; container < config.getContainerValue(); container++){
            Emulator emulator = new Emulator(config);
            containers.add(emulator);
        }
        collector = new SensorValueCollector(containers, config);
        new Thread(collector).start();
        for (Emulator container: containers){
            new Thread(container).start();
        }
    }

    // Can be executed independently
    public static void main(String[] args) {
        new EmulatorService(new EmulatorConfig());
    }
}

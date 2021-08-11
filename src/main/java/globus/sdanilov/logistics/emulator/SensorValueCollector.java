package globus.sdanilov.logistics.emulator;

import globus.sdanilov.logistics.config.EmulatorConfig;
import globus.sdanilov.logistics.structs.SensorValueCollectorReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class SensorValueCollector implements Runnable{

    private EmulatorConfig config;
    private List<Emulator> sensors;
    public SensorValueCollector(List<Emulator> sensors){
        this.config = new EmulatorConfig();
        this.sensors = sensors;
    }
    @Override
    public void run() {
        for (int step = 0; step < config.getStepsValue(); step++) {
            try {
                Thread.sleep((long) (config.getSyncInterval() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (Emulator emu : sensors) {
                if (emu.snapshots.size() != 0) {
                    SensorValueCollectorReport report = new SensorValueCollectorReport(emu.getContainerId(), emu.snapshots);

                }
            }
        }
    }
}

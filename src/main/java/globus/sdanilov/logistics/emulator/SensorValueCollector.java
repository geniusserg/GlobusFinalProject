package globus.sdanilov.logistics.emulator;

import globus.sdanilov.logistics.structs.SensorValueCollectorReport;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class SensorValueCollector implements Runnable{

    private EmulatorConfig config;
    private List<Emulator> sensors;
    private List<SensorValueCollectorReport> result;
    private final String URL = "http://localhost:8080/sensors/report";
    private boolean isFinished;
    public SensorValueCollector(List<Emulator> sensors, EmulatorConfig config){
        this.config = config;
        this.sensors = sensors;
    }

    public void sendReportToAPI(List<SensorValueCollectorReport> result){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(URL, result, String.class);
    }

    @Override
    public void run() {
        while (true) {
            result = new ArrayList<>();
            try {
                Thread.sleep((long) (config.getSyncInterval() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            if (sensors.isEmpty()){break;}
            int sensorsCounter = 0;
            for (Emulator emu: sensors) {
                if (!emu.snapshots.isEmpty()) {
                    SensorValueCollectorReport report = new SensorValueCollectorReport(emu.getContainerId(), new ArrayList<>(emu.snapshots));
                    result.add(report);
                    emu.snapshots.clear();
                }
                if (emu.isFinished()){
                    sensorsCounter++;
                }
            }
            sendReportToAPI(result);
            if (sensorsCounter==config.getContainerValue()){
                break;
            }
        }
    }
}

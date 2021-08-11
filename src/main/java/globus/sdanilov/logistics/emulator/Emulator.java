package globus.sdanilov.logistics.emulator;

import globus.sdanilov.logistics.config.EmulatorConfig;
import globus.sdanilov.logistics.structs.EmulatorParameters;
import globus.sdanilov.logistics.structs.Parameter;
import globus.sdanilov.logistics.structs.Snapshot;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Emulator implements Runnable{

    private EmulatorConfig params;
    private Random random;
    private Date date;

    public List<Snapshot>  snapshots = new ArrayList<Snapshot>();
    private int containerId;

    public int getContainerId() {
        return containerId;
    }

    @Override
    public void run() {
        params = new EmulatorConfig();
        random = new Random();
        date = new Date();
        random.setSeed(date.getTime());
        for (int step = 0; step < params.getStepsValue(); step++){
            float nextSnapshotTime = params.getMaxContainerOffset()*random.nextFloat();
            try {
                // wait for random time before snapshot
                Thread.sleep((long)(nextSnapshotTime*1000.0));
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }

            //generate new value
            List<Float> values = new ArrayList<>();
            for (Parameter p : params.getParameters()) {
                float generatedValue = (float) (p.getAverage() + (2.0*random.nextFloat() - 1.0)*p.getDifference());
                values.add(generatedValue);
                System.out.println(("Generated value "+Float.toString(generatedValue)));
            }
            snapshots.add(new Snapshot(date.getTime(), values));

            //wait for next iteration
            try {
                Thread.sleep((long)((params.getFrequency()-nextSnapshotTime)*1000.0));
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }

        }

    }
}

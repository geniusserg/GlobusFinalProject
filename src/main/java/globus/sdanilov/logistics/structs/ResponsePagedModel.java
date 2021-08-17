package globus.sdanilov.logistics.structs;

import globus.sdanilov.logistics.models.SensorSnapshotModel;
import org.springframework.beans.factory.annotation.Autowired;

public class ResponsePagedModel extends SensorSnapshotModel {
    private long page;
    public ResponsePagedModel(SensorSnapshotModel record, long recordsOnPage){
        super(record);
        page = 1 + this.getId() / recordsOnPage;
    }
}

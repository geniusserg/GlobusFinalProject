package globus.sdanilov.logistics.structs;

import lombok.Data;

import java.io.Serializable;

@Data
public class RangedRequest implements Serializable {
    private long start;
    private long end;
    private long recordsOnPage;
    RangedRequest(){

    }
}

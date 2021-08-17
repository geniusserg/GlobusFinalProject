package globus.sdanilov.logistics.structs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Parameter {
    private int id;
    private String name;
    private float average;
    private float maxDifference;
}

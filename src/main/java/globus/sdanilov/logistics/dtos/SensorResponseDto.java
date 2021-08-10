package globus.sdanilov.logistics.dtos;

import lombok.Value;

@Value
public class SensorResponseDto {
    private int id;
    private int page;
    private int container;
    private float time;
    private String name;
    private float value;

}

package globus.sdanilov.logistics.dtos;

import lombok.Value;

@Value
public class SensorResponseDto {
    private int sensorId;
    private float time;
    private float value;
}

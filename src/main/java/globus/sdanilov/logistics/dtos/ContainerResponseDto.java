package globus.sdanilov.logistics.dtos;

import lombok.Value;

import java.util.List;

@Value
public class ContainerResponseDto {
    private int id;
    private int container;
    private List<SensorResponseDto> sensors;

}

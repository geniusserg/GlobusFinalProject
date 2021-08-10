package globus.sdanilov.logistics.controllers;

import globus.sdanilov.logistics.dtos.ContainerResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RESTControllerSensors {

    @PostMapping("/send")
    public void sendValues(List<ContainerResponseDto> responses){
        // move to kafka broker
    }
}

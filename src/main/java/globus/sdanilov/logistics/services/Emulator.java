package globus.sdanilov.logistics.services;

import globus.sdanilov.logistics.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Emulator {
    @Autowired
    private AppConfig config;
    
    @Bean
    public void launchEmulator(){

    }
}

package globus.sdanilov.logistics.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public void loadConfig(){
        //reads config.json
        //loads info to other classes
    }
}

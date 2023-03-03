package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Samsung getPhone(){ // Hah, if it were only this easy to gert a new phone and it didn't cost an arm and leg.
        return new Samsung();
    }

    @Bean
    public MobileCPU getCPU(){
        //return new Qualcomm();
        return new MediaTek();
    }

}

package com.diseno.demo.configuration;

import com.diseno.demo.factory.user.InsideUserFactory;
import com.diseno.demo.factory.user.OutsideUserFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryConfig {

    @Bean
    public InsideUserFactory insideUserFactory() {
        return new InsideUserFactory();
    }

    @Bean
    public OutsideUserFactory outsideUserFactory() {
        return new OutsideUserFactory();
    }

}

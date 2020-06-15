package com.hu;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.ribbon.Ribbon;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRibbon {

    @Bean
    public IRule instanceRibbon(){
        return  new RandomRule();
    }
}

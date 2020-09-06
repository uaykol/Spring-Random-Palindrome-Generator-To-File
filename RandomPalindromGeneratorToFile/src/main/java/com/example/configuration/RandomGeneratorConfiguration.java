package com.example.configuration;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RandomGeneratorConfiguration {

	Random random = null;
	
    @Bean
    public Random getRandom() //Singleton
    {
    	if(random == null)
    		return new Random();
    	
    	return random;
    }

}

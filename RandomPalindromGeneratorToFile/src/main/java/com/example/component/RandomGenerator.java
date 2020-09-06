package com.example.component;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RandomGenerator {
	
    private final Timer timer;
    private final TimerTask timerTask;

    @Value("${work_time}")
    private int work_time;

    public RandomGenerator(Timer timer, TimerTask timerTask)
    {
        this.timer = timer;
        this.timerTask = timerTask;
    }

    @Bean
    public ApplicationRunner runApplication()
    {
        return args -> timer.scheduleAtFixedRate(timerTask, 0, work_time);
    }

}

package com.example.configuration;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.component.PalindromController;

@Configuration
public class TimerConfiguration {

    private final BufferedWriter m_bw;
    private final Random m_random;
    private final DataOutputStream m_dos;

    private Timer timer;
    
    @Autowired
    PalindromController p_controller;

    @Value("${count}")
    private int count;

    @Value("${min}")
    private int min;

    @Value("${max}")
    private int max;
    
    public TimerConfiguration(BufferedWriter bw, Random random, DataOutputStream dos)
    {
        m_bw = bw;
        m_random = random;
        m_dos = dos;
    }

    @Bean
    public Timer getTimer()
    {
        return (timer = new Timer());
    }


    @Bean
    public TimerTask getTimerTask() 
    {
        return new TimerTask() {
            private int m_count;

            @Override
            public void run()
            {
                    ++m_count;
                    if (TimerConfiguration.this.count == m_count)
                        timer.cancel();

                    String str = "";
                    int length = 3;
                    
                    for(int i = 0; i < length; i++)
                    {
                    	char ch = (char) (m_random.nextInt(max - min) + min);
                    	str += ch;
                    }
                    
                    if(p_controller.isPalindrome(str))
                    {
                    	
                    	System.out.printf("Palindrom String Generated : %s%n", str);
                    	
                    	try
                        {
       	                    m_dos.writeChars(str);;
       	                    m_bw.write(str + "\n");
       	                    m_bw.flush();
       	                }
                           catch(IOException exception)
                           {
                   
                           } 
                    }
                    else
                    	System.out.printf("%s %n", str);
 
                    
            }
        };
    }

}

package com.example.configuration;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileConfiguration {
	
    @Value("${first-filename}")
    private String firstFileName;


    private DataOutputStream f_out;

    private BufferedWriter b_writer;

    @Bean
    public  DataOutputStream getDataOutputStream() throws IOException
    {
        if (f_out == null)
            return new DataOutputStream(new FileOutputStream(firstFileName, true));

        return f_out;
    }

    @Bean
    public BufferedWriter getBufferedWriter() throws IOException
    {
        if (b_writer == null)
        	b_writer = new BufferedWriter(new FileWriter(firstFileName));

        return b_writer;
    }

}

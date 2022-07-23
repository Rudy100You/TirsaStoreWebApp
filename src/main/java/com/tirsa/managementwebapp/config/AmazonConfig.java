package com.tirsa.managementwebapp.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AmazonConfig {

    private static final String KEYS_PATH = "/resource-files/secret.csv";

    @Bean
    public AmazonS3 s3() throws IOException{
        //read SecretKeys
        
        String[] keys = readKeys();
        AWSCredentials awsCredentials = new BasicAWSCredentials(keys[0],keys[1]);
        return AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
    }

    private String[] readKeys() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(KEYS_PATH));
        String line;
        ArrayList<String> lines = new ArrayList<String>();
        while ((line = reader.readLine()) != null)
        {
            lines.add(line.substring(line.indexOf("=")+1));
        }
        reader.close();
        return (String[])lines.toArray();
    }
}

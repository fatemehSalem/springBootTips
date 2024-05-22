package com.springBoot.tips;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationPropertiesTest.class)
public class SpringBootTipsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTipsApplication.class, args);
    }


    @Component
    static class AppInitializer implements CommandLineRunner{
      @Autowired
        private ApplicationPropertiesTest applicationProperties;

        @Override
        public void run(String... args)  {
            System.out.println("app properties " + applicationProperties);
        }
    }
}

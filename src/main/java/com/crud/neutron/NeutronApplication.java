package com.crud.neutron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NeutronApplication {

    public static void main(String[] args) {
        SpringApplication.run(NeutronApplication.class, args);
        System.out.println("OK");
    }

}

package ru.common.medical_clinic.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("ru.common.medical_clinic.*")
public class MedicalMonitoringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicalMonitoringApplication.class, args);
    }

}

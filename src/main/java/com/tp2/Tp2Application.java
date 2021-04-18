package com.tp2;

import com.tp2.Repositories.PatientRepository;
import com.tp2.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Date;

@SpringBootApplication

public class Tp2Application implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository ;

    public static void main(String[] args) {
        SpringApplication.run(Tp2Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null,"abdo",new Date(),3000,false));
        patientRepository.save(new Patient(null,"zaza",new Date(),200,false));
        patientRepository.save(new Patient(null,"zozo",new Date(),300,false));
        patientRepository.save(new Patient(null,"zizi",new Date(),4000,true));
    }
}

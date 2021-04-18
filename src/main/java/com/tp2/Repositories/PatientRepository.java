package com.tp2.Repositories;

import com.tp2.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    public Page<Patient> findByNomContains(String name, Pageable pageable);
}

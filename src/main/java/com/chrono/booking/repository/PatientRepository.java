package com.chrono.booking.repository;

import com.chrono.booking.domain.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {
    Patient findPatientById(Long patientId);
}

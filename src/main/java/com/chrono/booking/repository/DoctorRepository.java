package com.chrono.booking.repository;

import com.chrono.booking.domain.Doctor;
import org.springframework.data.repository.CrudRepository;


public interface DoctorRepository extends CrudRepository<Doctor,Long> {
    Iterable<Doctor> findAllByClinicId(Long clinicId);

    Doctor findDoctorById(Long doctorId);
}

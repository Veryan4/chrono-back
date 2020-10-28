package com.chrono.booking.repository;

import com.chrono.booking.domain.Appointment;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    List<Appointment> findAllByDoctorIdAndPatientIdIsNullAndDateBetween(Long doctorId, LocalDate start, LocalDate end);

    Optional<Appointment> findByIdAndDoctorIdAndPatientIdIsNull(Long appointmentId, Long doctorId);
}

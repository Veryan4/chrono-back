package com.chrono.booking.service;

import com.chrono.booking.domain.Appointment;
import com.chrono.booking.repository.AppointmentRepository;
import com.chrono.booking.domain.Patient;
import com.chrono.booking.repository.PatientRepository;
import com.chrono.booking.request.BookAppointment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.Optional;


@Service
@Slf4j
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PatientRepository patientRepository;

    public Iterable<Appointment> findAppointments() {
        return appointmentRepository.findAll();
    }

    public Iterable<Appointment> saveAppointments(Appointment[] appointments) {
        return appointmentRepository.saveAll(Arrays.asList(appointments));
    }

    public Iterable<Patient> findPatients() {
        return patientRepository.findAll();
    }

    public Iterable<Patient> savePatients(Patient[] patients) {
        return patientRepository.saveAll(Arrays.asList(patients));
    }

    public String bookAppointment(BookAppointment bookAppointment) throws EntityNotFoundException {
        Optional<Patient> patient = patientRepository.findById(bookAppointment.getPatientId());
        if (!patient.isPresent()) {
            throw new EntityNotFoundException("Patient not found");
        }
        Optional<Appointment> appointment = appointmentRepository.findByIdAndDoctorIdAndPatientIdIsNull(bookAppointment.getAppointmentId(), bookAppointment.getDoctorId());
        if (!appointment.isPresent()) {
            return "No Appointment available";
        }
        appointment.get().setPatientId(patient.get().getId());
        appointmentRepository.save(appointment.get());
        return "Appointment booked";
        
    }

}

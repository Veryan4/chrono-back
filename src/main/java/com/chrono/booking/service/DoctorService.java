package com.chrono.booking.service;

import com.chrono.booking.domain.Appointment;
import com.chrono.booking.domain.Doctor;
import com.chrono.booking.domain.TimeSlot;
import com.chrono.booking.dto.AvailabilityDto;
import com.chrono.booking.repository.AppointmentRepository;
import com.chrono.booking.repository.DoctorRepository;
import com.chrono.booking.repository.TimeSlotRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

@Service
@Slf4j
public class DoctorService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private TimeSlotRepository timeSlotRepository;

    public Iterable<Doctor> findDoctors() {
        return doctorRepository.findAll();
    }

    public Iterable<Doctor> saveDoctors(Doctor[] doctors) {
        return doctorRepository.saveAll(Arrays.asList(doctors));
    }

    public List<AvailabilityDto> findDoctorAvailability(Long doctorId, LocalDate start, LocalDate end) {
        List<Appointment> appointments = appointmentRepository.findAllByDoctorIdAndPatientIdIsNullAndDateBetween(doctorId, start, end);
        List<AvailabilityDto> availabilities = new ArrayList<AvailabilityDto>();
        for (Appointment appointment : appointments) {
            TimeSlot timeSlot = timeSlotRepository.findTimeSlotById(appointment.getTimeSlotId());
            AvailabilityDto availability = new AvailabilityDto().setAvailabilityFromAppointmentAndTimeSlot(appointment, timeSlot);
            availabilities.add(availability);
        }
        return availabilities;
    }

}

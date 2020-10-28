package com.chrono.booking.controller;

import com.chrono.booking.domain.Doctor;
import com.chrono.booking.dto.AvailabilityDto;
import com.chrono.booking.request.BookAppointment;
import com.chrono.booking.service.AppointmentService;
import com.chrono.booking.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v0/clinic")
@Slf4j
public class ClinicController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/doctors")
    public ResponseEntity getDoctors() {
        Iterable<Doctor> doctors;
        try {
            doctors = doctorService.findDoctors();
        } catch (Exception e) {
            System.out.println("getDoctors() : An issue occured : {}" + e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error, contact the administrator");
        }

        return ResponseEntity.status(HttpStatus.OK).body(doctors);
    }

    @GetMapping("/doctors/{id}/availabilities")
    public ResponseEntity getDoctorAvailabilities(@PathVariable("id") Long id,
                                                @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
                                                @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        List<AvailabilityDto> availabilities;
        try {
            availabilities = doctorService.findDoctorAvailability(id, start, end);
        } catch (Exception e) {
            System.out.println("findDoctorAvailability() : An issue occured : {}" + e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error, contact the administrator");
        }
        return ResponseEntity.status(HttpStatus.OK).body(availabilities);
    }

    @PostMapping("/appointment")
    public ResponseEntity bookAppointment(@RequestBody BookAppointment bookAppointment) {
        String response;
        try {
            response = appointmentService.bookAppointment(bookAppointment);
        } catch (EntityNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

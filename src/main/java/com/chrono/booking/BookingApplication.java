package com.chrono.booking;

import com.chrono.booking.service.AppointmentService;
import com.chrono.booking.domain.Appointment;
import com.chrono.booking.service.DoctorService;
import com.chrono.booking.domain.Doctor;
import com.chrono.booking.domain.Patient;
import com.chrono.booking.service.TimeSlotService;
import com.chrono.booking.domain.TimeSlot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


@SpringBootApplication
public class BookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	}

	@Bean
	CommandLineRunner doctorRunner(DoctorService doctorService) {
		return args -> {
			InputStream input = BookingApplication.class.getResourceAsStream("/json/doctors.json");
			Reader reader = new InputStreamReader(input, "UTF-8");
			try {
				Doctor[] doctors  = new Gson().fromJson(reader, Doctor[].class);
				doctorService.saveDoctors(doctors);
			} catch (Exception e){
				System.out.println("Unable to save Doctors: " + e.getMessage());
			}
		};
	}

	@Bean
	CommandLineRunner timeSlotRunner(TimeSlotService timeSlotService) {
		return args -> {
			InputStream input = BookingApplication.class.getResourceAsStream("/json/timeSlots.json");
			Reader reader = new InputStreamReader(input, "UTF-8");
			try {
				TimeSlot[] timeSlots  = new Gson().fromJson(reader, TimeSlot[].class);
				timeSlotService.saveTimeSlots(timeSlots );
			} catch (Exception e){
				System.out.println("Unable to save TimeSlots : " + e.getMessage());
			}
		};
	}

	@Bean
	CommandLineRunner appointmentRunner(AppointmentService appointmentService) {
		return args -> {
			InputStream input = BookingApplication.class.getResourceAsStream("/json/appointments.json");
			Reader reader = new InputStreamReader(input, "UTF-8");
			try {
				Appointment[] appointments  = new Gson().fromJson(reader, Appointment[].class);
				appointmentService.saveAppointments(appointments);
			} catch (Exception e){
				System.out.println("Unable to save Appointments: " + e.getMessage());
			}
		};
	}

	@Bean
	CommandLineRunner patientRunner(AppointmentService appointmentService) {
		return args -> {
			InputStream input = BookingApplication.class.getResourceAsStream("/json/patients.json");
			Reader reader = new InputStreamReader(input, "UTF-8");
			try {
				Patient[] patients  = new Gson().fromJson(reader, Patient[].class);
				appointmentService.savePatients(patients);
			} catch (Exception e){
				System.out.println("Unable to save Patients: " + e.getMessage());
			}
		};
	}

}
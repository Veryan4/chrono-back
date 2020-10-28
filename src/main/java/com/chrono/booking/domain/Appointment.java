package com.chrono.booking.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.google.gson.Gson;

import javax.persistence.*;
import java.util.Objects;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
public class Appointment {

    @Id
    private Long id;
    private LocalDate date;
    private Long timeSlotId;
    private Long patientId;
    private Long doctorId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(Long timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment appointment = (Appointment) o;
        return Objects.equals(id, appointment.id) &&
                Objects.equals(date, appointment.date) &&
                Objects.equals(timeSlotId, appointment.timeSlotId) &&
                Objects.equals(patientId, appointment.patientId) &&
                Objects.equals(doctorId, appointment.doctorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, timeSlotId, patientId, doctorId);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

package com.chrono.booking.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.google.gson.Gson;

import java.util.Objects;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BookAppointment {
    @NotNull
    private Long appointmentId;
    @NotNull
    private Long doctorId;
    @NotNull
    private Long patientId;


    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookAppointment patient = (BookAppointment) o;
        return Objects.equals(appointmentId, patient.appointmentId) &&
                Objects.equals(doctorId, patient.doctorId) &&
                Objects.equals(patientId, patient.patientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId, doctorId, patientId);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

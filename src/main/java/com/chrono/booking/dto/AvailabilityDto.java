package com.chrono.booking.dto;

import com.chrono.booking.domain.Appointment;
import com.chrono.booking.domain.TimeSlot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.google.gson.Gson;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AvailabilityDto {
    Long id;
    LocalDate date;
    LocalTime start;
    LocalTime end;

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

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvailabilityDto appointment = (AvailabilityDto) o;
        return Objects.equals(date, appointment.date) &&
                Objects.equals(start, appointment.start) &&
                Objects.equals(end, appointment.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, start, end);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public AvailabilityDto setAvailabilityFromAppointmentAndTimeSlot(Appointment appointment, TimeSlot timeSlot) {
        this.id = appointment.getId();
        this.date = appointment.getDate();
        this.start = timeSlot.getStart();
        this.end = timeSlot.getEnd();
        return this;
    }
}

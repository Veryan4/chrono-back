package com.chrono.booking.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.google.gson.Gson;

import javax.persistence.*;
import java.util.Objects;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
public class TimeSlot {
    @Id
    private Long id;
    public LocalTime start;
    public LocalTime end;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        TimeSlot timeSlot = (TimeSlot) o;
        return Objects.equals(id, timeSlot.id) &&
                Objects.equals(start, timeSlot.start) &&
                Objects.equals(end, timeSlot.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, start, end);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

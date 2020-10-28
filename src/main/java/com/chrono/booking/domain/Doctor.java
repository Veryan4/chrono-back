package com.chrono.booking.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.google.gson.Gson;

import javax.persistence.*;
import java.util.Objects;


@Data
@AllArgsConstructor
@Entity
public class Doctor {
    @Id
    private Long id;
    private Long clinicId;
    private String firstName;
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getClinicId() {
        return clinicId;
    }

    public void setClinicId(Long clinicId) {
        this.clinicId = clinicId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(id, doctor.id) &&
                Objects.equals(firstName, doctor.firstName) &&
                Objects.equals(lastName, doctor.lastName) &&
                Objects.equals(clinicId, doctor.clinicId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, clinicId);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

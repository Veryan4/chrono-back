package com.chrono.booking.repository;

import com.chrono.booking.domain.TimeSlot;
import org.springframework.data.repository.CrudRepository;

public interface TimeSlotRepository extends CrudRepository<TimeSlot, Long> {
    TimeSlot findTimeSlotById(Long id);
}

package com.chrono.booking.service;


import com.chrono.booking.domain.TimeSlot;
import com.chrono.booking.repository.TimeSlotRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Slf4j
public class TimeSlotService {
    @Autowired
    private TimeSlotRepository timeSlotRepository;

    public Iterable<TimeSlot> findTimeSlots() {
        return timeSlotRepository.findAll();
    }

    public Iterable<TimeSlot> saveTimeSlots(TimeSlot[] timeSlots) {
        return timeSlotRepository.saveAll(Arrays.asList(timeSlots));
    }

}

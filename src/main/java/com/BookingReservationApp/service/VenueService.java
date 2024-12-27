package com.BookingReservationApp.service;

import com.BookingReservationApp.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenueService {
    @Autowired
    VenueRepository venueRepository;

}

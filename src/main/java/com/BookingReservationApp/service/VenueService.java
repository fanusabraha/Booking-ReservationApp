package com.BookingReservationApp.service;

import com.BookingReservationApp.domain.Venue;
import com.BookingReservationApp.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class VenueService {
    @Autowired
    VenueRepository venueRepository;
    public ResponseEntity<String> createBooking( @PathVariable Long eventId,
                                                 @RequestParam String phone,
                                                 @RequestParam String email,
                                                 @RequestParam String availability,
                                                 @RequestParam(required = false) String additionalInfo){

        return venueRepository.save();
    }

}

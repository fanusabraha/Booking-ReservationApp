package com.BookingReservationApp.web;

import com.BookingReservationApp.domain.Venue;
import com.BookingReservationApp.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class VenueController {
    @Autowired
    VenueService venueService;

    @PostMapping("/Booking/{id}")
    public ResponseEntity<String> eventBooking(Long eventId, String phone, String email, String availability, String additionalInfo ){
        venueService.createBooking(eventId, phone, email, availability, additionalInfo);
        return ResponseEntity.ok("Booking successful for event ID:" + eventId);
    }
    @PostMapping
    public ResponseEntity<Venue> createBooking(@RequestBody Venue venue){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

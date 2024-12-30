package com.BookingReservationApp.web;

import com.BookingReservationApp.domain.Venue;
import com.BookingReservationApp.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class VenueController {
    @Autowired
    VenueService venueService;

    @PostMapping("/Booking/{id}")
    public ResponseEntity<String> eventBooking(@PathVariable("id") Long eventId,
                                               @RequestParam String phone,
                                               @RequestParam String email,
                                               @RequestParam String availability,
                                               @RequestParam(required = false) String additionalInfo) {
        String response = venueService.createBooking(eventId, phone, email, availability, additionalInfo);
        if (response.equals("Booking successful")) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<Venue> createBooking(@RequestBody Venue venue) {
        //Venue savedVenue = venueService.saveVenue(venue);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

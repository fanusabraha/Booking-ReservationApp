package com.BookingReservationApp.service;

import com.BookingReservationApp.domain.Venue;
import com.BookingReservationApp.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Service
public class VenueService {
    @Autowired
    VenueRepository venueRepository;

    public String createBooking(Long eventId, String phone, String email, String availability, String additionalInfo) {
        boolean isBooked = venueRepository.existsByEventAndStatus(eventId, "BOOKED");
        boolean isUserAlreadyBooked = venueRepository.existsByEventIdAndUserEmail(eventId, email);
        if (isBooked) {
            return "The location is already booked.";
        }
        if (isUserAlreadyBooked) {
            return "You have already booked this event.";
        }
        Venue newVenue = new Venue();
        newVenue.setEventId(eventId);
        newVenue.setUserEmail(email);
        // date needs to be taken from the search input
        newVenue.setBookingTime(LocalDateTime.now());
        //venue.setUserName(); to be taken from the uid or attributes
        newVenue.setStatus("BOOKED");
        venueRepository.save(newVenue);
        return "Booking successful";
    }

}

package com.BookingReservationApp.service;

import com.BookingReservationApp.domain.Venue;
import com.BookingReservationApp.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VenueService {
    @Autowired
    VenueRepository venueRepository;
    public List<Venue> listOfAllBookings(){
        return venueRepository.findAll();
    }

    public String createBooking(Long eventId, String phone, String email, String availability, String additionalInfo) {
        boolean isBooked = venueRepository.existsByEventIdAndStatus(eventId, "BOOKED");
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
//    public boolean updateBookingStatus(Long bookingId, String newStatus) {
//        Optional<Venue> booking = venueRepository.findById(bookingId);
//        if (booking.isPresent()) {
//            Venue venue = booking.get();
//            venue.setStatus(newStatus);
//            venueRepository.save(venue);
//            return true;
//        }
//        return false;
//    }


}

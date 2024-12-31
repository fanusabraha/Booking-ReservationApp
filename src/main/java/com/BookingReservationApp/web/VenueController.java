package com.BookingReservationApp.web;

import com.BookingReservationApp.domain.Venue;
import com.BookingReservationApp.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/bookings")
public class VenueController {
    @Autowired
    VenueService venueService;

    @GetMapping("/all")
    public String listBookings(ModelMap map) {
        List<Venue> bookings = venueService.listOfAllBookings();
        map.addAttribute("bookings", bookings);
        return "allBooking";
    }

    @PostMapping("/book/{id}")
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
//    @PutMapping("/{id}/status")
//    public ResponseEntity<String> updateBookingStatus(@PathVariable Long id, @RequestBody Map<String, String> payload) {
//        String newStatus = payload.get("status");
//        boolean updated = venueService.updateBookingStatus(id, newStatus);
//        if (updated) {
//            return ResponseEntity.ok("Status updated successfully.");
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not found.");
//        }
//    }

    @PostMapping
    public ResponseEntity<Venue> createBooking(@RequestBody Venue venue) {
        //Venue savedVenue = venueService.saveVenue(venue);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}

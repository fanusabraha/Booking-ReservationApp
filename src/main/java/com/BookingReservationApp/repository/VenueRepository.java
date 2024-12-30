package com.BookingReservationApp.repository;

import com.BookingReservationApp.domain.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {
    // to check if the venue is booked by event ID and Status
    boolean existsByEventIdAndStatus(Long eventId, String status);
    // to check if the user has already booked the event by event ID and user email
    boolean existsByEventIdAndUserEmail(Long eventId, String email);
}

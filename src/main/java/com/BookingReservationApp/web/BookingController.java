package com.BookingReservationApp.web;

import com.BookingReservationApp.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BookingController {
    @Autowired
    BookingService bookingService;
    
}

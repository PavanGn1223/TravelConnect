package com.Bus.Ticket.Booking.User.Repository;

import com.Bus.Ticket.Booking.User.Entity.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingDetails,String> {
}

package com.Bus.Ticket.Booking.Operator.Repository;


import com.Bus.Ticket.Booking.User.Entity.TicketCost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketCostRepository extends JpaRepository<TicketCost,String> {
}

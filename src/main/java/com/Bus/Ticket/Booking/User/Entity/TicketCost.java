package com.Bus.Ticket.Booking.User.Entity;

import com.Bus.Ticket.Booking.Operator.Entity.BusOperator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Tickets")
public class TicketCost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticket_id", unique = true)
    private String ticketId;

    @OneToOne(mappedBy = "ticketCost")
    @JoinColumn(name = "bus_id")
    private BusOperator busOperator;


    private String code;
    private Double price;

    @Column(name = "discount_amt", unique = true)
    private Double discountAmount;
}

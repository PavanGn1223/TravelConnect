package com.Bus.Ticket.Booking.Operator.Service;


import com.Bus.Ticket.Booking.Operator.Entity.BusOperator;
import com.Bus.Ticket.Booking.Operator.PayLoad.BusOperatorDto;
import com.Bus.Ticket.Booking.Operator.PayLoad.PageResponse;

import java.util.List;

public interface BusOperatorService {
    BusOperatorDto saveSchedule(BusOperatorDto busOperatorDto);

    List<BusOperatorDto> getAllBusDetails();

    PageResponse getAllBus(int pageNo, int pageSize, String sortDir, String sortBy);


    List<BusOperator> findByBusOperatorCompanyName(String companyName);
}

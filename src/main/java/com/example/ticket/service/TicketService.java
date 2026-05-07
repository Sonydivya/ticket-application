package com.example.ticket.service;

import com.example.ticket.dto.TicketRequestDto;
import com.example.ticket.dto.TicketResponseDto;

import java.util.List;

public interface TicketService {

    TicketResponseDto createTicket(TicketRequestDto requestDto);

    List<TicketResponseDto> getAllTickets();

    TicketResponseDto updateTicket(Long id,TicketRequestDto requestDto);

    void deleteTicket(Long id);

}

package com.example.ticket.controller;

import com.example.ticket.dto.TicketRequestDto;
import com.example.ticket.dto.TicketResponseDto;
import com.example.ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
//@RequiredArgsConstructor

public class TicketController {

    private final TicketService service;

    public TicketController(TicketService service){
        this.service = service;
    }

    @PostMapping
    TicketResponseDto createTicket(@RequestBody TicketRequestDto requestDto) {
        return service.createTicket(requestDto);
    }

    @GetMapping
    public List<TicketResponseDto> getAllTickets(){
        return service.getAllTickets();
    }

    @PutMapping("/{id}")
    TicketResponseDto updateTicket(@PathVariable Long id,  @RequestBody TicketRequestDto requestDto){

        return service.updateTicket(id, requestDto);
    }
    @DeleteMapping("/{id}")
    public String deleteTicket(@PathVariable Long id) {
        service.deleteTicket(id);
        return "Ticket deleted successfully";
    }

}

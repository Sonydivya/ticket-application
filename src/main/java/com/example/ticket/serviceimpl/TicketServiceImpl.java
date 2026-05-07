package com.example.ticket.serviceimpl;

import com.example.ticket.dto.TicketRequestDto;
import com.example.ticket.dto.TicketResponseDto;
import com.example.ticket.dto.UserResponseDTO;
import com.example.ticket.entity.Ticket;
import com.example.ticket.repository.TicketRepository;
import com.example.ticket.service.TicketService;
import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository repository;
//    private final RestTemplate restTemplate;


    public TicketServiceImpl (TicketRepository repository){
        this.repository = repository;
//        this.restTemplate = restTemplate;
    }

    @Override
    public TicketResponseDto createTicket(TicketRequestDto requestDto) {
//        // 🔹 Assume assignedTo contains USER ID
//        String userServiceUrl = "http://user/api/users/" + requestDto.getAssignedTo();
//
//        UserResponseDTO user;
//
//        try {
//            user = restTemplate.getForObject(userServiceUrl, UserResponseDTO.class);
//        } catch (Exception e) {
//            throw new RuntimeException("User not found in User Service");
//        }
//
//        if (user == null) {
//            throw new RuntimeException("User not found");
//        }


        Ticket ticket = new Ticket();
        ticket.setName(requestDto.getName());
        ticket.setDescription(requestDto.getDescription());
        ticket.setStatus(requestDto.getStatus());
        ticket.setPriority(requestDto.getPriority());
        ticket.setAssignedFrom(requestDto.getAssignedFrom());
        ticket.setAssignedTo(requestDto.getAssignedTo());
        ticket.setStartDate(requestDto.getStartDate());
        ticket.setEndDate(requestDto.getEndDate());

        Ticket saveTicket = repository.save(ticket);

        TicketResponseDto response = new TicketResponseDto();
        response.setId(saveTicket.getId());
        response.setName(saveTicket.getName());
        response.setDescription(saveTicket.getDescription());
        response.setStatus(saveTicket.getStatus());
        response.setPriority(saveTicket.getPriority());
        response.setAssignedFrom(saveTicket.getAssignedFrom());
        response.setAssignedTo(saveTicket.getAssignedTo());
        response.setStartDate(saveTicket.getStartDate());
        response.setEndDate(saveTicket.getEndDate());

        return response;
    }

    @Override
    public List<TicketResponseDto> getAllTickets() {
        List<Ticket> tickets = repository.findAll();
        List<TicketResponseDto> responseList = new ArrayList<>();
        for(Ticket ticket:tickets){
            TicketResponseDto responseDto = new TicketResponseDto();
            responseDto.setId(ticket.getId());
            responseDto.setName(ticket.getName());
            responseDto.setDescription(ticket.getDescription());
            responseDto.setStatus(ticket.getStatus());
            responseDto.setPriority(ticket.getPriority());
            responseDto.setAssignedFrom(ticket.getAssignedFrom());
            responseDto.setAssignedTo(ticket.getAssignedTo());
            responseDto.setStartDate(ticket.getStartDate());
            responseDto.setEndDate(ticket.getEndDate());
            responseList.add(responseDto);
        }
        return  responseList;
    }

    @Override
    public TicketResponseDto updateTicket(Long id, TicketRequestDto requestDto) {

//        Optional<Ticket> optionalTicket = repository.findById(id);
        Ticket ticket = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

//        Ticket ticket1 = optionalTicket.get();

        ticket.setName(requestDto.getName());
        ticket.setDescription(requestDto.getDescription());
        ticket.setStatus(requestDto.getStatus());
        ticket.setPriority(requestDto.getPriority());
        ticket.setAssignedFrom(requestDto.getAssignedFrom());
        ticket.setAssignedTo(requestDto.getAssignedTo());
        ticket.setStartDate(requestDto.getStartDate());
        ticket.setEndDate(requestDto.getEndDate());

        Ticket updatedTicket = repository.save(ticket);

        TicketResponseDto response = new TicketResponseDto();
        response.setId(updatedTicket.getId());
        response.setName(updatedTicket.getName());
        response.setDescription(updatedTicket.getDescription());
        response.setStatus(updatedTicket.getStatus());
        response.setPriority(updatedTicket.getPriority());
        response.setAssignedFrom(updatedTicket.getAssignedFrom());
        response.setAssignedTo(updatedTicket.getAssignedTo());
        response.setStartDate(updatedTicket.getStartDate());
        response.setEndDate(updatedTicket.getEndDate());

        return response;
    }

    @Override
    public void deleteTicket(Long id) {
        repository.deleteById(id);
    }


}

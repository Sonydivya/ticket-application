package com.example.ticket.dto;


import lombok.*;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TicketRequestDto {
    private String name;
    private String description;
    private String status;
    private String priority;
    private String assignedFrom;
    private String assignedTo;
    private LocalDate startDate;
    private LocalDate endDate;

}

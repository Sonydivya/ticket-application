package com.example.ticket.entity;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "tickets")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private  String description;
    private String status;
    private String priority;
    private String assignedFrom;
    private String assignedTo;
    private LocalDate startDate;
    private LocalDate endDate;
}

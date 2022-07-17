package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.Ticket;
import com.example.tour.models.Tour;
import com.example.tour.services.TicketService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    List<Ticket> getTickets()  {
        return ticketService.getAllTickets();
    }

    @PostMapping("/")
    String addTourRating(@RequestBody Ticket ticket) {
        return  ticketService.saveTicket(ticket);
    }

    @GetMapping("/{id}")
    Ticket getTicket(@PathVariable long id)  {
        return ticketService.getTicketById(id);
    }

    @GetMapping("/status")
    boolean isTicketAvailable(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam Tour tour)  {
        return ticketService.isTicketAvailable(tour,date);
    }



//    List<Visitor> getBookedVisitorsbyTourCreatorIdAndTourId() {
//        return t
//    }













}

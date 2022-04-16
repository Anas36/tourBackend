package com.example.tour.services;

import com.example.tour.data.TicketRepo;
import com.example.tour.models.Ticket;
import com.example.tour.models.Tour;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TicketService {
    final TicketRepo ticketRepo;


    public TicketService(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    public List<Ticket> getAllTickets()
    {
        return ticketRepo.findAll();
    }

    public Ticket getTicketById(long id) {
        return ticketRepo.findById(id).orElse(null);
    }

    public void deleteTicketById(long id) {
        if (!ticketRepo.existsById(id)) {
            throw new IllegalStateException("Ticket Not Exist");
        } else {
            ticketRepo.deleteById(id);
        }

    }

    public boolean isTicketAvailable(Tour tour, LocalDate date) {
        return tour.getMax_participants() > getCountOfBookedTickets(tour, date);
    }

    public int getCountOfBookedTickets(Tour tour, LocalDate date) {
        return ticketRepo.countByTourAndDate(tour, date);
    }


    public void savePrefernce(Ticket ticket) {
        ticketRepo.save(ticket);
    }
}

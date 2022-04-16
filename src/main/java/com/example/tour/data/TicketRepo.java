package com.example.tour.data;

import com.example.tour.models.Ticket;
import com.example.tour.models.Tour;
import com.example.tour.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface TicketRepo extends JpaRepository<Ticket, Long> {


    int countByTourAndDate(Tour tour, LocalDate date);
}

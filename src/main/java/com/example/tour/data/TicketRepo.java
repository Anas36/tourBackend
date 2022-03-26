package com.example.tour.data;

import com.example.tour.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<User, Long> {

}

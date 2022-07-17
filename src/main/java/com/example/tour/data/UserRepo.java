package com.example.tour.data;

import com.example.tour.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByEmail(String email);
    boolean existsByEmail(String email);

    User getByEmail(String email);
}

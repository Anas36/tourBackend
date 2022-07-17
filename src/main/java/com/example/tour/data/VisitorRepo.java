package com.example.tour.data;

import com.example.tour.models.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VisitorRepo extends JpaRepository<Visitor, Long>{

    boolean existsByEmail(String email);

    Optional<Object> findByEmail(String email);
}

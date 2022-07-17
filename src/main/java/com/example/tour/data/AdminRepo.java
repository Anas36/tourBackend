package com.example.tour.data;

import com.example.tour.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long>{

    boolean existsByEmail(String email);
}

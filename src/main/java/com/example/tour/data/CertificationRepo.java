package com.example.tour.data;

import com.example.tour.models.Certification;
import com.example.tour.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationRepo extends JpaRepository<Certification, Long> {

}

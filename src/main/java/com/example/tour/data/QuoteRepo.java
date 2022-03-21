package com.example.tour.data;

import com.example.tour.models.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

//@SpringBootTest
//@DataJpaTest
public interface QuoteRepo extends JpaRepository<Quote, Long> {

}

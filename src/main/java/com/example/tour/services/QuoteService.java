package com.example.tour.services;

//Business Logic layer

import com.example.tour.data.QuoteRepo;
import com.example.tour.models.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuoteService {

//    Logger logger = LoggerFactory.getLogger(QuoteService.class);

    public QuoteService(QuoteRepo quoteRepo) {
        this.quoteRepo = quoteRepo;
    }
    private QuoteRepo quoteRepo;

    // =====================================================
    public List<Quote> getListOfQuotes() {
        return quoteRepo.findAll();
    }

    // =====================================================
    public void saveQuote(Quote quote) {
        quoteRepo.save(quote);
    }

    // =====================================================
    public void deleteQuote(long id) {

        if (!quoteRepo.existsById(id)) {
            throw new IllegalStateException("Quote Not Exist");
        } else {
            quoteRepo.deleteById(id);

        }
    }

    // =====================================================
//    public List<Quote> getQuoteWithAuthor(@Param(value = "author") String author) {
//        List<Quote> quoteList = new ArrayList<>();
//        quoteList = quoteRepo.findQuotesByAuthor(author);
//        logger.info(" quoteList : " + String.valueOf(quoteList.size()));
//        return quoteList;
//    }

    // =====================================================
//    public Quote getQuote(long id) {
//        return quoteRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Quote Not Found"));
//    }
    // =====================================================

}

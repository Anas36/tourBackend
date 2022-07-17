package com.example.tour.services;

import com.example.tour.data.VisitorRepo;
import com.example.tour.models.Visitor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitorService {

    private final VisitorRepo visitorRepo;


    public List<Visitor> getAllVisitors()
    {
        return visitorRepo.findAll();
    }

    public Visitor getVisitorById(long id) {
        return visitorRepo.findById(id).orElse(null);
    }

    public Visitor getVisitorByEmail(String  email) {
        return (Visitor) visitorRepo.findByEmail(email).orElse(null);
    }

    public void deleteVisitorById(long id) {
        if (!visitorRepo.existsById(id)) {
            throw new IllegalStateException("Visitor Not Exist");
        } else {
            visitorRepo.deleteById(id);
        }

    }

    public boolean visitorExists(String email) {
        return visitorRepo.existsByEmail(email);
    }

    public void saveVisitor(Visitor visitor) {

        visitorRepo.save(visitor);
    }
}

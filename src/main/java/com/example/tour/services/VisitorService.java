package com.example.tour.services;

import com.example.tour.data.VisitorRepo;
import com.example.tour.models.User;
import com.example.tour.models.Visitor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitorService {
    final VisitorRepo visitorRepo;


    public VisitorService(VisitorRepo visitorRepo) {
        this.visitorRepo = visitorRepo;
    }

    public List<Visitor> getAllVisitors()
    {
        return visitorRepo.findAll();
    }

    public Visitor getVisitorById(long id) {
        return visitorRepo.findById(id).orElse(null);
    }

    public void deleteVisitorById(long id) {
        if (!visitorRepo.existsById(id)) {
            throw new IllegalStateException("Visitor Not Exist");
        } else {
            visitorRepo.deleteById(id);
        }

    }

    public void saveVisitor(Visitor visitor) {
        visitorRepo.save(visitor);
    }
}

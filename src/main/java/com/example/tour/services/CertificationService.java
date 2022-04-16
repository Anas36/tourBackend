package com.example.tour.services;

//Business Logic layer
import com.example.tour.models.Certification;
import com.example.tour.data.CertificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificationService {

    final CertificationRepo certificationRepo;

    @Autowired
    public CertificationService(CertificationRepo certificationRepo) {
        this.certificationRepo = certificationRepo;
    }

    public List<Certification> getAllCertifications()
    {
        return certificationRepo.findAll();
    }

    public Certification getCertificationById(long id) {
        return certificationRepo.findById(id).orElse(null);
    }
}

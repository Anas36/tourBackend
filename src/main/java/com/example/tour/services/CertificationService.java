package com.example.tour.services;

//Business Logic layer
import com.example.tour.models.Certification;
import com.example.tour.data.CertificationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CertificationService {

    private final CertificationRepo certificationRepo;

    public List<Certification> getAllCertifications()
    {
        return certificationRepo.findAll();
    }

    public Certification getCertificationById(long id) {
        return certificationRepo.findById(id).orElse(null);
    }
}

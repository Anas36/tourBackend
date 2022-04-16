package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.Certification;
import com.example.tour.services.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("certifications")
public class CertificationController {

    public CertificationService certificationService;

    @Autowired
    public CertificationController(CertificationService certificationService) {
        this.certificationService = certificationService;
    }

    @GetMapping
    List<Certification> getCertifications()  {
        return certificationService.getAllCertifications();
    }
    @GetMapping("/{id}")
    Certification getCertification(@PathVariable long id)  {
        return certificationService.getCertificationById(id);
    }








}

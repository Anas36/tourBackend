package com.example.tour.services;

import com.example.tour.data.AdminRepo;
import com.example.tour.models.Admin;
import com.example.tour.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepo adminRepo;

    public List<Admin> getAllAdmins()
    {
        return adminRepo.findAll();

    }

    public Admin getAdminById(long id) {
        return adminRepo.findById(id).orElse(null);
    }

    public void deleteAdminById(long id) {
        if (!adminRepo.existsById(id)) {
            throw new IllegalStateException("Admin Not Exist");
        } else {
            adminRepo.deleteById(id);
        }

    }

    public boolean adminExists(String email) {
        return adminRepo.existsByEmail(email);
    }

    public void saveAdmin(Admin admin) {
        adminRepo.save(admin);
    }
}

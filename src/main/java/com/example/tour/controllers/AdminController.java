package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.Admin;
import com.example.tour.services.AdminService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("admins")
public class AdminController {

    public AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping()
    void addAdmin(@RequestBody Admin admin) {adminService.saveAdmin(admin);}
    @GetMapping
    List<Admin> getAdmins()  {
        return adminService.getAllAdmins();
    }
    @GetMapping("/{id}")
    Admin getAdmin(@PathVariable long id)  {
        return adminService.getAdminById(id);
    }
    @DeleteMapping("/{id}")
    void removeAdmin(@PathVariable long id)  {
        adminService.deleteAdminById(id);
    }



}

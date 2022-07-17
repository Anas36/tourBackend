package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.Admin;
import com.example.tour.services.AdminService;
import com.example.tour.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("admins")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final UserService userService;

    @PostMapping()
    Admin addAdmin(@RequestBody Admin admin) {
        admin.setRole();
        return (Admin) userService.saveUser(admin);
    }

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

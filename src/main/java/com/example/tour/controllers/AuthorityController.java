package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.Authority;
import com.example.tour.models.User;
import com.example.tour.services.AuthorityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("authorities")
public class AuthorityController {

    public AuthorityService authorityService;

    public AuthorityController(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }

    @PostMapping()
    void addAuthority(@RequestBody Authority authority) {authorityService.saveAuthority(authority);}
    @GetMapping
    List<Authority> getAuthorities()  {
        return authorityService.getAllAuthoritys();
    }
    @GetMapping("/{id}")
    Authority getAuthority(@PathVariable long id)  {
        return authorityService.getAuthorityById(id);
    }
    @DeleteMapping("/{id}")
    void removeAuthority(@PathVariable long id)  {
        authorityService.deleteAuthorityById(id);
    }



}

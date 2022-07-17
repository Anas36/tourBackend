package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.Authority;
import com.example.tour.services.AuthorityService;
import com.example.tour.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("authorities")
@RequiredArgsConstructor
public class AuthorityController {

    private final AuthorityService authorityService;
    private final UserService userService;



    @PostMapping()
    Authority addAuthority(@RequestBody Authority authority) {return (Authority) userService.saveUser(authority);}
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

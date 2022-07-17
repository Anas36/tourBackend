package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.User;
import com.example.tour.security.config.JwtTokenUtil;
import com.example.tour.security.model.JwtRequest;
import com.example.tour.security.model.JwtResponse;
import com.example.tour.security.service.JwtUserDetailsService;
import com.example.tour.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    private final JwtUserDetailsService userDetailsService;


    @GetMapping
    List<User> getUsers()  {
        return userService.getAllUsers();
    }
    @GetMapping("user/{id}")
    User getUser(@PathVariable long id)  {
        return userService.getUserById(id);
    }

//    @PostMapping ()
//    User addUser(@RequestBody User user) throws Exception {
//        if(userService.isUserExist(user))
//            throw new Exception("there is user exist wit this mail");
//        return userService.saveUser(user);
//    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(jwt));
    }










}

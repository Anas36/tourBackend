package com.example.tour.security.service;

import com.example.tour.data.UserRepo;
import com.example.tour.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class  JwtUserDetailsService implements UserDetailsService {

    private final VisitorService visitorService;
    private final TourCreatorService tourCreatorService;
    private final AdminService adminService;
    private final AuthorityService authorityService;
    private final AdvertiserService advertiserService;
    private final UserRepo userRepo;




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.example.tour.models.User user = userRepo.getByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("User not found in the database");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);

    }
}
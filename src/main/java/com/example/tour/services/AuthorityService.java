package com.example.tour.services;

import com.example.tour.data.AuthorityRepo;
import com.example.tour.models.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorityService {

    private final AuthorityRepo authorityRepo;


    public List<Authority> getAllAuthoritys()
    {
        return authorityRepo.findAll();

    }

    public Authority getAuthorityById(long id) {
        return authorityRepo.findById(id).orElse(null);
    }

    public void deleteAuthorityById(long id) {
        if (!authorityRepo.existsById(id)) {
            throw new IllegalStateException("Authority Not Exist");
        } else {
            authorityRepo.deleteById(id);
        }

    }

    public boolean authorityExists(String email) {
        return authorityRepo.existsByEmail(email);
    }

    public void saveAuthority(Authority authority) {
        authorityRepo.save(authority);
    }
}

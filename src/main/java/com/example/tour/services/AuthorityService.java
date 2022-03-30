package com.example.tour.services;

import com.example.tour.data.AuthorityRepo;
import com.example.tour.models.Authority;
import com.example.tour.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService {
    final AuthorityRepo authorityRepo;


    public AuthorityService(AuthorityRepo authorityRepo) {
        this.authorityRepo = authorityRepo;
    }

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

    public void saveAuthority(Authority authority) {
        authorityRepo.save(authority);
    }
}

package com.example.tour.services;

//Business Logic layer

import com.example.tour.data.UserRepo;
import com.example.tour.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService  { //implements UserDetailsService

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final VisitorService visitorService;
    private final TourCreatorService tourCreatorService;
    private final AdminService adminService;
    private final AuthorityService authorityService;
    private final AdvertiserService advertiserService;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(long id) {
        return userRepo.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        User newUser = userRepo.save(user);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        //setting the photo with custom name because since s3 need to retrieve the photo from the server with its name so to track it we will save it with custom name
        newUser.setPhoto();
        return newUser;
    }

    public User getByEmail(String email) throws Exception{
        if(isUserExistByEmail(email))
            return userRepo.getByEmail(email);
        throw  new Exception("there is no any user with this mail");
    }

    public boolean isUserExistByEmail(String email) {
        return userRepo.existsByEmail(email);
    }

    public boolean isUserExist(User user) {
        return userRepo.existsById(user.getId());
    }


//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        String role = "";
//        User user = userRepo.findByEmail(email);
//
//        if (visitorService.visitorExists(email)) {
//            role = "ROLE_VISITOR";
//        }
//        else if (tourCreatorService.tourCreatorExists(email)) {
//            role = "ROLE_TOUR_CREATOR";
//        }
//        else if (authorityService.authorityExists(email)) {
//            role = "ROLE_AUTHORITY";
//        }
//        else if (advertiserService.advertiseryExists(email)) {
//            role = "ROLE_ADVERTISER";
//        }
//        else if (adminService.adminExists(email)) {
//            role = "ROLE_ADMIN";
//        }
//        if(user == null || role.equals("")) {
//            throw new UsernameNotFoundException("User not found in the database");
//        } else {
//            Set<SimpleGrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority(role));
//            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
//        }
//    }


}


package com.example.tour.data;

import com.example.tour.models.Preference;
import com.example.tour.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferenceRepo extends JpaRepository<Preference, Long> {

}

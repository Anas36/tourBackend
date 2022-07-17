package com.example.tour.data;

import com.example.tour.models.Preference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferenceRepo extends JpaRepository<Preference, Long> {

}

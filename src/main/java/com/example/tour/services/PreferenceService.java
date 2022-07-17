package com.example.tour.services;

import com.example.tour.data.PreferenceRepo;
import com.example.tour.models.Preference;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PreferenceService {

    private final PreferenceRepo preferenceRepo;


    public List<Preference> getAllPreferences()
    {
        return preferenceRepo.findAll();
    }

    public Preference getPreferenceById(long id) {
        return preferenceRepo.findById(id).orElse(null);
    }

    public void deletePreferenceById(long id) {
        if (!preferenceRepo.existsById(id)) {
            throw new IllegalStateException("Preference Not Exist");
        } else {
            preferenceRepo.deleteById(id);
        }

    }


    public void savePrefernce(Preference preference) {
        preferenceRepo.save(preference);
    }
}

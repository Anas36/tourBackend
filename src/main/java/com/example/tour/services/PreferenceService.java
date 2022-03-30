package com.example.tour.services;

import com.example.tour.data.PreferenceRepo;
import com.example.tour.models.Preference;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PreferenceService {
    final PreferenceRepo preferenceRepo;


    public PreferenceService(PreferenceRepo preferenceRepo) {
        this.preferenceRepo = preferenceRepo;
    }

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

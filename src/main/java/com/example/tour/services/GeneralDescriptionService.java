package com.example.tour.services;

//Business Logic layer

import com.example.tour.data.AuthorityRepo;
import com.example.tour.data.GeneralDescriptionRepo;
import com.example.tour.data.ObjectRepo;
import com.example.tour.models.CompositeKey.GeneralDescriptionKey;
import com.example.tour.models.CompositeKey.ObjectKey;
import com.example.tour.models.CompositeKey.RoomKey;
import com.example.tour.models.GeneralDescription;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralDescriptionService {

    final GeneralDescriptionRepo generalDescriptionRepo;
    final ObjectRepo objectRepo;
    final AuthorityRepo authorityRepo;


    public GeneralDescriptionService(GeneralDescriptionRepo generalDescriptionRepo, ObjectRepo objectRepo, AuthorityRepo authorityRepo) {
        this.generalDescriptionRepo = generalDescriptionRepo;
        this.objectRepo = objectRepo;
        this.authorityRepo = authorityRepo;
    }

    public List<GeneralDescription> getAllGeneralDescriptions()
    {
        return generalDescriptionRepo.findAll();
    }

    public String saveDescription(GeneralDescription generalDescription) throws Exception {
        if (!objectRepo.existsById(new ObjectKey(generalDescription.getObjectId(),generalDescription.getPlaceId(),generalDescription.getRoomId())))
            throw new Exception("there is no object with this id");
        if (!authorityRepo.existsById(generalDescription.getAuthorityId()))
            throw new Exception("there is no Authority id with this details");
        generalDescriptionRepo.save(generalDescription);
        return "description been added";
    }

    public GeneralDescription getGeneralDescriptionById(GeneralDescriptionKey id) throws Exception {
        if (!objectRepo.existsById(new ObjectKey(id.getObjectId(),id.getPlaceId(),id.getRoomId())))
            throw new Exception("there is no object with this id");
        if (!authorityRepo.existsById(id.getAuthorityId()))
            throw new Exception("there is no Authority id with this details");

        return generalDescriptionRepo.findById(id).orElse(null);
    }
}

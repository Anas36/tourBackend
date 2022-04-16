//package com.example.tour.services;
//
//import com.example.tour.data.ObjectRepo;
//import com.example.tour.models.Object;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ObjectService2 {
//    final ObjectRepo objectRepo;
//
//
//    public ObjectService2(ObjectRepo objectRepo) {
//        this.objectRepo = objectRepo;
//    }
//
//    public List<Object> getAllObjects()
//    {
//        return objectRepo.findAll();
//
//    }
//
////    public List<Object> getObjectsByPlaceId(long placeID, long roomID) {
////        return objectRepo.getObjectsByPlaceId(placeID,roomID);
////    }
////
////    public void deleteObjectById(long id) {
////        if (!objectRepo.existsById(id)) {
////            throw new IllegalStateException("Object Not Exist");
////        } else {
////            objectRepo.deleteById(id);
////        }
////
////    }
//
//    public String saveObject(Object object) {
//        objectRepo.save(object);
//        return "object been added successfully";
//    }
//}

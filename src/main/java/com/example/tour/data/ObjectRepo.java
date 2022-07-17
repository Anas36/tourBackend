package com.example.tour.data;


import com.example.tour.models.CompositeKey.ObjectKey;
import com.example.tour.models.Object;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectRepo extends JpaRepository<Object, ObjectKey> {

}

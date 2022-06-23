package com.hotel.hms.room;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends MongoRepository<Room , String>{

    List<Room> findAllByCategoriesIn(ArrayList arrayList);
    
}

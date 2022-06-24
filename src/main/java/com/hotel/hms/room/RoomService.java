package com.hotel.hms.room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.hotel.hms.category.CategoryRepository;
import com.hotel.hms.exception.FieldValidationException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoomService {
    
    private final RoomRepository roomRepository;
    private final CategoryRepository categoryRepository;

    public Room addRoom(Room room){
        
        // service level validations check  categories exsist
        room.getCategories().stream().forEach(elementId -> {
            categoryRepository.findById(elementId).orElseThrow(()-> new FieldValidationException("Category error"));
        });

        return roomRepository.save(room);

    }


    public List<Room> getRoomByCategory(String categoryId) {
        return roomRepository.findAllByCategoriesIn(new ArrayList<>(Arrays.asList(categoryId)));
    }


    public Map<String, Double> calculateTotal(List<String> roomIds) {

        double total = roomRepository.findAllByIdIn(roomIds).stream().mapToDouble(r -> r.getPrice()).sum();
        
        Map<String,Double> returnMap = new HashMap<>();
        returnMap.put("totalPrice", total);

        return returnMap;

    }


    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }



}

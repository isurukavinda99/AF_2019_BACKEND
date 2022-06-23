package com.hotel.hms.room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

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

}

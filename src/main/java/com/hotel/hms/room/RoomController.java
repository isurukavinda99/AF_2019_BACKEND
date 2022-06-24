package com.hotel.hms.room;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.context.Theme;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hms.exception.FieldValidationException;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v2/room")
public class RoomController {
 
    private final RoomService roomService;
    
    @PostMapping("/")
    public ResponseEntity<Room> addRoom(@RequestBody Room room){

        // basic controller level validations
        if(room.getCode().isEmpty()){
            throw new FieldValidationException("Room code is required");
        }

        if(room.getPrice() <= 0 ){
            throw new FieldValidationException("Price is required");
        }

        if(room.getWing().isEmpty()){
            throw new FieldValidationException("Wind is required");
        }

        if(room.getCategories().size() == 0){
            throw new FieldValidationException("please enter a category");
        }

        return new ResponseEntity<>(roomService.addRoom(room) , HttpStatus.OK);

    }


    @GetMapping("/{categoryId}")
    public List<Room> getRoomByCategory(@PathVariable(name = "categoryId") String categoryId){
        
        // basic controller level validation
        if(categoryId.isBlank()){
            throw new FieldValidationException("give a catrgory id");
        }

        return roomService.getRoomByCategory(categoryId);

    }


    @PostMapping("/calculate-total")
    public ResponseEntity<Map<String, Double>> calculateRoomTotal(@RequestBody RoomPriceCalDto roomIds){

        // basic controller level validations
        if(roomIds.getRoomIds().size() == 0){
            throw new FieldValidationException("Select atleast one room");
        }

        return new ResponseEntity<>(roomService.calculateTotal(roomIds.getRoomIds()) , HttpStatus.OK);

    }

    @GetMapping("/")
    public ResponseEntity<List<Room>> getAllRooms(){
        return new ResponseEntity<>(roomService.getAllRooms() , HttpStatus.OK);
    }

}

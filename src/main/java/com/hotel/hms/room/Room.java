package com.hotel.hms.room;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    
    @Id
    private String id;
    private String code;
    private String wing;
    private ArrayList<String> categories;
    private double price;

}

package com.hotel.hms.category;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hms.exception.FieldValidationException;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v2/category")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    
    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){

        // basic controller level validations
        if(category.getCategoryName().isBlank()){
            throw new FieldValidationException("Category name is requied");
        }

        return new ResponseEntity<>(categoryService.addCategory(category) , HttpStatus.CREATED);

    }


    @GetMapping("/")
    public ResponseEntity<List<Category>> getAllCategories(){
        return new ResponseEntity<>(categoryService.getAllCategories() , HttpStatus.OK);
    }

}

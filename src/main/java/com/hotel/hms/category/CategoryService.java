package com.hotel.hms.category;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService {
    
    private final CategoryRepository categoryRepository;


    public Category addCategory(Category category){

        return categoryRepository.save(category);

    }


    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

}

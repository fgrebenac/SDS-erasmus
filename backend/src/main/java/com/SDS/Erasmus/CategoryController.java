package com.SDS.Erasmus;

import com.SDS.Erasmus.domain.Category;
import com.SDS.Erasmus.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/app-categories")
    public List<Category> listCategories() {
        return categoryService.listAll();
    }


}

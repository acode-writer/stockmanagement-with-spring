package sn.acodewriter.stockmanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sn.acodewriter.stockmanagement.controller.api.CategoryApi;
import sn.acodewriter.stockmanagement.dto.CategoryDto;
import sn.acodewriter.stockmanagement.service.CategoryService;

@RestController
public class CategoryController implements CategoryApi {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return this.categoryService.save(categoryDto);
    }

    @Override
    public CategoryDto findById(Integer id) {
        return this.categoryService.findById(id);
    }

    @Override
    public CategoryDto findByCode(String code) {
        return this.categoryService.findByCode(code);
    }

    @Override
    public List<CategoryDto> findAll() {
        return this.categoryService.findAll();
    }

    @Override
    public void delete(Integer id) {
        this.categoryService.delete(id);
    }
}

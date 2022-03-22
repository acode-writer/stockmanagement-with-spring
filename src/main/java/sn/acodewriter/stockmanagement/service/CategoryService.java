package sn.acodewriter.stockmanagement.service;


import sn.acodewriter.stockmanagement.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto save(CategoryDto CategoryDto);

    CategoryDto findById(Integer id);

    List<CategoryDto> findAll();

    void delete(Integer id);
}

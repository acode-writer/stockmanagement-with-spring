package sn.acodewriter.stockmanagement.service.implement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.acodewriter.stockmanagement.dto.CategoryDto;
import sn.acodewriter.stockmanagement.exception.EntityNotFoundException;
import sn.acodewriter.stockmanagement.exception.ErrorCodes;
import sn.acodewriter.stockmanagement.exception.InvalidEntityException;
import sn.acodewriter.stockmanagement.repository.CategoryRepository;
import sn.acodewriter.stockmanagement.service.CategoryService;
import sn.acodewriter.stockmanagement.validator.CategoryValidator;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImplement implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImplement(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        List<String> errors = CategoryValidator.validate(categoryDto);
        if (!errors.isEmpty()){
            log.error("Category is not valid {}", categoryDto);
            throw new  InvalidEntityException("Category is not valid", ErrorCodes.CATEGORY_NOT_VALID);
        }
        return CategoryDto.fromEntity(
                categoryRepository.save(
                        CategoryDto.toEntity(categoryDto)
                )
        );
    }

    @Override
    public CategoryDto findById(Integer id) {
        if (id == null){
            log.error("Category ID is null");
            throw new EntityNotFoundException("Category ID is null", ErrorCodes.CATEGORY_NOT_FOUND);
        }
        return categoryRepository.findById(id)
                .map(CategoryDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No Category with this ID: " + id, ErrorCodes.CATEGORY_NOT_FOUND));
    }

    @Override
    public CategoryDto findByCode(String code) {
        if (code == null){
            log.error("Category's CODE is null");
            throw new EntityNotFoundException("Category's CODE is null", ErrorCodes.CATEGORY_NOT_FOUND);
        }
        return categoryRepository.findCategoryByCode(code)
                .map(CategoryDto::fromEntity)
                .orElseThrow(() ->
                        new EntityNotFoundException("Category not found",ErrorCodes.CATEGORY_NOT_FOUND)
                );
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Category ID is null");
            throw new EntityNotFoundException("Category ID is null", ErrorCodes.CATEGORY_NOT_FOUND);
        }

        categoryRepository.deleteById(id);
    }
}

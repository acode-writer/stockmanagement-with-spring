package sn.acodewriter.stockmanagement.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import sn.acodewriter.stockmanagement.dto.CategoryDto;


import static sn.acodewriter.stockmanagement.utils.Constants.APP_ROOT;

@Api(value = APP_ROOT + "/categories", tags = "Categories")
public interface CategoryApi {

    @PostMapping(value = APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Save a Category.", notes = "This method allows you to update or set a Category", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category object has been created/updated"),
            @ApiResponse(code = 400, message = "Category object is invalid."),
    })
    CategoryDto save(@RequestBody CategoryDto CategoryDto);

    @GetMapping(value = APP_ROOT + "/categories/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Find an Category by his ID.", notes = "This method allows you to get an Category by his ID", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category object has been found"),
            @ApiResponse(code = 404, message = "No Category with this ID was found"),
    })
    CategoryDto findById(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT + "/categories/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Find an category by his CODE.", notes = "This method allows you to get an category by his CODE", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category object has been found"),
            @ApiResponse(code = 404, message = "No category with this ID was found"),
    })
    CategoryDto findByCode(@RequestParam @PathVariable String code);

    @GetMapping(value = APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all categories", notes = "This method allows you to get all categories", responseContainer = "List<CategoryDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category list or empty list"),
    })
    List<CategoryDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/categories/delete/{id}")
    @ApiOperation(value = "delete an Category by his ID", notes = "This method allows you to delete an Category by his ID", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category has been removed"),
    })
    void delete(Integer id);
}

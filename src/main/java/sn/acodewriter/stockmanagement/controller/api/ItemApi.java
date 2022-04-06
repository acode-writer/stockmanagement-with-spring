package sn.acodewriter.stockmanagement.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sn.acodewriter.stockmanagement.dto.ItemDto;

import java.util.List;

import static sn.acodewriter.stockmanagement.utils.Constants.APP_ROOT;

@Api(value = APP_ROOT + "/items",tags = "Items")
public interface ItemApi {

    @PostMapping(value = APP_ROOT + "/items/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Save an item.", notes = "This method allows you to update or set an item", response = ItemDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Item object has been created/updated"),
            @ApiResponse(code = 400, message = "Item object is invalid."),
    })
    ItemDto save( @RequestBody ItemDto itemDto);

    @GetMapping(value = APP_ROOT + "/items/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Find an item by his ID.", notes = "This method allows you to get an item by his ID", response = ItemDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Item object has been found"),
            @ApiResponse(code = 404, message = "No item with this ID was found"),
    })
    ItemDto findById(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT + "/items/{itemCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Find an item by his CODE.", notes = "This method allows you to get an item by his CODE", response = ItemDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Item object has been found"),
            @ApiResponse(code = 404, message = "No item with this ID was found"),
    })
    ItemDto findByItemCode(@PathVariable String itemCode);

    @GetMapping(value = APP_ROOT + "/items/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all items", notes = "This method allows you to get all items", responseContainer = "List<ItemDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Item list or empty list"),
    })
    List<ItemDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/items/delete/{id}")
    @ApiOperation(value = "delete an item by his ID", notes = "This method allows you to delete an item by his ID", response = ItemDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Item has been removed"),
    })
    void delete(@PathVariable Integer id);
}

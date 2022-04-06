package sn.acodewriter.stockmanagement.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import sn.acodewriter.stockmanagement.dto.CustomerOrderDto;


import static sn.acodewriter.stockmanagement.utils.Constants.APP_ROOT;

@Api(value = APP_ROOT + "/customerorders",tags = "CustomerOrder")
public interface CustomerOrderApi {

    @PostMapping(value = APP_ROOT + "/customerorders/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Save a CustomerOrder.", notes = "This method allows you to update or set a CustomerOrder", response = CustomerOrderDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "CustomerOrder object has been created/updated"),
            @ApiResponse(code = 400, message = "CustomerOrder object is invalid."),
    })
    ResponseEntity<CustomerOrderDto> save(@RequestBody CustomerOrderDto customerOrderDto);

    @GetMapping(value = APP_ROOT + "/customerorders/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Find an CustomerOrder by his ID.", notes = "This method allows you to get an CustomerOrder by his ID", response = CustomerOrderDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "CustomerOrder object has been found"),
            @ApiResponse(code = 404, message = "No CustomerOrder with this ID was found"),
    })
    ResponseEntity<CustomerOrderDto> findById(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT + "/customerorders/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Find an custormerOrder by his CODE.", notes = "This method allows you to get an custormerOrder by his CODE", response = CustomerOrderDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "CustomerOrder object has been found"),
            @ApiResponse(code = 404, message = "No custormerOrder with this ID was found"),
    })
    ResponseEntity<CustomerOrderDto> findByIdCode(@RequestParam @PathVariable String code);

    @GetMapping(value = APP_ROOT + "/customerorders/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all customerorders", notes = "This method allows you to get all customerorders", responseContainer = "List<CustomerOrderDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "CustomerOrder list or empty list"),
    })
    ResponseEntity<List<CustomerOrderDto>> findAll();

    @DeleteMapping(value = APP_ROOT + "/customerorders/delete/{id}")
    @ApiOperation(value = "delete an CustomerOrder by his ID", notes = "This method allows you to delete an CustomerOrder by his ID", response = CustomerOrderDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "CustomerOrder has been removed"),
    })
    ResponseEntity delete(@PathVariable Integer id);
}

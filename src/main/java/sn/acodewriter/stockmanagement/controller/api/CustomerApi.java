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
import sn.acodewriter.stockmanagement.dto.CustomerDto;


import static sn.acodewriter.stockmanagement.utils.Constants.APP_ROOT;

@Api(value = APP_ROOT + "/customers", tags = "Customers")
public interface CustomerApi {

    @PostMapping(value = APP_ROOT + "/customers/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Save a Customer.", notes = "This method allows you to update or set a Customer", response = CustomerDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Customer object has been created/updated"),
            @ApiResponse(code = 400, message = "Customer object is invalid."),
    })
    CustomerDto save(@RequestBody CustomerDto CustomerDto);

    @GetMapping(value = APP_ROOT + "/customers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Find an Customer by his ID.", notes = "This method allows you to get an Customer by his ID", response = CustomerDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Customer object has been found"),
            @ApiResponse(code = 404, message = "No Customer with this ID was found"),
    })
    CustomerDto findById(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT + "/customers/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all customers", notes = "This method allows you to get all customers", responseContainer = "List<CustomerDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Customer list or empty list"),
    })
    List<CustomerDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/customers/delete/{id}")
    @ApiOperation(value = "delete an Customer by his ID", notes = "This method allows you to delete an Customer by his ID", response = CustomerDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Customer has been removed"),
    })
    void delete(@PathVariable Integer id);
}

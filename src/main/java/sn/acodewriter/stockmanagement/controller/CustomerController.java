package sn.acodewriter.stockmanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sn.acodewriter.stockmanagement.controller.api.CustomerApi;
import sn.acodewriter.stockmanagement.dto.CustomerDto;
import sn.acodewriter.stockmanagement.service.CustomerService;

@RestController
public class CustomerController implements CustomerApi {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        return customerService.save(customerDto);
    }

    @Override
    public CustomerDto findById(Integer id) {
        return customerService.findById(id);
    }

    @Override
    public List<CustomerDto> findAll() {
        return customerService.findAll();
    }

    @Override
    public void delete(Integer id) {
        customerService.delete(id);
    }
}

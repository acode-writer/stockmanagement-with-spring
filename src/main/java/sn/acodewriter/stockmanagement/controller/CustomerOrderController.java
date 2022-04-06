package sn.acodewriter.stockmanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sn.acodewriter.stockmanagement.controller.api.CustomerOrderApi;
import sn.acodewriter.stockmanagement.dto.CustomerOrderDto;
import sn.acodewriter.stockmanagement.service.CustomerOrderService;

@RestController
public class CustomerOrderController implements CustomerOrderApi {

    private CustomerOrderService customerOrderService;

    @Autowired
    public CustomerOrderController(CustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
    }

    @Override
    public ResponseEntity<CustomerOrderDto> save(CustomerOrderDto customerOrderDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerOrderService.save(customerOrderDto));
    }

    @Override
    public ResponseEntity<CustomerOrderDto> findById(Integer id) {
        return ResponseEntity.ok(customerOrderService.findById(id));
    }

    @Override
    public ResponseEntity<CustomerOrderDto> findByIdCode(String code) {
        return ResponseEntity.ok(customerOrderService.findByIdCode(code));
    }

    @Override
    public ResponseEntity<List<CustomerOrderDto>> findAll() {
        return ResponseEntity.ok(customerOrderService.findAll());
    }

    @Override
    public ResponseEntity delete(Integer id) {
        customerOrderService.delete(id);
        return ResponseEntity.ok().build();
    }
}

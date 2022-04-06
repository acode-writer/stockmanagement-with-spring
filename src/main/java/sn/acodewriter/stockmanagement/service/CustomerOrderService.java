package sn.acodewriter.stockmanagement.service;

import io.swagger.annotations.Api;
import sn.acodewriter.stockmanagement.dto.CustomerOrderDto;

import java.util.List;


import static sn.acodewriter.stockmanagement.utils.Constants.APP_ROOT;

@Api(value = APP_ROOT + "customerorders", tags = "CustomerOrders")
public interface CustomerOrderService {

    CustomerOrderDto save(CustomerOrderDto customerOrderDto);

    CustomerOrderDto findById(Integer id);

    CustomerOrderDto findByIdCode(String code);

    List<CustomerOrderDto> findAll();

    void delete(Integer id);
}

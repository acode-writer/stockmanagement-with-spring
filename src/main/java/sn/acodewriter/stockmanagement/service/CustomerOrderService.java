package sn.acodewriter.stockmanagement.service;

import sn.acodewriter.stockmanagement.dto.CustomerOrderDto;

import java.util.List;

public interface CustomerOrderService {

    CustomerOrderDto save(CustomerOrderDto customerOrderDto);

    CustomerOrderDto findById(Integer id);

    CustomerOrderDto findByIdCode(String code);

    List<CustomerOrderDto> findAll();

    void delete(Integer id);
}

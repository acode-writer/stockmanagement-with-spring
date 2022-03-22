package sn.acodewriter.stockmanagement.service;


import sn.acodewriter.stockmanagement.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto save(CustomerDto CustomerDto);

    CustomerDto findById(Integer id);

    List<CustomerDto> findAll();

    void delete(Integer id);
}

package sn.acodewriter.stockmanagement.service;


import sn.acodewriter.stockmanagement.dto.SupplierDto;

import java.util.List;

public interface SupplierService {

    SupplierDto save(SupplierDto SupplierDto);

    SupplierDto findById(Integer id);

    List<SupplierDto> findAll();

    void delete(Integer id);
}

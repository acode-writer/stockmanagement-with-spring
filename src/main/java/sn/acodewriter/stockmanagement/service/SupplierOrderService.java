package sn.acodewriter.stockmanagement.service;

import sn.acodewriter.stockmanagement.dto.SupplierOrderDto;

import java.util.List;

public interface SupplierOrderService {

    SupplierOrderDto save(SupplierOrderDto supplierOrderDto);

    SupplierOrderDto findById(Integer id);

    SupplierOrderDto findByIdCode(String code);

    List<SupplierOrderDto> findAll();

    void delete(Integer id);
}

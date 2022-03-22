package sn.acodewriter.stockmanagement.service;


import sn.acodewriter.stockmanagement.dto.SalesDto;

import java.util.List;

public interface SalesService {

    SalesDto save(SalesDto salesDto);

    SalesDto findById(Integer id);

    SalesDto findByIdCode(String code);

    List<SalesDto> findAll();

    void delete(Integer id);
}

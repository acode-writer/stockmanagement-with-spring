package sn.acodewriter.stockmanagement.service;

import sn.acodewriter.stockmanagement.dto.CompanyDto;

import java.util.List;

public interface CompanyService {

    CompanyDto save(CompanyDto CompanyDto);

    CompanyDto findById(Integer id);

    List<CompanyDto> findAll();

    void delete(Integer id);
}

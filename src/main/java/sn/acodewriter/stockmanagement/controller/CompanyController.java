package sn.acodewriter.stockmanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sn.acodewriter.stockmanagement.controller.api.CompanyApi;
import sn.acodewriter.stockmanagement.dto.CompanyDto;
import sn.acodewriter.stockmanagement.service.CompanyService;

@RestController
public class CompanyController implements CompanyApi {

    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public CompanyDto save(CompanyDto companyDto) {
        return companyService.save(companyDto);
    }

    @Override
    public CompanyDto findById(Integer id) {
        return companyService.findById(id);
    }

    @Override
    public List<CompanyDto> findAll() {
        return companyService.findAll();
    }

    @Override
    public void delete(Integer id) {
        companyService.delete(id);
    }
}

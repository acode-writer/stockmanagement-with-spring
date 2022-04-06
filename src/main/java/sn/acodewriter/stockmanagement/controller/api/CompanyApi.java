package sn.acodewriter.stockmanagement.controller.api;

import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sn.acodewriter.stockmanagement.dto.CompanyDto;


import static sn.acodewriter.stockmanagement.utils.Constants.COMPANY_ENDPOINT;

@Api(value = COMPANY_ENDPOINT, tags = "Companies")
public interface CompanyApi {

    @PostMapping(COMPANY_ENDPOINT + "/create")
    CompanyDto save(@RequestBody CompanyDto companyDto);

    @GetMapping(COMPANY_ENDPOINT + "/{id}")
    CompanyDto findById(@PathVariable Integer id);

    @GetMapping(COMPANY_ENDPOINT + "/all")
    List<CompanyDto> findAll();

    @DeleteMapping(COMPANY_ENDPOINT + "/delete/{id}")
    void delete(@PathVariable Integer id);
}

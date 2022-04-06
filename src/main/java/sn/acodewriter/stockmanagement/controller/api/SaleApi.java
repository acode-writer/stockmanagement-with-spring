package sn.acodewriter.stockmanagement.controller.api;

import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sn.acodewriter.stockmanagement.dto.SalesDto;


import static sn.acodewriter.stockmanagement.utils.Constants.SALE_ENDPOINT;

@Api(value = SALE_ENDPOINT, tags = "Sales")
public interface SaleApi {

    @PostMapping(SALE_ENDPOINT + "/create")
    SalesDto save(@RequestBody SalesDto salesDto);

    @GetMapping(SALE_ENDPOINT + "/{id}")
    SalesDto findById(@PathVariable Integer id);

    @GetMapping(SALE_ENDPOINT + "/{code}")
    SalesDto findByIdCode(@PathVariable String code);

    @GetMapping(SALE_ENDPOINT + "/all")
    List<SalesDto> findAll();

    @DeleteMapping(SALE_ENDPOINT + "/delete/{id}")
    void delete(@PathVariable Integer id);
}

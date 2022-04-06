package sn.acodewriter.stockmanagement.controller.api;

import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sn.acodewriter.stockmanagement.dto.SupplierOrderDto;


import static sn.acodewriter.stockmanagement.utils.Constants.SUPPLIER_ORDER_ENDPOINT;

@Api(value = SUPPLIER_ORDER_ENDPOINT, tags = "SupllierOrders")
public interface SupplierOrderApi {

    @PostMapping(SUPPLIER_ORDER_ENDPOINT + "/create")
    SupplierOrderDto save(@RequestBody SupplierOrderDto supplierOrderDto);

    @GetMapping(SUPPLIER_ORDER_ENDPOINT + "/{id}" )
    SupplierOrderDto findById(@PathVariable Integer id);

    @GetMapping(SUPPLIER_ORDER_ENDPOINT + "/{code}" )
    SupplierOrderDto findByIdCode(@PathVariable String code);

    @GetMapping(SUPPLIER_ORDER_ENDPOINT + "/all" )
    List<SupplierOrderDto> findAll();

    @DeleteMapping(SUPPLIER_ORDER_ENDPOINT + "/delete/{id}")
    void delete(@PathVariable Integer id);
}

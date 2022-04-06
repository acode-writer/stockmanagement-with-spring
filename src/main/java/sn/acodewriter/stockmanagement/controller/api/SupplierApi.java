package sn.acodewriter.stockmanagement.controller.api;

import static sn.acodewriter.stockmanagement.utils.Constants.SUPPLIER_ENDPOINT;
import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sn.acodewriter.stockmanagement.dto.SupplierDto;

@Api(value = SUPPLIER_ENDPOINT, tags = "Suppliers")
public interface SupplierApi {

    @PostMapping(SUPPLIER_ENDPOINT + "/create")
    SupplierDto save(@RequestBody SupplierDto supplierDto);

    @GetMapping(SUPPLIER_ENDPOINT + "/{id}")
    SupplierDto findById(@PathVariable Integer id);

    @GetMapping(SUPPLIER_ENDPOINT + "/all")
    List<SupplierDto> findAll();

    @DeleteMapping(SUPPLIER_ENDPOINT + "/delete/{id}")
    void delete(@PathVariable Integer id);
}

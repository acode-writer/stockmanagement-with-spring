package sn.acodewriter.stockmanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sn.acodewriter.stockmanagement.controller.api.SupplierOrderApi;
import sn.acodewriter.stockmanagement.dto.SupplierOrderDto;
import sn.acodewriter.stockmanagement.service.SupplierOrderService;

@RestController
public class SupplierOrderController implements SupplierOrderApi {

    private SupplierOrderService supplierOrderService;

    @Autowired
    public SupplierOrderController(SupplierOrderService supplierOrderService) {
        this.supplierOrderService = supplierOrderService;
    }

    @Override
    public SupplierOrderDto save(SupplierOrderDto supplierOrderDto) {
        return supplierOrderService.save(supplierOrderDto);
    }

    @Override
    public SupplierOrderDto findById(Integer id) {
        return supplierOrderService.findById(id);
    }

    @Override
    public SupplierOrderDto findByIdCode(String code) {
        return supplierOrderService.findByIdCode(code);
    }

    @Override
    public List<SupplierOrderDto> findAll() {
        return supplierOrderService.findAll();
    }

    @Override
    public void delete(Integer id) {
        supplierOrderService.delete(id);
    }
}

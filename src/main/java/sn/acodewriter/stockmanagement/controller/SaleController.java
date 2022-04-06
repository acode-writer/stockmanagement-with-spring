package sn.acodewriter.stockmanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sn.acodewriter.stockmanagement.controller.api.SaleApi;
import sn.acodewriter.stockmanagement.dto.SalesDto;
import sn.acodewriter.stockmanagement.service.SalesService;

@RestController
public class SaleController implements SaleApi {

    private SalesService salesService;

    @Autowired
    public SaleController(SalesService salesService) {
        this.salesService = salesService;
    }

    @Override
    public SalesDto save(SalesDto salesDto) {
        return salesService.save(salesDto);
    }

    @Override
    public SalesDto findById(Integer id) {
        return salesService.findById(id);
    }

    @Override
    public SalesDto findByIdCode(String code) {
        return salesService.findByIdCode(code);
    }

    @Override
    public List<SalesDto> findAll() {
        return salesService.findAll();
    }

    @Override
    public void delete(Integer id) {
        salesService.delete(id);
    }
}

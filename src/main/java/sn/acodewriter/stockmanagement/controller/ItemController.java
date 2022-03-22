package sn.acodewriter.stockmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sn.acodewriter.stockmanagement.controller.api.ItemApi;
import sn.acodewriter.stockmanagement.dto.ItemDto;
import sn.acodewriter.stockmanagement.service.ItemService;

import java.util.List;

@RestController
public class ItemController implements ItemApi {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    public ItemDto save(ItemDto itemDto) {
        return itemService.save(itemDto);
    }

    @Override
    public ItemDto findById(Integer id) {
        return itemService.findById(id);
    }

    @Override
    public ItemDto findByItemCode(String itemCode) {
        return itemService.findByItemCode(itemCode);
    }

    @Override
    public List<ItemDto> findAll() {
        return itemService.findAll();
    }

    @Override
    public void delete(Integer id) {
        itemService.delete(id);
    }
}

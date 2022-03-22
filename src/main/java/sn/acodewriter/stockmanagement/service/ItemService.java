package sn.acodewriter.stockmanagement.service;

import sn.acodewriter.stockmanagement.dto.ItemDto;

import java.util.List;

public interface ItemService {

    ItemDto save(ItemDto itemDto);

    ItemDto findById(Integer id);

    ItemDto findByItemCode(String itemCode);

    List<ItemDto> findAll();

    void delete(Integer id);
}

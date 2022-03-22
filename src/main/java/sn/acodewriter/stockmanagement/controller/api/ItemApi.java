package sn.acodewriter.stockmanagement.controller.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sn.acodewriter.stockmanagement.dto.ItemDto;
import sn.acodewriter.stockmanagement.utils.Constants;

import java.util.List;

public interface ItemApi {

    @PostMapping(value = Constants.APP_ROOT + "/items/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ItemDto save( @RequestBody ItemDto itemDto);

    @GetMapping(value = Constants.APP_ROOT + "/items/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ItemDto findById(@PathVariable Integer id);

    @GetMapping(value = Constants.APP_ROOT + "/items/{itemCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    ItemDto findByItemCode(@PathVariable String itemCode);

    @GetMapping(value = Constants.APP_ROOT + "/items/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ItemDto> findAll();

    @DeleteMapping(value = Constants.APP_ROOT + "/items/delete/{id}")
    void delete(@PathVariable Integer id);
}

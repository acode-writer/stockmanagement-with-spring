package sn.acodewriter.stockmanagement.service.implement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.acodewriter.stockmanagement.dto.ItemDto;
import sn.acodewriter.stockmanagement.exception.EntityNotFoundException;
import sn.acodewriter.stockmanagement.exception.ErrorCodes;
import sn.acodewriter.stockmanagement.exception.InvalidEntityException;
import sn.acodewriter.stockmanagement.repository.ItemRepository;
import sn.acodewriter.stockmanagement.service.ItemService;
import sn.acodewriter.stockmanagement.validator.ItemValidator;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ItemServiceImplement implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImplement(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ItemDto save(ItemDto itemDto) {
        List<String> errors = ItemValidator.validate(itemDto);
        if (!errors.isEmpty()){
            log.error("Item is not valid {}", itemDto);
            throw new InvalidEntityException("Item not valid", ErrorCodes.ITEM_NOT_VALID);
        }
        return ItemDto.fromEntity(
                itemRepository.save(
                        ItemDto.toEntity(itemDto)
                )
        );
    }

    @Override
    public ItemDto findById(Integer id) {
        if (id == null){
            log.error("item ID is null");
            throw new EntityNotFoundException("Item ID is null", ErrorCodes.ITEM_NOT_FOUND);
        }

        return itemRepository.findById(id)
                .map(ItemDto::fromEntity)
                .orElseThrow(() ->
                new EntityNotFoundException("Item not found",ErrorCodes.ITEM_NOT_FOUND)
        );
    }

    @Override
    public ItemDto findByItemCode(String itemCode) {
        if (itemCode == null){
            log.error("Item's CODE is null");
            throw new EntityNotFoundException("Item's CODE is null", ErrorCodes.ITEM_NOT_FOUND);
        }
        return itemRepository.findItemsByItemCode(itemCode)
                .map(ItemDto::fromEntity)
                .orElseThrow(() ->
                new EntityNotFoundException("Item not found",ErrorCodes.ITEM_NOT_FOUND)
        );
    }

    @Override
    public List<ItemDto> findAll() {
        return itemRepository.findAll()
                .stream()
                .map(ItemDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("item ID is null");
            throw new EntityNotFoundException("Item ID is null", ErrorCodes.ITEM_NOT_FOUND);
        }
        itemRepository.deleteById(id);
    }
}

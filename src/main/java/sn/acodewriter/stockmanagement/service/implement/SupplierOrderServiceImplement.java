package sn.acodewriter.stockmanagement.service.implement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.acodewriter.stockmanagement.dto.SupplierOrderDto;
import sn.acodewriter.stockmanagement.dto.SupplierOrderDto;
import sn.acodewriter.stockmanagement.dto.SupplierOrderLineDto;
import sn.acodewriter.stockmanagement.exception.EntityNotFoundException;
import sn.acodewriter.stockmanagement.exception.ErrorCodes;
import sn.acodewriter.stockmanagement.exception.InvalidEntityException;
import sn.acodewriter.stockmanagement.model.Supplier;
import sn.acodewriter.stockmanagement.model.SupplierOrder;
import sn.acodewriter.stockmanagement.model.SupplierOrderLine;
import sn.acodewriter.stockmanagement.model.Item;
import sn.acodewriter.stockmanagement.repository.ItemRepository;
import sn.acodewriter.stockmanagement.repository.SupplierOrderLineRepository;
import sn.acodewriter.stockmanagement.repository.SupplierOrderRepository;
import sn.acodewriter.stockmanagement.repository.SupplierRepository;
import sn.acodewriter.stockmanagement.service.SupplierOrderService;
import sn.acodewriter.stockmanagement.validator.SupplierOrderValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SupplierOrderServiceImplement implements SupplierOrderService {

    private final SupplierOrderRepository supplierOrderRepository;
    private final SupplierOrderLineRepository supplierOrderLineRepository;
    private final SupplierRepository supplierRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public SupplierOrderServiceImplement(SupplierOrderRepository supplierOrderRepository, SupplierOrderLineRepository supplierOrderLineRepository, SupplierRepository supplierRepository, ItemRepository itemRepository) {
        this.supplierOrderRepository = supplierOrderRepository;
        this.supplierOrderLineRepository = supplierOrderLineRepository;
        this.supplierRepository = supplierRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public SupplierOrderDto save(SupplierOrderDto supplierOrderDto) {
        List<String> errors = SupplierOrderValidator.validate(supplierOrderDto);

        if (!errors.isEmpty()){
            log.error("SupplierOrder is not valid {}", supplierOrderDto);
            throw new InvalidEntityException("SupplierOrder is not valid", ErrorCodes.SUPPLIER_ORDER_NOT_VALID, errors);
        }
        Optional<Supplier> supplier = supplierRepository.findById(supplierOrderDto.getSupplier().getId());
        if (!supplier.isPresent()){
            Integer id = supplierOrderDto.getSupplier().getId();
            log.warn("No Supplier with ID {} wa found.", id);
            throw new EntityNotFoundException("No Supplier with ID: " + id + " was found.", ErrorCodes.SUPPLIER_NOT_FOUND);
        }

        List<SupplierOrderLineDto> supplierOrderLines = supplierOrderDto.getSupplierOrderLines();
        List<String> itemErrors = new ArrayList<>();
        if (supplierOrderLines != null){
            supplierOrderLines.forEach( supplierOrderLine -> {
                if (supplierOrderLine.getItem() != null){
                    Integer id = supplierOrderLine.getItem().getId();
                    Optional<Item>  item = itemRepository.findById(id);
                    if (item.isEmpty()){
                        itemErrors.add("The Item with this ID : " + id + "was not found");
                    }
                }else{
                    itemErrors.add("Cannot save an order with null Item ID");
                }
            });
        }
        if (!itemErrors.isEmpty()){
            log.warn("");
            throw new InvalidEntityException("These Items were not found.", ErrorCodes.ITEM_NOT_FOUND, itemErrors);
        }

        SupplierOrder savedSupplierOrder = supplierOrderRepository.save(SupplierOrderDto.toEntity(supplierOrderDto));

        if (supplierOrderDto.getSupplierOrderLines() != null){
            supplierOrderDto.getSupplierOrderLines().forEach( orderLine -> {
                SupplierOrderLine supplierOrderLine = SupplierOrderLineDto.toEntity(orderLine);
                supplierOrderLine.setSupplierOrder(savedSupplierOrder);
                supplierOrderLineRepository.save(supplierOrderLine);
            });
        }

        return SupplierOrderDto.fromEntity(savedSupplierOrder);
    }

    @Override
    public SupplierOrderDto findById(Integer id) {
        if(id == null){
            log.error("Supplier Order ID is null");
            throw new EntityNotFoundException("Supplier Order ID is null", ErrorCodes.SUPPLIER_ORDER_NOT_FOUND);
        }
        return supplierOrderRepository.findById(id)
                .map(SupplierOrderDto::fromEntity)
                .orElseThrow( () -> new EntityNotFoundException("No Supplier Order wuth this ID: " + id + "was found.", ErrorCodes.SUPPLIER_ORDER_NOT_FOUND));
    }

    @Override
    public SupplierOrderDto findByIdCode(String code) {
        if(code == null){
            log.error("Supplier Order CODE is null");
            throw new EntityNotFoundException("Supplier Order CODE is null", ErrorCodes.SUPPLIER_ORDER_NOT_FOUND);
        }
        return supplierOrderRepository.findByCode(code)
                .map(SupplierOrderDto::fromEntity)
                .orElseThrow( () -> new EntityNotFoundException("No Supplier Order wuth this CODE: " + code + "was found.", ErrorCodes.SUPPLIER_ORDER_NOT_FOUND));
    }

    @Override
    public List<SupplierOrderDto> findAll() {
        return supplierOrderRepository.findAll()
                .stream()
                .map(SupplierOrderDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Supplier Order ID is null");
            throw new EntityNotFoundException("Supplier Order ID is null", ErrorCodes.CUSTOMER_ORDER_NOT_FOUND);
        }

        supplierOrderRepository.deleteById(id);
    }
}

package sn.acodewriter.stockmanagement.service.implement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.acodewriter.stockmanagement.dto.CustomerOrderDto;
import sn.acodewriter.stockmanagement.dto.CustomerOrderLineDto;
import sn.acodewriter.stockmanagement.exception.EntityNotFoundException;
import sn.acodewriter.stockmanagement.exception.ErrorCodes;
import sn.acodewriter.stockmanagement.exception.InvalidEntityException;
import sn.acodewriter.stockmanagement.model.Customer;
import sn.acodewriter.stockmanagement.model.CustomerOrder;
import sn.acodewriter.stockmanagement.model.CustomerOrderLine;
import sn.acodewriter.stockmanagement.model.Item;
import sn.acodewriter.stockmanagement.repository.CustomerOrderLineRepository;
import sn.acodewriter.stockmanagement.repository.CustomerOrderRepository;
import sn.acodewriter.stockmanagement.repository.CustomerRepository;
import sn.acodewriter.stockmanagement.repository.ItemRepository;
import sn.acodewriter.stockmanagement.service.CustomerOrderService;
import sn.acodewriter.stockmanagement.validator.CustomerOrderValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerOrderServiceImplement implements CustomerOrderService {

    private final CustomerOrderRepository customerOrderRepository;
    private final CustomerRepository customerRepository;
    private final CustomerOrderLineRepository customerOrderLineRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public CustomerOrderServiceImplement(CustomerOrderRepository customerOrderRepository, CustomerRepository customerRepository, CustomerOrderLineRepository customerOrderLineRepository, ItemRepository itemRepository) {
        this.customerOrderRepository = customerOrderRepository;
        this.customerRepository = customerRepository;
        this.customerOrderLineRepository = customerOrderLineRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public CustomerOrderDto save(CustomerOrderDto customerOrderDto) {
        List<String> errors = CustomerOrderValidator.validate(customerOrderDto);

        if (!errors.isEmpty()){
           log.error("CustomerOrder is not valid {}", customerOrderDto);
           throw new InvalidEntityException("CustomerOrder is not valid", ErrorCodes.CUSTOMER_ORDER_NOT_VALID, errors);
        }
        Optional<Customer> customer = customerRepository.findById(customerOrderDto.getCustomer().getId());
        if (!customer.isPresent()){
            Integer id = customerOrderDto.getCustomer().getId();
            log.warn("No CustomerController with ID {} wa found.", id);
            throw new EntityNotFoundException("No CustomerController with ID: " + id + " was found.", ErrorCodes.CUSTOMER_NOT_FOUND);
        }

        List<CustomerOrderLineDto> customerOrderLines = customerOrderDto.getCustomerOrderLines();
        List<String> itemErrors = new ArrayList<>();
        if (customerOrderLines != null){
            customerOrderLines.forEach( customerOrderLine -> {
                if (customerOrderLine.getItem() != null){
                    Integer id = customerOrderLine.getItem().getId();
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

        CustomerOrder savedCustomerOrder = customerOrderRepository.save(CustomerOrderDto.toEntity(customerOrderDto));

        if (customerOrderDto.getCustomerOrderLines() != null){
            customerOrderDto.getCustomerOrderLines().forEach( orderLine -> {
                CustomerOrderLine customerOrderLine = CustomerOrderLineDto.toEntity(orderLine);
                customerOrderLine.setCustomerOrder(savedCustomerOrder);
                customerOrderLineRepository.save(customerOrderLine);
            });
        }

        return CustomerOrderDto.fromEntity(savedCustomerOrder);
    }

    @Override
    public CustomerOrderDto findById(Integer id) {
        if(id == null){
            log.error("CustomerController Order ID is null");
            throw new EntityNotFoundException("CustomerController Order ID is null", ErrorCodes.CUSTOMER_ORDER_NOT_FOUND);
        }
        return customerOrderRepository.findById(id)
                .map(CustomerOrderDto::fromEntity)
                .orElseThrow( () -> new EntityNotFoundException("No CustomerController Order wuth this ID: " + id + "was found.", ErrorCodes.CUSTOMER_ORDER_NOT_FOUND));
    }

    @Override
    public CustomerOrderDto findByIdCode(String code) {
        if(code == null){
            log.error("CustomerController Order CODE is null");
            throw new EntityNotFoundException("CustomerController Order CODE is null", ErrorCodes.CUSTOMER_ORDER_NOT_FOUND);
        }
        return customerOrderRepository.findByCode(code)
                .map(CustomerOrderDto::fromEntity)
                .orElseThrow( () -> new EntityNotFoundException("No CustomerController Order wuth this CODE: " + code + "was found.", ErrorCodes.CUSTOMER_ORDER_NOT_FOUND));
    }

    @Override
    public List<CustomerOrderDto> findAll() {
        return customerOrderRepository.findAll()
                .stream()
                .map(CustomerOrderDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("CustomerController Order ID is null");
            throw new EntityNotFoundException("CustomerController Order ID is null", ErrorCodes.CUSTOMER_ORDER_NOT_FOUND);
        }

        customerOrderRepository.deleteById(id);
    }
}

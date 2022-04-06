package sn.acodewriter.stockmanagement.service.implement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.acodewriter.stockmanagement.dto.CustomerDto;
import sn.acodewriter.stockmanagement.exception.EntityNotFoundException;
import sn.acodewriter.stockmanagement.exception.ErrorCodes;
import sn.acodewriter.stockmanagement.exception.InvalidEntityException;
import sn.acodewriter.stockmanagement.repository.CustomerRepository;
import sn.acodewriter.stockmanagement.service.CustomerService;
import sn.acodewriter.stockmanagement.validator.CustomerValidator;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerServiceImplement implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImplement(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        List<String> errors = CustomerValidator.validate(customerDto);
        if (!errors.isEmpty()){
            log.error("CustomerController is not valid {}", ErrorCodes.CUSTOMER_NOT_VALID);
            throw new InvalidEntityException("CustomerController is not valid", ErrorCodes.CUSTOMER_NOT_VALID);
        }
        return CustomerDto.fromEntity(
                customerRepository.save(
                        CustomerDto.toEntity(customerDto)));
    }

    @Override
    public CustomerDto findById(Integer id) {
        if (id == null){
            log.error("CustomerController ID is null ");
            throw new InvalidEntityException("CustomerController ID is null", ErrorCodes.CUSTOMER_NOT_FOUND);
        }
        return customerRepository.findById(id)
                .map(CustomerDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No CustomerController with ID: " + id, ErrorCodes.CUSTOMER_NOT_FOUND));
    }

    @Override
    public List<CustomerDto> findAll() {
        return customerRepository.findAll()
                .stream()
                .map(CustomerDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("CustomerController ID is null ");
            throw new InvalidEntityException("CustomerController ID is null", ErrorCodes.CUSTOMER_NOT_FOUND);
        }

        customerRepository.deleteById(id);
    }
}

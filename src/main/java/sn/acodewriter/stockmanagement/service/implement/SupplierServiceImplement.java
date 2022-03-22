package sn.acodewriter.stockmanagement.service.implement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.acodewriter.stockmanagement.dto.SupplierDto;
import sn.acodewriter.stockmanagement.exception.EntityNotFoundException;
import sn.acodewriter.stockmanagement.exception.ErrorCodes;
import sn.acodewriter.stockmanagement.exception.InvalidEntityException;
import sn.acodewriter.stockmanagement.repository.SupplierRepository;
import sn.acodewriter.stockmanagement.service.SupplierService;
import sn.acodewriter.stockmanagement.validator.SupplierValidator;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SupplierServiceImplement implements SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImplement(SupplierRepository supplierRepository) {
        this.supplierRepository =  supplierRepository;
    }

    @Override
    public SupplierDto save(SupplierDto supplierDto) {
        List<String> errors = SupplierValidator.validate(supplierDto);
        if (!errors.isEmpty()){
            log.error("Supplier is not valid {}", supplierDto);
            throw new InvalidEntityException("Supplier not valid", ErrorCodes.SUPPLIER_NOT_VALID);
        }
        return SupplierDto.fromEntity(
                supplierRepository.save(
                        SupplierDto.toEntity(supplierDto)) );
    }

    @Override
    public SupplierDto findById(Integer id) {
        if (id == null){
            log.error("Supplier ID is null");
            throw new EntityNotFoundException("Supplier ID is null", ErrorCodes.SUPPLIER_NOT_FOUND);
        }
        return supplierRepository.findById(id)
                .map(SupplierDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found",ErrorCodes.SUPPLIER_NOT_FOUND));
    }


    @Override
    public List<SupplierDto> findAll() {
        return supplierRepository.findAll()
                .stream()
                .map(SupplierDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Supplier ID is null");
            throw new EntityNotFoundException("Supplier ID is null", ErrorCodes.SUPPLIER_NOT_FOUND);
        }
        supplierRepository.deleteById(id);
    }
}

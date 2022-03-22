package sn.acodewriter.stockmanagement.service.implement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sn.acodewriter.stockmanagement.dto.SalesDto;
import sn.acodewriter.stockmanagement.dto.SalesLineDto;
import sn.acodewriter.stockmanagement.exception.EntityNotFoundException;
import sn.acodewriter.stockmanagement.exception.ErrorCodes;
import sn.acodewriter.stockmanagement.exception.InvalidEntityException;
import sn.acodewriter.stockmanagement.model.Item;
import sn.acodewriter.stockmanagement.model.Sales;
import sn.acodewriter.stockmanagement.model.SalesLine;
import sn.acodewriter.stockmanagement.repository.ItemRepository;
import sn.acodewriter.stockmanagement.repository.SalesLineRepository;
import sn.acodewriter.stockmanagement.repository.SalesRepository;
import sn.acodewriter.stockmanagement.service.SalesService;
import sn.acodewriter.stockmanagement.validator.SalesValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SalesServiceImplement implements SalesService {
   
    private final ItemRepository itemRepository;
    private final SalesRepository salesRepository;
    private final SalesLineRepository salesLineRepository;

    public SalesServiceImplement(ItemRepository itemRepository, SalesRepository salesRepository, SalesLineRepository salesLineRepository) {
        this.itemRepository = itemRepository;
        this.salesRepository = salesRepository;
        this.salesLineRepository = salesLineRepository;
    }

    @Override
    public SalesDto save(SalesDto salesDto) {
        List<String> errors = SalesValidator.validate(salesDto);
        
        if (!errors.isEmpty()){
            log.error("Sale is not valid {}", salesDto);
            throw new InvalidEntityException("Sale is not valid", ErrorCodes.SALE_NOT_VALID, errors);
        }
        
        List<String> itemErrors = new ArrayList<>();
        salesDto.getSalesLines().forEach( salesLineDto -> {
            Integer id = salesLineDto.getId();
            Optional<Item> item = itemRepository.findById(id);
            if (item.isEmpty()){
                itemErrors.add("No Item with ID: " + id + " was found");
            }
        });
        
        if (!itemErrors.isEmpty()){
            log.error("No Item  was found, {}" , itemErrors);
            throw new InvalidEntityException("No Item was found", ErrorCodes.SALE_NOT_FOUND, itemErrors);
        }
        Sales savedSale = salesRepository.save(SalesDto.toEntity(salesDto));
        
        salesDto.getSalesLines().forEach( lineDto -> {
            SalesLine salesLine = SalesLineDto.toEntity(lineDto);
            salesLine.setSale(savedSale);
            salesLineRepository.save(salesLine);
        });
        
        return SalesDto.fromEntity(savedSale);
    }

    @Override
    public SalesDto findById(Integer id) {
        if(id == null){
            log.error("Sale ID is null");
            throw new EntityNotFoundException("Sale ID is null", ErrorCodes.SALE_NOT_FOUND);
        }
        return salesRepository.findById(id)
                .map(SalesDto::fromEntity)
                .orElseThrow( () -> new EntityNotFoundException("No Sale wuth this ID: " + id + "was found.", ErrorCodes.SALE_NOT_FOUND));
    }

    @Override
    public SalesDto findByIdCode(String code) {
        if(code == null){
            log.error("Sale  CODE is null");
            throw new EntityNotFoundException("Sale  CODE is null", ErrorCodes.SALE_NOT_FOUND);
        }
        return salesRepository.findByCode(code)
                .map(SalesDto::fromEntity)
                .orElseThrow( () -> new EntityNotFoundException("No Sale  wuth this CODE: " + code + "was found.", ErrorCodes.SALE_NOT_FOUND));
    }

    @Override
    public List<SalesDto> findAll() {
        return salesRepository.findAll()
                .stream()
                .map(SalesDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Sale Order ID is null");
            throw new EntityNotFoundException("Sale  ID is null", ErrorCodes.SALE_NOT_FOUND);
        }

        salesRepository.deleteById(id);
    }
}

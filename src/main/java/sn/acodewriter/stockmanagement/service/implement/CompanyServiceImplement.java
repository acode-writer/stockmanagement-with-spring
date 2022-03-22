package sn.acodewriter.stockmanagement.service.implement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.acodewriter.stockmanagement.dto.CompanyDto;
import sn.acodewriter.stockmanagement.exception.EntityNotFoundException;
import sn.acodewriter.stockmanagement.exception.ErrorCodes;
import sn.acodewriter.stockmanagement.exception.InvalidEntityException;
import sn.acodewriter.stockmanagement.repository.CompanyRepository;
import sn.acodewriter.stockmanagement.service.CompanyService;
import sn.acodewriter.stockmanagement.validator.CompanyValidator;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CompanyServiceImplement implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImplement(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public CompanyDto save(CompanyDto companyDto) {
        List<String> errors = CompanyValidator.validate(companyDto);
        if (!errors.isEmpty()){
            log.error("Company is not valid {}", companyDto);
            throw new InvalidEntityException("Company is not valid", ErrorCodes.COMPANY_NOT_VALID);
        }
        return CompanyDto.fromEntity(
                companyRepository.save(
                        CompanyDto.toEntity(companyDto)));
    }

    @Override
    public CompanyDto findById(Integer id) {
        if (id == null){
            log.error("Company ID is null");
            throw new InvalidEntityException("Company ID is null", ErrorCodes.COMPANY_NOT_FOUND);
        }
        return companyRepository.findById(id)
                .map(CompanyDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No Company with this ID: " + id, ErrorCodes.COMPANY_NOT_FOUND));
    }

    @Override
    public List<CompanyDto> findAll() {
        return companyRepository.findAll()
                .stream()
                .map(CompanyDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Company ID is null");
            throw new InvalidEntityException("Company ID is null", ErrorCodes.COMPANY_NOT_FOUND);
        }
        companyRepository.deleteById(id);
    }
}

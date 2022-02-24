package sn.acodewriter.stockmanagement.dto;

import lombok.Builder;
import lombok.Data;
import sn.acodewriter.stockmanagement.model.Company;

@Builder
@Data
public class CompanyDto {

    private Integer id;

    private String name;

    public static CompanyDto fromEntity(Company company){
        if (company == null){
            return null;
        }
        return CompanyDto.builder()
                .id(company.getId())
                .name(company.getName())
                .build();
    }

    public static Company toEntity(CompanyDto companyDto){
        if (companyDto == null){
            return null;
        }

        Company company = new Company();
        company.setId(companyDto.getId());
        company.setName(companyDto.getName());
        return company;
    }
}

package sn.acodewriter.stockmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import sn.acodewriter.stockmanagement.model.Company;

import java.util.List;

@Builder
@Data
public class CompanyDto {

    private Integer id;

    private String name;

    private String description;

    private AddressDto address;

    private String taxCode;

    private String photo;

    private String mail;

    private String phoneNumber;

    private String website;

    @JsonIgnore
    private List<UsersDto> users;

    public static CompanyDto fromEntity(Company company){
        if (company == null){
            return null;
        }
        return CompanyDto.builder()
                .id(company.getId())
                .name(company.getName())
                .description(company.getDescription())
                .address(AddressDto.fromEntity(company.getAddress()))
                .taxCode(company.getTaxCode())
                .photo(company.getPhoto())
                .mail(company.getMail())
                .phoneNumber(company.getPhoneNumber())
                .website(company.getWebsite())
                .build();
    }

    public static Company toEntity(CompanyDto companyDto){
        if (companyDto == null){
            return null;
        }

        Company company = new Company();
        company.setId(companyDto.getId());
        company.setName(companyDto.getName());
        company.setDescription(companyDto.getName());
        company.setAddress(AddressDto.toEntity(companyDto.getAddress()));
        company.setTaxCode(companyDto.getTaxCode());
        company.setPhoto(companyDto.getPhoto());
        company.setMail(companyDto.getMail());
        company.setPhoneNumber(companyDto.getPhoneNumber());
        company.setWebsite(companyDto.getWebsite());
        return company;
    }
}

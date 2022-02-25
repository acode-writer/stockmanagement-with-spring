package sn.acodewriter.stockmanagement.validator;

import org.springframework.util.StringUtils;
import sn.acodewriter.stockmanagement.dto.CompanyDto;

import java.util.ArrayList;
import java.util.List;

public class CompanyValidator {

    public static List<String> validate(CompanyDto companyDto) {
        List<String> errors = new ArrayList<>();
        if (companyDto == null) {
            errors.add("Veuillez renseigner le nom de l'entreprise");
            errors.add("Veuillez reseigner la description de l'entreprise");
            errors.add("Veuillez reseigner le code fiscal de l'entreprise");
            errors.add("Veuillez reseigner l'email de l'entreprise");
            errors.add("Veuillez reseigner le numero de telephone de l'entreprise");
            errors.addAll(AddressValidatror.validate(companyDto.getAddress()));
        }else{
            if (!StringUtils.hasLength(companyDto.getName())) {
                errors.add("Veuillez renseigner le nom de l'entreprise");
            }
            if (!StringUtils.hasLength(companyDto.getDescription())) {
                errors.add("Veuillez reseigner la description de l'entreprise");
            }
            if (!StringUtils.hasLength(companyDto.getTaxCode())) {
                errors.add("Veuillez reseigner le code fiscal de l'entreprise");
            }
            if (!StringUtils.hasLength(companyDto.getMail())) {
                errors.add("Veuillez reseigner l'email de l'entreprise");
            }
            if (!StringUtils.hasLength(companyDto.getPhoneNumber())) {
                errors.add("Veuillez reseigner le numero de telephone de l'entreprise");
            }
            errors.addAll(AddressValidatror.validate(companyDto.getAddress()));
        }

        return errors;
    }
}

package sn.acodewriter.stockmanagement.validator;

import org.springframework.util.StringUtils;
import sn.acodewriter.stockmanagement.dto.CustomerDto;

import java.util.ArrayList;
import java.util.List;

public class CustomerValidator {

    public static List<String> validate(CustomerDto customerDto){

        List<String> errors = new ArrayList<String>();

        if (customerDto == null) {
            errors.add("Veuillew renseigner le nom du client");
            errors.add("Veuillew renseigner le prenom du client");
            errors.add("Veuillew renseigner l'email du client");
            errors.add("Veuillew renseigner le numero de telephone du client");
            errors.addAll(AddressValidatror.validate(customerDto.getAdderess()));
        }else{
            if (!StringUtils.hasLength(customerDto.getName())){
                errors.add("Veuillew renseigner le nom du client");
            }
            if (!StringUtils.hasLength(customerDto.getFirstname())){
                errors.add("Veuillew renseigner le prenom du client");
            }
            if (!StringUtils.hasLength(customerDto.getMail())){
                errors.add("Veuillew renseigner l'email du client");
            }
            if (!StringUtils.hasLength(customerDto.getPhoneNumber())){
                errors.add("Veuillew renseigner le numero de telephone du client");
            }
            errors.addAll(AddressValidatror.validate(customerDto.getAdderess()));
        }

        return errors;
    }
}

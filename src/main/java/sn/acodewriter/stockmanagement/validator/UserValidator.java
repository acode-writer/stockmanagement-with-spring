package sn.acodewriter.stockmanagement.validator;

import org.springframework.util.StringUtils;
import sn.acodewriter.stockmanagement.dto.UsersDto;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    public static List<String> validate(UsersDto usersDto){
        List<String> errors = new ArrayList<String>();
        if (usersDto == null) {
            errors.add("Veuillew renseigner le nom de l'utilisateur.");
            errors.add("Veuillew renseigner le prenom de l'utilisateur.");
            errors.add("Veuillew renseigner le mot de passe  de l'utilisateur.");
            errors.add("Veuillew renseigner l'email de l'utilisateur.");
            errors.add("Veuillew renseigner la date de naissancs de l'utilisateur.");
            errors.add("Veuillew renseigner l'adresse de l'utilisateur.");
            errors.addAll(AddressValidatror.validate(usersDto.getAdderess()));
        }else {
            if (!StringUtils.hasLength(usersDto.getName())){
                errors.add("Veuillew renseigner le nom de l'utilisateur.");
            }
            if (!StringUtils.hasLength(usersDto.getFirstname())){
                errors.add("Veuillew renseigner le prenom de l'utilisateur.");
            }
            if (!StringUtils.hasLength(usersDto.getMail())){
                errors.add("Veuillew renseigner l'email de l'utilisateur.");
            }
            if (!StringUtils.hasLength(usersDto.getPassword())){
                errors.add("Veuillew renseigner le mot de passe  de l'utilisateur.");
            }
            if (usersDto.getDateOfBirth() == null){
                errors.add("Veuillew renseigner la date de naissancs de l'utilisateur.");
            }
            errors.addAll(AddressValidatror.validate(usersDto.getAdderess()));
        }

        return errors;
    }
}

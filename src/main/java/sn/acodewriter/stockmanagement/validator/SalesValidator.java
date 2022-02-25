package sn.acodewriter.stockmanagement.validator;

import org.springframework.util.StringUtils;
import sn.acodewriter.stockmanagement.dto.SalesDto;

import java.util.ArrayList;
import java.util.List;

public class SalesValidator {

    public static List<String> validate(SalesDto salesDto) {
        List<String> errors = new ArrayList<>();
        if (salesDto == null) {
            errors.add("Veuillez renseigner le code de la commande");
            errors.add("Veuillez renseigner la date de la commande");
        }else{
            if (!StringUtils.hasLength(salesDto.getCode())) {
                errors.add("Veuillez renseigner le code de la commande");
            }
            if (salesDto.getSaledOn() == null) {
                errors.add("Veuillez renseigner la date de la commande");
            }
        }

        return errors;
    }

}

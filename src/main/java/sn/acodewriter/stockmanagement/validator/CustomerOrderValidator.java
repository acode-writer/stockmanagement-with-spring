package sn.acodewriter.stockmanagement.validator;

import org.springframework.util.StringUtils;
import sn.acodewriter.stockmanagement.dto.CustomerOrderDto;

import java.util.ArrayList;
import java.util.List;

public class CustomerOrderValidator {

    public static List<String> validate(CustomerOrderDto customerOrderDto) {
        List<String> errors = new ArrayList<>();
        if (customerOrderDto == null) {
            errors.add("Veuillez renseigner le code de la commande");
            errors.add("Veuillez renseigner la date de la commande");
            errors.add("Veuillez renseigner l'etat de la commande");
            errors.add("Veuillez renseigner le client");
        }else{
            if (!StringUtils.hasLength(customerOrderDto.getCode())) {
                errors.add("Veuillez renseigner le code de la commande");
            }
            if (customerOrderDto.getOrderedAt() == null) {
                errors.add("Veuillez renseigner la date de la commande");
            }
            if (!StringUtils.hasLength(customerOrderDto.getOrderStatus().toString())) {
                errors.add("Veuillez renseigner l'etat de la commande");
            }
            if (customerOrderDto.getCustomer() == null || customerOrderDto.getCustomer().getId() == null) {
                errors.add("Veuillez renseigner le client");
            }
        }

        return errors;
    }
}

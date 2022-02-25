package sn.acodewriter.stockmanagement.validator;

import org.springframework.util.StringUtils;
import sn.acodewriter.stockmanagement.dto.SupplierOrderDto;

import java.util.ArrayList;
import java.util.List;

public class SupplierOrderValidator {

    public static List<String> validate(SupplierOrderDto supplierOrderDto) {
        List<String> errors = new ArrayList<>();
        if (supplierOrderDto == null) {
            errors.add("Veuillez renseigner le code de la commande");
            errors.add("Veuillez renseigner la date de la commande");
            errors.add("Veuillez renseigner l'etat de la commande");
            errors.add("Veuillez renseigner le client");
        }else {
            if (!StringUtils.hasLength(supplierOrderDto.getCode())) {
                errors.add("Veuillez renseigner le code de la commande");
            }
            if (supplierOrderDto.getOrderedAt() == null) {
                errors.add("Veuillez renseigner la date de la commande");
            }
            if (!StringUtils.hasLength(supplierOrderDto.getOrderStatus().toString())) {
                errors.add("Veuillez renseigner l'etat de la commande");
            }
            if (supplierOrderDto.getSupplier() == null || supplierOrderDto.getSupplier().getId() == null) {
                errors.add("Veuillez renseigner le fournisseur");
            }
        }

        return errors;
    }
}

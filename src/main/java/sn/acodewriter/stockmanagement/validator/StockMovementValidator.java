package sn.acodewriter.stockmanagement.validator;

import org.springframework.util.StringUtils;
import sn.acodewriter.stockmanagement.dto.StockMovementDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StockMovementValidator {

    public static List<String> validate(StockMovementDto stockMovementDto) {
        List<String> errors = new ArrayList<>();
        if (stockMovementDto == null) {
            errors.add("Veuillez renseigner la date du mouvenent");
            errors.add("Veuillez renseigner la quantite du mouvenent");
            errors.add("Veuillez renseigner l'article");
            errors.add("Veuillez renseigner le type du mouvement");
        }else{
            if (stockMovementDto.getDateOfMovement() == null) {
                errors.add("Veuillez renseigner la date du mouvenent");
            }
            if (stockMovementDto.getQuantity() == null || stockMovementDto.getQuantity().compareTo(BigDecimal.ZERO) == 0) {
                errors.add("Veuillez renseigner la quantite du mouvenent");
            }
            if (stockMovementDto.getItem() == null || stockMovementDto.getItem().getId() == null) {
                errors.add("Veuillez renseigner l'article");
            }
            if (!StringUtils.hasLength(stockMovementDto.getStockMovementType().name())) {
                errors.add("Veuillez renseigner le type du mouvement");
            }
        }

        return errors;
    }
}

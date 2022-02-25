package sn.acodewriter.stockmanagement.validator;

import org.springframework.util.StringUtils;
import sn.acodewriter.stockmanagement.dto.ItemDto;

import java.util.ArrayList;
import java.util.List;

public class ItemValidator {

    public static List<String> validate(ItemDto itemDto){
        List<String> errors = new ArrayList<String>();

        if (itemDto == null) {
            errors.add("Veuillew renseigner le code de l'article");
            errors.add("Veuillew renseigner la designation de l'article");
            errors.add("Veuillew renseigner le prix unitaire de l'article");
            errors.add("Veuillew renseigner le taux TVA de l'article");
            errors.add("Veuillew renseigner le prix unitaire TTC de l'article");
            errors.add("Veuillew selectionner une categorie");
        }else{
            if (!StringUtils.hasLength(itemDto.getItemCode())){
                errors.add("Veuillew renseigner le code de l'article");
            }
            if (!StringUtils.hasLength(itemDto.getDesignation())){
                errors.add("Veuillew renseigner la designation de l'article");
            }
            if (itemDto.getUnitPricePurchased() == null){
                errors.add("Veuillew renseigner le prix unitaire de l'article");
            }
            if (itemDto.getVatRate() == null){
                errors.add("Veuillew renseigner le taux TVA de l'article");
            }
            if (itemDto.getUnitPriceIncludingTax() == null){
                errors.add("Veuillew renseigner le prix unitaire TTC de l'article");
            }
            if (itemDto.getCategory() == null || itemDto.getCategory().getId() == null){
                errors.add("Veuillew selectionner une categorie");
            }
        }

        return errors;
    }
}

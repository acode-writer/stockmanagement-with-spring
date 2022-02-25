package sn.acodewriter.stockmanagement.validator;

import org.springframework.util.StringUtils;
import sn.acodewriter.stockmanagement.dto.SupplierDto;

import java.util.ArrayList;
import java.util.List;

public class SupplierValidator {

    public static List<String> validate(SupplierDto supplierDto){

        List<String> errors = new ArrayList<String>();

        if (supplierDto == null) {
            errors.add("Veuillew renseigner le nom du fournisseur");
            errors.add("Veuillew renseigner le prenom du fournisseur");
            errors.add("Veuillew renseigner l'email du fournisseur");
            errors.add("Veuillew renseigner le numero de telephone du fournisseur");
            errors.addAll(AddressValidatror.validate(supplierDto.getAdderess()));
        }else{
            if (!StringUtils.hasLength(supplierDto.getName())){
                errors.add("Veuillew renseigner le nom du fournisseur");
            }
            if (!StringUtils.hasLength(supplierDto.getFirstname())){
                errors.add("Veuillew renseigner le prenom du fournisseur");
            }
            if (!StringUtils.hasLength(supplierDto.getMail())){
                errors.add("Veuillew renseigner l'email du fournisseur");
            }
            if (!StringUtils.hasLength(supplierDto.getPhoneNumber())){
                errors.add("Veuillew renseigner le numero de telephone du fournisseur");
            }
            errors.addAll(AddressValidatror.validate(supplierDto.getAdderess()));
        }

        return errors;
    }
}

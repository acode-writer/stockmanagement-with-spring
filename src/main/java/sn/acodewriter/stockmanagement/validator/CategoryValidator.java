package sn.acodewriter.stockmanagement.validator;

import org.springframework.util.StringUtils;
import sn.acodewriter.stockmanagement.dto.CategoryDto;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public static List<String> validate(CategoryDto categoryDto){
        List<String> errors = new ArrayList<String>();

        if (categoryDto == null || !StringUtils.hasLength(categoryDto.getCode())){
            errors.add("Veuillez renseigner le code de la category");
        }
        return errors;
    }
}

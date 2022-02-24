package sn.acodewriter.stockmanagement.dto;

import lombok.Data;
import lombok.Builder;
import sn.acodewriter.stockmanagement.model.Sales;

@Data
@Builder
public class SalesDto {

    private Integer id;

    private String code;

    public static SalesDto fromEntity(Sales sale){
        if (sale == null){
            return null;
        }

        return SalesDto.builder()
                .id(sale.getId())
                .code(sale.getCode())
                .build();
    }

    public static Sales toEntity(SalesDto saleDto){
        if (saleDto == null){
            return  null;
        }

        Sales sale = new Sales();
        sale.setId(saleDto.getId());
        sale.setCode(saleDto.getCode());

        return sale;
    }
}

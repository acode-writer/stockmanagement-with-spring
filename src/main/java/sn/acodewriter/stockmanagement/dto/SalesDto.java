package sn.acodewriter.stockmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Builder;
import sn.acodewriter.stockmanagement.model.Sales;


import java.time.Instant;
import java.util.List;

@Data
@Builder
public class SalesDto {

    private Integer id;

    private String code;

    private Instant saledOn;

    private String comments;

    private List<SalesLineDto> salesLines;

    public static SalesDto fromEntity(Sales sale){
        if (sale == null){
            return null;
        }

        return SalesDto.builder()
                .id(sale.getId())
                .code(sale.getCode())
                .saledOn(sale.getSaledOn())
                .comments(sale.getComments())
                .build();
    }

    public static Sales toEntity(SalesDto saleDto){
        if (saleDto == null){
            return  null;
        }

        Sales sale = new Sales();
        sale.setId(saleDto.getId());
        sale.setCode(saleDto.getCode());
        sale.setSaledOn(saleDto.getSaledOn());
        sale.setComments(saleDto.getComments());

        return sale;
    }
}

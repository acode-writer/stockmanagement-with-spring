package sn.acodewriter.stockmanagement.dto;

import lombok.Data;
import lombok.Builder;
import sn.acodewriter.stockmanagement.model.SalesLine;

import java.math.BigDecimal;

@Data
@Builder
public class SalesLineDto{

    private Integer id;

    private SalesDto sale;

    private BigDecimal quantity;

    private Integer companyId;

    public static SalesLineDto fromEntity(SalesLine salesLine){
        if (salesLine == null){
            return null;
        }

        return SalesLineDto.builder()
                .id(salesLine.getId())
                .sale(SalesDto.fromEntity(salesLine.getSale()))
                .quantity(salesLine.getQuantity())
                .companyId(salesLine.getCompanyId())
                .build();
    }

    public static SalesLine toEntity(SalesLineDto salesLineDto){
        if (salesLineDto == null){
            return  null;
        }

        SalesLine salesLine = new SalesLine();
        salesLine.setId(salesLineDto.getId());
        salesLine.setSale(SalesDto.toEntity(salesLineDto.getSale()));
        salesLine.setQuantity(salesLineDto.getQuantity());
        salesLine.setCompanyId(salesLineDto.getCompanyId());
        return salesLine;
    }
}

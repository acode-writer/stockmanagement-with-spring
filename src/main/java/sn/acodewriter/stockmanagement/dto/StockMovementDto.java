package sn.acodewriter.stockmanagement.dto;

import lombok.Data;
import lombok.Builder;
import sn.acodewriter.stockmanagement.model.Item;
import sn.acodewriter.stockmanagement.model.StockMovement;
import sn.acodewriter.stockmanagement.model.StockMovementType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class StockMovementDto{

    private Integer id;

    private Instant dateOfMovement;

    private BigDecimal quantity;

    private StockMovementType stockMovementType;

    private ItemDto item;

    private Integer companyId;

    public static StockMovementDto fromEntity(StockMovement stockMovement){
        if (stockMovement == null){
            return null;
        }

        return StockMovementDto.builder()
                .id(stockMovement.getId())
                .dateOfMovement(stockMovement.getDateOfMovement())
                .quantity(stockMovement.getQuantity())
                .stockMovementType(stockMovement.getStockMovementType())
                .item(ItemDto.fromEntity(stockMovement.getItem()))
                .companyId(stockMovement.getCompanyId())
                .build();
    }

    public static StockMovement toEntity(StockMovementDto stockMovementDto){
        if (stockMovementDto == null){
            return  null;
        }

        StockMovement stockMovement = new StockMovement();
        stockMovement.setId(stockMovementDto.getId());
        stockMovement.setDateOfMovement(stockMovementDto.getDateOfMovement());
        stockMovement.setQuantity(stockMovementDto.getQuantity());
        stockMovement.setStockMovementType(stockMovementDto.getStockMovementType());
        stockMovement.setItem(ItemDto.toEntity(stockMovementDto.getItem()));
        stockMovement.setCompanyId(stockMovementDto.getCompanyId());
        return stockMovement;
    }
}

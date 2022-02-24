package sn.acodewriter.stockmanagement.dto;

import lombok.Data;
import lombok.Builder;
import sn.acodewriter.stockmanagement.model.StockMovement;

@Data
@Builder
public class StockMovementDto{

    private Integer id;

    private ItemDto item;

    public static StockMovementDto fromEntity(StockMovement stockMovement){
        if (stockMovement == null){
            return null;
        }

        return StockMovementDto.builder()
                .id(stockMovement.getId())
                .item(ItemDto.fromEntity(stockMovement.getItem()))
                .build();
    }

    public static StockMovement toEntity(StockMovementDto stockMovementDto){
        if (stockMovementDto == null){
            return  null;
        }

        StockMovement stockMovement = new StockMovement();
        stockMovement.setId(stockMovementDto.getId());
        stockMovement.setItem(ItemDto.toEntity(stockMovementDto.getItem()));

        return stockMovement;
    }
}

package sn.acodewriter.stockmanagement.dto;

import lombok.Builder;
import lombok.Data;
import sn.acodewriter.stockmanagement.model.Item;

import java.math.BigDecimal;

@Builder
@Data
public class ItemDto {

    private Integer id;

    private String itemCode;

    private  String designation;

    private BigDecimal unitPricePurchased;

    private BigDecimal vatRate;

    private BigDecimal unitPriceIncludingTax;

    private CategoryDto category;

    private String photo;

    public static ItemDto fromEntity(Item item) {
        if(item == null){
            return null;
//            TODO throw an exception
        }
        return ItemDto.builder()
                .id(item.getId())
                .itemCode(item.getItemCode())
                .designation(item.getDesignation())
                .unitPricePurchased(item.getUnitPricePurchased())
                .vatRate(item.getVatRate())
                .unitPriceIncludingTax(item.getUnitPriceIncludingTax())
                .photo(item.getPhoto())
                .build();
    }

    public static Item toEntity(ItemDto itemDto){
        if(itemDto == null){
            return null;
//            TODO throw an exception
        }
        Item item = new Item();
        item.setId(itemDto.getId());
        item.setItemCode(itemDto.getItemCode());
        item.setDesignation(itemDto.getDesignation());
        item.setUnitPricePurchased(itemDto.getUnitPricePurchased());
        item.setVatRate(itemDto.getVatRate());
        item.setUnitPriceIncludingTax(itemDto.getUnitPriceIncludingTax());
        item.setPhoto(itemDto.getPhoto());
        return item;

    }
}

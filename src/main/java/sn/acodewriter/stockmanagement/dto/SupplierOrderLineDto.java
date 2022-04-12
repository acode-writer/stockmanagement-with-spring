package sn.acodewriter.stockmanagement.dto;

import lombok.Data;
import lombok.Builder;
import sn.acodewriter.stockmanagement.model.SupplierOrderLine;


@Data
@Builder
public class SupplierOrderLineDto{

    private Integer id;

    private ItemDto item;

    private SupplierOrderDto supplierOrder;

    private Integer companyId;

    public static SupplierOrderLineDto fromEntity(SupplierOrderLine supplierOrderLine){
        if (supplierOrderLine == null){
            return null;
        }

        return SupplierOrderLineDto.builder()
                .id(supplierOrderLine.getId())
                .item(ItemDto.fromEntity(supplierOrderLine.getItem()))
                .supplierOrder(SupplierOrderDto.fromEntity(supplierOrderLine.getSupplierOrder()))
                .companyId(supplierOrderLine.getCompanyId())
                .build();
    }

    public static SupplierOrderLine toEntity(SupplierOrderLineDto supplierOrderLineDto){
        if (supplierOrderLineDto == null){
            return  null;
        }

        SupplierOrderLine supplierOrderLine = new SupplierOrderLine();
        supplierOrderLine.setId(supplierOrderLineDto.getId());
        supplierOrderLine.setItem(ItemDto.toEntity(supplierOrderLineDto.getItem()));
        supplierOrderLine.setSupplierOrder(SupplierOrderDto.toEntity(supplierOrderLineDto.getSupplierOrder()));
        supplierOrderLine.setCompanyId(supplierOrderLineDto.getCompanyId());
        return supplierOrderLine;
    }
}

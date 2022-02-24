package sn.acodewriter.stockmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Builder;
import sn.acodewriter.stockmanagement.model.SupplierOrder;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class SupplierOrderDto{

    private Integer id;

    private String code;

    private Instant orderedAt;

    private SupplierDto supplier;

    @JsonIgnore
    private List<SupplierOrderLineDto> supplierOrderLines;

    public static SupplierOrderDto fromEntity(SupplierOrder supplierOrder){
        if (supplierOrder == null){
            return null;
        }

        return SupplierOrderDto.builder()
                .id(supplierOrder.getId())
                .code(supplierOrder.getCode())
                .orderedAt(supplierOrder.getOrderedAt())
                .supplier(SupplierDto.fromEntity(supplierOrder.getSupplier()))
                .build();
    }

    public static SupplierOrder toEntity(SupplierOrderDto supplierOrderDto){
        if (supplierOrderDto == null){
            return  null;
        }

        SupplierOrder supplierOrder = new SupplierOrder();
        supplierOrder.setId(supplierOrderDto.getId());
        supplierOrder.setCode(supplierOrderDto.getCode());
        supplierOrder.setOrderedAt(supplierOrderDto.getOrderedAt());
        supplierOrder.setSupplier(SupplierDto.toEntity(supplierOrderDto.getSupplier()));

        return supplierOrder;
    }
}

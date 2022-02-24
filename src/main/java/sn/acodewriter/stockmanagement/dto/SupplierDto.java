package sn.acodewriter.stockmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Builder;
import sn.acodewriter.stockmanagement.model.Supplier;

import java.util.List;

@Data
@Builder
public class SupplierDto {

    private Integer id;

    private String name;

    private String firstname;

    private AddressDto adderess;

    private String photo;

    private String mail;

    private String phoneNumber;

    @JsonIgnore
    private List<SupplierOrderDto> supplierOrders;

    public static SupplierDto fromEntity(Supplier supplier){
        if (supplier == null){
            return null;
        }

        return SupplierDto.builder()
                .id(supplier.getId())
                .name(supplier.getName())
                .firstname(supplier.getFirstname())
                .adderess(AddressDto.fromEntity(supplier.getAdderess()))
                .photo(supplier.getPhoto())
                .mail(supplier.getMail())
                .phoneNumber(supplier.getPhoneNumber())
                .build();
    }

    public static Supplier toEntity(SupplierDto supplierDto){
        if (supplierDto == null){
            return  null;
        }

        Supplier supplier = new Supplier();
        supplier.setId(supplierDto.getId());
        supplier.setName(supplierDto.getName());
        supplier.setFirstname(supplierDto.getFirstname());
        supplier.setAdderess(AddressDto.toEntity(supplierDto.getAdderess()));
        supplier.setPhoto(supplierDto.getPhoto());
        supplier.setMail(supplierDto.getMail());
        supplier.setPhoneNumber(supplierDto.getPhoneNumber());

        return supplier;
    }
}

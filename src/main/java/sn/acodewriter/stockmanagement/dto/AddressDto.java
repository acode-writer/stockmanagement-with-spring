package sn.acodewriter.stockmanagement.dto;

import lombok.Builder;
import lombok.Data;
import sn.acodewriter.stockmanagement.model.Address;

@Builder
@Data
public class AddressDto {

    private Integer id;

    private  String address1;

    private  String address2;

    private  String city;

    private  String zipCode;

    private  String country;

    public static AddressDto fromEntity(Address address){
        if (address == null){
            return null;
        }
        return AddressDto.builder()
                .address1(address.getAddress1())
                .address2(address.getAddress2())
                .zipCode(address.getZipCode())
                .city(address.getCity())
                .country(address.getCountry())
                .build();
    }

    public static Address toEntity(AddressDto addressDto){
        if (addressDto == null){
            return null;
        }

        Address address = new Address();
        address.setAddress1(addressDto.getAddress1());
        address.setAddress2(addressDto.getAddress2());
        address.setZipCode(addressDto.getZipCode());
        address.setCity(addressDto.getCity());
        address.setCountry(addressDto.getCountry());
        return address;
    }
}

package sn.acodewriter.stockmanagement.dto;

import lombok.Builder;
import lombok.Data;
import sn.acodewriter.stockmanagement.model.Customer;

import java.util.List;

@Data
@Builder
public class CustomerDto {

    private Integer id;

    private String name;

    private String firstname;

    private AddressDto adderess;

    private String photo;

    private String mail;

    private String phoneNumber;

    private List<CustomerOrderDto> customerOrders;

    public static CustomerDto fromEntity(Customer customer){
        if (customer == null){
            return null;
        }

        return CustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .firstname(customer.getFirstname())
                .adderess(AddressDto.fromEntity(customer.getAdderess()))
                .photo(customer.getPhoto())
                .mail(customer.getMail())
                .phoneNumber(customer.getPhoneNumber())
                .build();
    }

    public static Customer toEntity(CustomerDto customerDto){
        if (customerDto == null){
            return  null;
        }

        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setName(customerDto.getName());
        customer.setFirstname(customerDto.getFirstname());
        customer.setAdderess(AddressDto.toEntity(customerDto.getAdderess()));
        customer.setPhoto(customer.getPhoto());
        customer.setMail(customer.getMail());
        customer.setPhoneNumber(customer.getPhoneNumber());

        return customer;
    }
}

package sn.acodewriter.stockmanagement.dto;


import lombok.Builder;
import lombok.Data;
import sn.acodewriter.stockmanagement.model.CustomerOrderLine;

@Data
@Builder
public class CustomerOrderLineDto{

    private Integer id;

    private ItemDto item;

    private CustomerOrderDto customerOrder;

    public static CustomerOrderLineDto fromEntity(CustomerOrderLine customerOrderLine){
        if (customerOrderLine == null){
            return null;
        }

        return CustomerOrderLineDto.builder()
                .id(customerOrderLine.getId())
                .item(ItemDto.fromEntity(customerOrderLine.getItem()))
                .customerOrder(CustomerOrderDto.fromEntity(customerOrderLine.getCustomerOrder()))
                .build();
    }

    public static CustomerOrderLine toEntity(CustomerOrderLineDto customerOrderLineDto){
        if (customerOrderLineDto == null){
            return  null;
        }

        CustomerOrderLine customerOrderLine = new CustomerOrderLine();
        customerOrderLine.setId(customerOrderLineDto.getId());
        customerOrderLine.setItem(ItemDto.toEntity(customerOrderLineDto.getItem()));
        customerOrderLine.setCustomerOrder(CustomerOrderDto.toEntity(customerOrderLineDto.getCustomerOrder()));

        return customerOrderLine;
    }
}

package sn.acodewriter.stockmanagement.dto;

import lombok.Data;
import lombok.Builder;
import sn.acodewriter.stockmanagement.model.CustomerOrder;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CustomerOrderDto {

    private Integer id;

    private String code;

    private Instant orderedAt;

    private CustomerDto customer;

    private List<CustomerOrderLineDto> customerOrderLines;

    public static CustomerOrderDto fromEntity(CustomerOrder customerOrder){
        if (customerOrder == null){
            return null;
        }

        return CustomerOrderDto.builder()
                .id(customerOrder.getId())
                .code(customerOrder.getCode())
                .orderedAt(customerOrder.getOrderedAt())
                .customer(CustomerDto.fromEntity(customerOrder.getCustomer()))
                .build();
    }

    public static CustomerOrder toEntity(CustomerOrderDto customerOrderDto){
        if (customerOrderDto == null){
            return  null;
        }

        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setId(customerOrderDto.getId());
        customerOrder.setCode(customerOrderDto.getCode());
        customerOrder.setOrderedAt(customerOrderDto.getOrderedAt());
        customerOrder.setCustomer(CustomerDto.toEntity(customerOrderDto.getCustomer()));

        return customerOrder;
    }
}

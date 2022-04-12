package sn.acodewriter.stockmanagement.dto;

import lombok.Data;
import lombok.Builder;
import sn.acodewriter.stockmanagement.model.CustomerOrder;
import sn.acodewriter.stockmanagement.model.OrderStatus;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CustomerOrderDto {

    private Integer id;

    private String code;

    private Instant orderedAt;

    private OrderStatus orderStatus;

    private CustomerDto customer;

    private List<CustomerOrderLineDto> customerOrderLines;

    private Integer companyId;

    public static CustomerOrderDto fromEntity(CustomerOrder customerOrder){
        if (customerOrder == null){
            return null;
        }

        return CustomerOrderDto.builder()
                .id(customerOrder.getId())
                .code(customerOrder.getCode())
                .orderedAt(customerOrder.getOrderedAt())
                .orderStatus(customerOrder.getOrderStatus())
                .customer(CustomerDto.fromEntity(customerOrder.getCustomer()))
                .companyId(customerOrder.getCompanyId())
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
        customerOrder.setOrderStatus(customerOrderDto.getOrderStatus());
        customerOrder.setCustomer(CustomerDto.toEntity(customerOrderDto.getCustomer()));
        customerOrder.setCompanyId(customerOrderDto.getCompanyId());
        return customerOrder;
    }
}

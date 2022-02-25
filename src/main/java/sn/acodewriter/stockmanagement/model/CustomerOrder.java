package sn.acodewriter.stockmanagement.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table
public class CustomerOrder extends AbstractEntity{

    @Column(name = "code")
    private String code;


    @Column(name = "orderedAt")
    private Instant orderedAt;

    @Column(name = "orderStatus")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "customerOrder")
    private List<CustomerOrderLine> customerOrderLines;
}

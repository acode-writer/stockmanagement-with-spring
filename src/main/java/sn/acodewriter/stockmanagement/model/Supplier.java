package sn.acodewriter.stockmanagement.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table
public class Supplier extends AbstractEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "firstname")
    private String firstname;

    @Embedded
    private Address adderess;

    @Column(name = "photo")
    private String photo;

    @Column(name = "mail")
    private String mail;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @OneToMany(mappedBy = "supplier")
    private List<SupplierOrder> supplierOrders;

    @Column(name = "companyId")
    private Integer companyId;
}

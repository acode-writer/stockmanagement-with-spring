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
public class Company extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Embedded
    private Address address;

    @Column(name = "taxCode")
    private String taxCode;

    @Column(name = "photo")
    private String photo;

    @Column(name = "mail")
    private String mail;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "website")
    private String website;

    @OneToMany(mappedBy = "company")
    private List<Users> users;
}

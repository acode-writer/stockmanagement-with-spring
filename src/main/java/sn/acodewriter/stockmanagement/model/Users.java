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
public class Users extends AbstractEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "mail")
    private String mail;

    @Column(name = "")
    private Instant dateOfBirth;

    @Column(name = "password")
    private String password;

    @Embedded
    private Address adderess;

    @Column(name = "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "user")
    private List<Roles> roles;



}

package sn.acodewriter.stockmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Address {

    @Column(name = "addresse1")
    private  String address1;

    @Column(name = "address2")
    private  String address2;

    @Column(name = "city")
    private  String city;

    @Column(name = "zipCode")
    private  String zipCode;

    @Column(name = "country")
    private  String country;

}

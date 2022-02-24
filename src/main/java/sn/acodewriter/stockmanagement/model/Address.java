package sn.acodewriter.stockmanagement.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

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

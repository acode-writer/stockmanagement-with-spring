package sn.acodewriter.stockmanagement.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table
public class Item extends AbstractEntity{

    @Column(name = "itemcode")
    private String itemCode;

    @Column(name = "designation")
    private  String designation;

    @Column(name = "unitpricepurchased")
    private BigDecimal unitPricePurchased;

    @Column(name = "vatrate")
    private BigDecimal vatRate;

    @Column(name = "unitpriceincludingtax")
    private BigDecimal unitPriceIncludingTax;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Category category;

    @Column(name = "photo")
    private String photo;
}

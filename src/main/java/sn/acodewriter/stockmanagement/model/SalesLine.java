package sn.acodewriter.stockmanagement.model;

import javax.persistence.Column;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table
public class SalesLine extends  AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sales sale;

    private BigDecimal quantity;

    @Column(name = "companyId")
    private Integer companyId;
}

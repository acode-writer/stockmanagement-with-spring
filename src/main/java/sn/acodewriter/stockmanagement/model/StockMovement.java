package sn.acodewriter.stockmanagement.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table
public class StockMovement extends AbstractEntity{

    @Column(name = "dateOfMovement")
    private Instant dateOfMovement;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "stockMovementType")
    @Enumerated(EnumType.STRING)
    private StockMovementType stockMovementType;

    @Column(name = "companyId")
    private Integer companyId;
}

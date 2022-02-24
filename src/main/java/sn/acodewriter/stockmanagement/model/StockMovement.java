package sn.acodewriter.stockmanagement.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table
public class StockMovement extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}

package sn.acodewriter.stockmanagement.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table
public class Sales extends AbstractEntity{

    @Column(name = "code")
    private String code;

    @Column(name = "saledOn")
    private Instant saledOn;

    @Column(name = "comments")
    private String comments;

    @OneToMany(mappedBy = "sale")
    private List<SalesLine> salesLines;
}

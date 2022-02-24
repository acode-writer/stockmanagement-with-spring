package sn.acodewriter.stockmanagement.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table
public class Sales extends AbstractEntity{

    private String code;
}

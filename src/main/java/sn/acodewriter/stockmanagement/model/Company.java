package sn.acodewriter.stockmanagement.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table
public class Company extends AbstractEntity {

    @Column(name = "name")
    private String name;
}

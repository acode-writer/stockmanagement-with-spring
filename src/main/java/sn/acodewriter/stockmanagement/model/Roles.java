package sn.acodewriter.stockmanagement.model;

import javax.persistence.Column;
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
public class Roles extends AbstractEntity{

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "companyId")
    private Integer companyId;
    
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}

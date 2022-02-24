package sn.acodewriter.stockmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @CreatedDate
    @Column(name = "createdAt", nullable = false)
    @JsonIgnore
    private Instant createdAt;

    @LastModifiedBy
    @Column(name = "lastUpdatedDate")
    @JsonIgnore
    private  Instant lastUpdatedDate;
}

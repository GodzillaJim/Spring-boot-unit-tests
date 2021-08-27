package com.godzillajim.unittestingintegration.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    @CreatedDate
    private Date createdAt;

    @Temporal(TemporalType.DATE)
    @LastModifiedDate
    @Column(name ="modified_at")
    private Date modifiedAt;

    @PrePersist
    public void prePersist(){
        if(getCreatedAt() == null) setCreatedAt(new Date());
        if(getModifiedAt()==null) setModifiedAt(new Date());
    }
}

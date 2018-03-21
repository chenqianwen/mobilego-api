package com.example.mobilego.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @author： ygl
 * @date： 2018/3/15-16:59
 * @Description：
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "IdGenerate")
    @GenericGenerator(name = "IdGenerate", strategy = "com.example.mobilego.util.IdGenerate")
    @Column(name = "id", nullable = false, columnDefinition = "varchar(64)")
    private String id;

    @CreatedBy
    @Column(name = "created_by", nullable = false, columnDefinition = "varchar(16) comment'创建者'")
    private String createdBy;

    @CreatedDate
    @Column(name = "created_date", nullable = false, columnDefinition = "datetime comment'创建时间'")
    private Date createdDate;

    @LastModifiedBy
    @Column(name = "updated_by", nullable = false, columnDefinition = "varchar(16) comment'修改者'")
    private String updatedBy;

    @LastModifiedDate
    @Column(name = "updated_date", nullable = false, columnDefinition = "datetime comment'修改时间'")
    private Date updatedDate;

    @Column(name = "is_deleted", nullable = false, columnDefinition = "tinyint default 0 comment'删除标志'")
    private Integer isDeleted = 0;
}

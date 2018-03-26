package com.example.mobilego.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.KeySequence;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * @author： ygl
 * @date： 2018/3/26-10:24
 * @Description：
 */
@Data
public class SupperEntity<T extends Model> extends Model<T> {

    /**
     * 主键ID
     */
    @TableId("id")
    private String id;

    /**
     *创建者
     */
    private String createdBy;

    /**
     * 创建时间
     */
    @TableField(update = "now()")
    private Date createdDate;

    /**
     * 更新者
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    @TableField(update = "now()")
    private Date updatedDate;

    /**
     * 删除标志
     */
    @TableLogic
    private Integer isDeleted = 0;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}

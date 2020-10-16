package com.sqds.ces.biz.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;



import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 规格值表
 * </p>
 *
 * @author 李嘉琪
 * @since 2020-10-16
 */
@Data
@Accessors(chain = true)
@TableName("t_specification_value")
public class TSpecificationValue extends Model<TSpecificationValue> {

    private static final long serialVersionUID = 1L;

    /**
     * 规格值表主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 规格值内容
     */
    @TableField("name")
    private String name;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

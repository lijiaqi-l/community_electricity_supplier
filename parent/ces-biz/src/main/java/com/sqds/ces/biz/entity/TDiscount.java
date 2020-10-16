package com.sqds.ces.biz.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;



import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 优惠劵表
 * </p>
 *
 * @author 李嘉琪
 * @since 2020-10-16
 */
@Data
@Accessors(chain = true)
@TableName("t_discount")
public class TDiscount extends Model<TDiscount> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 优惠券名称
     */
    @TableField("discount_name")
    private String discountName;

    /**
     * 可用时间
     */
    @TableField("usable_time")
    private Date usableTime;

    /**
     * 优惠券开始时间
     */
    @TableField("begin_time")
    private Date beginTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

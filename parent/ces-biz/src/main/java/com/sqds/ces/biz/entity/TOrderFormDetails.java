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
 * 订单明细表
 * </p>
 *
 * @author 李嘉琪
 * @since 2020-10-16
 */
@Data
@Accessors(chain = true)
@TableName("t_order_form_details")
public class TOrderFormDetails extends Model<TOrderFormDetails> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单明细表id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品详情id
     */
    @TableField("goods_detailsId")
    private Integer goodsDetailsId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

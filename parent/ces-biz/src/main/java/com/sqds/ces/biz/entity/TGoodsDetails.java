package com.sqds.ces.biz.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;



import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品详情表
 * </p>
 *
 * @author 李嘉琪
 * @since 2020-10-16
 */
@Data
@Accessors(chain = true)
@TableName("t_goods_details")
public class TGoodsDetails extends Model<TGoodsDetails> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品详情表主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 库存
     */
    @TableField("inventory")
    private Integer inventory;

    /**
     * 价格
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 规格外键
     */
    @TableField("specification-id")
    private Integer specificationId;

    /**
     * 规格值外键
     */
    @TableField("specification-value_id")
    private Integer specificationValueId;

    /**
     * 商家外键
     */
    @TableField("merchant_id")
    private Integer merchantId;

    @TableField("goods_img")
    private String goodsImg;

    /**
     * 商品备注
     */
    @TableField("goods_remark")
    private String goodsRemark;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

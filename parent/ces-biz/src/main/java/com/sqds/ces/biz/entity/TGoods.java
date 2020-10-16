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
 * 商品表
 * </p>
 *
 * @author 李嘉琪
 * @since 2020-10-16
 */
@Data
@Accessors(chain = true)
@TableName("t_goods")
public class TGoods extends Model<TGoods> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品名
     */
    @TableField("goods_name")
    private String goodsName;

    /**
     * 类型外键
     */
    @TableField("type_id")
    private Integer typeId;

    /**
     * 品牌
     */
    @TableField("brand")
    private String brand;

    /**
     * 商品外键
     */
    @TableField("merchant_id")
    private Integer merchantId;

    /**
     * 商品详情外键
     */
    @TableField("goods_details_id")
    private Integer goodsDetailsId;

    @TableField("goods_status")
    private Integer goodsStatus;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

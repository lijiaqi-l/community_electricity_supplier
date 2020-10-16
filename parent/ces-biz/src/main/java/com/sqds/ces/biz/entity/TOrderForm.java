package com.sqds.ces.biz.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
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
 * 订单表
 * </p>
 *
 * @author 李嘉琪
 * @since 2020-10-16
 */
@Data
@Accessors(chain = true)
@TableName("t_order_form")
public class TOrderForm extends Model<TOrderForm> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单号
     */
    @TableField("order_number")
    private String orderNumber;

    /**
     * 用户外键
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 商家外键
     */
    @TableField("merchant_id")
    private Integer merchantId;

    /**
     * 状态
     */
    @TableField("order_form_status_id")
    private Integer orderFormStatusId;

    /**
     * 活动id
     */
    @TableField("activity_id")
    private Integer activityId;

    /**
     * 惠券外键
     */
    @TableField("discount_couponId")
    private Integer discountCouponId;

    /**
     * 总价
     */
    @TableField("price_sum")
    private BigDecimal priceSum;

    /**
     * 打折前
     */
    @TableField("discount_before")
    private BigDecimal discountBefore;

    /**
     * 打折后
     */
    @TableField("discount_after")
    private BigDecimal discountAfter;

    /**
     * 固定下单地址
     */
    @TableField("shopping_id")
    private Integer shoppingId;

    /**
     * 订单创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 订单结束时间
     */
    @TableField("end_time")
    private Date endTime;

    /**
     * 支付方式外键
     */
    @TableField("payment_id")
    private Integer paymentId;

    /**
     * 交易流水号
     */
    @TableField("serial_number")
    private String serialNumber;

    /**
     * 交易时间
     */
    @TableField("deal_time")
    private Date dealTime;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

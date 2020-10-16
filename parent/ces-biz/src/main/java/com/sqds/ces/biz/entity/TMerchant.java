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
 * 商家表
 * </p>
 *
 * @author 李嘉琪
 * @since 2020-10-16
 */
@Data
@Accessors(chain = true)
@TableName("t_merchant")
public class TMerchant extends Model<TMerchant> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商家名称
     */
    @TableField("merchant_name")
    private String merchantName;

    @TableField("pid")
    private Integer pid;

    @TableField("cid")
    private Integer cid;

    @TableField("did")
    private Integer did;

    @TableField("address")
    private String address;

    /**
     * 类型外键
     */
    @TableField("merchant_type_id")
    private Integer merchantTypeId;

    /**
     * 商家状态外键
     */
    @TableField("merchant_status_id")
    private Integer merchantStatusId;

    /**
     * 附件外键
     */
    @TableField("accessory_id")
    private Integer accessoryId;

    /**
     * 账户外键
     */
    @TableField("account_id")
    private Integer accountId;

    @TableField("merchant_img")
    private String merchantImg;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

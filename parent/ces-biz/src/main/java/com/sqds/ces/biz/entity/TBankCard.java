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
 * 银行卡表
 * </p>
 *
 * @author 李嘉琪
 * @since 2020-10-16
 */
@Data
@Accessors(chain = true)
@TableName("t_bank_card")
public class TBankCard extends Model<TBankCard> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 卡号
     */
    @TableField("bank_card_number")
    private String bankCardNumber;

    /**
     * 银行名称
     */
    @TableField("bank_name")
    private String bankName;

    @TableField("bank_card_status")
    private Integer bankCardStatus;

    @TableField("user-id")
    private Integer userId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

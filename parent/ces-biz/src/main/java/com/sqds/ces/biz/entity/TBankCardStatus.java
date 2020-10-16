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
 * 银行卡状态表
 * </p>
 *
 * @author 李嘉琪
 * @since 2020-10-16
 */
@Data
@Accessors(chain = true)
@TableName("t_bank_card_status")
public class TBankCardStatus extends Model<TBankCardStatus> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("status")
    private String status;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

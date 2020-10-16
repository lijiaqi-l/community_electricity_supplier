package com.sqds.ces.auth.entity;

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
 * 商家账户
 * </p>
 *
 * @author 李嘉琪
 * @since 2020-10-16
 */
@Data
@Accessors(chain = true)
public class TAccount extends Model<TAccount> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商家账户名
     */
    private String accountName;

    /**
     * 银行卡号
     */
    private String brankNumber;

    /**
     * 商家账户号
     */
    private String accountNumber;

    private String password;

    /**
     * 余额
     */
    private BigDecimal balance;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

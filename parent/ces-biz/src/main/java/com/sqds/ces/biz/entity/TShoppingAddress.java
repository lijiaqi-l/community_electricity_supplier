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
 * 商品地址表详情
 * </p>
 *
 * @author 李嘉琪
 * @since 2020-10-16
 */
@Data
@Accessors(chain = true)
@TableName("t_shopping_address")
public class TShoppingAddress extends Model<TShoppingAddress> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("pid")
    private Integer pid;

    @TableField("cid")
    private Integer cid;

    @TableField("did")
    private Integer did;

    /**
     * 对应的小区id
     */
    @TableField("ploy_id")
    private Integer ployId;

    /**
     * 对应的用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 用户的详细地址
     */
    @TableField("accurate_address")
    private String accurateAddress;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

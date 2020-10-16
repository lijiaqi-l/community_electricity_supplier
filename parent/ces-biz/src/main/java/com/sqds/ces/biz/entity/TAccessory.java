package com.sqds.ces.biz.entity;

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
 * 商家附件表
 * </p>
 *
 * @author 李嘉琪
 * @since 2020-10-16
 */
@Data
@Accessors(chain = true)
@TableName("t_accessory")
public class TAccessory extends Model<TAccessory> {

    private static final long serialVersionUID = 1L;

    /**
     * 商家附件表id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 执照号
     */
    private String licenseNumber;

    /**
     * 法人
     */
    private String legalPerson;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

package com.sqds.ces.biz.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
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
 * 用户表
 * </p>
 *
 * @author 李嘉琪
 * @since 2020-10-16
 */
@Data
@Accessors(chain = true)
@TableName("t_user")
public class TUser extends Model<TUser> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 手机号
     */
    @TableField("telephone")
    private String telephone;

    @TableField("name")
    private String name;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    /**
     * 所在小区外键
     */
    @TableField("plot_id")
    private Integer plotId;

    /**
     * 注册时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 最后一次登陆时间
     */
    @TableField("end_login_time")
    private Date endLoginTime;

    /**
     * 活动状态id
     */
    @TableField("user_Status-id")
    private Integer userStatusId;

    @TableField("role")
    private Integer role;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

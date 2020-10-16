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
 * 小区表
 * </p>
 *
 * @author 李嘉琪
 * @since 2020-10-16
 */
@Data
@Accessors(chain = true)
@TableName("t_plot")
public class TPlot extends Model<TPlot> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 小区名称
     */
    @TableField("polt_name")
    private String plotName;

    /**
     * 所属区域
     */
    @TableField("city_didId")
    private Integer cityDidId;

    /**
     * 小区详细地址(门牌号)
     */
    @TableField("plot_address")
    private String plotAddress;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

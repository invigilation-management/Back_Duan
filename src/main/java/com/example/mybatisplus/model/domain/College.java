package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author lxp
 * @since 2024-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="College对象", description="")
public class College extends Model<College> {

    private static final long serialVersionUID = 1L;

    @TableId("college_id")
    private Integer collegeId;

    private String collegeName;

    private String type;

    private Integer numPeople;

    private String createTime;


    @Override
    protected Serializable pkVal() {
        return this.collegeId;
    }

}

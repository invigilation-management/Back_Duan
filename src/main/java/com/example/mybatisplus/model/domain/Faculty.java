package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.time.LocalDateTime;

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
 * @since 2024-07-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Faculty对象", description="")
public class Faculty extends Model<Faculty> {

    private static final long serialVersionUID = 1L;

    @TableId("faculty_id")
    private Integer facultyId;

    private String facultyName;

    private String tele;

    private Integer level;

    private Integer collegeCollegeId;

    private LocalDateTime createdTime;

    private String avatar;



    @Override
    protected Serializable pkVal() {
        return this.facultyId;
    }

}

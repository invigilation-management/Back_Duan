package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
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
 * @since 2024-07-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Approval对象", description="")
public class Approval extends Model<Approval> {

    private static final long serialVersionUID = 1L;

    @TableId("approval_id")
    private Integer approvalId;

    private LocalDateTime approvalDate;

    private Integer approvalFacultyId;

    private String approvalcol;

    private Integer approvalResult;

    private Integer registrationRegistrationId;

    @TableField(exist = false)
    private Faculty faculty;
    @TableField(exist = false)
    private Registration registration;
    @Override
    protected Serializable pkVal() {
        return this.approvalId;
    }

}

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
@ApiModel(value="Registration对象", description="")
public class Registration extends Model<Registration> {

    private static final long serialVersionUID = 1L;

    @TableId("registration_id")
    private Integer registrationId;

    private Integer facultyFacultyId;

    private Integer batchBatchId;

    private Integer compensationCompensationId;

    private Integer state;

    private Integer passOrNot;

    private Integer gender;

    private Integer trueFacultyId;

    private String college;

    private String trueFacultyName;

    private String eduQualification;

    private String tele;

    private String teleBackup;

    private LocalDateTime birthday;

    private String avatar;

    private String targetCampus;



    @Override
    protected Serializable pkVal() {
        return this.registrationId;
    }

}

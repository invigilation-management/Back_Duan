package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
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

    @TableId(value = "registration_id", type = IdType.AUTO)
    private Integer registrationId;

    private Integer facultyFacultyId;

    private Integer batchBatchId;

    private String batchBatchName;

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

    private Integer amount;

    private String classroom;

    private Integer confirmOrNot;


    private LocalDateTime createTime;

    @TableField(exist = false)
    private Batch batch;

    @TableField(exist = false)
    private Approval approval;

    @Override
    protected Serializable pkVal() {
        return this.registrationId;
    }

}

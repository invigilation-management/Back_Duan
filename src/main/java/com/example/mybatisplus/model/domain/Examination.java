package com.example.mybatisplus.model.domain;

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
@ApiModel(value="Examination对象", description="")
public class Examination extends Model<Examination> {

    private static final long serialVersionUID = 1L;

    @TableId("exam_id")
    private Integer examId;

    private String examSubject;

    private String examCampus;

    private String examClassroom;

    private LocalDateTime examTime;

    private Integer batchBatchId;


    @Override
    protected Serializable pkVal() {
        return this.examId;
    }

}

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
 * @since 2024-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Batch对象", description="")
public class Batch extends Model<Batch> {

    private static final long serialVersionUID = 1L;

    @TableId("batch_id")
    private Integer batchId;

    private String batchName;

    private LocalDateTime batchStartTime;

    private LocalDateTime batchEndTime;

    private LocalDateTime regStartTime;

    private LocalDateTime regEndTime;

    private String batchInfo;

    private LocalDateTime batchCreatedTime;

    private Integer batchDuration;

    private Integer expectNum;

    private Integer alreadyPassedNum;

    private Integer alreadyConfirmNum;


    @Override
    protected Serializable pkVal() {
        return this.batchId;
    }

}

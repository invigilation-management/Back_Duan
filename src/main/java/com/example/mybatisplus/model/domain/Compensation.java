package com.example.mybatisplus.model.domain;

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
 * @since 2024-07-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Compensation对象", description="")
public class Compensation extends Model<Compensation> {

    private static final long serialVersionUID = 1L;

    @TableId("compensation_id")
    private Integer compensationId;

    private Integer amount;


    @Override
    protected Serializable pkVal() {
        return this.compensationId;
    }

}

package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Batch;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplus.model.domain.Registration;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lxp
 * @since 2024-07-19
 */
public interface BatchMapper extends BaseMapper<Batch> {

    Page<Batch> selectAppointAndFeesPageALL(Page<Batch> registrationPage, Long userId);
    Page<Batch> selectManagePageALL(Page<Batch> registrationPage, Long userId);

    Page<Batch> selectConfirmPageALL(Page<Batch> registrationPage, Long userId);

    Page<Batch> selectBatchDetailsPageALL(Page<Batch> registrationPage, String batchName);

    Page<Batch> selectConfirmPageUnClearALL(Page<Batch> registrationPage, String batchName);

    Page<Batch> selectManagementPageUnclearFindALL(Page<Batch> registrationPage, String batchName);


    int countByBatchName(@Param("batchName") String batchName);


    void insertBatch(@Param("batchName") String batchName,
                     @Param("batchCreatedTime") String batchCreatedTime,
                     @Param("regStartTime") String regStartTime,
                     @Param("regEndTime") String regEndTime,
                     @Param("batchInfo") String batchInfo,
                     @Param("batchStartTime") String batchStartTime,
                     @Param("batchEndTime") String batchEndTime,
                     @Param("batchDuration") int batchDuration,
                     @Param("expectNum") int expectNum);

    Page<Batch> getManageVice(Page<Batch> registrationPage, String batchName);

    Integer selectCountByBatchNameAndTargetCampus(String batchName, String targetCampus);
}

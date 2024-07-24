package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Batch;
import com.example.mybatisplus.mapper.BatchMapper;
import com.example.mybatisplus.model.dto.BatchDTO;
import com.example.mybatisplus.model.dto.PageDTO;
import com.example.mybatisplus.service.BatchService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxp
 * @since 2024-07-19
 */
@Service
public class BatchServiceImpl extends ServiceImpl<BatchMapper, Batch> implements BatchService {
    @Autowired
    private BatchMapper batchMapper;

    @Override
    public Page<Batch> getAppointAndFeesPageALL(Long userId, PageDTO pageDTO) {
        // 创建分页对象
        Page<Batch> batchPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());

        return batchMapper.selectAppointAndFeesPageALL(batchPage, userId);
    }



    @Override
    public Page<Batch> getManagementPageALL(Long userId, PageDTO pageDTO) {
        // 创建分页对象
        Page<Batch> registrationPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());

        return batchMapper.selectManagePageALL(registrationPage, userId);
    }

    @Override
    public Page<Batch> getConfirmPageALL(Long userId, PageDTO pageDTO) {
        // 创建分页对象
        Page<Batch> registrationPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());

        return batchMapper.selectConfirmPageALL(registrationPage, userId);
    }

    @Override
    public Page<Batch> getBatchDetailsPageALL(String batchName, PageDTO pageDTO) {
        // 创建分页对象
        Page<Batch> registrationPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());

        return batchMapper.selectBatchDetailsPageALL(registrationPage, batchName);
    }

    @Override
    public Page<Batch> getConfirmPageUnClearALL(String batchName, PageDTO pageDTO) {
        // 创建分页对象
        Page<Batch> registrationPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());

        return batchMapper.selectConfirmPageUnClearALL(registrationPage, batchName);
    }

    @Override
    public Page<Batch> getManagementPageUnclearFindALL(String batchName, PageDTO pageDTO) {
        // 创建分页对象
        Page<Batch> registrationPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());

        return batchMapper.selectManagementPageUnclearFindALL(registrationPage, batchName);
    }


    @Transactional
    public boolean addBatch(BatchDTO batchDTO) {
        // 检查是否已经存在该批次
        int count = batchMapper.countByBatchName(batchDTO.getBatchName());
        if (count > 0) {
            return false;  // 批次已经存在
        }

        // 插入新的批次
        batchMapper.insertBatch(batchDTO.getBatchName(), batchDTO.getBatchCreatedTime(),
                batchDTO.getRegStartTime(), batchDTO.getRegEndTime(),
                batchDTO.getBatchInfo(), batchDTO.getBatchStartTime(),
                batchDTO.getBatchEndTime(), batchDTO.getBatchDuration(),batchDTO.getExpectNum());
        return true;
    }

    @Override
    public Page<Batch> getManageVice(String batchName, PageDTO pageDTO) {
        // 创建分页对象
        Page<Batch> registrationPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());

        return batchMapper.getManageVice(registrationPage, batchName);
    }

    @Override
    public Page<Batch> findUnclearBatchDetails(Integer userId, String batchName, String trueFacultyName, PageDTO pageDTO) {
        // 创建分页对象
        Page<Batch> registrationPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());

        return batchMapper.findUnclearBatchDetails(registrationPage,userId, batchName,trueFacultyName);
    }

    @Override
    public Page<Batch> teacherSeeBatch(String batchName, PageDTO pageDTO) {
        // 创建分页对象
        Page<Batch> registrationPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());

        return batchMapper.teacherSeeBatch(registrationPage, batchName);
    }

}

package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Batch;
import com.example.mybatisplus.model.domain.Examination;
import com.example.mybatisplus.mapper.ExaminationMapper;
import com.example.mybatisplus.model.dto.PageDTO;
import com.example.mybatisplus.service.ExaminationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxp
 * @since 2024-07-17
 */
@Service
public class ExaminationServiceImpl extends ServiceImpl<ExaminationMapper, Examination> implements ExaminationService {
    @Autowired
    private ExaminationMapper examinationMapper;

    @Override
    public Page<Examination> teacherSeeBatch(String batchName, PageDTO pageDTO) {
        // 创建分页对象
        Page<Examination> registrationPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());

        return examinationMapper.teacherSeeBatch(registrationPage, batchName);
    }
}

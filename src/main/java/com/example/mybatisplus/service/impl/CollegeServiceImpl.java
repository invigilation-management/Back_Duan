package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.mapper.BatchMapper;
import com.example.mybatisplus.model.domain.Batch;
import com.example.mybatisplus.model.domain.College;
import com.example.mybatisplus.mapper.CollegeMapper;
import com.example.mybatisplus.model.dto.PageDTO;
import com.example.mybatisplus.service.CollegeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxp
 * @since 2024-07-19
 */
@Service
public class CollegeServiceImpl extends ServiceImpl<CollegeMapper, College> implements CollegeService {
    @Autowired
    CollegeMapper collegeMapper;

    @Override
    public Page<College> getRoleAndCollegeALL(Long userId, PageDTO pageDTO) {
        // 创建分页对象
        Page<College> collegePage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());

        return collegeMapper.selectAppointAndFeesPageALL(collegePage, userId);
    }

    @Override
    public Page<College> getRoleAndCollegeALLUnclearFind(String collegeName, PageDTO pageDTO) {
        // 创建分页对象
        Page<College> collegeNamePage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());

        return collegeMapper.selectRoleAndCollegeALLUnclearFind(collegeNamePage, collegeName);
    }
}

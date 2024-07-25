package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Approval;
import com.example.mybatisplus.mapper.ApprovalMapper;
import com.example.mybatisplus.model.domain.Faculty;
import com.example.mybatisplus.model.dto.PageDTO;
import com.example.mybatisplus.service.ApprovalService;
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
public class ApprovalServiceImpl extends ServiceImpl<ApprovalMapper, Approval> implements ApprovalService {
    @Autowired
    private ApprovalMapper approvalMapper;

    @Override
    public Page<Approval> historyCard(PageDTO pageDTO, String trueFacultyName, String batchName) {
        // 创建分页对象
        Page<Approval> registrationFindPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());
        return approvalMapper.historyCard(registrationFindPage, trueFacultyName,batchName );
    }
}

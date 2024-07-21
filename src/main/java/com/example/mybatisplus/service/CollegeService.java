package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.College;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.model.dto.PageDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lxp
 * @since 2024-07-19
 */
public interface CollegeService extends IService<College> {

    Page<College> getRoleAndCollegeALL(Long userId, PageDTO pageDTO);

    Page<College> getRoleAndCollegeALLUnclearFind(String collegeName, PageDTO pageDTO);

    boolean addCollege(String collegeName, String type);
}

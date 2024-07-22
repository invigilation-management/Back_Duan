package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Faculty;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lxp
 * @since 2024-07-17
 */
public interface FacultyMapper extends BaseMapper<Faculty> {

    Page<Faculty> seeAllRoleOfTheCollege(Page<Faculty> registrationFindPage, Long collegeId);
}

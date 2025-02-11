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

    Page<Faculty> getInfomationConfirmVice(Page<Faculty> registrationFindPage, String batchName);

    Page<Faculty> findBeforePost(Page<Faculty> registrationFindPage, String trueFacultyName);

    Page<Faculty> collegeIdFind1(Page<Faculty> registrationFindPage, Integer collegeId, String facultyName);

    Page<Faculty> collegeIdFind2(Page<Faculty> registrationFindPage, Integer collegeId, Integer level);

    Page<Faculty> historyCard(Page<Faculty> registrationFindPage, String trueFacultyName, String batchName);
}

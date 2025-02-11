package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Faculty;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.model.domain.Registration;
import com.example.mybatisplus.model.dto.FacultyUpdateDTO;
import com.example.mybatisplus.model.dto.PageDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lxp
 * @since 2024-07-17
 */
public interface FacultyService extends IService<Faculty> {
    public void updateFaculty(FacultyUpdateDTO facultyUpdateDTO);

    Page<Faculty> seeAllRoleOfTheCollege(Long collegeId, PageDTO pageDTO);

    Page<Faculty> getInfomationConfirmVice(String batchName, PageDTO pageDTO);

    Page<Registration> seeDetailsOfOffice(Long userId, Long trueFacultyId, PageDTO pageDTO, String batchName);

    Page<Faculty> findBeforePost(PageDTO pageDTO, String batchName);

    Page<Faculty> collegeIdFind1(PageDTO pageDTO, Integer collegeId, String facultyName);

    Page<Faculty> collegeIdFind2(PageDTO pageDTO, Integer collegeId, Integer level);

    Page<Faculty> historyCard(PageDTO pageDTO, String trueFacultyName, String batchName);
}

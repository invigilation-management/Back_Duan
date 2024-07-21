package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Faculty;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.model.domain.Registration;
import com.example.mybatisplus.model.dto.FacultyUpdateDTO;

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

}

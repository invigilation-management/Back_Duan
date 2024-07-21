package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.mapper.CollegeMapper;
import com.example.mybatisplus.model.domain.College;
import com.example.mybatisplus.model.domain.Faculty;
import com.example.mybatisplus.mapper.FacultyMapper;
import com.example.mybatisplus.model.dto.FacultyUpdateDTO;
import com.example.mybatisplus.service.FacultyService;
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
 * @since 2024-07-17
 */
@Service
public class FacultyServiceImpl extends ServiceImpl<FacultyMapper, Faculty> implements FacultyService {
    @Autowired
    private FacultyMapper facultyMapper;

    @Autowired
    private CollegeMapper collegeMapper;



    @Transactional
    public void updateFaculty(FacultyUpdateDTO facultyUpdateDTO) {
        // 根据collegeName查找对应的collegeId
        College college = collegeMapper.selectOne(new QueryWrapper<College>().eq("college_name", facultyUpdateDTO.getCollegeName()));
        if (college == null) {
            throw new IllegalArgumentException("College not found for name: " + facultyUpdateDTO.getCollegeName());
        }

        // 更新faculty信息
        Faculty faculty = new Faculty();
        faculty.setFacultyId(facultyUpdateDTO.getFacultyId());
        faculty.setFacultyName(facultyUpdateDTO.getFacultyName());
        faculty.setCollegeCollegeId(college.getCollegeId());

        facultyMapper.updateById(faculty);
    }

}

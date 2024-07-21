package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.College;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lxp
 * @since 2024-07-19
 */
public interface CollegeMapper extends BaseMapper<College> {

    Page<College> selectAppointAndFeesPageALL(Page<College> collegePage, Long userId);

    Page<College> selectRoleAndCollegeALLUnclearFind(Page<College> collegeNamePage, String collegeName);


    void insertCollege(@Param("collegeName") String collegeName, @Param("type") String type);
}

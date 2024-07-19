package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.College;
import com.example.mybatisplus.mapper.CollegeMapper;
import com.example.mybatisplus.service.CollegeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}

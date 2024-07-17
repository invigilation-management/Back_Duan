package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.Batch;
import com.example.mybatisplus.mapper.BatchMapper;
import com.example.mybatisplus.service.BatchService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class BatchServiceImpl extends ServiceImpl<BatchMapper, Batch> implements BatchService {

}

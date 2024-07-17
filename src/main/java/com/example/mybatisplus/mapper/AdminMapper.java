package com.example.mybatisplus.mapper;

import com.example.mybatisplus.model.domain.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lxp
 * @since 2021-06-17
 */
@Repository//注解不影响运行
public interface AdminMapper extends BaseMapper<Admin> {
    //AdminMapper中应该要放自己写的接口
    //Mapper里的接口一定对应一条sql
    //不管是什么类型的参数,不管是多少个参数,全都取别名
    Admin selectByIdMy(@Param("id") Long id);

    Admin selectByIdAdmin(@Param("admin") Admin a);

    List<Admin> selectByAdmin(@Param("admin") Admin a);

    //不管返回的是一个对象还是多个对象,xml的返回值都是对象类型
    //如果返回值是列表,那么会自动包装为列表(一个也包装)
    //相反,返回值是对象,那么查询结果只能是1或0条数据

    List<Admin> selectAll();



}

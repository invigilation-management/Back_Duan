package com.example.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.mapper.AdminMapper;
import com.example.mybatisplus.mapper.CollegeMapper;
import com.example.mybatisplus.mapper.StudentMapper;
import com.example.mybatisplus.model.domain.Admin;
import com.example.mybatisplus.model.domain.College;
import com.example.mybatisplus.model.domain.Student;
import com.example.mybatisplus.service.AdminService;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//加载ioc容器 扫描（本类所在路径的所有文件）
class MybatisplusApplicationTests {

//    @Autowired
//    private AdminService adminService;
//    @Test
//    void contextLoads() {
//        Admin byId = adminService.getById(1);
//        System.out.println(byId);
//    }
//查询id为1的admin
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CollegeMapper collegeMapper;


    @Test
    void hh(){
        //内置api
        College college = collegeMapper.selectById(1L);

        for(int i=4;i<11;i++){
            College college1= new College();
            college1.setCollegeId(i).setCollegeName("user"+i);
            int insert=collegeMapper.insert(college1);
        }




    }
    @Test
    void qq(){
        //条件构造器
        QueryWrapper<Admin> wrapper=new QueryWrapper<>();
        //查询id为1且名字为hello
        //select * from admin where id=1 and loginNanme='hello'
        wrapper.eq("id",1).eq("loginName","hello");
        int delete=adminMapper.delete(wrapper);//执行增删改后返回受影响的行数
        List<Admin> admins=adminMapper.selectList(wrapper);

    }
    @Test
    void qq2(){
        //定义分页参数,实际应该有前端传入
        Integer pageNo=1;
        Integer pageSize=10;

        //定义分页器,设置分页参数
        Page<Admin> page=new Page<>();
        page.setCurrent(pageNo).setSize(pageSize);
        QueryWrapper<Admin> wrapper=new QueryWrapper<>();
        Page<Admin> page1=adminMapper.selectPage(page, wrapper);
    }

    @Test
    void qq3(){
        //自己写一个SQL,查询id为1的用户
        Admin  admin =adminMapper.selectByIdMy(1L);
        Admin a=new Admin().setId(1L);//lomboc中链式写法
        Admin  admin1 =adminMapper.selectByIdAdmin(a);


        //查询所有
        List<Admin> list=adminMapper.selectAll();



    }

    @Test
    void hh2(){
        Admin admin=new Admin().setId(2L).setRemark("11");
        List<Admin> admins=adminMapper.selectByAdmin(admin);
    }

    @Test
    void hh3(){
        Student student=studentMapper.selectByIdWithAdmin(1L);
        System.out.println(student);
    }




}

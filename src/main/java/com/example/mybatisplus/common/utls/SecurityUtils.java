package com.example.mybatisplus.common.utls;

import com.example.mybatisplus.model.domain.Admin;
import com.example.mybatisplus.model.domain.User;
import com.example.mybatisplus.model.dto.UserInfoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SecurityUtils {
    /**
     * 获取当前用户
     *
     * @return
     */
    public static User getCurrentUserInfo() {
        User userInfo = SessionUtils.getCurrentUserInfo();
        //模拟登录
        if (userInfo == null) {
            userInfo = new User();
            userInfo.setUserName("模拟");
        }

        return userInfo;
    }

    public static User getUserInfo() {
        User userInfo = SessionUtils.getCurrentUserInfo();
        User userInfoDTO = new User();
        //模拟登录
        if (userInfo == null) {
            userInfo = new User();
            userInfo.setUserName("模拟用户");
            userInfoDTO.setUserId(1L);
            userInfoDTO.setUserName("模拟用户");
            userInfoDTO.setFacultyFacultyId(1L);
        }else{
            userInfoDTO = userInfo;
        }

        return userInfoDTO;
    }
}

package com.aix.admin.system.service;

import com.aix.admin.system.dto.LoginDTO;
import com.aix.admin.system.dto.UserAuthDTO;
import com.aix.admin.system.dto.UserDTO;

public interface AuthService {

    /**
     * 登录
     * @param loginDTO
     */
    String login(LoginDTO loginDTO);

    /**
     * 获取登录信息
     * @return
     */
    UserAuthDTO getUserInfo();
}

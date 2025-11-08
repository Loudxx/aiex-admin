package com.aiex.admin.system.service;

import com.aiex.admin.system.dto.LoginDTO;
import com.aiex.admin.system.dto.UserAuthDTO;

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

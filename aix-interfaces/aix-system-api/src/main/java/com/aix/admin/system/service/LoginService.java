package com.aix.admin.system.service;

import com.aix.admin.system.dto.LoginDTO;

public interface LoginService {

    /**
     * 登录
     * @param loginDTO
     */
    void login(LoginDTO loginDTO);
}

package com.aix.admin.system.service.impl;

import com.aix.admin.system.domian.service.LoginDomainService;
import com.aix.admin.system.dto.LoginDTO;
import com.aix.admin.system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDomainService loginDomainService;


    @Override
    public void login(LoginDTO loginDTO) {
        
    }
}

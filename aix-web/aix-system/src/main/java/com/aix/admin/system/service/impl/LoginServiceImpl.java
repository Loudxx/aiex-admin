package com.aix.admin.system.service.impl;

import com.aix.admin.system.domian.service.LoginDomainService;
import com.aix.admin.system.dto.LoginDTO;
import com.aix.admin.system.service.LoginService;
import com.aix.framework.security.bo.LoginUser;
import com.aix.framework.security.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDomainService loginDomainService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;


    @Override
    public String login(LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());
        // 用户验证
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // 生成token
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        return tokenService.genToken(loginUser);
    }
}

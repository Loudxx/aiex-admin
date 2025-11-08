package com.aiex.admin.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.aiex.admin.system.domian.domain.UserAuthDomain;
import com.aiex.admin.system.domian.service.AuthDomainService;
import com.aiex.admin.system.dto.LoginDTO;
import com.aiex.admin.system.dto.UserAuthDTO;
import com.aiex.admin.system.service.AuthService;
import com.aiex.framework.security.bo.LoginUser;
import com.aiex.framework.security.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthDomainService authDomainService;

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

    @Override
    public UserAuthDTO getUserInfo() {
        UserAuthDomain userAuthDomain = authDomainService.getUserInfo();
        return BeanUtil.toBean(userAuthDomain, UserAuthDTO.class);
    }
}

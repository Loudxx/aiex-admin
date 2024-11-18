package com.aix.admin.system.domian.service.impl;

import com.aix.admin.system.entity.Menu;
import com.aix.admin.system.entity.Role;
import com.aix.admin.system.entity.User;
import com.aix.admin.system.mapper.MenuMapper;
import com.aix.admin.system.mapper.RoleMapper;
import com.aix.admin.system.mapper.UserMapper;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", username);
        User user = userMapper.selectOneByQuery(queryWrapper);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        //查询用户对应角色
        List<Role> roles = roleMapper.selectListByUserId(user.getId());
        //查询用户对应菜单
        List<Menu> menus = menuMapper.selectListByUserId(user.getId());
        user.setRoles(roles);
        user.setMenus(menus);
        return user;
    }

}

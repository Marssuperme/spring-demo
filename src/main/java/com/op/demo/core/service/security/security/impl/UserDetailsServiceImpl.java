package com.op.demo.core.service.security.security.impl;


import com.op.demo.core.entity.User;
import com.op.demo.core.entity.UserRole;
import com.op.demo.core.entity.security.SecurityUser;
import com.op.demo.core.mapper.UserMapper;
import com.op.demo.core.mapper.UserRoleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author impact 2019-10-10
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private final UserMapper userMapper;
    private final UserRoleMapper userRoleMapper;

    @Autowired
    public UserDetailsServiceImpl(UserMapper userMapper, UserRoleMapper userRoleMapper) {
        this.userMapper = userMapper;
        this.userRoleMapper = userRoleMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userMapper.selectByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        List<UserRole> userRoleList = userRoleMapper.selectUserRoleByUserId(user.getUserId());
        if (userRoleList != null) {
            for (UserRole userRole : userRoleList) {
                authorities.add(new SimpleGrantedAuthority(userRole.getRole().getRoleName()));
                logger.info(authorities.toString());
            }
        }
        return new SecurityUser(user.getUserName(), user.getUserPassword(), authorities);
    }
}

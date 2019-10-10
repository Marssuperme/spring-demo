package com.op.demo.core.service.security.user;

import com.op.demo.core.entity.User;

/**
 * @author impact 2019-10-10
 */
public interface UserService {

    User selectByUserId(Integer userId);

    User selectByUserName(String userName);
}

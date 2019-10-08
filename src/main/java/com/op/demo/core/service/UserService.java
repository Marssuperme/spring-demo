package com.op.demo.core.service;

import com.op.demo.core.entity.User;

/**
 * @author im
 */
public interface UserService {
    User selectByUserId(Integer userId);
}

package com.op.demo.core.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author impact 2019-10-10
 */
@Getter
@Setter
public class UserRole {
    private Integer userRoleId;

    private Integer userId;

    private Integer roleId;

    private String remark;

    private Date createTime;

    private User user;

    private Role role;

}
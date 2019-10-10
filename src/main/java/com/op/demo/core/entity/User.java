package com.op.demo.core.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author impact 2019-10-10
 */
@Getter
@Setter
public class User {
    private Integer userId;

    private String userName;

    private String userPassword;

    private String remark;

    private Date createTime;

}
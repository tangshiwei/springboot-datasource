package com.datasource.bean;


import lombok.Data;

import java.util.Date;

@Data
public class PUser {
    private Long id;
    private Long groupId;
    private Long parentId;
    private Long merchantsId;
    private String userName;
    private String passWord;
    private String mobile;
    private String email;
    private Long status;
    private Date createTime;
    private String createBy;
    private Date updateTime;
    private String updateBy;
} 
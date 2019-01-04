package com.example.demo.domain;

import lombok.Data;

import java.util.Date;

/**
 * GO:
 * Created By JiWei.Chen 2018-12-18
 */
@Data
public class SysUserBean {
    private long id;
    private String username;
    private String password;
    private String mobile;
    private String email;
    private Date create_time;
}

package com.example.demo.service;

import com.example.demo.domain.SysUserBean;

import java.util.List;

public interface UserService {

    void save(SysUserBean bean);

    void drop(Long id);

    void edit(SysUserBean bean);

    SysUserBean find(Long id);

    List<SysUserBean> list();
}

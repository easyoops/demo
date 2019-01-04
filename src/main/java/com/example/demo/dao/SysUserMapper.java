package com.example.demo.dao;

import com.example.demo.domain.SysUserBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMapper {

    void insert(SysUserBean bean);

    List<SysUserBean> list();

    void delete(long id);
}

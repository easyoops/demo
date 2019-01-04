package com.example.demo.service;

import com.example.demo.dao.SysUserMapper;
import com.example.demo.domain.SysUserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * GO:
 * Created By JiWei.Chen 2018-12-18
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public void save(SysUserBean bean) {
        sysUserMapper.insert(bean);
    }

    @Override
    public void drop(Long id) {
        sysUserMapper.delete(id);
    }

    @Override
    public void edit(SysUserBean bean) {

    }

    @Override
    public SysUserBean find(Long id) {
        return null;
    }

    @Override
    public List<SysUserBean> list() {
        return null;
    }
}

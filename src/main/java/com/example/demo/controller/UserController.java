package com.example.demo.controller;

import com.example.demo.common.bean.ResultBean;
import com.example.demo.domain.SysUserBean;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * GO: Master the users
 * Created By JiWei.Chen 2019-01-04
 */

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/drop")
    public ResultBean drop(long id) {
        userService.drop(id);
        return new ResultBean();
    }

    @RequestMapping(value = "/save")
    public ResultBean save(SysUserBean bean) {
        userService.save(bean);
        return new ResultBean();
    }

    @RequestMapping(value = "/edit")
    public ResultBean edit(SysUserBean bean) {
        userService.edit(bean);
        return new ResultBean();
    }

    @RequestMapping(value = "/find")
    public ResultBean<SysUserBean> find(Long id) {
        return new ResultBean<>(userService.find(id));
    }

    @RequestMapping(value = "/list")
    public ResultBean<List<SysUserBean>> list() {
        return new ResultBean<>(userService.list());
    }

}



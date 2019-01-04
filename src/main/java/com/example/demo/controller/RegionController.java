package com.example.demo.controller;

import com.example.demo.common.bean.ResultBean;
import com.example.demo.common.config.JedisPoolUtil;
import com.example.demo.dao.RegionMapper;
import com.example.demo.domain.RegionBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * GO:
 * Created By JiWei.Chen 2018-12-13
 */
@RestController
@RequestMapping(value = "/area")
public class RegionController extends BaseController{

    @Autowired
    private RegionMapper RegionCodeMapper;
    @Autowired
    private JedisPoolUtil jedisPoolUtil;

    @RequestMapping(value = "/save")
    public ResultBean<String> get(RegionBean bean) {
        JedisPool jedisPool = jedisPoolUtil.getJedisPool();
        Jedis jedis = jedisPool.getResource();
        String temp = jedis.get("name");
        jedis.set("name", temp + "," + bean.getArea_name());
        jedis.close();
        Jedis jedis1 = jedisPool.getResource();
        String value = jedis1.get("name");
        jedis1.close();
        return new ResultBean<>(value);
    }

    @RequestMapping(value = "/list")
    public ResultBean<PageInfo> list() {
        //当前 页码和行数
        PageHelper.startPage(1, 10);
        List<RegionBean> list = RegionCodeMapper.list();
        PageInfo<RegionBean> pageInfo = new PageInfo<>(list);
        return new ResultBean(pageInfo);
    }
}

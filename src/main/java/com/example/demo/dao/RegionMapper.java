package com.example.demo.dao;

import com.example.demo.domain.RegionBean;

import java.util.List;

public interface RegionMapper {

    void insert(RegionBean bean);

    List<RegionBean> list();

    void update(RegionBean bean);
}

package com.example.demo.domain;


/**
 * GO: 省市编码
 * Created By JiWei.Chen 2019-01-04
 */
public class RegionBean {
    /**
     * 编码
     */
    private Long area_code;
    /**
     * 名称
     */
    private String area_name;
    /**
     * 级别
     */
    private int area_level;
    /**
     * 上级编码
     */
    private Long p_code;

    public Long getArea_code() {
        return area_code;
    }

    public void setArea_code(Long area_code) {
        this.area_code = area_code;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public int getArea_level() {
        return area_level;
    }

    public void setArea_level(int area_level) {
        this.area_level = area_level;
    }

    public Long getP_code() {
        return p_code;
    }

    public void setP_code(Long p_code) {
        this.p_code = p_code;
    }
}


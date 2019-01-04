package com.example.demo.common.bean;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * GO: 分页结果
 * Created By JiWei.Chen 2018-12-18
 */
public class PageResult<T> {

    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 当前页数量
     */
    private int pageSize;
    /**
     * 总记录数
     */
    private long total;
    /**
     * 总页数
     */
    private int pages;
    private List<T> list;

    public PageResult(){}

    public PageResult(PageInfo info){
        this.pageNum = info.getPageNum();
        this.pageSize = info.getPageSize();
        this.total = info.getTotal();
        this.pages = info.getPages();
        this.list = info.getList();
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}

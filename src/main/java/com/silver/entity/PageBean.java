package com.silver.entity;

import java.util.List;

/**
 * 进行分页操作的Java Bean封装
 * @author 光玉
 * @create 2018-05-17 14:09
 **/
public class PageBean<Object> {
    private int pageNum;                // 当前页码
    private int pageRecord;             // 每页记录数
    private int totalRecord;            // 总记录数
    private int totalPage;              // 总页数
    private List<Object> beanList;      // 当前页的记录

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageRecord() {
        return pageRecord;
    }

    public void setPageRecord(int pageRecord) {
        this.pageRecord = pageRecord;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<Object> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<Object> beanList) {
        this.beanList = beanList;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pageNum=" + pageNum +
                ", pageRecord=" + pageRecord +
                ", totalRecord=" + totalRecord +
                ", totalPage=" + totalPage +
                ", beanList=" + beanList +
                '}';
    }
}

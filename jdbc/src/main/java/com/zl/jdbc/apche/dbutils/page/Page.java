package com.zl.jdbc.apche.dbutils.page;

/**
 * Created by Administrator on 2017/8/8.
 */

public class Page {

    // 总条数
    private int totalSize;

    // 每页大小
    private int pageSize;

    // 总页数
    private int totalPage;

    // 第几页
    private int pageNum = 1;

    // 每页开始条数
    private int pageBegin;

    // 每页结束条数
    private int pageEnd;

    public Page(int pageSize) {
        this.pageSize = pageSize;
    }

    public Page() {
    }

    public void init() {
        // pageSize 默认为5
        if (pageSize <= 0) {
            pageSize = 5;
        }

        totalPage = totalSize / pageSize;

        if (0 != totalSize % pageSize) {
            totalPage += 1;
        }

        if (pageNum > totalPage) {
            pageNum = totalPage;
        }
        if (pageNum < 1) {
            pageNum = 1;
        }
        pageBegin = (pageNum - 1) * pageSize + 1;
        pageEnd = (pageNum) * pageSize;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageBegin() {
        return pageBegin;
    }

    public void setPageBegin(int pageBegin) {
        this.pageBegin = pageBegin;
    }

    public int getPageEnd() {
        return pageEnd;
    }

    public void setPageEnd(int pageEnd) {
        this.pageEnd = pageEnd;
    }

    @Override
    public String toString() {
        return "Page [totalSize=" + totalSize + ", pageSize=" + pageSize + ", totalPage=" + totalPage + ", pageNum="
                + pageNum + ", pageBegin=" + pageBegin + ", pageEnd=" + pageEnd + "]";
    }
}
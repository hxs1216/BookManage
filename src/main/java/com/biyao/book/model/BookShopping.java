package com.biyao.book.model;

import java.util.Date;

public class BookShopping {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 书的主键
     */
    private Integer bookId;

    /**
     * 账户
     */
    private String bookAccount;

    /**
     * 书的创建日期
     */
    private Date createTime;

    /**
     * 最后一次修改时间
     */
    private Date updateTime;

    /**
     * 书的状态
     */
    private String status;

    /**
     * 获取 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置   主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 书的主键
     */
    public Integer getBookId() {
        return bookId;
    }

    /**
     * 设置   书的主键
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    /**
     * 获取 账户
     */
    public String getBookAccount() {
        return bookAccount;
    }

    /**
     * 设置   账户
     */
    public void setBookAccount(String bookAccount) {
        this.bookAccount = bookAccount;
    }

    /**
     * 获取 书的创建日期
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置   书的创建日期
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 最后一次修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置   最后一次修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取 书的状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置   书的状态
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
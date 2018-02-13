package com.biyao.book.model;

import java.util.Date;

public class BookComment {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 评论
     */
    private String comment;

    /**
     * 作者
     */
    private String commentPerson;

    /**
     * 书的主键
     */
    private String bookId;

    /**
     * 书的创建日期
     */
    private Date createTime;

    /**
     * 最后一次修改时间
     */
    private Date updateTime;

    /**
     * 简介
     */
    private String express1;

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
     * 获取 评论
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置   评论
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 获取 作者
     */
    public String getCommentPerson() {
        return commentPerson;
    }

    /**
     * 设置   作者
     */
    public void setCommentPerson(String commentPerson) {
        this.commentPerson = commentPerson;
    }

    /**
     * 获取 书的主键
     */
    public String getBookId() {
        return bookId;
    }

    /**
     * 设置   书的主键
     */
    public void setBookId(String bookId) {
        this.bookId = bookId;
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
     * 获取 简介
     */
    public String getExpress1() {
        return express1;
    }

    /**
     * 设置   简介
     */
    public void setExpress1(String express1) {
        this.express1 = express1;
    }
}
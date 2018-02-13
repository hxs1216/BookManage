package com.biyao.book.model;

import java.util.Date;

public class BookIntroduct {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 书名
     */
    private String bookName;

    /**
     * 系列
     */
    private String bookSeries;

    /**
     * 作者
     */
        private String bookAuthor;

    /**
     * 类别
     */
    private String bookType;

    /**
     * 年龄段
     */
    private String bookAge;

    /**
     * 状态
     */
    private String bookStatus;

    /**
     * 发表点评
     */
    private String bookComment;

    /**
     * 书的图片
     */
    private String bookImage;

    /**
     * 个人图书馆
     */
    private String bookLibrary;

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
     * 冗余字段
     */
    private String express1;

    /**
     * 冗余字段
     */
    private String express2;

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
     * 获取 书名
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * 设置   书名
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * 获取 系列
     */
    public String getBookSeries() {
        return bookSeries;
    }

    /**
     * 设置   系列
     */
    public void setBookSeries(String bookSeries) {
        this.bookSeries = bookSeries;
    }

    /**
     * 获取 作者
     */
    public String getBookAuthor() {
        return bookAuthor;
    }

    /**
     * 设置   作者
     */
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    /**
     * 获取 类别
     */
    public String getBookType() {
        return bookType;
    }

    /**
     * 设置   类别
     */
    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    /**
     * 获取 年龄段
     */
    public String getBookAge() {
        return bookAge;
    }

    /**
     * 设置   年龄段
     */
    public void setBookAge(String bookAge) {
        this.bookAge = bookAge;
    }

    /**
     * 获取 状态
     */
    public String getBookStatus() {
        return bookStatus;
    }

    /**
     * 设置   状态
     */
    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus.trim();
    }

    /**
     * 获取 发表点评
     */
    public String getBookComment() {
        return bookComment.trim();
    }

    /**
     * 设置   发表点评
     */
    public void setBookComment(String bookComment) {
        this.bookComment = bookComment;
    }

    /**
     * 获取 书的图片
     */
    public String getBookImage() {
        return bookImage;
    }

    /**
     * 设置   书的图片
     */
    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    /**
     * 获取 个人图书馆
     */
    public String getBookLibrary() {
        return bookLibrary;
    }

    /**
     * 设置   个人图书馆
     */
    public void setBookLibrary(String bookLibrary) {
        this.bookLibrary = bookLibrary;
    }

    public String getBookAccount() {
        return bookAccount;
    }

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
     * 获取 冗余字段
     */
    public String getExpress1() {
        return express1;
    }

    /**
     * 设置   冗余字段
     */
    public void setExpress1(String express1) {
        this.express1 = express1;
    }

    /**
     * 获取 冗余字段
     */
    public String getExpress2() {
        return express2;
    }

    /**
     * 设置   冗余字段
     */
    public void setExpress2(String express2) {
        this.express2 = express2;
    }
}
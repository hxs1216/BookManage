package com.biyao.book.dao;

import com.biyao.book.model.BookIntroduct;
import com.biyao.book.model.BookShopping;
import com.biyao.book.model.BookShoppingExample;
import java.util.List;
import java.util.Map;

public interface IBookShoppingDAO {
    int countByExample(BookShoppingExample example);

    int deleteByExample(BookShoppingExample example);

    int deleteByPrimaryKey(Integer id);

    void insert(BookShopping record);

    void insertSelective(BookShopping record);

    List<BookShopping> selectByExample(BookShoppingExample example);

    BookShopping selectByPrimaryKey(Integer id);

    int updateByExampleSelective(BookShopping record, BookShoppingExample example);

    int updateByExample(BookShopping record, BookShoppingExample example);

    int updateByPrimaryKeySelective(BookShopping record);

    int updateByPrimaryKey(BookShopping record);

    //展示个人购物车
    List<Map> selectShopping(String bookAccount);

    //汇总购物车
    List<Map> collectShopping(Map map);
}
package com.biyao.book.dao;

import com.biyao.book.model.BookIntroduct;
import com.biyao.book.model.BookIntroductExample;
import java.util.List;
import java.util.Map;

public interface IBookIntroductDAO {
    int countByExample(BookIntroductExample example);

    int deleteByExample(BookIntroductExample example);

    int deleteByPrimaryKey(Integer id);

    void insert(BookIntroduct record);

    void insertSelective(BookIntroduct record);

    List<BookIntroduct> selectByExample(BookIntroductExample example);

    BookIntroduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(BookIntroduct record, BookIntroductExample example);

    int updateByExample(BookIntroduct record, BookIntroductExample example);

    int updateByPrimaryKeySelective(BookIntroduct record);

    int updateByPrimaryKey(BookIntroduct record);

    //搜索书的列表
    List<BookIntroduct> searchBooks(Map condition);

    //搜索书的数量
    int countBooks(Map condition);
}
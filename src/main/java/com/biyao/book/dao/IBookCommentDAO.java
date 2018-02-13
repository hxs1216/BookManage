package com.biyao.book.dao;

import com.biyao.book.model.BookComment;
import com.biyao.book.model.BookCommentExample;
import java.util.List;

public interface IBookCommentDAO {
    int countByExample(BookCommentExample example);

    int deleteByExample(BookCommentExample example);

    int deleteByPrimaryKey(Integer id);

    void insert(BookComment record);

    void insertSelective(BookComment record);

    List<BookComment> selectByExample(BookCommentExample example);

    BookComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(BookComment record, BookCommentExample example);

    int updateByExample(BookComment record, BookCommentExample example);

    int updateByPrimaryKeySelective(BookComment record);

    int updateByPrimaryKey(BookComment record);
}
package com.biyao.book.dao.impl;

import com.biyao.book.dao.IBookCommentDAO;
import com.biyao.book.model.BookComment;
import com.biyao.book.model.BookCommentExample;
import com.biyao.common.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("iBookCommentDAO")
public class BookCommentDAOImpl extends BaseDaoImpl implements IBookCommentDAO {

    public BookCommentDAOImpl() {
        super();
    }

    public int countByExample(BookCommentExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("t_book_comment.countByExample", example);
        return count;
    }

    public int deleteByExample(BookCommentExample example) {
        int rows = getSqlMapClientTemplate().delete("t_book_comment.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Integer id) {
        BookComment _key = new BookComment();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("t_book_comment.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BookComment record) {
        getSqlMapClientTemplate().insert("t_book_comment.insert", record);
    }

    public void insertSelective(BookComment record) {
        getSqlMapClientTemplate().insert("t_book_comment.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BookComment> selectByExample(BookCommentExample example) {
        List<BookComment> list = getSqlMapClientTemplate().queryForList("t_book_comment.selectByExample", example);
        return list;
    }

    public BookComment selectByPrimaryKey(Integer id) {
        BookComment _key = new BookComment();
        _key.setId(id);
        BookComment record = (BookComment) getSqlMapClientTemplate().queryForObject("t_book_comment.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BookComment record, BookCommentExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_book_comment.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BookComment record, BookCommentExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_book_comment.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BookComment record) {
        int rows = getSqlMapClientTemplate().update("t_book_comment.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BookComment record) {
        int rows = getSqlMapClientTemplate().update("t_book_comment.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends BookCommentExample {
        private Object record;

        public UpdateByExampleParms(Object record, BookCommentExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}
package com.biyao.book.dao.impl;

import com.biyao.book.dao.IBookIntroductDAO;
import com.biyao.book.model.BookIntroduct;
import com.biyao.book.model.BookIntroductExample;
import com.biyao.common.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("iBookIntroductDAO")
public class BookIntroductDAOImpl extends BaseDaoImpl implements IBookIntroductDAO {

    public BookIntroductDAOImpl() {
        super();
    }

    public int countByExample(BookIntroductExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("t_book_introduct.countByExample", example);
        return count;
    }

    public int deleteByExample(BookIntroductExample example) {
        int rows = getSqlMapClientTemplate().delete("t_book_introduct.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Integer id) {
        BookIntroduct _key = new BookIntroduct();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("t_book_introduct.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BookIntroduct record) {
        getSqlMapClientTemplate().insert("t_book_introduct.insert", record);
    }

    public void insertSelective(BookIntroduct record) {
        getSqlMapClientTemplate().insert("t_book_introduct.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BookIntroduct> selectByExample(BookIntroductExample example) {
        List<BookIntroduct> list = getSqlMapClientTemplate().queryForList("t_book_introduct.selectByExample", example);
        return list;
    }

    public BookIntroduct selectByPrimaryKey(Integer id) {
        BookIntroduct _key = new BookIntroduct();
        _key.setId(id);
        BookIntroduct record = (BookIntroduct) getSqlMapClientTemplate().queryForObject("t_book_introduct.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BookIntroduct record, BookIntroductExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_book_introduct.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BookIntroduct record, BookIntroductExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_book_introduct.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BookIntroduct record) {
        int rows = getSqlMapClientTemplate().update("t_book_introduct.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BookIntroduct record) {
        int rows = getSqlMapClientTemplate().update("t_book_introduct.updateByPrimaryKey", record);
        return rows;
    }

    public List<BookIntroduct> searchBooks(Map condition) {
        List<BookIntroduct> list = getSqlMapClientTemplate().queryForList("t_book_introduct.searchBooks", condition);
        return list;
    }

    public int countBooks(Map condition) {
        Integer list = (Integer)getSqlMapClientTemplate().queryForObject("t_book_introduct.countBooks", condition);
        return list;
    }

    protected static class UpdateByExampleParms extends BookIntroductExample {
        private Object record;

        public UpdateByExampleParms(Object record, BookIntroductExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}
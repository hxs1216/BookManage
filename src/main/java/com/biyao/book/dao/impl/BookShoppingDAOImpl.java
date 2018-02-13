package com.biyao.book.dao.impl;

import com.biyao.book.dao.IBookShoppingDAO;
import com.biyao.book.model.BookIntroduct;
import com.biyao.book.model.BookShopping;
import com.biyao.book.model.BookShoppingExample;
import com.biyao.common.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("iBookShoppingDAO")
public class BookShoppingDAOImpl extends BaseDaoImpl implements IBookShoppingDAO {

    public BookShoppingDAOImpl() {
        super();
    }

    public int countByExample(BookShoppingExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("t_book_shopping.countByExample", example);
        return count;
    }

    public int deleteByExample(BookShoppingExample example) {
        int rows = getSqlMapClientTemplate().delete("t_book_shopping.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Integer id) {
        BookShopping _key = new BookShopping();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("t_book_shopping.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BookShopping record) {
        getSqlMapClientTemplate().insert("t_book_shopping.insert", record);
    }

    public void insertSelective(BookShopping record) {
        getSqlMapClientTemplate().insert("t_book_shopping.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BookShopping> selectByExample(BookShoppingExample example) {
        List<BookShopping> list = getSqlMapClientTemplate().queryForList("t_book_shopping.selectByExample", example);
        return list;
    }

    public BookShopping selectByPrimaryKey(Integer id) {
        BookShopping _key = new BookShopping();
        _key.setId(id);
        BookShopping record = (BookShopping) getSqlMapClientTemplate().queryForObject("t_book_shopping.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BookShopping record, BookShoppingExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_book_shopping.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BookShopping record, BookShoppingExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_book_shopping.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BookShopping record) {
        int rows = getSqlMapClientTemplate().update("t_book_shopping.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BookShopping record) {
        int rows = getSqlMapClientTemplate().update("t_book_shopping.updateByPrimaryKey", record);
        return rows;
    }

    public List<Map> selectShopping(String bookAccount) {
        List<Map> list = getSqlMapClientTemplate().queryForList("t_book_shopping.selectShopping", bookAccount);
        return list;
    }

    public List<Map> collectShopping(Map map) {
        List<Map> list = getSqlMapClientTemplate().queryForList("t_book_shopping.collectShopping", map);
        return list;
    }

    protected static class UpdateByExampleParms extends BookShoppingExample {
        private Object record;

        public UpdateByExampleParms(Object record, BookShoppingExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}
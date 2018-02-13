package com.biyao.book.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookIntroductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer mysqlOffset;

    private Integer mysqlLength;

    public BookIntroductExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BookIntroductExample(BookIntroductExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
        this.distinct = example.distinct;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setMysqlOffset(Integer mysqlOffset) {
        this.mysqlOffset = mysqlOffset;
    }

    public Integer getMysqlOffset() {
        return mysqlOffset;
    }

    public void setMysqlLength(Integer mysqlLength) {
        this.mysqlLength = mysqlLength;
    }

    public Integer getMysqlLength() {
        return mysqlLength;
    }

    protected abstract static class GeneratedCriteria {
        protected List<String> criteriaWithoutValue;

        protected List<Map<String, Object>> criteriaWithSingleValue;

        protected List<Map<String, Object>> criteriaWithListValue;

        protected List<Map<String, Object>> criteriaWithBetweenValue;

        protected GeneratedCriteria() {
            super();
            criteriaWithoutValue = new ArrayList<String>();
            criteriaWithSingleValue = new ArrayList<Map<String, Object>>();
            criteriaWithListValue = new ArrayList<Map<String, Object>>();
            criteriaWithBetweenValue = new ArrayList<Map<String, Object>>();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List<String> getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public void setCriteriaWithoutValue(List<String> criteriaWithoutValue) {
            this.criteriaWithoutValue = criteriaWithoutValue;
        }

        public List<Map<String, Object>> getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public void setCriteriaWithSingleValue(List<Map<String, Object>> criteriaWithSingleValue) {
            this.criteriaWithSingleValue = criteriaWithSingleValue;
        }

        public List<Map<String, Object>> getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public void setCriteriaWithListValue(List<Map<String, Object>> criteriaWithListValue) {
            this.criteriaWithListValue = criteriaWithListValue;
        }

        public List<Map<String, Object>> getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        public void setCriteriaWithBetweenValue(List<Map<String, Object>> criteriaWithBetweenValue) {
            this.criteriaWithBetweenValue = criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List<? extends Object> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List<Object> list = new ArrayList<Object>();
            list.add(value1);
            list.add(value2);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNull() {
            addCriterion("book_name is null");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNotNull() {
            addCriterion("book_name is not null");
            return (Criteria) this;
        }

        public Criteria andBookNameEqualTo(String value) {
            addCriterion("book_name =", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotEqualTo(String value) {
            addCriterion("book_name <>", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThan(String value) {
            addCriterion("book_name >", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("book_name >=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThan(String value) {
            addCriterion("book_name <", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThanOrEqualTo(String value) {
            addCriterion("book_name <=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLike(String value) {
            addCriterion("book_name like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotLike(String value) {
            addCriterion("book_name not like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameIn(List<String> values) {
            addCriterion("book_name in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotIn(List<String> values) {
            addCriterion("book_name not in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameBetween(String value1, String value2) {
            addCriterion("book_name between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotBetween(String value1, String value2) {
            addCriterion("book_name not between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookSeriesIsNull() {
            addCriterion("book_series is null");
            return (Criteria) this;
        }

        public Criteria andBookSeriesIsNotNull() {
            addCriterion("book_series is not null");
            return (Criteria) this;
        }

        public Criteria andBookSeriesEqualTo(String value) {
            addCriterion("book_series =", value, "bookSeries");
            return (Criteria) this;
        }

        public Criteria andBookSeriesNotEqualTo(String value) {
            addCriterion("book_series <>", value, "bookSeries");
            return (Criteria) this;
        }

        public Criteria andBookSeriesGreaterThan(String value) {
            addCriterion("book_series >", value, "bookSeries");
            return (Criteria) this;
        }

        public Criteria andBookSeriesGreaterThanOrEqualTo(String value) {
            addCriterion("book_series >=", value, "bookSeries");
            return (Criteria) this;
        }

        public Criteria andBookSeriesLessThan(String value) {
            addCriterion("book_series <", value, "bookSeries");
            return (Criteria) this;
        }

        public Criteria andBookSeriesLessThanOrEqualTo(String value) {
            addCriterion("book_series <=", value, "bookSeries");
            return (Criteria) this;
        }

        public Criteria andBookSeriesLike(String value) {
            addCriterion("book_series like", value, "bookSeries");
            return (Criteria) this;
        }

        public Criteria andBookSeriesNotLike(String value) {
            addCriterion("book_series not like", value, "bookSeries");
            return (Criteria) this;
        }

        public Criteria andBookSeriesIn(List<String> values) {
            addCriterion("book_series in", values, "bookSeries");
            return (Criteria) this;
        }

        public Criteria andBookSeriesNotIn(List<String> values) {
            addCriterion("book_series not in", values, "bookSeries");
            return (Criteria) this;
        }

        public Criteria andBookSeriesBetween(String value1, String value2) {
            addCriterion("book_series between", value1, value2, "bookSeries");
            return (Criteria) this;
        }

        public Criteria andBookSeriesNotBetween(String value1, String value2) {
            addCriterion("book_series not between", value1, value2, "bookSeries");
            return (Criteria) this;
        }

        public Criteria andBookAuthorIsNull() {
            addCriterion("book_author is null");
            return (Criteria) this;
        }

        public Criteria andBookAuthorIsNotNull() {
            addCriterion("book_author is not null");
            return (Criteria) this;
        }

        public Criteria andBookAuthorEqualTo(String value) {
            addCriterion("book_author =", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotEqualTo(String value) {
            addCriterion("book_author <>", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorGreaterThan(String value) {
            addCriterion("book_author >", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("book_author >=", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorLessThan(String value) {
            addCriterion("book_author <", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorLessThanOrEqualTo(String value) {
            addCriterion("book_author <=", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorLike(String value) {
            addCriterion("book_author like", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotLike(String value) {
            addCriterion("book_author not like", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorIn(List<String> values) {
            addCriterion("book_author in", values, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotIn(List<String> values) {
            addCriterion("book_author not in", values, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorBetween(String value1, String value2) {
            addCriterion("book_author between", value1, value2, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotBetween(String value1, String value2) {
            addCriterion("book_author not between", value1, value2, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookTypeIsNull() {
            addCriterion("book_type is null");
            return (Criteria) this;
        }

        public Criteria andBookTypeIsNotNull() {
            addCriterion("book_type is not null");
            return (Criteria) this;
        }

        public Criteria andBookTypeEqualTo(String value) {
            addCriterion("book_type =", value, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeNotEqualTo(String value) {
            addCriterion("book_type <>", value, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeGreaterThan(String value) {
            addCriterion("book_type >", value, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeGreaterThanOrEqualTo(String value) {
            addCriterion("book_type >=", value, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeLessThan(String value) {
            addCriterion("book_type <", value, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeLessThanOrEqualTo(String value) {
            addCriterion("book_type <=", value, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeLike(String value) {
            addCriterion("book_type like", value, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeNotLike(String value) {
            addCriterion("book_type not like", value, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeIn(List<String> values) {
            addCriterion("book_type in", values, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeNotIn(List<String> values) {
            addCriterion("book_type not in", values, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeBetween(String value1, String value2) {
            addCriterion("book_type between", value1, value2, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeNotBetween(String value1, String value2) {
            addCriterion("book_type not between", value1, value2, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookAgeIsNull() {
            addCriterion("book_age is null");
            return (Criteria) this;
        }

        public Criteria andBookAgeIsNotNull() {
            addCriterion("book_age is not null");
            return (Criteria) this;
        }

        public Criteria andBookAgeEqualTo(String value) {
            addCriterion("book_age =", value, "bookAge");
            return (Criteria) this;
        }

        public Criteria andBookAgeNotEqualTo(String value) {
            addCriterion("book_age <>", value, "bookAge");
            return (Criteria) this;
        }

        public Criteria andBookAgeGreaterThan(String value) {
            addCriterion("book_age >", value, "bookAge");
            return (Criteria) this;
        }

        public Criteria andBookAgeGreaterThanOrEqualTo(String value) {
            addCriterion("book_age >=", value, "bookAge");
            return (Criteria) this;
        }

        public Criteria andBookAgeLessThan(String value) {
            addCriterion("book_age <", value, "bookAge");
            return (Criteria) this;
        }

        public Criteria andBookAgeLessThanOrEqualTo(String value) {
            addCriterion("book_age <=", value, "bookAge");
            return (Criteria) this;
        }

        public Criteria andBookAgeLike(String value) {
            addCriterion("book_age like", value, "bookAge");
            return (Criteria) this;
        }

        public Criteria andBookAgeNotLike(String value) {
            addCriterion("book_age not like", value, "bookAge");
            return (Criteria) this;
        }

        public Criteria andBookAgeIn(List<String> values) {
            addCriterion("book_age in", values, "bookAge");
            return (Criteria) this;
        }

        public Criteria andBookAgeNotIn(List<String> values) {
            addCriterion("book_age not in", values, "bookAge");
            return (Criteria) this;
        }

        public Criteria andBookAgeBetween(String value1, String value2) {
            addCriterion("book_age between", value1, value2, "bookAge");
            return (Criteria) this;
        }

        public Criteria andBookAgeNotBetween(String value1, String value2) {
            addCriterion("book_age not between", value1, value2, "bookAge");
            return (Criteria) this;
        }

        public Criteria andBookStatusIsNull() {
            addCriterion("book_status is null");
            return (Criteria) this;
        }

        public Criteria andBookStatusIsNotNull() {
            addCriterion("book_status is not null");
            return (Criteria) this;
        }

        public Criteria andBookStatusEqualTo(String value) {
            addCriterion("book_status =", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusNotEqualTo(String value) {
            addCriterion("book_status <>", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusGreaterThan(String value) {
            addCriterion("book_status >", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusGreaterThanOrEqualTo(String value) {
            addCriterion("book_status >=", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusLessThan(String value) {
            addCriterion("book_status <", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusLessThanOrEqualTo(String value) {
            addCriterion("book_status <=", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusLike(String value) {
            addCriterion("book_status like", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusNotLike(String value) {
            addCriterion("book_status not like", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusIn(List<String> values) {
            addCriterion("book_status in", values, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusNotIn(List<String> values) {
            addCriterion("book_status not in", values, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusBetween(String value1, String value2) {
            addCriterion("book_status between", value1, value2, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusNotBetween(String value1, String value2) {
            addCriterion("book_status not between", value1, value2, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookCommentIsNull() {
            addCriterion("book_comment is null");
            return (Criteria) this;
        }

        public Criteria andBookCommentIsNotNull() {
            addCriterion("book_comment is not null");
            return (Criteria) this;
        }

        public Criteria andBookCommentEqualTo(String value) {
            addCriterion("book_comment =", value, "bookComment");
            return (Criteria) this;
        }

        public Criteria andBookCommentNotEqualTo(String value) {
            addCriterion("book_comment <>", value, "bookComment");
            return (Criteria) this;
        }

        public Criteria andBookCommentGreaterThan(String value) {
            addCriterion("book_comment >", value, "bookComment");
            return (Criteria) this;
        }

        public Criteria andBookCommentGreaterThanOrEqualTo(String value) {
            addCriterion("book_comment >=", value, "bookComment");
            return (Criteria) this;
        }

        public Criteria andBookCommentLessThan(String value) {
            addCriterion("book_comment <", value, "bookComment");
            return (Criteria) this;
        }

        public Criteria andBookCommentLessThanOrEqualTo(String value) {
            addCriterion("book_comment <=", value, "bookComment");
            return (Criteria) this;
        }

        public Criteria andBookCommentLike(String value) {
            addCriterion("book_comment like", value, "bookComment");
            return (Criteria) this;
        }

        public Criteria andBookCommentNotLike(String value) {
            addCriterion("book_comment not like", value, "bookComment");
            return (Criteria) this;
        }

        public Criteria andBookCommentIn(List<String> values) {
            addCriterion("book_comment in", values, "bookComment");
            return (Criteria) this;
        }

        public Criteria andBookCommentNotIn(List<String> values) {
            addCriterion("book_comment not in", values, "bookComment");
            return (Criteria) this;
        }

        public Criteria andBookCommentBetween(String value1, String value2) {
            addCriterion("book_comment between", value1, value2, "bookComment");
            return (Criteria) this;
        }

        public Criteria andBookCommentNotBetween(String value1, String value2) {
            addCriterion("book_comment not between", value1, value2, "bookComment");
            return (Criteria) this;
        }

        public Criteria andBookImageIsNull() {
            addCriterion("book_image is null");
            return (Criteria) this;
        }

        public Criteria andBookImageIsNotNull() {
            addCriterion("book_image is not null");
            return (Criteria) this;
        }

        public Criteria andBookImageEqualTo(String value) {
            addCriterion("book_image =", value, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageNotEqualTo(String value) {
            addCriterion("book_image <>", value, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageGreaterThan(String value) {
            addCriterion("book_image >", value, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageGreaterThanOrEqualTo(String value) {
            addCriterion("book_image >=", value, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageLessThan(String value) {
            addCriterion("book_image <", value, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageLessThanOrEqualTo(String value) {
            addCriterion("book_image <=", value, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageLike(String value) {
            addCriterion("book_image like", value, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageNotLike(String value) {
            addCriterion("book_image not like", value, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageIn(List<String> values) {
            addCriterion("book_image in", values, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageNotIn(List<String> values) {
            addCriterion("book_image not in", values, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageBetween(String value1, String value2) {
            addCriterion("book_image between", value1, value2, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageNotBetween(String value1, String value2) {
            addCriterion("book_image not between", value1, value2, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookLibraryIsNull() {
            addCriterion("book_library is null");
            return (Criteria) this;
        }

        public Criteria andBookLibraryIsNotNull() {
            addCriterion("book_library is not null");
            return (Criteria) this;
        }

        public Criteria andBookLibraryEqualTo(String value) {
            addCriterion("book_library =", value, "bookLibrary");
            return (Criteria) this;
        }

        public Criteria andBookLibraryNotEqualTo(String value) {
            addCriterion("book_library <>", value, "bookLibrary");
            return (Criteria) this;
        }

        public Criteria andBookLibraryGreaterThan(String value) {
            addCriterion("book_library >", value, "bookLibrary");
            return (Criteria) this;
        }

        public Criteria andBookLibraryGreaterThanOrEqualTo(String value) {
            addCriterion("book_library >=", value, "bookLibrary");
            return (Criteria) this;
        }

        public Criteria andBookLibraryLessThan(String value) {
            addCriterion("book_library <", value, "bookLibrary");
            return (Criteria) this;
        }

        public Criteria andBookLibraryLessThanOrEqualTo(String value) {
            addCriterion("book_library <=", value, "bookLibrary");
            return (Criteria) this;
        }

        public Criteria andBookLibraryLike(String value) {
            addCriterion("book_library like", value, "bookLibrary");
            return (Criteria) this;
        }

        public Criteria andBookLibraryNotLike(String value) {
            addCriterion("book_library not like", value, "bookLibrary");
            return (Criteria) this;
        }

        public Criteria andBookLibraryIn(List<String> values) {
            addCriterion("book_library in", values, "bookLibrary");
            return (Criteria) this;
        }

        public Criteria andBookLibraryNotIn(List<String> values) {
            addCriterion("book_library not in", values, "bookLibrary");
            return (Criteria) this;
        }

        public Criteria andBookLibraryBetween(String value1, String value2) {
            addCriterion("book_library between", value1, value2, "bookLibrary");
            return (Criteria) this;
        }

        public Criteria andBookLibraryNotBetween(String value1, String value2) {
            addCriterion("book_library not between", value1, value2, "bookLibrary");
            return (Criteria) this;
        }

        public Criteria andBookAccountIsNull() {
            addCriterion("book_account is null");
            return (Criteria) this;
        }

        public Criteria andBookAccountIsNotNull() {
            addCriterion("book_account is not null");
            return (Criteria) this;
        }

        public Criteria andBookAccountEqualTo(String value) {
            addCriterion("book_account =", value, "bookAccount");
            return (Criteria) this;
        }

        public Criteria andBookAccountNotEqualTo(String value) {
            addCriterion("book_account <>", value, "bookAccount");
            return (Criteria) this;
        }

        public Criteria andBookAccountGreaterThan(String value) {
            addCriterion("book_account >", value, "bookAccount");
            return (Criteria) this;
        }

        public Criteria andBookAccountGreaterThanOrEqualTo(String value) {
            addCriterion("book_account >=", value, "bookAccount");
            return (Criteria) this;
        }

        public Criteria andBookAccountLessThan(String value) {
            addCriterion("book_account <", value, "bookAccount");
            return (Criteria) this;
        }

        public Criteria andBookAccountLessThanOrEqualTo(String value) {
            addCriterion("book_account <=", value, "bookAccount");
            return (Criteria) this;
        }

        public Criteria andBookAccountLike(String value) {
            addCriterion("book_account like", value, "bookAccount");
            return (Criteria) this;
        }

        public Criteria andBookAccountNotLike(String value) {
            addCriterion("book_account not like", value, "bookAccount");
            return (Criteria) this;
        }

        public Criteria andBookAccountIn(List<String> values) {
            addCriterion("book_account in", values, "bookAccount");
            return (Criteria) this;
        }

        public Criteria andBookAccountNotIn(List<String> values) {
            addCriterion("book_account not in", values, "bookAccount");
            return (Criteria) this;
        }

        public Criteria andBookAccountBetween(String value1, String value2) {
            addCriterion("book_account between", value1, value2, "bookAccount");
            return (Criteria) this;
        }

        public Criteria andBookAccountNotBetween(String value1, String value2) {
            addCriterion("book_account not between", value1, value2, "bookAccount");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andExpress1IsNull() {
            addCriterion("express1 is null");
            return (Criteria) this;
        }

        public Criteria andExpress1IsNotNull() {
            addCriterion("express1 is not null");
            return (Criteria) this;
        }

        public Criteria andExpress1EqualTo(String value) {
            addCriterion("express1 =", value, "express1");
            return (Criteria) this;
        }

        public Criteria andExpress1NotEqualTo(String value) {
            addCriterion("express1 <>", value, "express1");
            return (Criteria) this;
        }

        public Criteria andExpress1GreaterThan(String value) {
            addCriterion("express1 >", value, "express1");
            return (Criteria) this;
        }

        public Criteria andExpress1GreaterThanOrEqualTo(String value) {
            addCriterion("express1 >=", value, "express1");
            return (Criteria) this;
        }

        public Criteria andExpress1LessThan(String value) {
            addCriterion("express1 <", value, "express1");
            return (Criteria) this;
        }

        public Criteria andExpress1LessThanOrEqualTo(String value) {
            addCriterion("express1 <=", value, "express1");
            return (Criteria) this;
        }

        public Criteria andExpress1Like(String value) {
            addCriterion("express1 like", value, "express1");
            return (Criteria) this;
        }

        public Criteria andExpress1NotLike(String value) {
            addCriterion("express1 not like", value, "express1");
            return (Criteria) this;
        }

        public Criteria andExpress1In(List<String> values) {
            addCriterion("express1 in", values, "express1");
            return (Criteria) this;
        }

        public Criteria andExpress1NotIn(List<String> values) {
            addCriterion("express1 not in", values, "express1");
            return (Criteria) this;
        }

        public Criteria andExpress1Between(String value1, String value2) {
            addCriterion("express1 between", value1, value2, "express1");
            return (Criteria) this;
        }

        public Criteria andExpress1NotBetween(String value1, String value2) {
            addCriterion("express1 not between", value1, value2, "express1");
            return (Criteria) this;
        }

        public Criteria andExpress2IsNull() {
            addCriterion("express2 is null");
            return (Criteria) this;
        }

        public Criteria andExpress2IsNotNull() {
            addCriterion("express2 is not null");
            return (Criteria) this;
        }

        public Criteria andExpress2EqualTo(String value) {
            addCriterion("express2 =", value, "express2");
            return (Criteria) this;
        }

        public Criteria andExpress2NotEqualTo(String value) {
            addCriterion("express2 <>", value, "express2");
            return (Criteria) this;
        }

        public Criteria andExpress2GreaterThan(String value) {
            addCriterion("express2 >", value, "express2");
            return (Criteria) this;
        }

        public Criteria andExpress2GreaterThanOrEqualTo(String value) {
            addCriterion("express2 >=", value, "express2");
            return (Criteria) this;
        }

        public Criteria andExpress2LessThan(String value) {
            addCriterion("express2 <", value, "express2");
            return (Criteria) this;
        }

        public Criteria andExpress2LessThanOrEqualTo(String value) {
            addCriterion("express2 <=", value, "express2");
            return (Criteria) this;
        }

        public Criteria andExpress2Like(String value) {
            addCriterion("express2 like", value, "express2");
            return (Criteria) this;
        }

        public Criteria andExpress2NotLike(String value) {
            addCriterion("express2 not like", value, "express2");
            return (Criteria) this;
        }

        public Criteria andExpress2In(List<String> values) {
            addCriterion("express2 in", values, "express2");
            return (Criteria) this;
        }

        public Criteria andExpress2NotIn(List<String> values) {
            addCriterion("express2 not in", values, "express2");
            return (Criteria) this;
        }

        public Criteria andExpress2Between(String value1, String value2) {
            addCriterion("express2 between", value1, value2, "express2");
            return (Criteria) this;
        }

        public Criteria andExpress2NotBetween(String value1, String value2) {
            addCriterion("express2 not between", value1, value2, "express2");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andBookNameLikeInsensitive(String value) {
            addCriterion("upper(book_name) like", value.toUpperCase(), "bookName");
            return this;
        }

        public Criteria andBookSeriesLikeInsensitive(String value) {
            addCriterion("upper(book_series) like", value.toUpperCase(), "bookSeries");
            return this;
        }

        public Criteria andBookAuthorLikeInsensitive(String value) {
            addCriterion("upper(book_author) like", value.toUpperCase(), "bookAuthor");
            return this;
        }

        public Criteria andBookTypeLikeInsensitive(String value) {
            addCriterion("upper(book_type) like", value.toUpperCase(), "bookType");
            return this;
        }

        public Criteria andBookAgeLikeInsensitive(String value) {
            addCriterion("upper(book_age) like", value.toUpperCase(), "bookAge");
            return this;
        }

        public Criteria andBookStatusLikeInsensitive(String value) {
            addCriterion("upper(book_status) like", value.toUpperCase(), "bookStatus");
            return this;
        }

        public Criteria andBookCommentLikeInsensitive(String value) {
            addCriterion("upper(book_comment) like", value.toUpperCase(), "bookComment");
            return this;
        }

        public Criteria andBookImageLikeInsensitive(String value) {
            addCriterion("upper(book_image) like", value.toUpperCase(), "bookImage");
            return this;
        }

        public Criteria andBookLibraryLikeInsensitive(String value) {
            addCriterion("upper(book_library) like", value.toUpperCase(), "bookLibrary");
            return this;
        }

        public Criteria andBookAccountLikeInsensitive(String value) {
            addCriterion("upper(book_account) like", value.toUpperCase(), "bookAccount");
            return this;
        }

        public Criteria andExpress1LikeInsensitive(String value) {
            addCriterion("upper(express1) like", value.toUpperCase(), "express1");
            return this;
        }

        public Criteria andExpress2LikeInsensitive(String value) {
            addCriterion("upper(express2) like", value.toUpperCase(), "express2");
            return this;
        }
    }
}
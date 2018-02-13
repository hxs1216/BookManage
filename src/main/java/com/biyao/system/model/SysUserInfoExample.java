package com.biyao.system.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SysUserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer mysqlOffset;

    private Integer mysqlLength;

    public SysUserInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected SysUserInfoExample(SysUserInfoExample example) {
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

        public Criteria andLibraryNameIsNull() {
            addCriterion("library_name is null");
            return (Criteria) this;
        }

        public Criteria andLibraryNameIsNotNull() {
            addCriterion("library_name is not null");
            return (Criteria) this;
        }

        public Criteria andLibraryNameEqualTo(String value) {
            addCriterion("library_name =", value, "libraryName");
            return (Criteria) this;
        }

        public Criteria andLibraryNameNotEqualTo(String value) {
            addCriterion("library_name <>", value, "libraryName");
            return (Criteria) this;
        }

        public Criteria andLibraryNameGreaterThan(String value) {
            addCriterion("library_name >", value, "libraryName");
            return (Criteria) this;
        }

        public Criteria andLibraryNameGreaterThanOrEqualTo(String value) {
            addCriterion("library_name >=", value, "libraryName");
            return (Criteria) this;
        }

        public Criteria andLibraryNameLessThan(String value) {
            addCriterion("library_name <", value, "libraryName");
            return (Criteria) this;
        }

        public Criteria andLibraryNameLessThanOrEqualTo(String value) {
            addCriterion("library_name <=", value, "libraryName");
            return (Criteria) this;
        }

        public Criteria andLibraryNameLike(String value) {
            addCriterion("library_name like", value, "libraryName");
            return (Criteria) this;
        }

        public Criteria andLibraryNameNotLike(String value) {
            addCriterion("library_name not like", value, "libraryName");
            return (Criteria) this;
        }

        public Criteria andLibraryNameIn(List<String> values) {
            addCriterion("library_name in", values, "libraryName");
            return (Criteria) this;
        }

        public Criteria andLibraryNameNotIn(List<String> values) {
            addCriterion("library_name not in", values, "libraryName");
            return (Criteria) this;
        }

        public Criteria andLibraryNameBetween(String value1, String value2) {
            addCriterion("library_name between", value1, value2, "libraryName");
            return (Criteria) this;
        }

        public Criteria andLibraryNameNotBetween(String value1, String value2) {
            addCriterion("library_name not between", value1, value2, "libraryName");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andLoginAccountIsNull() {
            addCriterion("login_account is null");
            return (Criteria) this;
        }

        public Criteria andLoginAccountIsNotNull() {
            addCriterion("login_account is not null");
            return (Criteria) this;
        }

        public Criteria andLoginAccountEqualTo(String value) {
            addCriterion("login_account =", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountNotEqualTo(String value) {
            addCriterion("login_account <>", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountGreaterThan(String value) {
            addCriterion("login_account >", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountGreaterThanOrEqualTo(String value) {
            addCriterion("login_account >=", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountLessThan(String value) {
            addCriterion("login_account <", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountLessThanOrEqualTo(String value) {
            addCriterion("login_account <=", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountLike(String value) {
            addCriterion("login_account like", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountNotLike(String value) {
            addCriterion("login_account not like", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountIn(List<String> values) {
            addCriterion("login_account in", values, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountNotIn(List<String> values) {
            addCriterion("login_account not in", values, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountBetween(String value1, String value2) {
            addCriterion("login_account between", value1, value2, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountNotBetween(String value1, String value2) {
            addCriterion("login_account not between", value1, value2, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andUserPwdIsNull() {
            addCriterion("user_pwd is null");
            return (Criteria) this;
        }

        public Criteria andUserPwdIsNotNull() {
            addCriterion("user_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andUserPwdEqualTo(String value) {
            addCriterion("user_pwd =", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotEqualTo(String value) {
            addCriterion("user_pwd <>", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThan(String value) {
            addCriterion("user_pwd >", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThanOrEqualTo(String value) {
            addCriterion("user_pwd >=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThan(String value) {
            addCriterion("user_pwd <", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThanOrEqualTo(String value) {
            addCriterion("user_pwd <=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLike(String value) {
            addCriterion("user_pwd like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotLike(String value) {
            addCriterion("user_pwd not like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdIn(List<String> values) {
            addCriterion("user_pwd in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotIn(List<String> values) {
            addCriterion("user_pwd not in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdBetween(String value1, String value2) {
            addCriterion("user_pwd between", value1, value2, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotBetween(String value1, String value2) {
            addCriterion("user_pwd not between", value1, value2, "userPwd");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andConnectPhoneIsNull() {
            addCriterion("connect_phone is null");
            return (Criteria) this;
        }

        public Criteria andConnectPhoneIsNotNull() {
            addCriterion("connect_phone is not null");
            return (Criteria) this;
        }

        public Criteria andConnectPhoneEqualTo(String value) {
            addCriterion("connect_phone =", value, "connectPhone");
            return (Criteria) this;
        }

        public Criteria andConnectPhoneNotEqualTo(String value) {
            addCriterion("connect_phone <>", value, "connectPhone");
            return (Criteria) this;
        }

        public Criteria andConnectPhoneGreaterThan(String value) {
            addCriterion("connect_phone >", value, "connectPhone");
            return (Criteria) this;
        }

        public Criteria andConnectPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("connect_phone >=", value, "connectPhone");
            return (Criteria) this;
        }

        public Criteria andConnectPhoneLessThan(String value) {
            addCriterion("connect_phone <", value, "connectPhone");
            return (Criteria) this;
        }

        public Criteria andConnectPhoneLessThanOrEqualTo(String value) {
            addCriterion("connect_phone <=", value, "connectPhone");
            return (Criteria) this;
        }

        public Criteria andConnectPhoneLike(String value) {
            addCriterion("connect_phone like", value, "connectPhone");
            return (Criteria) this;
        }

        public Criteria andConnectPhoneNotLike(String value) {
            addCriterion("connect_phone not like", value, "connectPhone");
            return (Criteria) this;
        }

        public Criteria andConnectPhoneIn(List<String> values) {
            addCriterion("connect_phone in", values, "connectPhone");
            return (Criteria) this;
        }

        public Criteria andConnectPhoneNotIn(List<String> values) {
            addCriterion("connect_phone not in", values, "connectPhone");
            return (Criteria) this;
        }

        public Criteria andConnectPhoneBetween(String value1, String value2) {
            addCriterion("connect_phone between", value1, value2, "connectPhone");
            return (Criteria) this;
        }

        public Criteria andConnectPhoneNotBetween(String value1, String value2) {
            addCriterion("connect_phone not between", value1, value2, "connectPhone");
            return (Criteria) this;
        }

        public Criteria andQqAccountIsNull() {
            addCriterion("qq_account is null");
            return (Criteria) this;
        }

        public Criteria andQqAccountIsNotNull() {
            addCriterion("qq_account is not null");
            return (Criteria) this;
        }

        public Criteria andQqAccountEqualTo(String value) {
            addCriterion("qq_account =", value, "qqAccount");
            return (Criteria) this;
        }

        public Criteria andQqAccountNotEqualTo(String value) {
            addCriterion("qq_account <>", value, "qqAccount");
            return (Criteria) this;
        }

        public Criteria andQqAccountGreaterThan(String value) {
            addCriterion("qq_account >", value, "qqAccount");
            return (Criteria) this;
        }

        public Criteria andQqAccountGreaterThanOrEqualTo(String value) {
            addCriterion("qq_account >=", value, "qqAccount");
            return (Criteria) this;
        }

        public Criteria andQqAccountLessThan(String value) {
            addCriterion("qq_account <", value, "qqAccount");
            return (Criteria) this;
        }

        public Criteria andQqAccountLessThanOrEqualTo(String value) {
            addCriterion("qq_account <=", value, "qqAccount");
            return (Criteria) this;
        }

        public Criteria andQqAccountLike(String value) {
            addCriterion("qq_account like", value, "qqAccount");
            return (Criteria) this;
        }

        public Criteria andQqAccountNotLike(String value) {
            addCriterion("qq_account not like", value, "qqAccount");
            return (Criteria) this;
        }

        public Criteria andQqAccountIn(List<String> values) {
            addCriterion("qq_account in", values, "qqAccount");
            return (Criteria) this;
        }

        public Criteria andQqAccountNotIn(List<String> values) {
            addCriterion("qq_account not in", values, "qqAccount");
            return (Criteria) this;
        }

        public Criteria andQqAccountBetween(String value1, String value2) {
            addCriterion("qq_account between", value1, value2, "qqAccount");
            return (Criteria) this;
        }

        public Criteria andQqAccountNotBetween(String value1, String value2) {
            addCriterion("qq_account not between", value1, value2, "qqAccount");
            return (Criteria) this;
        }

        public Criteria andWechatAccountIsNull() {
            addCriterion("wechat_account is null");
            return (Criteria) this;
        }

        public Criteria andWechatAccountIsNotNull() {
            addCriterion("wechat_account is not null");
            return (Criteria) this;
        }

        public Criteria andWechatAccountEqualTo(String value) {
            addCriterion("wechat_account =", value, "wechatAccount");
            return (Criteria) this;
        }

        public Criteria andWechatAccountNotEqualTo(String value) {
            addCriterion("wechat_account <>", value, "wechatAccount");
            return (Criteria) this;
        }

        public Criteria andWechatAccountGreaterThan(String value) {
            addCriterion("wechat_account >", value, "wechatAccount");
            return (Criteria) this;
        }

        public Criteria andWechatAccountGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_account >=", value, "wechatAccount");
            return (Criteria) this;
        }

        public Criteria andWechatAccountLessThan(String value) {
            addCriterion("wechat_account <", value, "wechatAccount");
            return (Criteria) this;
        }

        public Criteria andWechatAccountLessThanOrEqualTo(String value) {
            addCriterion("wechat_account <=", value, "wechatAccount");
            return (Criteria) this;
        }

        public Criteria andWechatAccountLike(String value) {
            addCriterion("wechat_account like", value, "wechatAccount");
            return (Criteria) this;
        }

        public Criteria andWechatAccountNotLike(String value) {
            addCriterion("wechat_account not like", value, "wechatAccount");
            return (Criteria) this;
        }

        public Criteria andWechatAccountIn(List<String> values) {
            addCriterion("wechat_account in", values, "wechatAccount");
            return (Criteria) this;
        }

        public Criteria andWechatAccountNotIn(List<String> values) {
            addCriterion("wechat_account not in", values, "wechatAccount");
            return (Criteria) this;
        }

        public Criteria andWechatAccountBetween(String value1, String value2) {
            addCriterion("wechat_account between", value1, value2, "wechatAccount");
            return (Criteria) this;
        }

        public Criteria andWechatAccountNotBetween(String value1, String value2) {
            addCriterion("wechat_account not between", value1, value2, "wechatAccount");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("nation is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("nation is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("nation =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("nation <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("nation >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("nation >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("nation <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("nation <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("nation like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("nation not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<String> values) {
            addCriterion("nation in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<String> values) {
            addCriterion("nation not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("nation between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("nation not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andWorkUnitIsNull() {
            addCriterion("work_unit is null");
            return (Criteria) this;
        }

        public Criteria andWorkUnitIsNotNull() {
            addCriterion("work_unit is not null");
            return (Criteria) this;
        }

        public Criteria andWorkUnitEqualTo(String value) {
            addCriterion("work_unit =", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitNotEqualTo(String value) {
            addCriterion("work_unit <>", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitGreaterThan(String value) {
            addCriterion("work_unit >", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitGreaterThanOrEqualTo(String value) {
            addCriterion("work_unit >=", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitLessThan(String value) {
            addCriterion("work_unit <", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitLessThanOrEqualTo(String value) {
            addCriterion("work_unit <=", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitLike(String value) {
            addCriterion("work_unit like", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitNotLike(String value) {
            addCriterion("work_unit not like", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitIn(List<String> values) {
            addCriterion("work_unit in", values, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitNotIn(List<String> values) {
            addCriterion("work_unit not in", values, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitBetween(String value1, String value2) {
            addCriterion("work_unit between", value1, value2, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitNotBetween(String value1, String value2) {
            addCriterion("work_unit not between", value1, value2, "workUnit");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(String value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(String value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(String value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(String value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(String value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(String value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLike(String value) {
            addCriterion("grade like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotLike(String value) {
            addCriterion("grade not like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<String> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<String> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(String value1, String value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(String value1, String value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andLibraryIntroduceIsNull() {
            addCriterion("library_introduce is null");
            return (Criteria) this;
        }

        public Criteria andLibraryIntroduceIsNotNull() {
            addCriterion("library_introduce is not null");
            return (Criteria) this;
        }

        public Criteria andLibraryIntroduceEqualTo(String value) {
            addCriterion("library_introduce =", value, "libraryIntroduce");
            return (Criteria) this;
        }

        public Criteria andLibraryIntroduceNotEqualTo(String value) {
            addCriterion("library_introduce <>", value, "libraryIntroduce");
            return (Criteria) this;
        }

        public Criteria andLibraryIntroduceGreaterThan(String value) {
            addCriterion("library_introduce >", value, "libraryIntroduce");
            return (Criteria) this;
        }

        public Criteria andLibraryIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("library_introduce >=", value, "libraryIntroduce");
            return (Criteria) this;
        }

        public Criteria andLibraryIntroduceLessThan(String value) {
            addCriterion("library_introduce <", value, "libraryIntroduce");
            return (Criteria) this;
        }

        public Criteria andLibraryIntroduceLessThanOrEqualTo(String value) {
            addCriterion("library_introduce <=", value, "libraryIntroduce");
            return (Criteria) this;
        }

        public Criteria andLibraryIntroduceLike(String value) {
            addCriterion("library_introduce like", value, "libraryIntroduce");
            return (Criteria) this;
        }

        public Criteria andLibraryIntroduceNotLike(String value) {
            addCriterion("library_introduce not like", value, "libraryIntroduce");
            return (Criteria) this;
        }

        public Criteria andLibraryIntroduceIn(List<String> values) {
            addCriterion("library_introduce in", values, "libraryIntroduce");
            return (Criteria) this;
        }

        public Criteria andLibraryIntroduceNotIn(List<String> values) {
            addCriterion("library_introduce not in", values, "libraryIntroduce");
            return (Criteria) this;
        }

        public Criteria andLibraryIntroduceBetween(String value1, String value2) {
            addCriterion("library_introduce between", value1, value2, "libraryIntroduce");
            return (Criteria) this;
        }

        public Criteria andLibraryIntroduceNotBetween(String value1, String value2) {
            addCriterion("library_introduce not between", value1, value2, "libraryIntroduce");
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

        public Criteria andExpress3IsNull() {
            addCriterion("express3 is null");
            return (Criteria) this;
        }

        public Criteria andExpress3IsNotNull() {
            addCriterion("express3 is not null");
            return (Criteria) this;
        }

        public Criteria andExpress3EqualTo(String value) {
            addCriterion("express3 =", value, "express3");
            return (Criteria) this;
        }

        public Criteria andExpress3NotEqualTo(String value) {
            addCriterion("express3 <>", value, "express3");
            return (Criteria) this;
        }

        public Criteria andExpress3GreaterThan(String value) {
            addCriterion("express3 >", value, "express3");
            return (Criteria) this;
        }

        public Criteria andExpress3GreaterThanOrEqualTo(String value) {
            addCriterion("express3 >=", value, "express3");
            return (Criteria) this;
        }

        public Criteria andExpress3LessThan(String value) {
            addCriterion("express3 <", value, "express3");
            return (Criteria) this;
        }

        public Criteria andExpress3LessThanOrEqualTo(String value) {
            addCriterion("express3 <=", value, "express3");
            return (Criteria) this;
        }

        public Criteria andExpress3Like(String value) {
            addCriterion("express3 like", value, "express3");
            return (Criteria) this;
        }

        public Criteria andExpress3NotLike(String value) {
            addCriterion("express3 not like", value, "express3");
            return (Criteria) this;
        }

        public Criteria andExpress3In(List<String> values) {
            addCriterion("express3 in", values, "express3");
            return (Criteria) this;
        }

        public Criteria andExpress3NotIn(List<String> values) {
            addCriterion("express3 not in", values, "express3");
            return (Criteria) this;
        }

        public Criteria andExpress3Between(String value1, String value2) {
            addCriterion("express3 between", value1, value2, "express3");
            return (Criteria) this;
        }

        public Criteria andExpress3NotBetween(String value1, String value2) {
            addCriterion("express3 not between", value1, value2, "express3");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andLibraryNameLikeInsensitive(String value) {
            addCriterion("upper(library_name) like", value.toUpperCase(), "libraryName");
            return this;
        }

        public Criteria andUserIdLikeInsensitive(String value) {
            addCriterion("upper(user_id) like", value.toUpperCase(), "userId");
            return this;
        }

        public Criteria andUserNameLikeInsensitive(String value) {
            addCriterion("upper(user_name) like", value.toUpperCase(), "userName");
            return this;
        }

        public Criteria andLoginAccountLikeInsensitive(String value) {
            addCriterion("upper(login_account) like", value.toUpperCase(), "loginAccount");
            return this;
        }

        public Criteria andUserPwdLikeInsensitive(String value) {
            addCriterion("upper(user_pwd) like", value.toUpperCase(), "userPwd");
            return this;
        }

        public Criteria andEmailLikeInsensitive(String value) {
            addCriterion("upper(email) like", value.toUpperCase(), "email");
            return this;
        }

        public Criteria andConnectPhoneLikeInsensitive(String value) {
            addCriterion("upper(connect_phone) like", value.toUpperCase(), "connectPhone");
            return this;
        }

        public Criteria andQqAccountLikeInsensitive(String value) {
            addCriterion("upper(qq_account) like", value.toUpperCase(), "qqAccount");
            return this;
        }

        public Criteria andWechatAccountLikeInsensitive(String value) {
            addCriterion("upper(wechat_account) like", value.toUpperCase(), "wechatAccount");
            return this;
        }

        public Criteria andNationLikeInsensitive(String value) {
            addCriterion("upper(nation) like", value.toUpperCase(), "nation");
            return this;
        }

        public Criteria andProvinceLikeInsensitive(String value) {
            addCriterion("upper(province) like", value.toUpperCase(), "province");
            return this;
        }

        public Criteria andCityLikeInsensitive(String value) {
            addCriterion("upper(city) like", value.toUpperCase(), "city");
            return this;
        }

        public Criteria andWorkUnitLikeInsensitive(String value) {
            addCriterion("upper(work_unit) like", value.toUpperCase(), "workUnit");
            return this;
        }

        public Criteria andGradeLikeInsensitive(String value) {
            addCriterion("upper(grade) like", value.toUpperCase(), "grade");
            return this;
        }

        public Criteria andLibraryIntroduceLikeInsensitive(String value) {
            addCriterion("upper(library_introduce) like", value.toUpperCase(), "libraryIntroduce");
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

        public Criteria andExpress3LikeInsensitive(String value) {
            addCriterion("upper(express3) like", value.toUpperCase(), "express3");
            return this;
        }
    }
}
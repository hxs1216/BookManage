package com.biyao.system.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SysDictionaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer mysqlOffset;

    private Integer mysqlLength;

    public SysDictionaryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected SysDictionaryExample(SysDictionaryExample example) {
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

        public Criteria andCfgTypeIsNull() {
            addCriterion("cfg_type is null");
            return (Criteria) this;
        }

        public Criteria andCfgTypeIsNotNull() {
            addCriterion("cfg_type is not null");
            return (Criteria) this;
        }

        public Criteria andCfgTypeEqualTo(String value) {
            addCriterion("cfg_type =", value, "cfgType");
            return (Criteria) this;
        }

        public Criteria andCfgTypeNotEqualTo(String value) {
            addCriterion("cfg_type <>", value, "cfgType");
            return (Criteria) this;
        }

        public Criteria andCfgTypeGreaterThan(String value) {
            addCriterion("cfg_type >", value, "cfgType");
            return (Criteria) this;
        }

        public Criteria andCfgTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cfg_type >=", value, "cfgType");
            return (Criteria) this;
        }

        public Criteria andCfgTypeLessThan(String value) {
            addCriterion("cfg_type <", value, "cfgType");
            return (Criteria) this;
        }

        public Criteria andCfgTypeLessThanOrEqualTo(String value) {
            addCriterion("cfg_type <=", value, "cfgType");
            return (Criteria) this;
        }

        public Criteria andCfgTypeLike(String value) {
            addCriterion("cfg_type like", value, "cfgType");
            return (Criteria) this;
        }

        public Criteria andCfgTypeNotLike(String value) {
            addCriterion("cfg_type not like", value, "cfgType");
            return (Criteria) this;
        }

        public Criteria andCfgTypeIn(List<String> values) {
            addCriterion("cfg_type in", values, "cfgType");
            return (Criteria) this;
        }

        public Criteria andCfgTypeNotIn(List<String> values) {
            addCriterion("cfg_type not in", values, "cfgType");
            return (Criteria) this;
        }

        public Criteria andCfgTypeBetween(String value1, String value2) {
            addCriterion("cfg_type between", value1, value2, "cfgType");
            return (Criteria) this;
        }

        public Criteria andCfgTypeNotBetween(String value1, String value2) {
            addCriterion("cfg_type not between", value1, value2, "cfgType");
            return (Criteria) this;
        }

        public Criteria andCfgValueIsNull() {
            addCriterion("cfg_value is null");
            return (Criteria) this;
        }

        public Criteria andCfgValueIsNotNull() {
            addCriterion("cfg_value is not null");
            return (Criteria) this;
        }

        public Criteria andCfgValueEqualTo(String value) {
            addCriterion("cfg_value =", value, "cfgValue");
            return (Criteria) this;
        }

        public Criteria andCfgValueNotEqualTo(String value) {
            addCriterion("cfg_value <>", value, "cfgValue");
            return (Criteria) this;
        }

        public Criteria andCfgValueGreaterThan(String value) {
            addCriterion("cfg_value >", value, "cfgValue");
            return (Criteria) this;
        }

        public Criteria andCfgValueGreaterThanOrEqualTo(String value) {
            addCriterion("cfg_value >=", value, "cfgValue");
            return (Criteria) this;
        }

        public Criteria andCfgValueLessThan(String value) {
            addCriterion("cfg_value <", value, "cfgValue");
            return (Criteria) this;
        }

        public Criteria andCfgValueLessThanOrEqualTo(String value) {
            addCriterion("cfg_value <=", value, "cfgValue");
            return (Criteria) this;
        }

        public Criteria andCfgValueLike(String value) {
            addCriterion("cfg_value like", value, "cfgValue");
            return (Criteria) this;
        }

        public Criteria andCfgValueNotLike(String value) {
            addCriterion("cfg_value not like", value, "cfgValue");
            return (Criteria) this;
        }

        public Criteria andCfgValueIn(List<String> values) {
            addCriterion("cfg_value in", values, "cfgValue");
            return (Criteria) this;
        }

        public Criteria andCfgValueNotIn(List<String> values) {
            addCriterion("cfg_value not in", values, "cfgValue");
            return (Criteria) this;
        }

        public Criteria andCfgValueBetween(String value1, String value2) {
            addCriterion("cfg_value between", value1, value2, "cfgValue");
            return (Criteria) this;
        }

        public Criteria andCfgValueNotBetween(String value1, String value2) {
            addCriterion("cfg_value not between", value1, value2, "cfgValue");
            return (Criteria) this;
        }

        public Criteria andCfgValueIdIsNull() {
            addCriterion("cfg_value_id is null");
            return (Criteria) this;
        }

        public Criteria andCfgValueIdIsNotNull() {
            addCriterion("cfg_value_id is not null");
            return (Criteria) this;
        }

        public Criteria andCfgValueIdEqualTo(String value) {
            addCriterion("cfg_value_id =", value, "cfgValueId");
            return (Criteria) this;
        }

        public Criteria andCfgValueIdNotEqualTo(String value) {
            addCriterion("cfg_value_id <>", value, "cfgValueId");
            return (Criteria) this;
        }

        public Criteria andCfgValueIdGreaterThan(String value) {
            addCriterion("cfg_value_id >", value, "cfgValueId");
            return (Criteria) this;
        }

        public Criteria andCfgValueIdGreaterThanOrEqualTo(String value) {
            addCriterion("cfg_value_id >=", value, "cfgValueId");
            return (Criteria) this;
        }

        public Criteria andCfgValueIdLessThan(String value) {
            addCriterion("cfg_value_id <", value, "cfgValueId");
            return (Criteria) this;
        }

        public Criteria andCfgValueIdLessThanOrEqualTo(String value) {
            addCriterion("cfg_value_id <=", value, "cfgValueId");
            return (Criteria) this;
        }

        public Criteria andCfgValueIdLike(String value) {
            addCriterion("cfg_value_id like", value, "cfgValueId");
            return (Criteria) this;
        }

        public Criteria andCfgValueIdNotLike(String value) {
            addCriterion("cfg_value_id not like", value, "cfgValueId");
            return (Criteria) this;
        }

        public Criteria andCfgValueIdIn(List<String> values) {
            addCriterion("cfg_value_id in", values, "cfgValueId");
            return (Criteria) this;
        }

        public Criteria andCfgValueIdNotIn(List<String> values) {
            addCriterion("cfg_value_id not in", values, "cfgValueId");
            return (Criteria) this;
        }

        public Criteria andCfgValueIdBetween(String value1, String value2) {
            addCriterion("cfg_value_id between", value1, value2, "cfgValueId");
            return (Criteria) this;
        }

        public Criteria andCfgValueIdNotBetween(String value1, String value2) {
            addCriterion("cfg_value_id not between", value1, value2, "cfgValueId");
            return (Criteria) this;
        }

        public Criteria andParentIsNull() {
            addCriterion("parent is null");
            return (Criteria) this;
        }

        public Criteria andParentIsNotNull() {
            addCriterion("parent is not null");
            return (Criteria) this;
        }

        public Criteria andParentEqualTo(Integer value) {
            addCriterion("parent =", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentNotEqualTo(Integer value) {
            addCriterion("parent <>", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentGreaterThan(Integer value) {
            addCriterion("parent >", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent >=", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentLessThan(Integer value) {
            addCriterion("parent <", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentLessThanOrEqualTo(Integer value) {
            addCriterion("parent <=", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentIn(List<Integer> values) {
            addCriterion("parent in", values, "parent");
            return (Criteria) this;
        }

        public Criteria andParentNotIn(List<Integer> values) {
            addCriterion("parent not in", values, "parent");
            return (Criteria) this;
        }

        public Criteria andParentBetween(Integer value1, Integer value2) {
            addCriterion("parent between", value1, value2, "parent");
            return (Criteria) this;
        }

        public Criteria andParentNotBetween(Integer value1, Integer value2) {
            addCriterion("parent not between", value1, value2, "parent");
            return (Criteria) this;
        }

        public Criteria andEnableIsNull() {
            addCriterion("enable is null");
            return (Criteria) this;
        }

        public Criteria andEnableIsNotNull() {
            addCriterion("enable is not null");
            return (Criteria) this;
        }

        public Criteria andEnableEqualTo(Integer value) {
            addCriterion("enable =", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotEqualTo(Integer value) {
            addCriterion("enable <>", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThan(Integer value) {
            addCriterion("enable >", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanOrEqualTo(Integer value) {
            addCriterion("enable >=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThan(Integer value) {
            addCriterion("enable <", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThanOrEqualTo(Integer value) {
            addCriterion("enable <=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableIn(List<Integer> values) {
            addCriterion("enable in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotIn(List<Integer> values) {
            addCriterion("enable not in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableBetween(Integer value1, Integer value2) {
            addCriterion("enable between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotBetween(Integer value1, Integer value2) {
            addCriterion("enable not between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(Integer value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(Integer value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(Integer value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(Integer value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(Integer value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<Integer> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<Integer> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(Integer value1, Integer value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("priority not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andIsEditIsNull() {
            addCriterion("is_edit is null");
            return (Criteria) this;
        }

        public Criteria andIsEditIsNotNull() {
            addCriterion("is_edit is not null");
            return (Criteria) this;
        }

        public Criteria andIsEditEqualTo(Integer value) {
            addCriterion("is_edit =", value, "isEdit");
            return (Criteria) this;
        }

        public Criteria andIsEditNotEqualTo(Integer value) {
            addCriterion("is_edit <>", value, "isEdit");
            return (Criteria) this;
        }

        public Criteria andIsEditGreaterThan(Integer value) {
            addCriterion("is_edit >", value, "isEdit");
            return (Criteria) this;
        }

        public Criteria andIsEditGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_edit >=", value, "isEdit");
            return (Criteria) this;
        }

        public Criteria andIsEditLessThan(Integer value) {
            addCriterion("is_edit <", value, "isEdit");
            return (Criteria) this;
        }

        public Criteria andIsEditLessThanOrEqualTo(Integer value) {
            addCriterion("is_edit <=", value, "isEdit");
            return (Criteria) this;
        }

        public Criteria andIsEditIn(List<Integer> values) {
            addCriterion("is_edit in", values, "isEdit");
            return (Criteria) this;
        }

        public Criteria andIsEditNotIn(List<Integer> values) {
            addCriterion("is_edit not in", values, "isEdit");
            return (Criteria) this;
        }

        public Criteria andIsEditBetween(Integer value1, Integer value2) {
            addCriterion("is_edit between", value1, value2, "isEdit");
            return (Criteria) this;
        }

        public Criteria andIsEditNotBetween(Integer value1, Integer value2) {
            addCriterion("is_edit not between", value1, value2, "isEdit");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNull() {
            addCriterion("system_id is null");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNotNull() {
            addCriterion("system_id is not null");
            return (Criteria) this;
        }

        public Criteria andSystemIdEqualTo(String value) {
            addCriterion("system_id =", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotEqualTo(String value) {
            addCriterion("system_id <>", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThan(String value) {
            addCriterion("system_id >", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThanOrEqualTo(String value) {
            addCriterion("system_id >=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThan(String value) {
            addCriterion("system_id <", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThanOrEqualTo(String value) {
            addCriterion("system_id <=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLike(String value) {
            addCriterion("system_id like", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotLike(String value) {
            addCriterion("system_id not like", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdIn(List<String> values) {
            addCriterion("system_id in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotIn(List<String> values) {
            addCriterion("system_id not in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdBetween(String value1, String value2) {
            addCriterion("system_id between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotBetween(String value1, String value2) {
            addCriterion("system_id not between", value1, value2, "systemId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andCfgTypeLikeInsensitive(String value) {
            addCriterion("upper(cfg_type) like", value.toUpperCase(), "cfgType");
            return this;
        }

        public Criteria andCfgValueLikeInsensitive(String value) {
            addCriterion("upper(cfg_value) like", value.toUpperCase(), "cfgValue");
            return this;
        }

        public Criteria andCfgValueIdLikeInsensitive(String value) {
            addCriterion("upper(cfg_value_id) like", value.toUpperCase(), "cfgValueId");
            return this;
        }

        public Criteria andSystemIdLikeInsensitive(String value) {
            addCriterion("upper(system_id) like", value.toUpperCase(), "systemId");
            return this;
        }
    }
}
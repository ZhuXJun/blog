package com.zxj.blog.entity.zxjdb;

import java.util.ArrayList;
import java.util.List;

public class SingleTableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SingleTableExample() {
        oredCriteria = new ArrayList<>();
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

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
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

        public Criteria andKey1IsNull() {
            addCriterion("key1 is null");
            return (Criteria) this;
        }

        public Criteria andKey1IsNotNull() {
            addCriterion("key1 is not null");
            return (Criteria) this;
        }

        public Criteria andKey1EqualTo(String value) {
            addCriterion("key1 =", value, "key1");
            return (Criteria) this;
        }

        public Criteria andKey1NotEqualTo(String value) {
            addCriterion("key1 <>", value, "key1");
            return (Criteria) this;
        }

        public Criteria andKey1GreaterThan(String value) {
            addCriterion("key1 >", value, "key1");
            return (Criteria) this;
        }

        public Criteria andKey1GreaterThanOrEqualTo(String value) {
            addCriterion("key1 >=", value, "key1");
            return (Criteria) this;
        }

        public Criteria andKey1LessThan(String value) {
            addCriterion("key1 <", value, "key1");
            return (Criteria) this;
        }

        public Criteria andKey1LessThanOrEqualTo(String value) {
            addCriterion("key1 <=", value, "key1");
            return (Criteria) this;
        }

        public Criteria andKey1Like(String value) {
            addCriterion("key1 like", value, "key1");
            return (Criteria) this;
        }

        public Criteria andKey1NotLike(String value) {
            addCriterion("key1 not like", value, "key1");
            return (Criteria) this;
        }

        public Criteria andKey1In(List<String> values) {
            addCriterion("key1 in", values, "key1");
            return (Criteria) this;
        }

        public Criteria andKey1NotIn(List<String> values) {
            addCriterion("key1 not in", values, "key1");
            return (Criteria) this;
        }

        public Criteria andKey1Between(String value1, String value2) {
            addCriterion("key1 between", value1, value2, "key1");
            return (Criteria) this;
        }

        public Criteria andKey1NotBetween(String value1, String value2) {
            addCriterion("key1 not between", value1, value2, "key1");
            return (Criteria) this;
        }

        public Criteria andKey2IsNull() {
            addCriterion("key2 is null");
            return (Criteria) this;
        }

        public Criteria andKey2IsNotNull() {
            addCriterion("key2 is not null");
            return (Criteria) this;
        }

        public Criteria andKey2EqualTo(Integer value) {
            addCriterion("key2 =", value, "key2");
            return (Criteria) this;
        }

        public Criteria andKey2NotEqualTo(Integer value) {
            addCriterion("key2 <>", value, "key2");
            return (Criteria) this;
        }

        public Criteria andKey2GreaterThan(Integer value) {
            addCriterion("key2 >", value, "key2");
            return (Criteria) this;
        }

        public Criteria andKey2GreaterThanOrEqualTo(Integer value) {
            addCriterion("key2 >=", value, "key2");
            return (Criteria) this;
        }

        public Criteria andKey2LessThan(Integer value) {
            addCriterion("key2 <", value, "key2");
            return (Criteria) this;
        }

        public Criteria andKey2LessThanOrEqualTo(Integer value) {
            addCriterion("key2 <=", value, "key2");
            return (Criteria) this;
        }

        public Criteria andKey2In(List<Integer> values) {
            addCriterion("key2 in", values, "key2");
            return (Criteria) this;
        }

        public Criteria andKey2NotIn(List<Integer> values) {
            addCriterion("key2 not in", values, "key2");
            return (Criteria) this;
        }

        public Criteria andKey2Between(Integer value1, Integer value2) {
            addCriterion("key2 between", value1, value2, "key2");
            return (Criteria) this;
        }

        public Criteria andKey2NotBetween(Integer value1, Integer value2) {
            addCriterion("key2 not between", value1, value2, "key2");
            return (Criteria) this;
        }

        public Criteria andKey3IsNull() {
            addCriterion("key3 is null");
            return (Criteria) this;
        }

        public Criteria andKey3IsNotNull() {
            addCriterion("key3 is not null");
            return (Criteria) this;
        }

        public Criteria andKey3EqualTo(String value) {
            addCriterion("key3 =", value, "key3");
            return (Criteria) this;
        }

        public Criteria andKey3NotEqualTo(String value) {
            addCriterion("key3 <>", value, "key3");
            return (Criteria) this;
        }

        public Criteria andKey3GreaterThan(String value) {
            addCriterion("key3 >", value, "key3");
            return (Criteria) this;
        }

        public Criteria andKey3GreaterThanOrEqualTo(String value) {
            addCriterion("key3 >=", value, "key3");
            return (Criteria) this;
        }

        public Criteria andKey3LessThan(String value) {
            addCriterion("key3 <", value, "key3");
            return (Criteria) this;
        }

        public Criteria andKey3LessThanOrEqualTo(String value) {
            addCriterion("key3 <=", value, "key3");
            return (Criteria) this;
        }

        public Criteria andKey3Like(String value) {
            addCriterion("key3 like", value, "key3");
            return (Criteria) this;
        }

        public Criteria andKey3NotLike(String value) {
            addCriterion("key3 not like", value, "key3");
            return (Criteria) this;
        }

        public Criteria andKey3In(List<String> values) {
            addCriterion("key3 in", values, "key3");
            return (Criteria) this;
        }

        public Criteria andKey3NotIn(List<String> values) {
            addCriterion("key3 not in", values, "key3");
            return (Criteria) this;
        }

        public Criteria andKey3Between(String value1, String value2) {
            addCriterion("key3 between", value1, value2, "key3");
            return (Criteria) this;
        }

        public Criteria andKey3NotBetween(String value1, String value2) {
            addCriterion("key3 not between", value1, value2, "key3");
            return (Criteria) this;
        }

        public Criteria andKeyPart1IsNull() {
            addCriterion("key_part1 is null");
            return (Criteria) this;
        }

        public Criteria andKeyPart1IsNotNull() {
            addCriterion("key_part1 is not null");
            return (Criteria) this;
        }

        public Criteria andKeyPart1EqualTo(String value) {
            addCriterion("key_part1 =", value, "keyPart1");
            return (Criteria) this;
        }

        public Criteria andKeyPart1NotEqualTo(String value) {
            addCriterion("key_part1 <>", value, "keyPart1");
            return (Criteria) this;
        }

        public Criteria andKeyPart1GreaterThan(String value) {
            addCriterion("key_part1 >", value, "keyPart1");
            return (Criteria) this;
        }

        public Criteria andKeyPart1GreaterThanOrEqualTo(String value) {
            addCriterion("key_part1 >=", value, "keyPart1");
            return (Criteria) this;
        }

        public Criteria andKeyPart1LessThan(String value) {
            addCriterion("key_part1 <", value, "keyPart1");
            return (Criteria) this;
        }

        public Criteria andKeyPart1LessThanOrEqualTo(String value) {
            addCriterion("key_part1 <=", value, "keyPart1");
            return (Criteria) this;
        }

        public Criteria andKeyPart1Like(String value) {
            addCriterion("key_part1 like", value, "keyPart1");
            return (Criteria) this;
        }

        public Criteria andKeyPart1NotLike(String value) {
            addCriterion("key_part1 not like", value, "keyPart1");
            return (Criteria) this;
        }

        public Criteria andKeyPart1In(List<String> values) {
            addCriterion("key_part1 in", values, "keyPart1");
            return (Criteria) this;
        }

        public Criteria andKeyPart1NotIn(List<String> values) {
            addCriterion("key_part1 not in", values, "keyPart1");
            return (Criteria) this;
        }

        public Criteria andKeyPart1Between(String value1, String value2) {
            addCriterion("key_part1 between", value1, value2, "keyPart1");
            return (Criteria) this;
        }

        public Criteria andKeyPart1NotBetween(String value1, String value2) {
            addCriterion("key_part1 not between", value1, value2, "keyPart1");
            return (Criteria) this;
        }

        public Criteria andKeyPart2IsNull() {
            addCriterion("key_part2 is null");
            return (Criteria) this;
        }

        public Criteria andKeyPart2IsNotNull() {
            addCriterion("key_part2 is not null");
            return (Criteria) this;
        }

        public Criteria andKeyPart2EqualTo(String value) {
            addCriterion("key_part2 =", value, "keyPart2");
            return (Criteria) this;
        }

        public Criteria andKeyPart2NotEqualTo(String value) {
            addCriterion("key_part2 <>", value, "keyPart2");
            return (Criteria) this;
        }

        public Criteria andKeyPart2GreaterThan(String value) {
            addCriterion("key_part2 >", value, "keyPart2");
            return (Criteria) this;
        }

        public Criteria andKeyPart2GreaterThanOrEqualTo(String value) {
            addCriterion("key_part2 >=", value, "keyPart2");
            return (Criteria) this;
        }

        public Criteria andKeyPart2LessThan(String value) {
            addCriterion("key_part2 <", value, "keyPart2");
            return (Criteria) this;
        }

        public Criteria andKeyPart2LessThanOrEqualTo(String value) {
            addCriterion("key_part2 <=", value, "keyPart2");
            return (Criteria) this;
        }

        public Criteria andKeyPart2Like(String value) {
            addCriterion("key_part2 like", value, "keyPart2");
            return (Criteria) this;
        }

        public Criteria andKeyPart2NotLike(String value) {
            addCriterion("key_part2 not like", value, "keyPart2");
            return (Criteria) this;
        }

        public Criteria andKeyPart2In(List<String> values) {
            addCriterion("key_part2 in", values, "keyPart2");
            return (Criteria) this;
        }

        public Criteria andKeyPart2NotIn(List<String> values) {
            addCriterion("key_part2 not in", values, "keyPart2");
            return (Criteria) this;
        }

        public Criteria andKeyPart2Between(String value1, String value2) {
            addCriterion("key_part2 between", value1, value2, "keyPart2");
            return (Criteria) this;
        }

        public Criteria andKeyPart2NotBetween(String value1, String value2) {
            addCriterion("key_part2 not between", value1, value2, "keyPart2");
            return (Criteria) this;
        }

        public Criteria andKeyPart3IsNull() {
            addCriterion("key_part3 is null");
            return (Criteria) this;
        }

        public Criteria andKeyPart3IsNotNull() {
            addCriterion("key_part3 is not null");
            return (Criteria) this;
        }

        public Criteria andKeyPart3EqualTo(String value) {
            addCriterion("key_part3 =", value, "keyPart3");
            return (Criteria) this;
        }

        public Criteria andKeyPart3NotEqualTo(String value) {
            addCriterion("key_part3 <>", value, "keyPart3");
            return (Criteria) this;
        }

        public Criteria andKeyPart3GreaterThan(String value) {
            addCriterion("key_part3 >", value, "keyPart3");
            return (Criteria) this;
        }

        public Criteria andKeyPart3GreaterThanOrEqualTo(String value) {
            addCriterion("key_part3 >=", value, "keyPart3");
            return (Criteria) this;
        }

        public Criteria andKeyPart3LessThan(String value) {
            addCriterion("key_part3 <", value, "keyPart3");
            return (Criteria) this;
        }

        public Criteria andKeyPart3LessThanOrEqualTo(String value) {
            addCriterion("key_part3 <=", value, "keyPart3");
            return (Criteria) this;
        }

        public Criteria andKeyPart3Like(String value) {
            addCriterion("key_part3 like", value, "keyPart3");
            return (Criteria) this;
        }

        public Criteria andKeyPart3NotLike(String value) {
            addCriterion("key_part3 not like", value, "keyPart3");
            return (Criteria) this;
        }

        public Criteria andKeyPart3In(List<String> values) {
            addCriterion("key_part3 in", values, "keyPart3");
            return (Criteria) this;
        }

        public Criteria andKeyPart3NotIn(List<String> values) {
            addCriterion("key_part3 not in", values, "keyPart3");
            return (Criteria) this;
        }

        public Criteria andKeyPart3Between(String value1, String value2) {
            addCriterion("key_part3 between", value1, value2, "keyPart3");
            return (Criteria) this;
        }

        public Criteria andKeyPart3NotBetween(String value1, String value2) {
            addCriterion("key_part3 not between", value1, value2, "keyPart3");
            return (Criteria) this;
        }

        public Criteria andCommonFieldIsNull() {
            addCriterion("common_field is null");
            return (Criteria) this;
        }

        public Criteria andCommonFieldIsNotNull() {
            addCriterion("common_field is not null");
            return (Criteria) this;
        }

        public Criteria andCommonFieldEqualTo(String value) {
            addCriterion("common_field =", value, "commonField");
            return (Criteria) this;
        }

        public Criteria andCommonFieldNotEqualTo(String value) {
            addCriterion("common_field <>", value, "commonField");
            return (Criteria) this;
        }

        public Criteria andCommonFieldGreaterThan(String value) {
            addCriterion("common_field >", value, "commonField");
            return (Criteria) this;
        }

        public Criteria andCommonFieldGreaterThanOrEqualTo(String value) {
            addCriterion("common_field >=", value, "commonField");
            return (Criteria) this;
        }

        public Criteria andCommonFieldLessThan(String value) {
            addCriterion("common_field <", value, "commonField");
            return (Criteria) this;
        }

        public Criteria andCommonFieldLessThanOrEqualTo(String value) {
            addCriterion("common_field <=", value, "commonField");
            return (Criteria) this;
        }

        public Criteria andCommonFieldLike(String value) {
            addCriterion("common_field like", value, "commonField");
            return (Criteria) this;
        }

        public Criteria andCommonFieldNotLike(String value) {
            addCriterion("common_field not like", value, "commonField");
            return (Criteria) this;
        }

        public Criteria andCommonFieldIn(List<String> values) {
            addCriterion("common_field in", values, "commonField");
            return (Criteria) this;
        }

        public Criteria andCommonFieldNotIn(List<String> values) {
            addCriterion("common_field not in", values, "commonField");
            return (Criteria) this;
        }

        public Criteria andCommonFieldBetween(String value1, String value2) {
            addCriterion("common_field between", value1, value2, "commonField");
            return (Criteria) this;
        }

        public Criteria andCommonFieldNotBetween(String value1, String value2) {
            addCriterion("common_field not between", value1, value2, "commonField");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
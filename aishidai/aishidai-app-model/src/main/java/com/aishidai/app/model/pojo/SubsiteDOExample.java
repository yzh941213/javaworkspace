package com.aishidai.app.model.pojo;

import java.util.ArrayList;
import java.util.List;

public class SubsiteDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubsiteDOExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andSubIdIsNull() {
            addCriterion("sub_id is null");
            return (Criteria) this;
        }

        public Criteria andSubIdIsNotNull() {
            addCriterion("sub_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubIdEqualTo(Long value) {
            addCriterion("sub_id =", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotEqualTo(Long value) {
            addCriterion("sub_id <>", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdGreaterThan(Long value) {
            addCriterion("sub_id >", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sub_id >=", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdLessThan(Long value) {
            addCriterion("sub_id <", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdLessThanOrEqualTo(Long value) {
            addCriterion("sub_id <=", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdIn(List<Long> values) {
            addCriterion("sub_id in", values, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotIn(List<Long> values) {
            addCriterion("sub_id not in", values, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdBetween(Long value1, Long value2) {
            addCriterion("sub_id between", value1, value2, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotBetween(Long value1, Long value2) {
            addCriterion("sub_id not between", value1, value2, "subId");
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

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andSubNumberIsNull() {
            addCriterion("sub_number is null");
            return (Criteria) this;
        }

        public Criteria andSubNumberIsNotNull() {
            addCriterion("sub_number is not null");
            return (Criteria) this;
        }

        public Criteria andSubNumberEqualTo(String value) {
            addCriterion("sub_number =", value, "subNumber");
            return (Criteria) this;
        }

        public Criteria andSubNumberNotEqualTo(String value) {
            addCriterion("sub_number <>", value, "subNumber");
            return (Criteria) this;
        }

        public Criteria andSubNumberGreaterThan(String value) {
            addCriterion("sub_number >", value, "subNumber");
            return (Criteria) this;
        }

        public Criteria andSubNumberGreaterThanOrEqualTo(String value) {
            addCriterion("sub_number >=", value, "subNumber");
            return (Criteria) this;
        }

        public Criteria andSubNumberLessThan(String value) {
            addCriterion("sub_number <", value, "subNumber");
            return (Criteria) this;
        }

        public Criteria andSubNumberLessThanOrEqualTo(String value) {
            addCriterion("sub_number <=", value, "subNumber");
            return (Criteria) this;
        }

        public Criteria andSubNumberLike(String value) {
            addCriterion("sub_number like", value, "subNumber");
            return (Criteria) this;
        }

        public Criteria andSubNumberNotLike(String value) {
            addCriterion("sub_number not like", value, "subNumber");
            return (Criteria) this;
        }

        public Criteria andSubNumberIn(List<String> values) {
            addCriterion("sub_number in", values, "subNumber");
            return (Criteria) this;
        }

        public Criteria andSubNumberNotIn(List<String> values) {
            addCriterion("sub_number not in", values, "subNumber");
            return (Criteria) this;
        }

        public Criteria andSubNumberBetween(String value1, String value2) {
            addCriterion("sub_number between", value1, value2, "subNumber");
            return (Criteria) this;
        }

        public Criteria andSubNumberNotBetween(String value1, String value2) {
            addCriterion("sub_number not between", value1, value2, "subNumber");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Integer value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Integer value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Integer value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Integer value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Integer value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Integer value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Integer> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Integer> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Integer value1, Integer value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Integer value1, Integer value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNull() {
            addCriterion("updated is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("updated is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(Integer value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Integer value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Integer value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Integer value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Integer value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Integer value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Integer> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Integer> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Integer value1, Integer value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Integer value1, Integer value2) {
            addCriterion("updated not between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andSubTypeIsNull() {
            addCriterion("sub_type is null");
            return (Criteria) this;
        }

        public Criteria andSubTypeIsNotNull() {
            addCriterion("sub_type is not null");
            return (Criteria) this;
        }

        public Criteria andSubTypeEqualTo(String value) {
            addCriterion("sub_type =", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeNotEqualTo(String value) {
            addCriterion("sub_type <>", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeGreaterThan(String value) {
            addCriterion("sub_type >", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sub_type >=", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeLessThan(String value) {
            addCriterion("sub_type <", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeLessThanOrEqualTo(String value) {
            addCriterion("sub_type <=", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeLike(String value) {
            addCriterion("sub_type like", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeNotLike(String value) {
            addCriterion("sub_type not like", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeIn(List<String> values) {
            addCriterion("sub_type in", values, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeNotIn(List<String> values) {
            addCriterion("sub_type not in", values, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeBetween(String value1, String value2) {
            addCriterion("sub_type between", value1, value2, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeNotBetween(String value1, String value2) {
            addCriterion("sub_type not between", value1, value2, "subType");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andExpirationStartIsNull() {
            addCriterion("expiration_start is null");
            return (Criteria) this;
        }

        public Criteria andExpirationStartIsNotNull() {
            addCriterion("expiration_start is not null");
            return (Criteria) this;
        }

        public Criteria andExpirationStartEqualTo(String value) {
            addCriterion("expiration_start =", value, "expirationStart");
            return (Criteria) this;
        }

        public Criteria andExpirationStartNotEqualTo(String value) {
            addCriterion("expiration_start <>", value, "expirationStart");
            return (Criteria) this;
        }

        public Criteria andExpirationStartGreaterThan(String value) {
            addCriterion("expiration_start >", value, "expirationStart");
            return (Criteria) this;
        }

        public Criteria andExpirationStartGreaterThanOrEqualTo(String value) {
            addCriterion("expiration_start >=", value, "expirationStart");
            return (Criteria) this;
        }

        public Criteria andExpirationStartLessThan(String value) {
            addCriterion("expiration_start <", value, "expirationStart");
            return (Criteria) this;
        }

        public Criteria andExpirationStartLessThanOrEqualTo(String value) {
            addCriterion("expiration_start <=", value, "expirationStart");
            return (Criteria) this;
        }

        public Criteria andExpirationStartLike(String value) {
            addCriterion("expiration_start like", value, "expirationStart");
            return (Criteria) this;
        }

        public Criteria andExpirationStartNotLike(String value) {
            addCriterion("expiration_start not like", value, "expirationStart");
            return (Criteria) this;
        }

        public Criteria andExpirationStartIn(List<String> values) {
            addCriterion("expiration_start in", values, "expirationStart");
            return (Criteria) this;
        }

        public Criteria andExpirationStartNotIn(List<String> values) {
            addCriterion("expiration_start not in", values, "expirationStart");
            return (Criteria) this;
        }

        public Criteria andExpirationStartBetween(String value1, String value2) {
            addCriterion("expiration_start between", value1, value2, "expirationStart");
            return (Criteria) this;
        }

        public Criteria andExpirationStartNotBetween(String value1, String value2) {
            addCriterion("expiration_start not between", value1, value2, "expirationStart");
            return (Criteria) this;
        }

        public Criteria andExpirationEndIsNull() {
            addCriterion("expiration_end is null");
            return (Criteria) this;
        }

        public Criteria andExpirationEndIsNotNull() {
            addCriterion("expiration_end is not null");
            return (Criteria) this;
        }

        public Criteria andExpirationEndEqualTo(String value) {
            addCriterion("expiration_end =", value, "expirationEnd");
            return (Criteria) this;
        }

        public Criteria andExpirationEndNotEqualTo(String value) {
            addCriterion("expiration_end <>", value, "expirationEnd");
            return (Criteria) this;
        }

        public Criteria andExpirationEndGreaterThan(String value) {
            addCriterion("expiration_end >", value, "expirationEnd");
            return (Criteria) this;
        }

        public Criteria andExpirationEndGreaterThanOrEqualTo(String value) {
            addCriterion("expiration_end >=", value, "expirationEnd");
            return (Criteria) this;
        }

        public Criteria andExpirationEndLessThan(String value) {
            addCriterion("expiration_end <", value, "expirationEnd");
            return (Criteria) this;
        }

        public Criteria andExpirationEndLessThanOrEqualTo(String value) {
            addCriterion("expiration_end <=", value, "expirationEnd");
            return (Criteria) this;
        }

        public Criteria andExpirationEndLike(String value) {
            addCriterion("expiration_end like", value, "expirationEnd");
            return (Criteria) this;
        }

        public Criteria andExpirationEndNotLike(String value) {
            addCriterion("expiration_end not like", value, "expirationEnd");
            return (Criteria) this;
        }

        public Criteria andExpirationEndIn(List<String> values) {
            addCriterion("expiration_end in", values, "expirationEnd");
            return (Criteria) this;
        }

        public Criteria andExpirationEndNotIn(List<String> values) {
            addCriterion("expiration_end not in", values, "expirationEnd");
            return (Criteria) this;
        }

        public Criteria andExpirationEndBetween(String value1, String value2) {
            addCriterion("expiration_end between", value1, value2, "expirationEnd");
            return (Criteria) this;
        }

        public Criteria andExpirationEndNotBetween(String value1, String value2) {
            addCriterion("expiration_end not between", value1, value2, "expirationEnd");
            return (Criteria) this;
        }

        public Criteria andShopsIdIsNull() {
            addCriterion("shops_id is null");
            return (Criteria) this;
        }

        public Criteria andShopsIdIsNotNull() {
            addCriterion("shops_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopsIdEqualTo(Long value) {
            addCriterion("shops_id =", value, "shopsId");
            return (Criteria) this;
        }

        public Criteria andShopsIdNotEqualTo(Long value) {
            addCriterion("shops_id <>", value, "shopsId");
            return (Criteria) this;
        }

        public Criteria andShopsIdGreaterThan(Long value) {
            addCriterion("shops_id >", value, "shopsId");
            return (Criteria) this;
        }

        public Criteria andShopsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("shops_id >=", value, "shopsId");
            return (Criteria) this;
        }

        public Criteria andShopsIdLessThan(Long value) {
            addCriterion("shops_id <", value, "shopsId");
            return (Criteria) this;
        }

        public Criteria andShopsIdLessThanOrEqualTo(Long value) {
            addCriterion("shops_id <=", value, "shopsId");
            return (Criteria) this;
        }

        public Criteria andShopsIdIn(List<Long> values) {
            addCriterion("shops_id in", values, "shopsId");
            return (Criteria) this;
        }

        public Criteria andShopsIdNotIn(List<Long> values) {
            addCriterion("shops_id not in", values, "shopsId");
            return (Criteria) this;
        }

        public Criteria andShopsIdBetween(Long value1, Long value2) {
            addCriterion("shops_id between", value1, value2, "shopsId");
            return (Criteria) this;
        }

        public Criteria andShopsIdNotBetween(Long value1, Long value2) {
            addCriterion("shops_id not between", value1, value2, "shopsId");
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
package com.aishidai.app.model.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FavoriteDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FavoriteDOExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andRelTypeIsNull() {
            addCriterion("rel_type is null");
            return (Criteria) this;
        }

        public Criteria andRelTypeIsNotNull() {
            addCriterion("rel_type is not null");
            return (Criteria) this;
        }

        public Criteria andRelTypeEqualTo(Short value) {
            addCriterion("rel_type =", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeNotEqualTo(Short value) {
            addCriterion("rel_type <>", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeGreaterThan(Short value) {
            addCriterion("rel_type >", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("rel_type >=", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeLessThan(Short value) {
            addCriterion("rel_type <", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeLessThanOrEqualTo(Short value) {
            addCriterion("rel_type <=", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeIn(List<Short> values) {
            addCriterion("rel_type in", values, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeNotIn(List<Short> values) {
            addCriterion("rel_type not in", values, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeBetween(Short value1, Short value2) {
            addCriterion("rel_type between", value1, value2, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeNotBetween(Short value1, Short value2) {
            addCriterion("rel_type not between", value1, value2, "relType");
            return (Criteria) this;
        }

        public Criteria andRelIdIsNull() {
            addCriterion("rel_id is null");
            return (Criteria) this;
        }

        public Criteria andRelIdIsNotNull() {
            addCriterion("rel_id is not null");
            return (Criteria) this;
        }

        public Criteria andRelIdEqualTo(Long value) {
            addCriterion("rel_id =", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdNotEqualTo(Long value) {
            addCriterion("rel_id <>", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdGreaterThan(Long value) {
            addCriterion("rel_id >", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("rel_id >=", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdLessThan(Long value) {
            addCriterion("rel_id <", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdLessThanOrEqualTo(Long value) {
            addCriterion("rel_id <=", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdIn(List<Long> values) {
            addCriterion("rel_id in", values, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdNotIn(List<Long> values) {
            addCriterion("rel_id not in", values, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdBetween(Long value1, Long value2) {
            addCriterion("rel_id between", value1, value2, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdNotBetween(Long value1, Long value2) {
            addCriterion("rel_id not between", value1, value2, "relId");
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

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
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

        public Criteria andUpdatedEqualTo(Date value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Date value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Date value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Date value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Date> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Date> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Date value1, Date value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("updated not between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andFavTypeIsNull() {
            addCriterion("fav_type is null");
            return (Criteria) this;
        }

        public Criteria andFavTypeIsNotNull() {
            addCriterion("fav_type is not null");
            return (Criteria) this;
        }

        public Criteria andFavTypeEqualTo(Short value) {
            addCriterion("fav_type =", value, "favType");
            return (Criteria) this;
        }

        public Criteria andFavTypeNotEqualTo(Short value) {
            addCriterion("fav_type <>", value, "favType");
            return (Criteria) this;
        }

        public Criteria andFavTypeGreaterThan(Short value) {
            addCriterion("fav_type >", value, "favType");
            return (Criteria) this;
        }

        public Criteria andFavTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("fav_type >=", value, "favType");
            return (Criteria) this;
        }

        public Criteria andFavTypeLessThan(Short value) {
            addCriterion("fav_type <", value, "favType");
            return (Criteria) this;
        }

        public Criteria andFavTypeLessThanOrEqualTo(Short value) {
            addCriterion("fav_type <=", value, "favType");
            return (Criteria) this;
        }

        public Criteria andFavTypeIn(List<Short> values) {
            addCriterion("fav_type in", values, "favType");
            return (Criteria) this;
        }

        public Criteria andFavTypeNotIn(List<Short> values) {
            addCriterion("fav_type not in", values, "favType");
            return (Criteria) this;
        }

        public Criteria andFavTypeBetween(Short value1, Short value2) {
            addCriterion("fav_type between", value1, value2, "favType");
            return (Criteria) this;
        }

        public Criteria andFavTypeNotBetween(Short value1, Short value2) {
            addCriterion("fav_type not between", value1, value2, "favType");
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
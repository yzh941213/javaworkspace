package com.aishidai.app.model.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MakerCommissionDetailDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MakerCommissionDetailDOExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNull() {
            addCriterion("commission is null");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNotNull() {
            addCriterion("commission is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionEqualTo(Integer value) {
            addCriterion("commission =", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotEqualTo(Integer value) {
            addCriterion("commission <>", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThan(Integer value) {
            addCriterion("commission >", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThanOrEqualTo(Integer value) {
            addCriterion("commission >=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThan(Integer value) {
            addCriterion("commission <", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThanOrEqualTo(Integer value) {
            addCriterion("commission <=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionIn(List<Integer> values) {
            addCriterion("commission in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotIn(List<Integer> values) {
            addCriterion("commission not in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionBetween(Integer value1, Integer value2) {
            addCriterion("commission between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotBetween(Integer value1, Integer value2) {
            addCriterion("commission not between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andMakerNameIsNull() {
            addCriterion("maker_name is null");
            return (Criteria) this;
        }

        public Criteria andMakerNameIsNotNull() {
            addCriterion("maker_name is not null");
            return (Criteria) this;
        }

        public Criteria andMakerNameEqualTo(String value) {
            addCriterion("maker_name =", value, "makerName");
            return (Criteria) this;
        }

        public Criteria andMakerNameNotEqualTo(String value) {
            addCriterion("maker_name <>", value, "makerName");
            return (Criteria) this;
        }

        public Criteria andMakerNameGreaterThan(String value) {
            addCriterion("maker_name >", value, "makerName");
            return (Criteria) this;
        }

        public Criteria andMakerNameGreaterThanOrEqualTo(String value) {
            addCriterion("maker_name >=", value, "makerName");
            return (Criteria) this;
        }

        public Criteria andMakerNameLessThan(String value) {
            addCriterion("maker_name <", value, "makerName");
            return (Criteria) this;
        }

        public Criteria andMakerNameLessThanOrEqualTo(String value) {
            addCriterion("maker_name <=", value, "makerName");
            return (Criteria) this;
        }

        public Criteria andMakerNameLike(String value) {
            addCriterion("maker_name like", value, "makerName");
            return (Criteria) this;
        }

        public Criteria andMakerNameNotLike(String value) {
            addCriterion("maker_name not like", value, "makerName");
            return (Criteria) this;
        }

        public Criteria andMakerNameIn(List<String> values) {
            addCriterion("maker_name in", values, "makerName");
            return (Criteria) this;
        }

        public Criteria andMakerNameNotIn(List<String> values) {
            addCriterion("maker_name not in", values, "makerName");
            return (Criteria) this;
        }

        public Criteria andMakerNameBetween(String value1, String value2) {
            addCriterion("maker_name between", value1, value2, "makerName");
            return (Criteria) this;
        }

        public Criteria andMakerNameNotBetween(String value1, String value2) {
            addCriterion("maker_name not between", value1, value2, "makerName");
            return (Criteria) this;
        }

        public Criteria andMakerIdIsNull() {
            addCriterion("maker_id is null");
            return (Criteria) this;
        }

        public Criteria andMakerIdIsNotNull() {
            addCriterion("maker_id is not null");
            return (Criteria) this;
        }

        public Criteria andMakerIdEqualTo(String value) {
            addCriterion("maker_id =", value, "makerId");
            return (Criteria) this;
        }

        public Criteria andMakerIdNotEqualTo(String value) {
            addCriterion("maker_id <>", value, "makerId");
            return (Criteria) this;
        }

        public Criteria andMakerIdGreaterThan(String value) {
            addCriterion("maker_id >", value, "makerId");
            return (Criteria) this;
        }

        public Criteria andMakerIdGreaterThanOrEqualTo(String value) {
            addCriterion("maker_id >=", value, "makerId");
            return (Criteria) this;
        }

        public Criteria andMakerIdLessThan(String value) {
            addCriterion("maker_id <", value, "makerId");
            return (Criteria) this;
        }

        public Criteria andMakerIdLessThanOrEqualTo(String value) {
            addCriterion("maker_id <=", value, "makerId");
            return (Criteria) this;
        }

        public Criteria andMakerIdLike(String value) {
            addCriterion("maker_id like", value, "makerId");
            return (Criteria) this;
        }

        public Criteria andMakerIdNotLike(String value) {
            addCriterion("maker_id not like", value, "makerId");
            return (Criteria) this;
        }

        public Criteria andMakerIdIn(List<String> values) {
            addCriterion("maker_id in", values, "makerId");
            return (Criteria) this;
        }

        public Criteria andMakerIdNotIn(List<String> values) {
            addCriterion("maker_id not in", values, "makerId");
            return (Criteria) this;
        }

        public Criteria andMakerIdBetween(String value1, String value2) {
            addCriterion("maker_id between", value1, value2, "makerId");
            return (Criteria) this;
        }

        public Criteria andMakerIdNotBetween(String value1, String value2) {
            addCriterion("maker_id not between", value1, value2, "makerId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andOtherShopIdIsNull() {
            addCriterion("other_shop_id is null");
            return (Criteria) this;
        }

        public Criteria andOtherShopIdIsNotNull() {
            addCriterion("other_shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andOtherShopIdEqualTo(Long value) {
            addCriterion("other_shop_id =", value, "otherShopId");
            return (Criteria) this;
        }

        public Criteria andOtherShopIdNotEqualTo(Long value) {
            addCriterion("other_shop_id <>", value, "otherShopId");
            return (Criteria) this;
        }

        public Criteria andOtherShopIdGreaterThan(Long value) {
            addCriterion("other_shop_id >", value, "otherShopId");
            return (Criteria) this;
        }

        public Criteria andOtherShopIdGreaterThanOrEqualTo(Long value) {
            addCriterion("other_shop_id >=", value, "otherShopId");
            return (Criteria) this;
        }

        public Criteria andOtherShopIdLessThan(Long value) {
            addCriterion("other_shop_id <", value, "otherShopId");
            return (Criteria) this;
        }

        public Criteria andOtherShopIdLessThanOrEqualTo(Long value) {
            addCriterion("other_shop_id <=", value, "otherShopId");
            return (Criteria) this;
        }

        public Criteria andOtherShopIdIn(List<Long> values) {
            addCriterion("other_shop_id in", values, "otherShopId");
            return (Criteria) this;
        }

        public Criteria andOtherShopIdNotIn(List<Long> values) {
            addCriterion("other_shop_id not in", values, "otherShopId");
            return (Criteria) this;
        }

        public Criteria andOtherShopIdBetween(Long value1, Long value2) {
            addCriterion("other_shop_id between", value1, value2, "otherShopId");
            return (Criteria) this;
        }

        public Criteria andOtherShopIdNotBetween(Long value1, Long value2) {
            addCriterion("other_shop_id not between", value1, value2, "otherShopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(Long value) {
            addCriterion("shop_id =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(Long value) {
            addCriterion("shop_id <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(Long value) {
            addCriterion("shop_id >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            addCriterion("shop_id >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(Long value) {
            addCriterion("shop_id <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Long value) {
            addCriterion("shop_id <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<Long> values) {
            addCriterion("shop_id in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<Long> values) {
            addCriterion("shop_id not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(Long value1, Long value2) {
            addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(Long value1, Long value2) {
            addCriterion("shop_id not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andCreateNameIsNull() {
            addCriterion("create_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateNameIsNotNull() {
            addCriterion("create_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateNameEqualTo(String value) {
            addCriterion("create_name =", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotEqualTo(String value) {
            addCriterion("create_name <>", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThan(String value) {
            addCriterion("create_name >", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_name >=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThan(String value) {
            addCriterion("create_name <", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThanOrEqualTo(String value) {
            addCriterion("create_name <=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLike(String value) {
            addCriterion("create_name like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotLike(String value) {
            addCriterion("create_name not like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameIn(List<String> values) {
            addCriterion("create_name in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotIn(List<String> values) {
            addCriterion("create_name not in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameBetween(String value1, String value2) {
            addCriterion("create_name between", value1, value2, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotBetween(String value1, String value2) {
            addCriterion("create_name not between", value1, value2, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNull() {
            addCriterion("create_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNotNull() {
            addCriterion("create_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateIdEqualTo(Long value) {
            addCriterion("create_id =", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotEqualTo(Long value) {
            addCriterion("create_id <>", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThan(Long value) {
            addCriterion("create_id >", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("create_id >=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThan(Long value) {
            addCriterion("create_id <", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThanOrEqualTo(Long value) {
            addCriterion("create_id <=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdIn(List<Long> values) {
            addCriterion("create_id in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotIn(List<Long> values) {
            addCriterion("create_id not in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdBetween(Long value1, Long value2) {
            addCriterion("create_id between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotBetween(Long value1, Long value2) {
            addCriterion("create_id not between", value1, value2, "createId");
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

        public Criteria andDeleteIsIsNull() {
            addCriterion("delete_is is null");
            return (Criteria) this;
        }

        public Criteria andDeleteIsIsNotNull() {
            addCriterion("delete_is is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteIsEqualTo(Integer value) {
            addCriterion("delete_is =", value, "deleteIs");
            return (Criteria) this;
        }

        public Criteria andDeleteIsNotEqualTo(Integer value) {
            addCriterion("delete_is <>", value, "deleteIs");
            return (Criteria) this;
        }

        public Criteria andDeleteIsGreaterThan(Integer value) {
            addCriterion("delete_is >", value, "deleteIs");
            return (Criteria) this;
        }

        public Criteria andDeleteIsGreaterThanOrEqualTo(Integer value) {
            addCriterion("delete_is >=", value, "deleteIs");
            return (Criteria) this;
        }

        public Criteria andDeleteIsLessThan(Integer value) {
            addCriterion("delete_is <", value, "deleteIs");
            return (Criteria) this;
        }

        public Criteria andDeleteIsLessThanOrEqualTo(Integer value) {
            addCriterion("delete_is <=", value, "deleteIs");
            return (Criteria) this;
        }

        public Criteria andDeleteIsIn(List<Integer> values) {
            addCriterion("delete_is in", values, "deleteIs");
            return (Criteria) this;
        }

        public Criteria andDeleteIsNotIn(List<Integer> values) {
            addCriterion("delete_is not in", values, "deleteIs");
            return (Criteria) this;
        }

        public Criteria andDeleteIsBetween(Integer value1, Integer value2) {
            addCriterion("delete_is between", value1, value2, "deleteIs");
            return (Criteria) this;
        }

        public Criteria andDeleteIsNotBetween(Integer value1, Integer value2) {
            addCriterion("delete_is not between", value1, value2, "deleteIs");
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
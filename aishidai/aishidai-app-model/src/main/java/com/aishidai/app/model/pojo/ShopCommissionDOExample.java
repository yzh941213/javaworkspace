package com.aishidai.app.model.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopCommissionDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopCommissionDOExample() {
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

        public Criteria andBarbershopCommissionIsNull() {
            addCriterion("barbershop_commission is null");
            return (Criteria) this;
        }

        public Criteria andBarbershopCommissionIsNotNull() {
            addCriterion("barbershop_commission is not null");
            return (Criteria) this;
        }

        public Criteria andBarbershopCommissionEqualTo(Integer value) {
            addCriterion("barbershop_commission =", value, "barbershopCommission");
            return (Criteria) this;
        }

        public Criteria andBarbershopCommissionNotEqualTo(Integer value) {
            addCriterion("barbershop_commission <>", value, "barbershopCommission");
            return (Criteria) this;
        }

        public Criteria andBarbershopCommissionGreaterThan(Integer value) {
            addCriterion("barbershop_commission >", value, "barbershopCommission");
            return (Criteria) this;
        }

        public Criteria andBarbershopCommissionGreaterThanOrEqualTo(Integer value) {
            addCriterion("barbershop_commission >=", value, "barbershopCommission");
            return (Criteria) this;
        }

        public Criteria andBarbershopCommissionLessThan(Integer value) {
            addCriterion("barbershop_commission <", value, "barbershopCommission");
            return (Criteria) this;
        }

        public Criteria andBarbershopCommissionLessThanOrEqualTo(Integer value) {
            addCriterion("barbershop_commission <=", value, "barbershopCommission");
            return (Criteria) this;
        }

        public Criteria andBarbershopCommissionIn(List<Integer> values) {
            addCriterion("barbershop_commission in", values, "barbershopCommission");
            return (Criteria) this;
        }

        public Criteria andBarbershopCommissionNotIn(List<Integer> values) {
            addCriterion("barbershop_commission not in", values, "barbershopCommission");
            return (Criteria) this;
        }

        public Criteria andBarbershopCommissionBetween(Integer value1, Integer value2) {
            addCriterion("barbershop_commission between", value1, value2, "barbershopCommission");
            return (Criteria) this;
        }

        public Criteria andBarbershopCommissionNotBetween(Integer value1, Integer value2) {
            addCriterion("barbershop_commission not between", value1, value2, "barbershopCommission");
            return (Criteria) this;
        }

        public Criteria andDistributorIdIsNull() {
            addCriterion("distributor_id is null");
            return (Criteria) this;
        }

        public Criteria andDistributorIdIsNotNull() {
            addCriterion("distributor_id is not null");
            return (Criteria) this;
        }

        public Criteria andDistributorIdEqualTo(Long value) {
            addCriterion("distributor_id =", value, "distributorId");
            return (Criteria) this;
        }

        public Criteria andDistributorIdNotEqualTo(Long value) {
            addCriterion("distributor_id <>", value, "distributorId");
            return (Criteria) this;
        }

        public Criteria andDistributorIdGreaterThan(Long value) {
            addCriterion("distributor_id >", value, "distributorId");
            return (Criteria) this;
        }

        public Criteria andDistributorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("distributor_id >=", value, "distributorId");
            return (Criteria) this;
        }

        public Criteria andDistributorIdLessThan(Long value) {
            addCriterion("distributor_id <", value, "distributorId");
            return (Criteria) this;
        }

        public Criteria andDistributorIdLessThanOrEqualTo(Long value) {
            addCriterion("distributor_id <=", value, "distributorId");
            return (Criteria) this;
        }

        public Criteria andDistributorIdIn(List<Long> values) {
            addCriterion("distributor_id in", values, "distributorId");
            return (Criteria) this;
        }

        public Criteria andDistributorIdNotIn(List<Long> values) {
            addCriterion("distributor_id not in", values, "distributorId");
            return (Criteria) this;
        }

        public Criteria andDistributorIdBetween(Long value1, Long value2) {
            addCriterion("distributor_id between", value1, value2, "distributorId");
            return (Criteria) this;
        }

        public Criteria andDistributorIdNotBetween(Long value1, Long value2) {
            addCriterion("distributor_id not between", value1, value2, "distributorId");
            return (Criteria) this;
        }

        public Criteria andDistributorNameIsNull() {
            addCriterion("distributor_name is null");
            return (Criteria) this;
        }

        public Criteria andDistributorNameIsNotNull() {
            addCriterion("distributor_name is not null");
            return (Criteria) this;
        }

        public Criteria andDistributorNameEqualTo(String value) {
            addCriterion("distributor_name =", value, "distributorName");
            return (Criteria) this;
        }

        public Criteria andDistributorNameNotEqualTo(String value) {
            addCriterion("distributor_name <>", value, "distributorName");
            return (Criteria) this;
        }

        public Criteria andDistributorNameGreaterThan(String value) {
            addCriterion("distributor_name >", value, "distributorName");
            return (Criteria) this;
        }

        public Criteria andDistributorNameGreaterThanOrEqualTo(String value) {
            addCriterion("distributor_name >=", value, "distributorName");
            return (Criteria) this;
        }

        public Criteria andDistributorNameLessThan(String value) {
            addCriterion("distributor_name <", value, "distributorName");
            return (Criteria) this;
        }

        public Criteria andDistributorNameLessThanOrEqualTo(String value) {
            addCriterion("distributor_name <=", value, "distributorName");
            return (Criteria) this;
        }

        public Criteria andDistributorNameLike(String value) {
            addCriterion("distributor_name like", value, "distributorName");
            return (Criteria) this;
        }

        public Criteria andDistributorNameNotLike(String value) {
            addCriterion("distributor_name not like", value, "distributorName");
            return (Criteria) this;
        }

        public Criteria andDistributorNameIn(List<String> values) {
            addCriterion("distributor_name in", values, "distributorName");
            return (Criteria) this;
        }

        public Criteria andDistributorNameNotIn(List<String> values) {
            addCriterion("distributor_name not in", values, "distributorName");
            return (Criteria) this;
        }

        public Criteria andDistributorNameBetween(String value1, String value2) {
            addCriterion("distributor_name between", value1, value2, "distributorName");
            return (Criteria) this;
        }

        public Criteria andDistributorNameNotBetween(String value1, String value2) {
            addCriterion("distributor_name not between", value1, value2, "distributorName");
            return (Criteria) this;
        }

        public Criteria andDistributorCommissionIsNull() {
            addCriterion("distributor_commission is null");
            return (Criteria) this;
        }

        public Criteria andDistributorCommissionIsNotNull() {
            addCriterion("distributor_commission is not null");
            return (Criteria) this;
        }

        public Criteria andDistributorCommissionEqualTo(Integer value) {
            addCriterion("distributor_commission =", value, "distributorCommission");
            return (Criteria) this;
        }

        public Criteria andDistributorCommissionNotEqualTo(Integer value) {
            addCriterion("distributor_commission <>", value, "distributorCommission");
            return (Criteria) this;
        }

        public Criteria andDistributorCommissionGreaterThan(Integer value) {
            addCriterion("distributor_commission >", value, "distributorCommission");
            return (Criteria) this;
        }

        public Criteria andDistributorCommissionGreaterThanOrEqualTo(Integer value) {
            addCriterion("distributor_commission >=", value, "distributorCommission");
            return (Criteria) this;
        }

        public Criteria andDistributorCommissionLessThan(Integer value) {
            addCriterion("distributor_commission <", value, "distributorCommission");
            return (Criteria) this;
        }

        public Criteria andDistributorCommissionLessThanOrEqualTo(Integer value) {
            addCriterion("distributor_commission <=", value, "distributorCommission");
            return (Criteria) this;
        }

        public Criteria andDistributorCommissionIn(List<Integer> values) {
            addCriterion("distributor_commission in", values, "distributorCommission");
            return (Criteria) this;
        }

        public Criteria andDistributorCommissionNotIn(List<Integer> values) {
            addCriterion("distributor_commission not in", values, "distributorCommission");
            return (Criteria) this;
        }

        public Criteria andDistributorCommissionBetween(Integer value1, Integer value2) {
            addCriterion("distributor_commission between", value1, value2, "distributorCommission");
            return (Criteria) this;
        }

        public Criteria andDistributorCommissionNotBetween(Integer value1, Integer value2) {
            addCriterion("distributor_commission not between", value1, value2, "distributorCommission");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNull() {
            addCriterion("shop_name is null");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNotNull() {
            addCriterion("shop_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopNameEqualTo(String value) {
            addCriterion("shop_name =", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotEqualTo(String value) {
            addCriterion("shop_name <>", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThan(String value) {
            addCriterion("shop_name >", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThanOrEqualTo(String value) {
            addCriterion("shop_name >=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThan(String value) {
            addCriterion("shop_name <", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThanOrEqualTo(String value) {
            addCriterion("shop_name <=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLike(String value) {
            addCriterion("shop_name like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotLike(String value) {
            addCriterion("shop_name not like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameIn(List<String> values) {
            addCriterion("shop_name in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotIn(List<String> values) {
            addCriterion("shop_name not in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameBetween(String value1, String value2) {
            addCriterion("shop_name between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotBetween(String value1, String value2) {
            addCriterion("shop_name not between", value1, value2, "shopName");
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

        public Criteria andMakerCommissionIsNull() {
            addCriterion("maker_commission is null");
            return (Criteria) this;
        }

        public Criteria andMakerCommissionIsNotNull() {
            addCriterion("maker_commission is not null");
            return (Criteria) this;
        }

        public Criteria andMakerCommissionEqualTo(Integer value) {
            addCriterion("maker_commission =", value, "makerCommission");
            return (Criteria) this;
        }

        public Criteria andMakerCommissionNotEqualTo(Integer value) {
            addCriterion("maker_commission <>", value, "makerCommission");
            return (Criteria) this;
        }

        public Criteria andMakerCommissionGreaterThan(Integer value) {
            addCriterion("maker_commission >", value, "makerCommission");
            return (Criteria) this;
        }

        public Criteria andMakerCommissionGreaterThanOrEqualTo(Integer value) {
            addCriterion("maker_commission >=", value, "makerCommission");
            return (Criteria) this;
        }

        public Criteria andMakerCommissionLessThan(Integer value) {
            addCriterion("maker_commission <", value, "makerCommission");
            return (Criteria) this;
        }

        public Criteria andMakerCommissionLessThanOrEqualTo(Integer value) {
            addCriterion("maker_commission <=", value, "makerCommission");
            return (Criteria) this;
        }

        public Criteria andMakerCommissionIn(List<Integer> values) {
            addCriterion("maker_commission in", values, "makerCommission");
            return (Criteria) this;
        }

        public Criteria andMakerCommissionNotIn(List<Integer> values) {
            addCriterion("maker_commission not in", values, "makerCommission");
            return (Criteria) this;
        }

        public Criteria andMakerCommissionBetween(Integer value1, Integer value2) {
            addCriterion("maker_commission between", value1, value2, "makerCommission");
            return (Criteria) this;
        }

        public Criteria andMakerCommissionNotBetween(Integer value1, Integer value2) {
            addCriterion("maker_commission not between", value1, value2, "makerCommission");
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
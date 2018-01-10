package com.aishidai.app.model.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopsDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopsDOExample() {
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

        public Criteria andShopsNameIsNull() {
            addCriterion("shops_name is null");
            return (Criteria) this;
        }

        public Criteria andShopsNameIsNotNull() {
            addCriterion("shops_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopsNameEqualTo(String value) {
            addCriterion("shops_name =", value, "shopsName");
            return (Criteria) this;
        }

        public Criteria andShopsNameNotEqualTo(String value) {
            addCriterion("shops_name <>", value, "shopsName");
            return (Criteria) this;
        }

        public Criteria andShopsNameGreaterThan(String value) {
            addCriterion("shops_name >", value, "shopsName");
            return (Criteria) this;
        }

        public Criteria andShopsNameGreaterThanOrEqualTo(String value) {
            addCriterion("shops_name >=", value, "shopsName");
            return (Criteria) this;
        }

        public Criteria andShopsNameLessThan(String value) {
            addCriterion("shops_name <", value, "shopsName");
            return (Criteria) this;
        }

        public Criteria andShopsNameLessThanOrEqualTo(String value) {
            addCriterion("shops_name <=", value, "shopsName");
            return (Criteria) this;
        }

        public Criteria andShopsNameLike(String value) {
            addCriterion("shops_name like", value, "shopsName");
            return (Criteria) this;
        }

        public Criteria andShopsNameNotLike(String value) {
            addCriterion("shops_name not like", value, "shopsName");
            return (Criteria) this;
        }

        public Criteria andShopsNameIn(List<String> values) {
            addCriterion("shops_name in", values, "shopsName");
            return (Criteria) this;
        }

        public Criteria andShopsNameNotIn(List<String> values) {
            addCriterion("shops_name not in", values, "shopsName");
            return (Criteria) this;
        }

        public Criteria andShopsNameBetween(String value1, String value2) {
            addCriterion("shops_name between", value1, value2, "shopsName");
            return (Criteria) this;
        }

        public Criteria andShopsNameNotBetween(String value1, String value2) {
            addCriterion("shops_name not between", value1, value2, "shopsName");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNull() {
            addCriterion("introduce is null");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNotNull() {
            addCriterion("introduce is not null");
            return (Criteria) this;
        }

        public Criteria andIntroduceEqualTo(String value) {
            addCriterion("introduce =", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotEqualTo(String value) {
            addCriterion("introduce <>", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThan(String value) {
            addCriterion("introduce >", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("introduce >=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThan(String value) {
            addCriterion("introduce <", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThanOrEqualTo(String value) {
            addCriterion("introduce <=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLike(String value) {
            addCriterion("introduce like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotLike(String value) {
            addCriterion("introduce not like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceIn(List<String> values) {
            addCriterion("introduce in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotIn(List<String> values) {
            addCriterion("introduce not in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceBetween(String value1, String value2) {
            addCriterion("introduce between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotBetween(String value1, String value2) {
            addCriterion("introduce not between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andShopsUrlIsNull() {
            addCriterion("shops_url is null");
            return (Criteria) this;
        }

        public Criteria andShopsUrlIsNotNull() {
            addCriterion("shops_url is not null");
            return (Criteria) this;
        }

        public Criteria andShopsUrlEqualTo(String value) {
            addCriterion("shops_url =", value, "shopsUrl");
            return (Criteria) this;
        }

        public Criteria andShopsUrlNotEqualTo(String value) {
            addCriterion("shops_url <>", value, "shopsUrl");
            return (Criteria) this;
        }

        public Criteria andShopsUrlGreaterThan(String value) {
            addCriterion("shops_url >", value, "shopsUrl");
            return (Criteria) this;
        }

        public Criteria andShopsUrlGreaterThanOrEqualTo(String value) {
            addCriterion("shops_url >=", value, "shopsUrl");
            return (Criteria) this;
        }

        public Criteria andShopsUrlLessThan(String value) {
            addCriterion("shops_url <", value, "shopsUrl");
            return (Criteria) this;
        }

        public Criteria andShopsUrlLessThanOrEqualTo(String value) {
            addCriterion("shops_url <=", value, "shopsUrl");
            return (Criteria) this;
        }

        public Criteria andShopsUrlLike(String value) {
            addCriterion("shops_url like", value, "shopsUrl");
            return (Criteria) this;
        }

        public Criteria andShopsUrlNotLike(String value) {
            addCriterion("shops_url not like", value, "shopsUrl");
            return (Criteria) this;
        }

        public Criteria andShopsUrlIn(List<String> values) {
            addCriterion("shops_url in", values, "shopsUrl");
            return (Criteria) this;
        }

        public Criteria andShopsUrlNotIn(List<String> values) {
            addCriterion("shops_url not in", values, "shopsUrl");
            return (Criteria) this;
        }

        public Criteria andShopsUrlBetween(String value1, String value2) {
            addCriterion("shops_url between", value1, value2, "shopsUrl");
            return (Criteria) this;
        }

        public Criteria andShopsUrlNotBetween(String value1, String value2) {
            addCriterion("shops_url not between", value1, value2, "shopsUrl");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
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

        public Criteria andActivityIsNull() {
            addCriterion("activity is null");
            return (Criteria) this;
        }

        public Criteria andActivityIsNotNull() {
            addCriterion("activity is not null");
            return (Criteria) this;
        }

        public Criteria andActivityEqualTo(String value) {
            addCriterion("activity =", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityNotEqualTo(String value) {
            addCriterion("activity <>", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityGreaterThan(String value) {
            addCriterion("activity >", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityGreaterThanOrEqualTo(String value) {
            addCriterion("activity >=", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityLessThan(String value) {
            addCriterion("activity <", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityLessThanOrEqualTo(String value) {
            addCriterion("activity <=", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityLike(String value) {
            addCriterion("activity like", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityNotLike(String value) {
            addCriterion("activity not like", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityIn(List<String> values) {
            addCriterion("activity in", values, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityNotIn(List<String> values) {
            addCriterion("activity not in", values, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityBetween(String value1, String value2) {
            addCriterion("activity between", value1, value2, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityNotBetween(String value1, String value2) {
            addCriterion("activity not between", value1, value2, "activity");
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

        public Criteria andSysUserIdIsNull() {
            addCriterion("sys_user_id is null");
            return (Criteria) this;
        }

        public Criteria andSysUserIdIsNotNull() {
            addCriterion("sys_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysUserIdEqualTo(Long value) {
            addCriterion("sys_user_id =", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdNotEqualTo(Long value) {
            addCriterion("sys_user_id <>", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdGreaterThan(Long value) {
            addCriterion("sys_user_id >", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sys_user_id >=", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdLessThan(Long value) {
            addCriterion("sys_user_id <", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdLessThanOrEqualTo(Long value) {
            addCriterion("sys_user_id <=", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdIn(List<Long> values) {
            addCriterion("sys_user_id in", values, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdNotIn(List<Long> values) {
            addCriterion("sys_user_id not in", values, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdBetween(Long value1, Long value2) {
            addCriterion("sys_user_id between", value1, value2, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdNotBetween(Long value1, Long value2) {
            addCriterion("sys_user_id not between", value1, value2, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andShopHoursOpenIsNull() {
            addCriterion("shop_hours_open is null");
            return (Criteria) this;
        }

        public Criteria andShopHoursOpenIsNotNull() {
            addCriterion("shop_hours_open is not null");
            return (Criteria) this;
        }

        public Criteria andShopHoursOpenEqualTo(String value) {
            addCriterion("shop_hours_open =", value, "shopHoursOpen");
            return (Criteria) this;
        }

        public Criteria andShopHoursOpenNotEqualTo(String value) {
            addCriterion("shop_hours_open <>", value, "shopHoursOpen");
            return (Criteria) this;
        }

        public Criteria andShopHoursOpenGreaterThan(String value) {
            addCriterion("shop_hours_open >", value, "shopHoursOpen");
            return (Criteria) this;
        }

        public Criteria andShopHoursOpenGreaterThanOrEqualTo(String value) {
            addCriterion("shop_hours_open >=", value, "shopHoursOpen");
            return (Criteria) this;
        }

        public Criteria andShopHoursOpenLessThan(String value) {
            addCriterion("shop_hours_open <", value, "shopHoursOpen");
            return (Criteria) this;
        }

        public Criteria andShopHoursOpenLessThanOrEqualTo(String value) {
            addCriterion("shop_hours_open <=", value, "shopHoursOpen");
            return (Criteria) this;
        }

        public Criteria andShopHoursOpenLike(String value) {
            addCriterion("shop_hours_open like", value, "shopHoursOpen");
            return (Criteria) this;
        }

        public Criteria andShopHoursOpenNotLike(String value) {
            addCriterion("shop_hours_open not like", value, "shopHoursOpen");
            return (Criteria) this;
        }

        public Criteria andShopHoursOpenIn(List<String> values) {
            addCriterion("shop_hours_open in", values, "shopHoursOpen");
            return (Criteria) this;
        }

        public Criteria andShopHoursOpenNotIn(List<String> values) {
            addCriterion("shop_hours_open not in", values, "shopHoursOpen");
            return (Criteria) this;
        }

        public Criteria andShopHoursOpenBetween(String value1, String value2) {
            addCriterion("shop_hours_open between", value1, value2, "shopHoursOpen");
            return (Criteria) this;
        }

        public Criteria andShopHoursOpenNotBetween(String value1, String value2) {
            addCriterion("shop_hours_open not between", value1, value2, "shopHoursOpen");
            return (Criteria) this;
        }

        public Criteria andShopHoursCloseIsNull() {
            addCriterion("shop_hours_close is null");
            return (Criteria) this;
        }

        public Criteria andShopHoursCloseIsNotNull() {
            addCriterion("shop_hours_close is not null");
            return (Criteria) this;
        }

        public Criteria andShopHoursCloseEqualTo(String value) {
            addCriterion("shop_hours_close =", value, "shopHoursClose");
            return (Criteria) this;
        }

        public Criteria andShopHoursCloseNotEqualTo(String value) {
            addCriterion("shop_hours_close <>", value, "shopHoursClose");
            return (Criteria) this;
        }

        public Criteria andShopHoursCloseGreaterThan(String value) {
            addCriterion("shop_hours_close >", value, "shopHoursClose");
            return (Criteria) this;
        }

        public Criteria andShopHoursCloseGreaterThanOrEqualTo(String value) {
            addCriterion("shop_hours_close >=", value, "shopHoursClose");
            return (Criteria) this;
        }

        public Criteria andShopHoursCloseLessThan(String value) {
            addCriterion("shop_hours_close <", value, "shopHoursClose");
            return (Criteria) this;
        }

        public Criteria andShopHoursCloseLessThanOrEqualTo(String value) {
            addCriterion("shop_hours_close <=", value, "shopHoursClose");
            return (Criteria) this;
        }

        public Criteria andShopHoursCloseLike(String value) {
            addCriterion("shop_hours_close like", value, "shopHoursClose");
            return (Criteria) this;
        }

        public Criteria andShopHoursCloseNotLike(String value) {
            addCriterion("shop_hours_close not like", value, "shopHoursClose");
            return (Criteria) this;
        }

        public Criteria andShopHoursCloseIn(List<String> values) {
            addCriterion("shop_hours_close in", values, "shopHoursClose");
            return (Criteria) this;
        }

        public Criteria andShopHoursCloseNotIn(List<String> values) {
            addCriterion("shop_hours_close not in", values, "shopHoursClose");
            return (Criteria) this;
        }

        public Criteria andShopHoursCloseBetween(String value1, String value2) {
            addCriterion("shop_hours_close between", value1, value2, "shopHoursClose");
            return (Criteria) this;
        }

        public Criteria andShopHoursCloseNotBetween(String value1, String value2) {
            addCriterion("shop_hours_close not between", value1, value2, "shopHoursClose");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Byte value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Byte value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Byte value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Byte value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Byte value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Byte> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Byte> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Byte value1, Byte value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Byte value1, Byte value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andServicesIsNull() {
            addCriterion("services is null");
            return (Criteria) this;
        }

        public Criteria andServicesIsNotNull() {
            addCriterion("services is not null");
            return (Criteria) this;
        }

        public Criteria andServicesEqualTo(String value) {
            addCriterion("services =", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesNotEqualTo(String value) {
            addCriterion("services <>", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesGreaterThan(String value) {
            addCriterion("services >", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesGreaterThanOrEqualTo(String value) {
            addCriterion("services >=", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesLessThan(String value) {
            addCriterion("services <", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesLessThanOrEqualTo(String value) {
            addCriterion("services <=", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesLike(String value) {
            addCriterion("services like", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesNotLike(String value) {
            addCriterion("services not like", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesIn(List<String> values) {
            addCriterion("services in", values, "services");
            return (Criteria) this;
        }

        public Criteria andServicesNotIn(List<String> values) {
            addCriterion("services not in", values, "services");
            return (Criteria) this;
        }

        public Criteria andServicesBetween(String value1, String value2) {
            addCriterion("services between", value1, value2, "services");
            return (Criteria) this;
        }

        public Criteria andServicesNotBetween(String value1, String value2) {
            addCriterion("services not between", value1, value2, "services");
            return (Criteria) this;
        }

        public Criteria andHotIsNull() {
            addCriterion("hot is null");
            return (Criteria) this;
        }

        public Criteria andHotIsNotNull() {
            addCriterion("hot is not null");
            return (Criteria) this;
        }

        public Criteria andHotEqualTo(Integer value) {
            addCriterion("hot =", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotEqualTo(Integer value) {
            addCriterion("hot <>", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotGreaterThan(Integer value) {
            addCriterion("hot >", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotGreaterThanOrEqualTo(Integer value) {
            addCriterion("hot >=", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotLessThan(Integer value) {
            addCriterion("hot <", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotLessThanOrEqualTo(Integer value) {
            addCriterion("hot <=", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotIn(List<Integer> values) {
            addCriterion("hot in", values, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotIn(List<Integer> values) {
            addCriterion("hot not in", values, "hot");
            return (Criteria) this;
        }

        public Criteria andHotBetween(Integer value1, Integer value2) {
            addCriterion("hot between", value1, value2, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotBetween(Integer value1, Integer value2) {
            addCriterion("hot not between", value1, value2, "hot");
            return (Criteria) this;
        }

        public Criteria andServicesTypeIsNull() {
            addCriterion("services_type is null");
            return (Criteria) this;
        }

        public Criteria andServicesTypeIsNotNull() {
            addCriterion("services_type is not null");
            return (Criteria) this;
        }

        public Criteria andServicesTypeEqualTo(String value) {
            addCriterion("services_type =", value, "servicesType");
            return (Criteria) this;
        }

        public Criteria andServicesTypeNotEqualTo(String value) {
            addCriterion("services_type <>", value, "servicesType");
            return (Criteria) this;
        }

        public Criteria andServicesTypeGreaterThan(String value) {
            addCriterion("services_type >", value, "servicesType");
            return (Criteria) this;
        }

        public Criteria andServicesTypeGreaterThanOrEqualTo(String value) {
            addCriterion("services_type >=", value, "servicesType");
            return (Criteria) this;
        }

        public Criteria andServicesTypeLessThan(String value) {
            addCriterion("services_type <", value, "servicesType");
            return (Criteria) this;
        }

        public Criteria andServicesTypeLessThanOrEqualTo(String value) {
            addCriterion("services_type <=", value, "servicesType");
            return (Criteria) this;
        }

        public Criteria andServicesTypeLike(String value) {
            addCriterion("services_type like", value, "servicesType");
            return (Criteria) this;
        }

        public Criteria andServicesTypeNotLike(String value) {
            addCriterion("services_type not like", value, "servicesType");
            return (Criteria) this;
        }

        public Criteria andServicesTypeIn(List<String> values) {
            addCriterion("services_type in", values, "servicesType");
            return (Criteria) this;
        }

        public Criteria andServicesTypeNotIn(List<String> values) {
            addCriterion("services_type not in", values, "servicesType");
            return (Criteria) this;
        }

        public Criteria andServicesTypeBetween(String value1, String value2) {
            addCriterion("services_type between", value1, value2, "servicesType");
            return (Criteria) this;
        }

        public Criteria andServicesTypeNotBetween(String value1, String value2) {
            addCriterion("services_type not between", value1, value2, "servicesType");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(Long value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(Long value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(Long value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(Long value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(Long value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<Long> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<Long> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(Long value1, Long value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(Long value1, Long value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIsIsNull() {
            addCriterion("device_is is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIsIsNotNull() {
            addCriterion("device_is is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIsEqualTo(Integer value) {
            addCriterion("device_is =", value, "deviceIs");
            return (Criteria) this;
        }

        public Criteria andDeviceIsNotEqualTo(Integer value) {
            addCriterion("device_is <>", value, "deviceIs");
            return (Criteria) this;
        }

        public Criteria andDeviceIsGreaterThan(Integer value) {
            addCriterion("device_is >", value, "deviceIs");
            return (Criteria) this;
        }

        public Criteria andDeviceIsGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_is >=", value, "deviceIs");
            return (Criteria) this;
        }

        public Criteria andDeviceIsLessThan(Integer value) {
            addCriterion("device_is <", value, "deviceIs");
            return (Criteria) this;
        }

        public Criteria andDeviceIsLessThanOrEqualTo(Integer value) {
            addCriterion("device_is <=", value, "deviceIs");
            return (Criteria) this;
        }

        public Criteria andDeviceIsIn(List<Integer> values) {
            addCriterion("device_is in", values, "deviceIs");
            return (Criteria) this;
        }

        public Criteria andDeviceIsNotIn(List<Integer> values) {
            addCriterion("device_is not in", values, "deviceIs");
            return (Criteria) this;
        }

        public Criteria andDeviceIsBetween(Integer value1, Integer value2) {
            addCriterion("device_is between", value1, value2, "deviceIs");
            return (Criteria) this;
        }

        public Criteria andDeviceIsNotBetween(Integer value1, Integer value2) {
            addCriterion("device_is not between", value1, value2, "deviceIs");
            return (Criteria) this;
        }

        public Criteria andAuditIsNull() {
            addCriterion("audit is null");
            return (Criteria) this;
        }

        public Criteria andAuditIsNotNull() {
            addCriterion("audit is not null");
            return (Criteria) this;
        }

        public Criteria andAuditEqualTo(Integer value) {
            addCriterion("audit =", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotEqualTo(Integer value) {
            addCriterion("audit <>", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditGreaterThan(Integer value) {
            addCriterion("audit >", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit >=", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditLessThan(Integer value) {
            addCriterion("audit <", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditLessThanOrEqualTo(Integer value) {
            addCriterion("audit <=", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditIn(List<Integer> values) {
            addCriterion("audit in", values, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotIn(List<Integer> values) {
            addCriterion("audit not in", values, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditBetween(Integer value1, Integer value2) {
            addCriterion("audit between", value1, value2, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotBetween(Integer value1, Integer value2) {
            addCriterion("audit not between", value1, value2, "audit");
            return (Criteria) this;
        }

        public Criteria andStarIsNull() {
            addCriterion("star is null");
            return (Criteria) this;
        }

        public Criteria andStarIsNotNull() {
            addCriterion("star is not null");
            return (Criteria) this;
        }

        public Criteria andStarEqualTo(Byte value) {
            addCriterion("star =", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotEqualTo(Byte value) {
            addCriterion("star <>", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarGreaterThan(Byte value) {
            addCriterion("star >", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarGreaterThanOrEqualTo(Byte value) {
            addCriterion("star >=", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarLessThan(Byte value) {
            addCriterion("star <", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarLessThanOrEqualTo(Byte value) {
            addCriterion("star <=", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarIn(List<Byte> values) {
            addCriterion("star in", values, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotIn(List<Byte> values) {
            addCriterion("star not in", values, "star");
            return (Criteria) this;
        }

        public Criteria andStarBetween(Byte value1, Byte value2) {
            addCriterion("star between", value1, value2, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotBetween(Byte value1, Byte value2) {
            addCriterion("star not between", value1, value2, "star");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("lat is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("lat is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(String value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(String value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(String value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(String value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(String value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(String value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLike(String value) {
            addCriterion("lat like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotLike(String value) {
            addCriterion("lat not like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<String> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<String> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(String value1, String value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(String value1, String value2) {
            addCriterion("lat not between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLntIsNull() {
            addCriterion("lnt is null");
            return (Criteria) this;
        }

        public Criteria andLntIsNotNull() {
            addCriterion("lnt is not null");
            return (Criteria) this;
        }

        public Criteria andLntEqualTo(String value) {
            addCriterion("lnt =", value, "lnt");
            return (Criteria) this;
        }

        public Criteria andLntNotEqualTo(String value) {
            addCriterion("lnt <>", value, "lnt");
            return (Criteria) this;
        }

        public Criteria andLntGreaterThan(String value) {
            addCriterion("lnt >", value, "lnt");
            return (Criteria) this;
        }

        public Criteria andLntGreaterThanOrEqualTo(String value) {
            addCriterion("lnt >=", value, "lnt");
            return (Criteria) this;
        }

        public Criteria andLntLessThan(String value) {
            addCriterion("lnt <", value, "lnt");
            return (Criteria) this;
        }

        public Criteria andLntLessThanOrEqualTo(String value) {
            addCriterion("lnt <=", value, "lnt");
            return (Criteria) this;
        }

        public Criteria andLntLike(String value) {
            addCriterion("lnt like", value, "lnt");
            return (Criteria) this;
        }

        public Criteria andLntNotLike(String value) {
            addCriterion("lnt not like", value, "lnt");
            return (Criteria) this;
        }

        public Criteria andLntIn(List<String> values) {
            addCriterion("lnt in", values, "lnt");
            return (Criteria) this;
        }

        public Criteria andLntNotIn(List<String> values) {
            addCriterion("lnt not in", values, "lnt");
            return (Criteria) this;
        }

        public Criteria andLntBetween(String value1, String value2) {
            addCriterion("lnt between", value1, value2, "lnt");
            return (Criteria) this;
        }

        public Criteria andLntNotBetween(String value1, String value2) {
            addCriterion("lnt not between", value1, value2, "lnt");
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
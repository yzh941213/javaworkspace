package com.aishidai.app.model.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserSizeDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserSizeDOExample() {
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

        public Criteria andSizeIdIsNull() {
            addCriterion("size_id is null");
            return (Criteria) this;
        }

        public Criteria andSizeIdIsNotNull() {
            addCriterion("size_id is not null");
            return (Criteria) this;
        }

        public Criteria andSizeIdEqualTo(Long value) {
            addCriterion("size_id =", value, "sizeId");
            return (Criteria) this;
        }

        public Criteria andSizeIdNotEqualTo(Long value) {
            addCriterion("size_id <>", value, "sizeId");
            return (Criteria) this;
        }

        public Criteria andSizeIdGreaterThan(Long value) {
            addCriterion("size_id >", value, "sizeId");
            return (Criteria) this;
        }

        public Criteria andSizeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("size_id >=", value, "sizeId");
            return (Criteria) this;
        }

        public Criteria andSizeIdLessThan(Long value) {
            addCriterion("size_id <", value, "sizeId");
            return (Criteria) this;
        }

        public Criteria andSizeIdLessThanOrEqualTo(Long value) {
            addCriterion("size_id <=", value, "sizeId");
            return (Criteria) this;
        }

        public Criteria andSizeIdIn(List<Long> values) {
            addCriterion("size_id in", values, "sizeId");
            return (Criteria) this;
        }

        public Criteria andSizeIdNotIn(List<Long> values) {
            addCriterion("size_id not in", values, "sizeId");
            return (Criteria) this;
        }

        public Criteria andSizeIdBetween(Long value1, Long value2) {
            addCriterion("size_id between", value1, value2, "sizeId");
            return (Criteria) this;
        }

        public Criteria andSizeIdNotBetween(Long value1, Long value2) {
            addCriterion("size_id not between", value1, value2, "sizeId");
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(String value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(String value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(String value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(String value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(String value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(String value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLike(String value) {
            addCriterion("height like", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotLike(String value) {
            addCriterion("height not like", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<String> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<String> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(String value1, String value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(String value1, String value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(String value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(String value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(String value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(String value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(String value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(String value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLike(String value) {
            addCriterion("weight like", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotLike(String value) {
            addCriterion("weight not like", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<String> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<String> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(String value1, String value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(String value1, String value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWaistIsNull() {
            addCriterion("waist is null");
            return (Criteria) this;
        }

        public Criteria andWaistIsNotNull() {
            addCriterion("waist is not null");
            return (Criteria) this;
        }

        public Criteria andWaistEqualTo(String value) {
            addCriterion("waist =", value, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistNotEqualTo(String value) {
            addCriterion("waist <>", value, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistGreaterThan(String value) {
            addCriterion("waist >", value, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistGreaterThanOrEqualTo(String value) {
            addCriterion("waist >=", value, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistLessThan(String value) {
            addCriterion("waist <", value, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistLessThanOrEqualTo(String value) {
            addCriterion("waist <=", value, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistLike(String value) {
            addCriterion("waist like", value, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistNotLike(String value) {
            addCriterion("waist not like", value, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistIn(List<String> values) {
            addCriterion("waist in", values, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistNotIn(List<String> values) {
            addCriterion("waist not in", values, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistBetween(String value1, String value2) {
            addCriterion("waist between", value1, value2, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistNotBetween(String value1, String value2) {
            addCriterion("waist not between", value1, value2, "waist");
            return (Criteria) this;
        }

        public Criteria andHipIsNull() {
            addCriterion("hip is null");
            return (Criteria) this;
        }

        public Criteria andHipIsNotNull() {
            addCriterion("hip is not null");
            return (Criteria) this;
        }

        public Criteria andHipEqualTo(String value) {
            addCriterion("hip =", value, "hip");
            return (Criteria) this;
        }

        public Criteria andHipNotEqualTo(String value) {
            addCriterion("hip <>", value, "hip");
            return (Criteria) this;
        }

        public Criteria andHipGreaterThan(String value) {
            addCriterion("hip >", value, "hip");
            return (Criteria) this;
        }

        public Criteria andHipGreaterThanOrEqualTo(String value) {
            addCriterion("hip >=", value, "hip");
            return (Criteria) this;
        }

        public Criteria andHipLessThan(String value) {
            addCriterion("hip <", value, "hip");
            return (Criteria) this;
        }

        public Criteria andHipLessThanOrEqualTo(String value) {
            addCriterion("hip <=", value, "hip");
            return (Criteria) this;
        }

        public Criteria andHipLike(String value) {
            addCriterion("hip like", value, "hip");
            return (Criteria) this;
        }

        public Criteria andHipNotLike(String value) {
            addCriterion("hip not like", value, "hip");
            return (Criteria) this;
        }

        public Criteria andHipIn(List<String> values) {
            addCriterion("hip in", values, "hip");
            return (Criteria) this;
        }

        public Criteria andHipNotIn(List<String> values) {
            addCriterion("hip not in", values, "hip");
            return (Criteria) this;
        }

        public Criteria andHipBetween(String value1, String value2) {
            addCriterion("hip between", value1, value2, "hip");
            return (Criteria) this;
        }

        public Criteria andHipNotBetween(String value1, String value2) {
            addCriterion("hip not between", value1, value2, "hip");
            return (Criteria) this;
        }

        public Criteria andBustIsNull() {
            addCriterion("bust is null");
            return (Criteria) this;
        }

        public Criteria andBustIsNotNull() {
            addCriterion("bust is not null");
            return (Criteria) this;
        }

        public Criteria andBustEqualTo(String value) {
            addCriterion("bust =", value, "bust");
            return (Criteria) this;
        }

        public Criteria andBustNotEqualTo(String value) {
            addCriterion("bust <>", value, "bust");
            return (Criteria) this;
        }

        public Criteria andBustGreaterThan(String value) {
            addCriterion("bust >", value, "bust");
            return (Criteria) this;
        }

        public Criteria andBustGreaterThanOrEqualTo(String value) {
            addCriterion("bust >=", value, "bust");
            return (Criteria) this;
        }

        public Criteria andBustLessThan(String value) {
            addCriterion("bust <", value, "bust");
            return (Criteria) this;
        }

        public Criteria andBustLessThanOrEqualTo(String value) {
            addCriterion("bust <=", value, "bust");
            return (Criteria) this;
        }

        public Criteria andBustLike(String value) {
            addCriterion("bust like", value, "bust");
            return (Criteria) this;
        }

        public Criteria andBustNotLike(String value) {
            addCriterion("bust not like", value, "bust");
            return (Criteria) this;
        }

        public Criteria andBustIn(List<String> values) {
            addCriterion("bust in", values, "bust");
            return (Criteria) this;
        }

        public Criteria andBustNotIn(List<String> values) {
            addCriterion("bust not in", values, "bust");
            return (Criteria) this;
        }

        public Criteria andBustBetween(String value1, String value2) {
            addCriterion("bust between", value1, value2, "bust");
            return (Criteria) this;
        }

        public Criteria andBustNotBetween(String value1, String value2) {
            addCriterion("bust not between", value1, value2, "bust");
            return (Criteria) this;
        }

        public Criteria andShoulderIsNull() {
            addCriterion("shoulder is null");
            return (Criteria) this;
        }

        public Criteria andShoulderIsNotNull() {
            addCriterion("shoulder is not null");
            return (Criteria) this;
        }

        public Criteria andShoulderEqualTo(String value) {
            addCriterion("shoulder =", value, "shoulder");
            return (Criteria) this;
        }

        public Criteria andShoulderNotEqualTo(String value) {
            addCriterion("shoulder <>", value, "shoulder");
            return (Criteria) this;
        }

        public Criteria andShoulderGreaterThan(String value) {
            addCriterion("shoulder >", value, "shoulder");
            return (Criteria) this;
        }

        public Criteria andShoulderGreaterThanOrEqualTo(String value) {
            addCriterion("shoulder >=", value, "shoulder");
            return (Criteria) this;
        }

        public Criteria andShoulderLessThan(String value) {
            addCriterion("shoulder <", value, "shoulder");
            return (Criteria) this;
        }

        public Criteria andShoulderLessThanOrEqualTo(String value) {
            addCriterion("shoulder <=", value, "shoulder");
            return (Criteria) this;
        }

        public Criteria andShoulderLike(String value) {
            addCriterion("shoulder like", value, "shoulder");
            return (Criteria) this;
        }

        public Criteria andShoulderNotLike(String value) {
            addCriterion("shoulder not like", value, "shoulder");
            return (Criteria) this;
        }

        public Criteria andShoulderIn(List<String> values) {
            addCriterion("shoulder in", values, "shoulder");
            return (Criteria) this;
        }

        public Criteria andShoulderNotIn(List<String> values) {
            addCriterion("shoulder not in", values, "shoulder");
            return (Criteria) this;
        }

        public Criteria andShoulderBetween(String value1, String value2) {
            addCriterion("shoulder between", value1, value2, "shoulder");
            return (Criteria) this;
        }

        public Criteria andShoulderNotBetween(String value1, String value2) {
            addCriterion("shoulder not between", value1, value2, "shoulder");
            return (Criteria) this;
        }

        public Criteria andThighIsNull() {
            addCriterion("thigh is null");
            return (Criteria) this;
        }

        public Criteria andThighIsNotNull() {
            addCriterion("thigh is not null");
            return (Criteria) this;
        }

        public Criteria andThighEqualTo(String value) {
            addCriterion("thigh =", value, "thigh");
            return (Criteria) this;
        }

        public Criteria andThighNotEqualTo(String value) {
            addCriterion("thigh <>", value, "thigh");
            return (Criteria) this;
        }

        public Criteria andThighGreaterThan(String value) {
            addCriterion("thigh >", value, "thigh");
            return (Criteria) this;
        }

        public Criteria andThighGreaterThanOrEqualTo(String value) {
            addCriterion("thigh >=", value, "thigh");
            return (Criteria) this;
        }

        public Criteria andThighLessThan(String value) {
            addCriterion("thigh <", value, "thigh");
            return (Criteria) this;
        }

        public Criteria andThighLessThanOrEqualTo(String value) {
            addCriterion("thigh <=", value, "thigh");
            return (Criteria) this;
        }

        public Criteria andThighLike(String value) {
            addCriterion("thigh like", value, "thigh");
            return (Criteria) this;
        }

        public Criteria andThighNotLike(String value) {
            addCriterion("thigh not like", value, "thigh");
            return (Criteria) this;
        }

        public Criteria andThighIn(List<String> values) {
            addCriterion("thigh in", values, "thigh");
            return (Criteria) this;
        }

        public Criteria andThighNotIn(List<String> values) {
            addCriterion("thigh not in", values, "thigh");
            return (Criteria) this;
        }

        public Criteria andThighBetween(String value1, String value2) {
            addCriterion("thigh between", value1, value2, "thigh");
            return (Criteria) this;
        }

        public Criteria andThighNotBetween(String value1, String value2) {
            addCriterion("thigh not between", value1, value2, "thigh");
            return (Criteria) this;
        }

        public Criteria andNeckIsNull() {
            addCriterion("neck is null");
            return (Criteria) this;
        }

        public Criteria andNeckIsNotNull() {
            addCriterion("neck is not null");
            return (Criteria) this;
        }

        public Criteria andNeckEqualTo(String value) {
            addCriterion("neck =", value, "neck");
            return (Criteria) this;
        }

        public Criteria andNeckNotEqualTo(String value) {
            addCriterion("neck <>", value, "neck");
            return (Criteria) this;
        }

        public Criteria andNeckGreaterThan(String value) {
            addCriterion("neck >", value, "neck");
            return (Criteria) this;
        }

        public Criteria andNeckGreaterThanOrEqualTo(String value) {
            addCriterion("neck >=", value, "neck");
            return (Criteria) this;
        }

        public Criteria andNeckLessThan(String value) {
            addCriterion("neck <", value, "neck");
            return (Criteria) this;
        }

        public Criteria andNeckLessThanOrEqualTo(String value) {
            addCriterion("neck <=", value, "neck");
            return (Criteria) this;
        }

        public Criteria andNeckLike(String value) {
            addCriterion("neck like", value, "neck");
            return (Criteria) this;
        }

        public Criteria andNeckNotLike(String value) {
            addCriterion("neck not like", value, "neck");
            return (Criteria) this;
        }

        public Criteria andNeckIn(List<String> values) {
            addCriterion("neck in", values, "neck");
            return (Criteria) this;
        }

        public Criteria andNeckNotIn(List<String> values) {
            addCriterion("neck not in", values, "neck");
            return (Criteria) this;
        }

        public Criteria andNeckBetween(String value1, String value2) {
            addCriterion("neck between", value1, value2, "neck");
            return (Criteria) this;
        }

        public Criteria andNeckNotBetween(String value1, String value2) {
            addCriterion("neck not between", value1, value2, "neck");
            return (Criteria) this;
        }

        public Criteria andUpperArmIsNull() {
            addCriterion("upper_arm is null");
            return (Criteria) this;
        }

        public Criteria andUpperArmIsNotNull() {
            addCriterion("upper_arm is not null");
            return (Criteria) this;
        }

        public Criteria andUpperArmEqualTo(String value) {
            addCriterion("upper_arm =", value, "upperArm");
            return (Criteria) this;
        }

        public Criteria andUpperArmNotEqualTo(String value) {
            addCriterion("upper_arm <>", value, "upperArm");
            return (Criteria) this;
        }

        public Criteria andUpperArmGreaterThan(String value) {
            addCriterion("upper_arm >", value, "upperArm");
            return (Criteria) this;
        }

        public Criteria andUpperArmGreaterThanOrEqualTo(String value) {
            addCriterion("upper_arm >=", value, "upperArm");
            return (Criteria) this;
        }

        public Criteria andUpperArmLessThan(String value) {
            addCriterion("upper_arm <", value, "upperArm");
            return (Criteria) this;
        }

        public Criteria andUpperArmLessThanOrEqualTo(String value) {
            addCriterion("upper_arm <=", value, "upperArm");
            return (Criteria) this;
        }

        public Criteria andUpperArmLike(String value) {
            addCriterion("upper_arm like", value, "upperArm");
            return (Criteria) this;
        }

        public Criteria andUpperArmNotLike(String value) {
            addCriterion("upper_arm not like", value, "upperArm");
            return (Criteria) this;
        }

        public Criteria andUpperArmIn(List<String> values) {
            addCriterion("upper_arm in", values, "upperArm");
            return (Criteria) this;
        }

        public Criteria andUpperArmNotIn(List<String> values) {
            addCriterion("upper_arm not in", values, "upperArm");
            return (Criteria) this;
        }

        public Criteria andUpperArmBetween(String value1, String value2) {
            addCriterion("upper_arm between", value1, value2, "upperArm");
            return (Criteria) this;
        }

        public Criteria andUpperArmNotBetween(String value1, String value2) {
            addCriterion("upper_arm not between", value1, value2, "upperArm");
            return (Criteria) this;
        }

        public Criteria andLowerArmIsNull() {
            addCriterion("lower_arm is null");
            return (Criteria) this;
        }

        public Criteria andLowerArmIsNotNull() {
            addCriterion("lower_arm is not null");
            return (Criteria) this;
        }

        public Criteria andLowerArmEqualTo(String value) {
            addCriterion("lower_arm =", value, "lowerArm");
            return (Criteria) this;
        }

        public Criteria andLowerArmNotEqualTo(String value) {
            addCriterion("lower_arm <>", value, "lowerArm");
            return (Criteria) this;
        }

        public Criteria andLowerArmGreaterThan(String value) {
            addCriterion("lower_arm >", value, "lowerArm");
            return (Criteria) this;
        }

        public Criteria andLowerArmGreaterThanOrEqualTo(String value) {
            addCriterion("lower_arm >=", value, "lowerArm");
            return (Criteria) this;
        }

        public Criteria andLowerArmLessThan(String value) {
            addCriterion("lower_arm <", value, "lowerArm");
            return (Criteria) this;
        }

        public Criteria andLowerArmLessThanOrEqualTo(String value) {
            addCriterion("lower_arm <=", value, "lowerArm");
            return (Criteria) this;
        }

        public Criteria andLowerArmLike(String value) {
            addCriterion("lower_arm like", value, "lowerArm");
            return (Criteria) this;
        }

        public Criteria andLowerArmNotLike(String value) {
            addCriterion("lower_arm not like", value, "lowerArm");
            return (Criteria) this;
        }

        public Criteria andLowerArmIn(List<String> values) {
            addCriterion("lower_arm in", values, "lowerArm");
            return (Criteria) this;
        }

        public Criteria andLowerArmNotIn(List<String> values) {
            addCriterion("lower_arm not in", values, "lowerArm");
            return (Criteria) this;
        }

        public Criteria andLowerArmBetween(String value1, String value2) {
            addCriterion("lower_arm between", value1, value2, "lowerArm");
            return (Criteria) this;
        }

        public Criteria andLowerArmNotBetween(String value1, String value2) {
            addCriterion("lower_arm not between", value1, value2, "lowerArm");
            return (Criteria) this;
        }

        public Criteria andFeatureIsNull() {
            addCriterion("feature is null");
            return (Criteria) this;
        }

        public Criteria andFeatureIsNotNull() {
            addCriterion("feature is not null");
            return (Criteria) this;
        }

        public Criteria andFeatureEqualTo(String value) {
            addCriterion("feature =", value, "feature");
            return (Criteria) this;
        }

        public Criteria andFeatureNotEqualTo(String value) {
            addCriterion("feature <>", value, "feature");
            return (Criteria) this;
        }

        public Criteria andFeatureGreaterThan(String value) {
            addCriterion("feature >", value, "feature");
            return (Criteria) this;
        }

        public Criteria andFeatureGreaterThanOrEqualTo(String value) {
            addCriterion("feature >=", value, "feature");
            return (Criteria) this;
        }

        public Criteria andFeatureLessThan(String value) {
            addCriterion("feature <", value, "feature");
            return (Criteria) this;
        }

        public Criteria andFeatureLessThanOrEqualTo(String value) {
            addCriterion("feature <=", value, "feature");
            return (Criteria) this;
        }

        public Criteria andFeatureLike(String value) {
            addCriterion("feature like", value, "feature");
            return (Criteria) this;
        }

        public Criteria andFeatureNotLike(String value) {
            addCriterion("feature not like", value, "feature");
            return (Criteria) this;
        }

        public Criteria andFeatureIn(List<String> values) {
            addCriterion("feature in", values, "feature");
            return (Criteria) this;
        }

        public Criteria andFeatureNotIn(List<String> values) {
            addCriterion("feature not in", values, "feature");
            return (Criteria) this;
        }

        public Criteria andFeatureBetween(String value1, String value2) {
            addCriterion("feature between", value1, value2, "feature");
            return (Criteria) this;
        }

        public Criteria andFeatureNotBetween(String value1, String value2) {
            addCriterion("feature not between", value1, value2, "feature");
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

        public Criteria andCreatedEqualTo(Long value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Long value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Long value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Long value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Long value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Long value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Long> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Long> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Long value1, Long value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Long value1, Long value2) {
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

        public Criteria andUpdatedEqualTo(Long value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Long value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Long value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Long value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Long value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Long value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Long> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Long> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Long value1, Long value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Long value1, Long value2) {
            addCriterion("updated not between", value1, value2, "updated");
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

        public Criteria andIsDefaultIsNull() {
            addCriterion("is_default is null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNotNull() {
            addCriterion("is_default is not null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultEqualTo(Byte value) {
            addCriterion("is_default =", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotEqualTo(Byte value) {
            addCriterion("is_default <>", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThan(Byte value) {
            addCriterion("is_default >", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_default >=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThan(Byte value) {
            addCriterion("is_default <", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThanOrEqualTo(Byte value) {
            addCriterion("is_default <=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIn(List<Byte> values) {
            addCriterion("is_default in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotIn(List<Byte> values) {
            addCriterion("is_default not in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultBetween(Byte value1, Byte value2) {
            addCriterion("is_default between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotBetween(Byte value1, Byte value2) {
            addCriterion("is_default not between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andModCountIsNull() {
            addCriterion("mod_count is null");
            return (Criteria) this;
        }

        public Criteria andModCountIsNotNull() {
            addCriterion("mod_count is not null");
            return (Criteria) this;
        }

        public Criteria andModCountEqualTo(String value) {
            addCriterion("mod_count =", value, "modCount");
            return (Criteria) this;
        }

        public Criteria andModCountNotEqualTo(String value) {
            addCriterion("mod_count <>", value, "modCount");
            return (Criteria) this;
        }

        public Criteria andModCountGreaterThan(String value) {
            addCriterion("mod_count >", value, "modCount");
            return (Criteria) this;
        }

        public Criteria andModCountGreaterThanOrEqualTo(String value) {
            addCriterion("mod_count >=", value, "modCount");
            return (Criteria) this;
        }

        public Criteria andModCountLessThan(String value) {
            addCriterion("mod_count <", value, "modCount");
            return (Criteria) this;
        }

        public Criteria andModCountLessThanOrEqualTo(String value) {
            addCriterion("mod_count <=", value, "modCount");
            return (Criteria) this;
        }

        public Criteria andModCountLike(String value) {
            addCriterion("mod_count like", value, "modCount");
            return (Criteria) this;
        }

        public Criteria andModCountNotLike(String value) {
            addCriterion("mod_count not like", value, "modCount");
            return (Criteria) this;
        }

        public Criteria andModCountIn(List<String> values) {
            addCriterion("mod_count in", values, "modCount");
            return (Criteria) this;
        }

        public Criteria andModCountNotIn(List<String> values) {
            addCriterion("mod_count not in", values, "modCount");
            return (Criteria) this;
        }

        public Criteria andModCountBetween(String value1, String value2) {
            addCriterion("mod_count between", value1, value2, "modCount");
            return (Criteria) this;
        }

        public Criteria andModCountNotBetween(String value1, String value2) {
            addCriterion("mod_count not between", value1, value2, "modCount");
            return (Criteria) this;
        }

        public Criteria andRephotographIsNull() {
            addCriterion("rephotograph is null");
            return (Criteria) this;
        }

        public Criteria andRephotographIsNotNull() {
            addCriterion("rephotograph is not null");
            return (Criteria) this;
        }

        public Criteria andRephotographEqualTo(String value) {
            addCriterion("rephotograph =", value, "rephotograph");
            return (Criteria) this;
        }

        public Criteria andRephotographNotEqualTo(String value) {
            addCriterion("rephotograph <>", value, "rephotograph");
            return (Criteria) this;
        }

        public Criteria andRephotographGreaterThan(String value) {
            addCriterion("rephotograph >", value, "rephotograph");
            return (Criteria) this;
        }

        public Criteria andRephotographGreaterThanOrEqualTo(String value) {
            addCriterion("rephotograph >=", value, "rephotograph");
            return (Criteria) this;
        }

        public Criteria andRephotographLessThan(String value) {
            addCriterion("rephotograph <", value, "rephotograph");
            return (Criteria) this;
        }

        public Criteria andRephotographLessThanOrEqualTo(String value) {
            addCriterion("rephotograph <=", value, "rephotograph");
            return (Criteria) this;
        }

        public Criteria andRephotographLike(String value) {
            addCriterion("rephotograph like", value, "rephotograph");
            return (Criteria) this;
        }

        public Criteria andRephotographNotLike(String value) {
            addCriterion("rephotograph not like", value, "rephotograph");
            return (Criteria) this;
        }

        public Criteria andRephotographIn(List<String> values) {
            addCriterion("rephotograph in", values, "rephotograph");
            return (Criteria) this;
        }

        public Criteria andRephotographNotIn(List<String> values) {
            addCriterion("rephotograph not in", values, "rephotograph");
            return (Criteria) this;
        }

        public Criteria andRephotographBetween(String value1, String value2) {
            addCriterion("rephotograph between", value1, value2, "rephotograph");
            return (Criteria) this;
        }

        public Criteria andRephotographNotBetween(String value1, String value2) {
            addCriterion("rephotograph not between", value1, value2, "rephotograph");
            return (Criteria) this;
        }

        public Criteria andScanImesIsNull() {
            addCriterion("scan_imes is null");
            return (Criteria) this;
        }

        public Criteria andScanImesIsNotNull() {
            addCriterion("scan_imes is not null");
            return (Criteria) this;
        }

        public Criteria andScanImesEqualTo(String value) {
            addCriterion("scan_imes =", value, "scanImes");
            return (Criteria) this;
        }

        public Criteria andScanImesNotEqualTo(String value) {
            addCriterion("scan_imes <>", value, "scanImes");
            return (Criteria) this;
        }

        public Criteria andScanImesGreaterThan(String value) {
            addCriterion("scan_imes >", value, "scanImes");
            return (Criteria) this;
        }

        public Criteria andScanImesGreaterThanOrEqualTo(String value) {
            addCriterion("scan_imes >=", value, "scanImes");
            return (Criteria) this;
        }

        public Criteria andScanImesLessThan(String value) {
            addCriterion("scan_imes <", value, "scanImes");
            return (Criteria) this;
        }

        public Criteria andScanImesLessThanOrEqualTo(String value) {
            addCriterion("scan_imes <=", value, "scanImes");
            return (Criteria) this;
        }

        public Criteria andScanImesLike(String value) {
            addCriterion("scan_imes like", value, "scanImes");
            return (Criteria) this;
        }

        public Criteria andScanImesNotLike(String value) {
            addCriterion("scan_imes not like", value, "scanImes");
            return (Criteria) this;
        }

        public Criteria andScanImesIn(List<String> values) {
            addCriterion("scan_imes in", values, "scanImes");
            return (Criteria) this;
        }

        public Criteria andScanImesNotIn(List<String> values) {
            addCriterion("scan_imes not in", values, "scanImes");
            return (Criteria) this;
        }

        public Criteria andScanImesBetween(String value1, String value2) {
            addCriterion("scan_imes between", value1, value2, "scanImes");
            return (Criteria) this;
        }

        public Criteria andScanImesNotBetween(String value1, String value2) {
            addCriterion("scan_imes not between", value1, value2, "scanImes");
            return (Criteria) this;
        }

        public Criteria andProportionIsNull() {
            addCriterion("proportion is null");
            return (Criteria) this;
        }

        public Criteria andProportionIsNotNull() {
            addCriterion("proportion is not null");
            return (Criteria) this;
        }

        public Criteria andProportionEqualTo(String value) {
            addCriterion("proportion =", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionNotEqualTo(String value) {
            addCriterion("proportion <>", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionGreaterThan(String value) {
            addCriterion("proportion >", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionGreaterThanOrEqualTo(String value) {
            addCriterion("proportion >=", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionLessThan(String value) {
            addCriterion("proportion <", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionLessThanOrEqualTo(String value) {
            addCriterion("proportion <=", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionLike(String value) {
            addCriterion("proportion like", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionNotLike(String value) {
            addCriterion("proportion not like", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionIn(List<String> values) {
            addCriterion("proportion in", values, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionNotIn(List<String> values) {
            addCriterion("proportion not in", values, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionBetween(String value1, String value2) {
            addCriterion("proportion between", value1, value2, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionNotBetween(String value1, String value2) {
            addCriterion("proportion not between", value1, value2, "proportion");
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
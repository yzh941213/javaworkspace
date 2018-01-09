package com.aishidai.app.model.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommissionMoneyDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommissionMoneyDOExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andHqAmountIsNull() {
            addCriterion("hq_amount is null");
            return (Criteria) this;
        }

        public Criteria andHqAmountIsNotNull() {
            addCriterion("hq_amount is not null");
            return (Criteria) this;
        }

        public Criteria andHqAmountEqualTo(String value) {
            addCriterion("hq_amount =", value, "hqAmount");
            return (Criteria) this;
        }

        public Criteria andHqAmountNotEqualTo(String value) {
            addCriterion("hq_amount <>", value, "hqAmount");
            return (Criteria) this;
        }

        public Criteria andHqAmountGreaterThan(String value) {
            addCriterion("hq_amount >", value, "hqAmount");
            return (Criteria) this;
        }

        public Criteria andHqAmountGreaterThanOrEqualTo(String value) {
            addCriterion("hq_amount >=", value, "hqAmount");
            return (Criteria) this;
        }

        public Criteria andHqAmountLessThan(String value) {
            addCriterion("hq_amount <", value, "hqAmount");
            return (Criteria) this;
        }

        public Criteria andHqAmountLessThanOrEqualTo(String value) {
            addCriterion("hq_amount <=", value, "hqAmount");
            return (Criteria) this;
        }

        public Criteria andHqAmountLike(String value) {
            addCriterion("hq_amount like", value, "hqAmount");
            return (Criteria) this;
        }

        public Criteria andHqAmountNotLike(String value) {
            addCriterion("hq_amount not like", value, "hqAmount");
            return (Criteria) this;
        }

        public Criteria andHqAmountIn(List<String> values) {
            addCriterion("hq_amount in", values, "hqAmount");
            return (Criteria) this;
        }

        public Criteria andHqAmountNotIn(List<String> values) {
            addCriterion("hq_amount not in", values, "hqAmount");
            return (Criteria) this;
        }

        public Criteria andHqAmountBetween(String value1, String value2) {
            addCriterion("hq_amount between", value1, value2, "hqAmount");
            return (Criteria) this;
        }

        public Criteria andHqAmountNotBetween(String value1, String value2) {
            addCriterion("hq_amount not between", value1, value2, "hqAmount");
            return (Criteria) this;
        }

        public Criteria andDistributorAmountIsNull() {
            addCriterion("distributor_amount is null");
            return (Criteria) this;
        }

        public Criteria andDistributorAmountIsNotNull() {
            addCriterion("distributor_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDistributorAmountEqualTo(String value) {
            addCriterion("distributor_amount =", value, "distributorAmount");
            return (Criteria) this;
        }

        public Criteria andDistributorAmountNotEqualTo(String value) {
            addCriterion("distributor_amount <>", value, "distributorAmount");
            return (Criteria) this;
        }

        public Criteria andDistributorAmountGreaterThan(String value) {
            addCriterion("distributor_amount >", value, "distributorAmount");
            return (Criteria) this;
        }

        public Criteria andDistributorAmountGreaterThanOrEqualTo(String value) {
            addCriterion("distributor_amount >=", value, "distributorAmount");
            return (Criteria) this;
        }

        public Criteria andDistributorAmountLessThan(String value) {
            addCriterion("distributor_amount <", value, "distributorAmount");
            return (Criteria) this;
        }

        public Criteria andDistributorAmountLessThanOrEqualTo(String value) {
            addCriterion("distributor_amount <=", value, "distributorAmount");
            return (Criteria) this;
        }

        public Criteria andDistributorAmountLike(String value) {
            addCriterion("distributor_amount like", value, "distributorAmount");
            return (Criteria) this;
        }

        public Criteria andDistributorAmountNotLike(String value) {
            addCriterion("distributor_amount not like", value, "distributorAmount");
            return (Criteria) this;
        }

        public Criteria andDistributorAmountIn(List<String> values) {
            addCriterion("distributor_amount in", values, "distributorAmount");
            return (Criteria) this;
        }

        public Criteria andDistributorAmountNotIn(List<String> values) {
            addCriterion("distributor_amount not in", values, "distributorAmount");
            return (Criteria) this;
        }

        public Criteria andDistributorAmountBetween(String value1, String value2) {
            addCriterion("distributor_amount between", value1, value2, "distributorAmount");
            return (Criteria) this;
        }

        public Criteria andDistributorAmountNotBetween(String value1, String value2) {
            addCriterion("distributor_amount not between", value1, value2, "distributorAmount");
            return (Criteria) this;
        }

        public Criteria andOthershopAmountIsNull() {
            addCriterion("othershop_amount is null");
            return (Criteria) this;
        }

        public Criteria andOthershopAmountIsNotNull() {
            addCriterion("othershop_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOthershopAmountEqualTo(String value) {
            addCriterion("othershop_amount =", value, "othershopAmount");
            return (Criteria) this;
        }

        public Criteria andOthershopAmountNotEqualTo(String value) {
            addCriterion("othershop_amount <>", value, "othershopAmount");
            return (Criteria) this;
        }

        public Criteria andOthershopAmountGreaterThan(String value) {
            addCriterion("othershop_amount >", value, "othershopAmount");
            return (Criteria) this;
        }

        public Criteria andOthershopAmountGreaterThanOrEqualTo(String value) {
            addCriterion("othershop_amount >=", value, "othershopAmount");
            return (Criteria) this;
        }

        public Criteria andOthershopAmountLessThan(String value) {
            addCriterion("othershop_amount <", value, "othershopAmount");
            return (Criteria) this;
        }

        public Criteria andOthershopAmountLessThanOrEqualTo(String value) {
            addCriterion("othershop_amount <=", value, "othershopAmount");
            return (Criteria) this;
        }

        public Criteria andOthershopAmountLike(String value) {
            addCriterion("othershop_amount like", value, "othershopAmount");
            return (Criteria) this;
        }

        public Criteria andOthershopAmountNotLike(String value) {
            addCriterion("othershop_amount not like", value, "othershopAmount");
            return (Criteria) this;
        }

        public Criteria andOthershopAmountIn(List<String> values) {
            addCriterion("othershop_amount in", values, "othershopAmount");
            return (Criteria) this;
        }

        public Criteria andOthershopAmountNotIn(List<String> values) {
            addCriterion("othershop_amount not in", values, "othershopAmount");
            return (Criteria) this;
        }

        public Criteria andOthershopAmountBetween(String value1, String value2) {
            addCriterion("othershop_amount between", value1, value2, "othershopAmount");
            return (Criteria) this;
        }

        public Criteria andOthershopAmountNotBetween(String value1, String value2) {
            addCriterion("othershop_amount not between", value1, value2, "othershopAmount");
            return (Criteria) this;
        }

        public Criteria andMakerAmountIsNull() {
            addCriterion("maker_amount is null");
            return (Criteria) this;
        }

        public Criteria andMakerAmountIsNotNull() {
            addCriterion("maker_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMakerAmountEqualTo(String value) {
            addCriterion("maker_amount =", value, "makerAmount");
            return (Criteria) this;
        }

        public Criteria andMakerAmountNotEqualTo(String value) {
            addCriterion("maker_amount <>", value, "makerAmount");
            return (Criteria) this;
        }

        public Criteria andMakerAmountGreaterThan(String value) {
            addCriterion("maker_amount >", value, "makerAmount");
            return (Criteria) this;
        }

        public Criteria andMakerAmountGreaterThanOrEqualTo(String value) {
            addCriterion("maker_amount >=", value, "makerAmount");
            return (Criteria) this;
        }

        public Criteria andMakerAmountLessThan(String value) {
            addCriterion("maker_amount <", value, "makerAmount");
            return (Criteria) this;
        }

        public Criteria andMakerAmountLessThanOrEqualTo(String value) {
            addCriterion("maker_amount <=", value, "makerAmount");
            return (Criteria) this;
        }

        public Criteria andMakerAmountLike(String value) {
            addCriterion("maker_amount like", value, "makerAmount");
            return (Criteria) this;
        }

        public Criteria andMakerAmountNotLike(String value) {
            addCriterion("maker_amount not like", value, "makerAmount");
            return (Criteria) this;
        }

        public Criteria andMakerAmountIn(List<String> values) {
            addCriterion("maker_amount in", values, "makerAmount");
            return (Criteria) this;
        }

        public Criteria andMakerAmountNotIn(List<String> values) {
            addCriterion("maker_amount not in", values, "makerAmount");
            return (Criteria) this;
        }

        public Criteria andMakerAmountBetween(String value1, String value2) {
            addCriterion("maker_amount between", value1, value2, "makerAmount");
            return (Criteria) this;
        }

        public Criteria andMakerAmountNotBetween(String value1, String value2) {
            addCriterion("maker_amount not between", value1, value2, "makerAmount");
            return (Criteria) this;
        }

        public Criteria andShopAmountIsNull() {
            addCriterion("shop_amount is null");
            return (Criteria) this;
        }

        public Criteria andShopAmountIsNotNull() {
            addCriterion("shop_amount is not null");
            return (Criteria) this;
        }

        public Criteria andShopAmountEqualTo(String value) {
            addCriterion("shop_amount =", value, "shopAmount");
            return (Criteria) this;
        }

        public Criteria andShopAmountNotEqualTo(String value) {
            addCriterion("shop_amount <>", value, "shopAmount");
            return (Criteria) this;
        }

        public Criteria andShopAmountGreaterThan(String value) {
            addCriterion("shop_amount >", value, "shopAmount");
            return (Criteria) this;
        }

        public Criteria andShopAmountGreaterThanOrEqualTo(String value) {
            addCriterion("shop_amount >=", value, "shopAmount");
            return (Criteria) this;
        }

        public Criteria andShopAmountLessThan(String value) {
            addCriterion("shop_amount <", value, "shopAmount");
            return (Criteria) this;
        }

        public Criteria andShopAmountLessThanOrEqualTo(String value) {
            addCriterion("shop_amount <=", value, "shopAmount");
            return (Criteria) this;
        }

        public Criteria andShopAmountLike(String value) {
            addCriterion("shop_amount like", value, "shopAmount");
            return (Criteria) this;
        }

        public Criteria andShopAmountNotLike(String value) {
            addCriterion("shop_amount not like", value, "shopAmount");
            return (Criteria) this;
        }

        public Criteria andShopAmountIn(List<String> values) {
            addCriterion("shop_amount in", values, "shopAmount");
            return (Criteria) this;
        }

        public Criteria andShopAmountNotIn(List<String> values) {
            addCriterion("shop_amount not in", values, "shopAmount");
            return (Criteria) this;
        }

        public Criteria andShopAmountBetween(String value1, String value2) {
            addCriterion("shop_amount between", value1, value2, "shopAmount");
            return (Criteria) this;
        }

        public Criteria andShopAmountNotBetween(String value1, String value2) {
            addCriterion("shop_amount not between", value1, value2, "shopAmount");
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

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
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
package com.aishidai.app.model.pojo;

import java.util.ArrayList;
import java.util.List;

public class AppPanelDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppPanelDOExample() {
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

        public Criteria andPanelIdIsNull() {
            addCriterion("panel_id is null");
            return (Criteria) this;
        }

        public Criteria andPanelIdIsNotNull() {
            addCriterion("panel_id is not null");
            return (Criteria) this;
        }

        public Criteria andPanelIdEqualTo(Long value) {
            addCriterion("panel_id =", value, "panelId");
            return (Criteria) this;
        }

        public Criteria andPanelIdNotEqualTo(Long value) {
            addCriterion("panel_id <>", value, "panelId");
            return (Criteria) this;
        }

        public Criteria andPanelIdGreaterThan(Long value) {
            addCriterion("panel_id >", value, "panelId");
            return (Criteria) this;
        }

        public Criteria andPanelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("panel_id >=", value, "panelId");
            return (Criteria) this;
        }

        public Criteria andPanelIdLessThan(Long value) {
            addCriterion("panel_id <", value, "panelId");
            return (Criteria) this;
        }

        public Criteria andPanelIdLessThanOrEqualTo(Long value) {
            addCriterion("panel_id <=", value, "panelId");
            return (Criteria) this;
        }

        public Criteria andPanelIdIn(List<Long> values) {
            addCriterion("panel_id in", values, "panelId");
            return (Criteria) this;
        }

        public Criteria andPanelIdNotIn(List<Long> values) {
            addCriterion("panel_id not in", values, "panelId");
            return (Criteria) this;
        }

        public Criteria andPanelIdBetween(Long value1, Long value2) {
            addCriterion("panel_id between", value1, value2, "panelId");
            return (Criteria) this;
        }

        public Criteria andPanelIdNotBetween(Long value1, Long value2) {
            addCriterion("panel_id not between", value1, value2, "panelId");
            return (Criteria) this;
        }

        public Criteria andPanelCodeIsNull() {
            addCriterion("panel_code is null");
            return (Criteria) this;
        }

        public Criteria andPanelCodeIsNotNull() {
            addCriterion("panel_code is not null");
            return (Criteria) this;
        }

        public Criteria andPanelCodeEqualTo(String value) {
            addCriterion("panel_code =", value, "panelCode");
            return (Criteria) this;
        }

        public Criteria andPanelCodeNotEqualTo(String value) {
            addCriterion("panel_code <>", value, "panelCode");
            return (Criteria) this;
        }

        public Criteria andPanelCodeGreaterThan(String value) {
            addCriterion("panel_code >", value, "panelCode");
            return (Criteria) this;
        }

        public Criteria andPanelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("panel_code >=", value, "panelCode");
            return (Criteria) this;
        }

        public Criteria andPanelCodeLessThan(String value) {
            addCriterion("panel_code <", value, "panelCode");
            return (Criteria) this;
        }

        public Criteria andPanelCodeLessThanOrEqualTo(String value) {
            addCriterion("panel_code <=", value, "panelCode");
            return (Criteria) this;
        }

        public Criteria andPanelCodeLike(String value) {
            addCriterion("panel_code like", value, "panelCode");
            return (Criteria) this;
        }

        public Criteria andPanelCodeNotLike(String value) {
            addCriterion("panel_code not like", value, "panelCode");
            return (Criteria) this;
        }

        public Criteria andPanelCodeIn(List<String> values) {
            addCriterion("panel_code in", values, "panelCode");
            return (Criteria) this;
        }

        public Criteria andPanelCodeNotIn(List<String> values) {
            addCriterion("panel_code not in", values, "panelCode");
            return (Criteria) this;
        }

        public Criteria andPanelCodeBetween(String value1, String value2) {
            addCriterion("panel_code between", value1, value2, "panelCode");
            return (Criteria) this;
        }

        public Criteria andPanelCodeNotBetween(String value1, String value2) {
            addCriterion("panel_code not between", value1, value2, "panelCode");
            return (Criteria) this;
        }

        public Criteria andPanelNameIsNull() {
            addCriterion("panel_name is null");
            return (Criteria) this;
        }

        public Criteria andPanelNameIsNotNull() {
            addCriterion("panel_name is not null");
            return (Criteria) this;
        }

        public Criteria andPanelNameEqualTo(String value) {
            addCriterion("panel_name =", value, "panelName");
            return (Criteria) this;
        }

        public Criteria andPanelNameNotEqualTo(String value) {
            addCriterion("panel_name <>", value, "panelName");
            return (Criteria) this;
        }

        public Criteria andPanelNameGreaterThan(String value) {
            addCriterion("panel_name >", value, "panelName");
            return (Criteria) this;
        }

        public Criteria andPanelNameGreaterThanOrEqualTo(String value) {
            addCriterion("panel_name >=", value, "panelName");
            return (Criteria) this;
        }

        public Criteria andPanelNameLessThan(String value) {
            addCriterion("panel_name <", value, "panelName");
            return (Criteria) this;
        }

        public Criteria andPanelNameLessThanOrEqualTo(String value) {
            addCriterion("panel_name <=", value, "panelName");
            return (Criteria) this;
        }

        public Criteria andPanelNameLike(String value) {
            addCriterion("panel_name like", value, "panelName");
            return (Criteria) this;
        }

        public Criteria andPanelNameNotLike(String value) {
            addCriterion("panel_name not like", value, "panelName");
            return (Criteria) this;
        }

        public Criteria andPanelNameIn(List<String> values) {
            addCriterion("panel_name in", values, "panelName");
            return (Criteria) this;
        }

        public Criteria andPanelNameNotIn(List<String> values) {
            addCriterion("panel_name not in", values, "panelName");
            return (Criteria) this;
        }

        public Criteria andPanelNameBetween(String value1, String value2) {
            addCriterion("panel_name between", value1, value2, "panelName");
            return (Criteria) this;
        }

        public Criteria andPanelNameNotBetween(String value1, String value2) {
            addCriterion("panel_name not between", value1, value2, "panelName");
            return (Criteria) this;
        }

        public Criteria andSortingIsNull() {
            addCriterion("sorting is null");
            return (Criteria) this;
        }

        public Criteria andSortingIsNotNull() {
            addCriterion("sorting is not null");
            return (Criteria) this;
        }

        public Criteria andSortingEqualTo(String value) {
            addCriterion("sorting =", value, "sorting");
            return (Criteria) this;
        }

        public Criteria andSortingNotEqualTo(String value) {
            addCriterion("sorting <>", value, "sorting");
            return (Criteria) this;
        }

        public Criteria andSortingGreaterThan(String value) {
            addCriterion("sorting >", value, "sorting");
            return (Criteria) this;
        }

        public Criteria andSortingGreaterThanOrEqualTo(String value) {
            addCriterion("sorting >=", value, "sorting");
            return (Criteria) this;
        }

        public Criteria andSortingLessThan(String value) {
            addCriterion("sorting <", value, "sorting");
            return (Criteria) this;
        }

        public Criteria andSortingLessThanOrEqualTo(String value) {
            addCriterion("sorting <=", value, "sorting");
            return (Criteria) this;
        }

        public Criteria andSortingLike(String value) {
            addCriterion("sorting like", value, "sorting");
            return (Criteria) this;
        }

        public Criteria andSortingNotLike(String value) {
            addCriterion("sorting not like", value, "sorting");
            return (Criteria) this;
        }

        public Criteria andSortingIn(List<String> values) {
            addCriterion("sorting in", values, "sorting");
            return (Criteria) this;
        }

        public Criteria andSortingNotIn(List<String> values) {
            addCriterion("sorting not in", values, "sorting");
            return (Criteria) this;
        }

        public Criteria andSortingBetween(String value1, String value2) {
            addCriterion("sorting between", value1, value2, "sorting");
            return (Criteria) this;
        }

        public Criteria andSortingNotBetween(String value1, String value2) {
            addCriterion("sorting not between", value1, value2, "sorting");
            return (Criteria) this;
        }

        public Criteria andJumpPageIsNull() {
            addCriterion("jump_page is null");
            return (Criteria) this;
        }

        public Criteria andJumpPageIsNotNull() {
            addCriterion("jump_page is not null");
            return (Criteria) this;
        }

        public Criteria andJumpPageEqualTo(String value) {
            addCriterion("jump_page =", value, "jumpPage");
            return (Criteria) this;
        }

        public Criteria andJumpPageNotEqualTo(String value) {
            addCriterion("jump_page <>", value, "jumpPage");
            return (Criteria) this;
        }

        public Criteria andJumpPageGreaterThan(String value) {
            addCriterion("jump_page >", value, "jumpPage");
            return (Criteria) this;
        }

        public Criteria andJumpPageGreaterThanOrEqualTo(String value) {
            addCriterion("jump_page >=", value, "jumpPage");
            return (Criteria) this;
        }

        public Criteria andJumpPageLessThan(String value) {
            addCriterion("jump_page <", value, "jumpPage");
            return (Criteria) this;
        }

        public Criteria andJumpPageLessThanOrEqualTo(String value) {
            addCriterion("jump_page <=", value, "jumpPage");
            return (Criteria) this;
        }

        public Criteria andJumpPageLike(String value) {
            addCriterion("jump_page like", value, "jumpPage");
            return (Criteria) this;
        }

        public Criteria andJumpPageNotLike(String value) {
            addCriterion("jump_page not like", value, "jumpPage");
            return (Criteria) this;
        }

        public Criteria andJumpPageIn(List<String> values) {
            addCriterion("jump_page in", values, "jumpPage");
            return (Criteria) this;
        }

        public Criteria andJumpPageNotIn(List<String> values) {
            addCriterion("jump_page not in", values, "jumpPage");
            return (Criteria) this;
        }

        public Criteria andJumpPageBetween(String value1, String value2) {
            addCriterion("jump_page between", value1, value2, "jumpPage");
            return (Criteria) this;
        }

        public Criteria andJumpPageNotBetween(String value1, String value2) {
            addCriterion("jump_page not between", value1, value2, "jumpPage");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNull() {
            addCriterion("img_url is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNotNull() {
            addCriterion("img_url is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlEqualTo(String value) {
            addCriterion("img_url =", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotEqualTo(String value) {
            addCriterion("img_url <>", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThan(String value) {
            addCriterion("img_url >", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("img_url >=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThan(String value) {
            addCriterion("img_url <", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThanOrEqualTo(String value) {
            addCriterion("img_url <=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLike(String value) {
            addCriterion("img_url like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotLike(String value) {
            addCriterion("img_url not like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlIn(List<String> values) {
            addCriterion("img_url in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotIn(List<String> values) {
            addCriterion("img_url not in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlBetween(String value1, String value2) {
            addCriterion("img_url between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotBetween(String value1, String value2) {
            addCriterion("img_url not between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNull() {
            addCriterion("is_show is null");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNotNull() {
            addCriterion("is_show is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowEqualTo(Integer value) {
            addCriterion("is_show =", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotEqualTo(Integer value) {
            addCriterion("is_show <>", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThan(Integer value) {
            addCriterion("is_show >", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_show >=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThan(Integer value) {
            addCriterion("is_show <", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThanOrEqualTo(Integer value) {
            addCriterion("is_show <=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowIn(List<Integer> values) {
            addCriterion("is_show in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotIn(List<Integer> values) {
            addCriterion("is_show not in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowBetween(Integer value1, Integer value2) {
            addCriterion("is_show between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotBetween(Integer value1, Integer value2) {
            addCriterion("is_show not between", value1, value2, "isShow");
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
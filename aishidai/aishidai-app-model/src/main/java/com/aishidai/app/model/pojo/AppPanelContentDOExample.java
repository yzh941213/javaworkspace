package com.aishidai.app.model.pojo;

import java.util.ArrayList;
import java.util.List;

public class AppPanelContentDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppPanelContentDOExample() {
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

        public Criteria andPanelContentIdIsNull() {
            addCriterion("panel_content_id is null");
            return (Criteria) this;
        }

        public Criteria andPanelContentIdIsNotNull() {
            addCriterion("panel_content_id is not null");
            return (Criteria) this;
        }

        public Criteria andPanelContentIdEqualTo(Long value) {
            addCriterion("panel_content_id =", value, "panelContentId");
            return (Criteria) this;
        }

        public Criteria andPanelContentIdNotEqualTo(Long value) {
            addCriterion("panel_content_id <>", value, "panelContentId");
            return (Criteria) this;
        }

        public Criteria andPanelContentIdGreaterThan(Long value) {
            addCriterion("panel_content_id >", value, "panelContentId");
            return (Criteria) this;
        }

        public Criteria andPanelContentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("panel_content_id >=", value, "panelContentId");
            return (Criteria) this;
        }

        public Criteria andPanelContentIdLessThan(Long value) {
            addCriterion("panel_content_id <", value, "panelContentId");
            return (Criteria) this;
        }

        public Criteria andPanelContentIdLessThanOrEqualTo(Long value) {
            addCriterion("panel_content_id <=", value, "panelContentId");
            return (Criteria) this;
        }

        public Criteria andPanelContentIdIn(List<Long> values) {
            addCriterion("panel_content_id in", values, "panelContentId");
            return (Criteria) this;
        }

        public Criteria andPanelContentIdNotIn(List<Long> values) {
            addCriterion("panel_content_id not in", values, "panelContentId");
            return (Criteria) this;
        }

        public Criteria andPanelContentIdBetween(Long value1, Long value2) {
            addCriterion("panel_content_id between", value1, value2, "panelContentId");
            return (Criteria) this;
        }

        public Criteria andPanelContentIdNotBetween(Long value1, Long value2) {
            addCriterion("panel_content_id not between", value1, value2, "panelContentId");
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andIsH5IsNull() {
            addCriterion("is_h5 is null");
            return (Criteria) this;
        }

        public Criteria andIsH5IsNotNull() {
            addCriterion("is_h5 is not null");
            return (Criteria) this;
        }

        public Criteria andIsH5EqualTo(String value) {
            addCriterion("is_h5 =", value, "isH5");
            return (Criteria) this;
        }

        public Criteria andIsH5NotEqualTo(String value) {
            addCriterion("is_h5 <>", value, "isH5");
            return (Criteria) this;
        }

        public Criteria andIsH5GreaterThan(String value) {
            addCriterion("is_h5 >", value, "isH5");
            return (Criteria) this;
        }

        public Criteria andIsH5GreaterThanOrEqualTo(String value) {
            addCriterion("is_h5 >=", value, "isH5");
            return (Criteria) this;
        }

        public Criteria andIsH5LessThan(String value) {
            addCriterion("is_h5 <", value, "isH5");
            return (Criteria) this;
        }

        public Criteria andIsH5LessThanOrEqualTo(String value) {
            addCriterion("is_h5 <=", value, "isH5");
            return (Criteria) this;
        }

        public Criteria andIsH5Like(String value) {
            addCriterion("is_h5 like", value, "isH5");
            return (Criteria) this;
        }

        public Criteria andIsH5NotLike(String value) {
            addCriterion("is_h5 not like", value, "isH5");
            return (Criteria) this;
        }

        public Criteria andIsH5In(List<String> values) {
            addCriterion("is_h5 in", values, "isH5");
            return (Criteria) this;
        }

        public Criteria andIsH5NotIn(List<String> values) {
            addCriterion("is_h5 not in", values, "isH5");
            return (Criteria) this;
        }

        public Criteria andIsH5Between(String value1, String value2) {
            addCriterion("is_h5 between", value1, value2, "isH5");
            return (Criteria) this;
        }

        public Criteria andIsH5NotBetween(String value1, String value2) {
            addCriterion("is_h5 not between", value1, value2, "isH5");
            return (Criteria) this;
        }

        public Criteria andHrefPageIsNull() {
            addCriterion("href_page is null");
            return (Criteria) this;
        }

        public Criteria andHrefPageIsNotNull() {
            addCriterion("href_page is not null");
            return (Criteria) this;
        }

        public Criteria andHrefPageEqualTo(String value) {
            addCriterion("href_page =", value, "hrefPage");
            return (Criteria) this;
        }

        public Criteria andHrefPageNotEqualTo(String value) {
            addCriterion("href_page <>", value, "hrefPage");
            return (Criteria) this;
        }

        public Criteria andHrefPageGreaterThan(String value) {
            addCriterion("href_page >", value, "hrefPage");
            return (Criteria) this;
        }

        public Criteria andHrefPageGreaterThanOrEqualTo(String value) {
            addCriterion("href_page >=", value, "hrefPage");
            return (Criteria) this;
        }

        public Criteria andHrefPageLessThan(String value) {
            addCriterion("href_page <", value, "hrefPage");
            return (Criteria) this;
        }

        public Criteria andHrefPageLessThanOrEqualTo(String value) {
            addCriterion("href_page <=", value, "hrefPage");
            return (Criteria) this;
        }

        public Criteria andHrefPageLike(String value) {
            addCriterion("href_page like", value, "hrefPage");
            return (Criteria) this;
        }

        public Criteria andHrefPageNotLike(String value) {
            addCriterion("href_page not like", value, "hrefPage");
            return (Criteria) this;
        }

        public Criteria andHrefPageIn(List<String> values) {
            addCriterion("href_page in", values, "hrefPage");
            return (Criteria) this;
        }

        public Criteria andHrefPageNotIn(List<String> values) {
            addCriterion("href_page not in", values, "hrefPage");
            return (Criteria) this;
        }

        public Criteria andHrefPageBetween(String value1, String value2) {
            addCriterion("href_page between", value1, value2, "hrefPage");
            return (Criteria) this;
        }

        public Criteria andHrefPageNotBetween(String value1, String value2) {
            addCriterion("href_page not between", value1, value2, "hrefPage");
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

        public Criteria andContentTypeIsNull() {
            addCriterion("content_type is null");
            return (Criteria) this;
        }

        public Criteria andContentTypeIsNotNull() {
            addCriterion("content_type is not null");
            return (Criteria) this;
        }

        public Criteria andContentTypeEqualTo(Integer value) {
            addCriterion("content_type =", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotEqualTo(Integer value) {
            addCriterion("content_type <>", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeGreaterThan(Integer value) {
            addCriterion("content_type >", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("content_type >=", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLessThan(Integer value) {
            addCriterion("content_type <", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLessThanOrEqualTo(Integer value) {
            addCriterion("content_type <=", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeIn(List<Integer> values) {
            addCriterion("content_type in", values, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotIn(List<Integer> values) {
            addCriterion("content_type not in", values, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeBetween(Integer value1, Integer value2) {
            addCriterion("content_type between", value1, value2, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("content_type not between", value1, value2, "contentType");
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
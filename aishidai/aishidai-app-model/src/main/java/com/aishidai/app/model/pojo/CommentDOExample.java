package com.aishidai.app.model.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentDOExample() {
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

        public Criteria andDestIdIsNull() {
            addCriterion("dest_id is null");
            return (Criteria) this;
        }

        public Criteria andDestIdIsNotNull() {
            addCriterion("dest_id is not null");
            return (Criteria) this;
        }

        public Criteria andDestIdEqualTo(Long value) {
            addCriterion("dest_id =", value, "destId");
            return (Criteria) this;
        }

        public Criteria andDestIdNotEqualTo(Long value) {
            addCriterion("dest_id <>", value, "destId");
            return (Criteria) this;
        }

        public Criteria andDestIdGreaterThan(Long value) {
            addCriterion("dest_id >", value, "destId");
            return (Criteria) this;
        }

        public Criteria andDestIdGreaterThanOrEqualTo(Long value) {
            addCriterion("dest_id >=", value, "destId");
            return (Criteria) this;
        }

        public Criteria andDestIdLessThan(Long value) {
            addCriterion("dest_id <", value, "destId");
            return (Criteria) this;
        }

        public Criteria andDestIdLessThanOrEqualTo(Long value) {
            addCriterion("dest_id <=", value, "destId");
            return (Criteria) this;
        }

        public Criteria andDestIdIn(List<Long> values) {
            addCriterion("dest_id in", values, "destId");
            return (Criteria) this;
        }

        public Criteria andDestIdNotIn(List<Long> values) {
            addCriterion("dest_id not in", values, "destId");
            return (Criteria) this;
        }

        public Criteria andDestIdBetween(Long value1, Long value2) {
            addCriterion("dest_id between", value1, value2, "destId");
            return (Criteria) this;
        }

        public Criteria andDestIdNotBetween(Long value1, Long value2) {
            addCriterion("dest_id not between", value1, value2, "destId");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(Long value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(Long value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(Long value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(Long value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(Long value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(Long value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<Long> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<Long> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(Long value1, Long value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(Long value1, Long value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andLabelServiceIdIsNull() {
            addCriterion("label_service_id is null");
            return (Criteria) this;
        }

        public Criteria andLabelServiceIdIsNotNull() {
            addCriterion("label_service_id is not null");
            return (Criteria) this;
        }

        public Criteria andLabelServiceIdEqualTo(Long value) {
            addCriterion("label_service_id =", value, "labelServiceId");
            return (Criteria) this;
        }

        public Criteria andLabelServiceIdNotEqualTo(Long value) {
            addCriterion("label_service_id <>", value, "labelServiceId");
            return (Criteria) this;
        }

        public Criteria andLabelServiceIdGreaterThan(Long value) {
            addCriterion("label_service_id >", value, "labelServiceId");
            return (Criteria) this;
        }

        public Criteria andLabelServiceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("label_service_id >=", value, "labelServiceId");
            return (Criteria) this;
        }

        public Criteria andLabelServiceIdLessThan(Long value) {
            addCriterion("label_service_id <", value, "labelServiceId");
            return (Criteria) this;
        }

        public Criteria andLabelServiceIdLessThanOrEqualTo(Long value) {
            addCriterion("label_service_id <=", value, "labelServiceId");
            return (Criteria) this;
        }

        public Criteria andLabelServiceIdIn(List<Long> values) {
            addCriterion("label_service_id in", values, "labelServiceId");
            return (Criteria) this;
        }

        public Criteria andLabelServiceIdNotIn(List<Long> values) {
            addCriterion("label_service_id not in", values, "labelServiceId");
            return (Criteria) this;
        }

        public Criteria andLabelServiceIdBetween(Long value1, Long value2) {
            addCriterion("label_service_id between", value1, value2, "labelServiceId");
            return (Criteria) this;
        }

        public Criteria andLabelServiceIdNotBetween(Long value1, Long value2) {
            addCriterion("label_service_id not between", value1, value2, "labelServiceId");
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

        public Criteria andTypeEqualTo(Long value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Long value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Long value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Long value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Long value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Long> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Long> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Long value1, Long value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Long value1, Long value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andLabelCraftsmenIdIsNull() {
            addCriterion("label_craftsmen_id is null");
            return (Criteria) this;
        }

        public Criteria andLabelCraftsmenIdIsNotNull() {
            addCriterion("label_craftsmen_id is not null");
            return (Criteria) this;
        }

        public Criteria andLabelCraftsmenIdEqualTo(Long value) {
            addCriterion("label_craftsmen_id =", value, "labelCraftsmenId");
            return (Criteria) this;
        }

        public Criteria andLabelCraftsmenIdNotEqualTo(Long value) {
            addCriterion("label_craftsmen_id <>", value, "labelCraftsmenId");
            return (Criteria) this;
        }

        public Criteria andLabelCraftsmenIdGreaterThan(Long value) {
            addCriterion("label_craftsmen_id >", value, "labelCraftsmenId");
            return (Criteria) this;
        }

        public Criteria andLabelCraftsmenIdGreaterThanOrEqualTo(Long value) {
            addCriterion("label_craftsmen_id >=", value, "labelCraftsmenId");
            return (Criteria) this;
        }

        public Criteria andLabelCraftsmenIdLessThan(Long value) {
            addCriterion("label_craftsmen_id <", value, "labelCraftsmenId");
            return (Criteria) this;
        }

        public Criteria andLabelCraftsmenIdLessThanOrEqualTo(Long value) {
            addCriterion("label_craftsmen_id <=", value, "labelCraftsmenId");
            return (Criteria) this;
        }

        public Criteria andLabelCraftsmenIdIn(List<Long> values) {
            addCriterion("label_craftsmen_id in", values, "labelCraftsmenId");
            return (Criteria) this;
        }

        public Criteria andLabelCraftsmenIdNotIn(List<Long> values) {
            addCriterion("label_craftsmen_id not in", values, "labelCraftsmenId");
            return (Criteria) this;
        }

        public Criteria andLabelCraftsmenIdBetween(Long value1, Long value2) {
            addCriterion("label_craftsmen_id between", value1, value2, "labelCraftsmenId");
            return (Criteria) this;
        }

        public Criteria andLabelCraftsmenIdNotBetween(Long value1, Long value2) {
            addCriterion("label_craftsmen_id not between", value1, value2, "labelCraftsmenId");
            return (Criteria) this;
        }

        public Criteria andReplayCommentIdIsNull() {
            addCriterion("replay_comment_id is null");
            return (Criteria) this;
        }

        public Criteria andReplayCommentIdIsNotNull() {
            addCriterion("replay_comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andReplayCommentIdEqualTo(Long value) {
            addCriterion("replay_comment_id =", value, "replayCommentId");
            return (Criteria) this;
        }

        public Criteria andReplayCommentIdNotEqualTo(Long value) {
            addCriterion("replay_comment_id <>", value, "replayCommentId");
            return (Criteria) this;
        }

        public Criteria andReplayCommentIdGreaterThan(Long value) {
            addCriterion("replay_comment_id >", value, "replayCommentId");
            return (Criteria) this;
        }

        public Criteria andReplayCommentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("replay_comment_id >=", value, "replayCommentId");
            return (Criteria) this;
        }

        public Criteria andReplayCommentIdLessThan(Long value) {
            addCriterion("replay_comment_id <", value, "replayCommentId");
            return (Criteria) this;
        }

        public Criteria andReplayCommentIdLessThanOrEqualTo(Long value) {
            addCriterion("replay_comment_id <=", value, "replayCommentId");
            return (Criteria) this;
        }

        public Criteria andReplayCommentIdIn(List<Long> values) {
            addCriterion("replay_comment_id in", values, "replayCommentId");
            return (Criteria) this;
        }

        public Criteria andReplayCommentIdNotIn(List<Long> values) {
            addCriterion("replay_comment_id not in", values, "replayCommentId");
            return (Criteria) this;
        }

        public Criteria andReplayCommentIdBetween(Long value1, Long value2) {
            addCriterion("replay_comment_id between", value1, value2, "replayCommentId");
            return (Criteria) this;
        }

        public Criteria andReplayCommentIdNotBetween(Long value1, Long value2) {
            addCriterion("replay_comment_id not between", value1, value2, "replayCommentId");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
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

        public Criteria andPicListIsNull() {
            addCriterion("pic_list is null");
            return (Criteria) this;
        }

        public Criteria andPicListIsNotNull() {
            addCriterion("pic_list is not null");
            return (Criteria) this;
        }

        public Criteria andPicListEqualTo(String value) {
            addCriterion("pic_list =", value, "picList");
            return (Criteria) this;
        }

        public Criteria andPicListNotEqualTo(String value) {
            addCriterion("pic_list <>", value, "picList");
            return (Criteria) this;
        }

        public Criteria andPicListGreaterThan(String value) {
            addCriterion("pic_list >", value, "picList");
            return (Criteria) this;
        }

        public Criteria andPicListGreaterThanOrEqualTo(String value) {
            addCriterion("pic_list >=", value, "picList");
            return (Criteria) this;
        }

        public Criteria andPicListLessThan(String value) {
            addCriterion("pic_list <", value, "picList");
            return (Criteria) this;
        }

        public Criteria andPicListLessThanOrEqualTo(String value) {
            addCriterion("pic_list <=", value, "picList");
            return (Criteria) this;
        }

        public Criteria andPicListLike(String value) {
            addCriterion("pic_list like", value, "picList");
            return (Criteria) this;
        }

        public Criteria andPicListNotLike(String value) {
            addCriterion("pic_list not like", value, "picList");
            return (Criteria) this;
        }

        public Criteria andPicListIn(List<String> values) {
            addCriterion("pic_list in", values, "picList");
            return (Criteria) this;
        }

        public Criteria andPicListNotIn(List<String> values) {
            addCriterion("pic_list not in", values, "picList");
            return (Criteria) this;
        }

        public Criteria andPicListBetween(String value1, String value2) {
            addCriterion("pic_list between", value1, value2, "picList");
            return (Criteria) this;
        }

        public Criteria andPicListNotBetween(String value1, String value2) {
            addCriterion("pic_list not between", value1, value2, "picList");
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

        public Criteria andStarEqualTo(Integer value) {
            addCriterion("star =", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotEqualTo(Integer value) {
            addCriterion("star <>", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarGreaterThan(Integer value) {
            addCriterion("star >", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarGreaterThanOrEqualTo(Integer value) {
            addCriterion("star >=", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarLessThan(Integer value) {
            addCriterion("star <", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarLessThanOrEqualTo(Integer value) {
            addCriterion("star <=", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarIn(List<Integer> values) {
            addCriterion("star in", values, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotIn(List<Integer> values) {
            addCriterion("star not in", values, "star");
            return (Criteria) this;
        }

        public Criteria andStarBetween(Integer value1, Integer value2) {
            addCriterion("star between", value1, value2, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotBetween(Integer value1, Integer value2) {
            addCriterion("star not between", value1, value2, "star");
            return (Criteria) this;
        }

        public Criteria andLogisticsStarIsNull() {
            addCriterion("logistics_star is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsStarIsNotNull() {
            addCriterion("logistics_star is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsStarEqualTo(Integer value) {
            addCriterion("logistics_star =", value, "logisticsStar");
            return (Criteria) this;
        }

        public Criteria andLogisticsStarNotEqualTo(Integer value) {
            addCriterion("logistics_star <>", value, "logisticsStar");
            return (Criteria) this;
        }

        public Criteria andLogisticsStarGreaterThan(Integer value) {
            addCriterion("logistics_star >", value, "logisticsStar");
            return (Criteria) this;
        }

        public Criteria andLogisticsStarGreaterThanOrEqualTo(Integer value) {
            addCriterion("logistics_star >=", value, "logisticsStar");
            return (Criteria) this;
        }

        public Criteria andLogisticsStarLessThan(Integer value) {
            addCriterion("logistics_star <", value, "logisticsStar");
            return (Criteria) this;
        }

        public Criteria andLogisticsStarLessThanOrEqualTo(Integer value) {
            addCriterion("logistics_star <=", value, "logisticsStar");
            return (Criteria) this;
        }

        public Criteria andLogisticsStarIn(List<Integer> values) {
            addCriterion("logistics_star in", values, "logisticsStar");
            return (Criteria) this;
        }

        public Criteria andLogisticsStarNotIn(List<Integer> values) {
            addCriterion("logistics_star not in", values, "logisticsStar");
            return (Criteria) this;
        }

        public Criteria andLogisticsStarBetween(Integer value1, Integer value2) {
            addCriterion("logistics_star between", value1, value2, "logisticsStar");
            return (Criteria) this;
        }

        public Criteria andLogisticsStarNotBetween(Integer value1, Integer value2) {
            addCriterion("logistics_star not between", value1, value2, "logisticsStar");
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
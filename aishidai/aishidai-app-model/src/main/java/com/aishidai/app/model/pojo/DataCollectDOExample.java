package com.aishidai.app.model.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataCollectDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DataCollectDOExample() {
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

        public Criteria andBodyDataIsNull() {
            addCriterion("body_data is null");
            return (Criteria) this;
        }

        public Criteria andBodyDataIsNotNull() {
            addCriterion("body_data is not null");
            return (Criteria) this;
        }

        public Criteria andBodyDataEqualTo(Long value) {
            addCriterion("body_data =", value, "bodyData");
            return (Criteria) this;
        }

        public Criteria andBodyDataNotEqualTo(Long value) {
            addCriterion("body_data <>", value, "bodyData");
            return (Criteria) this;
        }

        public Criteria andBodyDataGreaterThan(Long value) {
            addCriterion("body_data >", value, "bodyData");
            return (Criteria) this;
        }

        public Criteria andBodyDataGreaterThanOrEqualTo(Long value) {
            addCriterion("body_data >=", value, "bodyData");
            return (Criteria) this;
        }

        public Criteria andBodyDataLessThan(Long value) {
            addCriterion("body_data <", value, "bodyData");
            return (Criteria) this;
        }

        public Criteria andBodyDataLessThanOrEqualTo(Long value) {
            addCriterion("body_data <=", value, "bodyData");
            return (Criteria) this;
        }

        public Criteria andBodyDataIn(List<Long> values) {
            addCriterion("body_data in", values, "bodyData");
            return (Criteria) this;
        }

        public Criteria andBodyDataNotIn(List<Long> values) {
            addCriterion("body_data not in", values, "bodyData");
            return (Criteria) this;
        }

        public Criteria andBodyDataBetween(Long value1, Long value2) {
            addCriterion("body_data between", value1, value2, "bodyData");
            return (Criteria) this;
        }

        public Criteria andBodyDataNotBetween(Long value1, Long value2) {
            addCriterion("body_data not between", value1, value2, "bodyData");
            return (Criteria) this;
        }

        public Criteria andAngleSwitchingIsNull() {
            addCriterion("angle_switching is null");
            return (Criteria) this;
        }

        public Criteria andAngleSwitchingIsNotNull() {
            addCriterion("angle_switching is not null");
            return (Criteria) this;
        }

        public Criteria andAngleSwitchingEqualTo(Long value) {
            addCriterion("angle_switching =", value, "angleSwitching");
            return (Criteria) this;
        }

        public Criteria andAngleSwitchingNotEqualTo(Long value) {
            addCriterion("angle_switching <>", value, "angleSwitching");
            return (Criteria) this;
        }

        public Criteria andAngleSwitchingGreaterThan(Long value) {
            addCriterion("angle_switching >", value, "angleSwitching");
            return (Criteria) this;
        }

        public Criteria andAngleSwitchingGreaterThanOrEqualTo(Long value) {
            addCriterion("angle_switching >=", value, "angleSwitching");
            return (Criteria) this;
        }

        public Criteria andAngleSwitchingLessThan(Long value) {
            addCriterion("angle_switching <", value, "angleSwitching");
            return (Criteria) this;
        }

        public Criteria andAngleSwitchingLessThanOrEqualTo(Long value) {
            addCriterion("angle_switching <=", value, "angleSwitching");
            return (Criteria) this;
        }

        public Criteria andAngleSwitchingIn(List<Long> values) {
            addCriterion("angle_switching in", values, "angleSwitching");
            return (Criteria) this;
        }

        public Criteria andAngleSwitchingNotIn(List<Long> values) {
            addCriterion("angle_switching not in", values, "angleSwitching");
            return (Criteria) this;
        }

        public Criteria andAngleSwitchingBetween(Long value1, Long value2) {
            addCriterion("angle_switching between", value1, value2, "angleSwitching");
            return (Criteria) this;
        }

        public Criteria andAngleSwitchingNotBetween(Long value1, Long value2) {
            addCriterion("angle_switching not between", value1, value2, "angleSwitching");
            return (Criteria) this;
        }

        public Criteria andFittingRoomIsNull() {
            addCriterion("fitting_room is null");
            return (Criteria) this;
        }

        public Criteria andFittingRoomIsNotNull() {
            addCriterion("fitting_room is not null");
            return (Criteria) this;
        }

        public Criteria andFittingRoomEqualTo(Long value) {
            addCriterion("fitting_room =", value, "fittingRoom");
            return (Criteria) this;
        }

        public Criteria andFittingRoomNotEqualTo(Long value) {
            addCriterion("fitting_room <>", value, "fittingRoom");
            return (Criteria) this;
        }

        public Criteria andFittingRoomGreaterThan(Long value) {
            addCriterion("fitting_room >", value, "fittingRoom");
            return (Criteria) this;
        }

        public Criteria andFittingRoomGreaterThanOrEqualTo(Long value) {
            addCriterion("fitting_room >=", value, "fittingRoom");
            return (Criteria) this;
        }

        public Criteria andFittingRoomLessThan(Long value) {
            addCriterion("fitting_room <", value, "fittingRoom");
            return (Criteria) this;
        }

        public Criteria andFittingRoomLessThanOrEqualTo(Long value) {
            addCriterion("fitting_room <=", value, "fittingRoom");
            return (Criteria) this;
        }

        public Criteria andFittingRoomIn(List<Long> values) {
            addCriterion("fitting_room in", values, "fittingRoom");
            return (Criteria) this;
        }

        public Criteria andFittingRoomNotIn(List<Long> values) {
            addCriterion("fitting_room not in", values, "fittingRoom");
            return (Criteria) this;
        }

        public Criteria andFittingRoomBetween(Long value1, Long value2) {
            addCriterion("fitting_room between", value1, value2, "fittingRoom");
            return (Criteria) this;
        }

        public Criteria andFittingRoomNotBetween(Long value1, Long value2) {
            addCriterion("fitting_room not between", value1, value2, "fittingRoom");
            return (Criteria) this;
        }

        public Criteria andFaceIsNull() {
            addCriterion("face is null");
            return (Criteria) this;
        }

        public Criteria andFaceIsNotNull() {
            addCriterion("face is not null");
            return (Criteria) this;
        }

        public Criteria andFaceEqualTo(Long value) {
            addCriterion("face =", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceNotEqualTo(Long value) {
            addCriterion("face <>", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceGreaterThan(Long value) {
            addCriterion("face >", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceGreaterThanOrEqualTo(Long value) {
            addCriterion("face >=", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceLessThan(Long value) {
            addCriterion("face <", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceLessThanOrEqualTo(Long value) {
            addCriterion("face <=", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceIn(List<Long> values) {
            addCriterion("face in", values, "face");
            return (Criteria) this;
        }

        public Criteria andFaceNotIn(List<Long> values) {
            addCriterion("face not in", values, "face");
            return (Criteria) this;
        }

        public Criteria andFaceBetween(Long value1, Long value2) {
            addCriterion("face between", value1, value2, "face");
            return (Criteria) this;
        }

        public Criteria andFaceNotBetween(Long value1, Long value2) {
            addCriterion("face not between", value1, value2, "face");
            return (Criteria) this;
        }

        public Criteria andFaceSaveIsNull() {
            addCriterion("face_save is null");
            return (Criteria) this;
        }

        public Criteria andFaceSaveIsNotNull() {
            addCriterion("face_save is not null");
            return (Criteria) this;
        }

        public Criteria andFaceSaveEqualTo(Long value) {
            addCriterion("face_save =", value, "faceSave");
            return (Criteria) this;
        }

        public Criteria andFaceSaveNotEqualTo(Long value) {
            addCriterion("face_save <>", value, "faceSave");
            return (Criteria) this;
        }

        public Criteria andFaceSaveGreaterThan(Long value) {
            addCriterion("face_save >", value, "faceSave");
            return (Criteria) this;
        }

        public Criteria andFaceSaveGreaterThanOrEqualTo(Long value) {
            addCriterion("face_save >=", value, "faceSave");
            return (Criteria) this;
        }

        public Criteria andFaceSaveLessThan(Long value) {
            addCriterion("face_save <", value, "faceSave");
            return (Criteria) this;
        }

        public Criteria andFaceSaveLessThanOrEqualTo(Long value) {
            addCriterion("face_save <=", value, "faceSave");
            return (Criteria) this;
        }

        public Criteria andFaceSaveIn(List<Long> values) {
            addCriterion("face_save in", values, "faceSave");
            return (Criteria) this;
        }

        public Criteria andFaceSaveNotIn(List<Long> values) {
            addCriterion("face_save not in", values, "faceSave");
            return (Criteria) this;
        }

        public Criteria andFaceSaveBetween(Long value1, Long value2) {
            addCriterion("face_save between", value1, value2, "faceSave");
            return (Criteria) this;
        }

        public Criteria andFaceSaveNotBetween(Long value1, Long value2) {
            addCriterion("face_save not between", value1, value2, "faceSave");
            return (Criteria) this;
        }

        public Criteria andPTimesIsNull() {
            addCriterion("p_times is null");
            return (Criteria) this;
        }

        public Criteria andPTimesIsNotNull() {
            addCriterion("p_times is not null");
            return (Criteria) this;
        }

        public Criteria andPTimesEqualTo(Long value) {
            addCriterion("p_times =", value, "pTimes");
            return (Criteria) this;
        }

        public Criteria andPTimesNotEqualTo(Long value) {
            addCriterion("p_times <>", value, "pTimes");
            return (Criteria) this;
        }

        public Criteria andPTimesGreaterThan(Long value) {
            addCriterion("p_times >", value, "pTimes");
            return (Criteria) this;
        }

        public Criteria andPTimesGreaterThanOrEqualTo(Long value) {
            addCriterion("p_times >=", value, "pTimes");
            return (Criteria) this;
        }

        public Criteria andPTimesLessThan(Long value) {
            addCriterion("p_times <", value, "pTimes");
            return (Criteria) this;
        }

        public Criteria andPTimesLessThanOrEqualTo(Long value) {
            addCriterion("p_times <=", value, "pTimes");
            return (Criteria) this;
        }

        public Criteria andPTimesIn(List<Long> values) {
            addCriterion("p_times in", values, "pTimes");
            return (Criteria) this;
        }

        public Criteria andPTimesNotIn(List<Long> values) {
            addCriterion("p_times not in", values, "pTimes");
            return (Criteria) this;
        }

        public Criteria andPTimesBetween(Long value1, Long value2) {
            addCriterion("p_times between", value1, value2, "pTimes");
            return (Criteria) this;
        }

        public Criteria andPTimesNotBetween(Long value1, Long value2) {
            addCriterion("p_times not between", value1, value2, "pTimes");
            return (Criteria) this;
        }

        public Criteria andShopCartIsNull() {
            addCriterion("shop_cart is null");
            return (Criteria) this;
        }

        public Criteria andShopCartIsNotNull() {
            addCriterion("shop_cart is not null");
            return (Criteria) this;
        }

        public Criteria andShopCartEqualTo(Long value) {
            addCriterion("shop_cart =", value, "shopCart");
            return (Criteria) this;
        }

        public Criteria andShopCartNotEqualTo(Long value) {
            addCriterion("shop_cart <>", value, "shopCart");
            return (Criteria) this;
        }

        public Criteria andShopCartGreaterThan(Long value) {
            addCriterion("shop_cart >", value, "shopCart");
            return (Criteria) this;
        }

        public Criteria andShopCartGreaterThanOrEqualTo(Long value) {
            addCriterion("shop_cart >=", value, "shopCart");
            return (Criteria) this;
        }

        public Criteria andShopCartLessThan(Long value) {
            addCriterion("shop_cart <", value, "shopCart");
            return (Criteria) this;
        }

        public Criteria andShopCartLessThanOrEqualTo(Long value) {
            addCriterion("shop_cart <=", value, "shopCart");
            return (Criteria) this;
        }

        public Criteria andShopCartIn(List<Long> values) {
            addCriterion("shop_cart in", values, "shopCart");
            return (Criteria) this;
        }

        public Criteria andShopCartNotIn(List<Long> values) {
            addCriterion("shop_cart not in", values, "shopCart");
            return (Criteria) this;
        }

        public Criteria andShopCartBetween(Long value1, Long value2) {
            addCriterion("shop_cart between", value1, value2, "shopCart");
            return (Criteria) this;
        }

        public Criteria andShopCartNotBetween(Long value1, Long value2) {
            addCriterion("shop_cart not between", value1, value2, "shopCart");
            return (Criteria) this;
        }

        public Criteria andRegisterIsNull() {
            addCriterion("register is null");
            return (Criteria) this;
        }

        public Criteria andRegisterIsNotNull() {
            addCriterion("register is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterEqualTo(Long value) {
            addCriterion("register =", value, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterNotEqualTo(Long value) {
            addCriterion("register <>", value, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterGreaterThan(Long value) {
            addCriterion("register >", value, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterGreaterThanOrEqualTo(Long value) {
            addCriterion("register >=", value, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterLessThan(Long value) {
            addCriterion("register <", value, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterLessThanOrEqualTo(Long value) {
            addCriterion("register <=", value, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterIn(List<Long> values) {
            addCriterion("register in", values, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterNotIn(List<Long> values) {
            addCriterion("register not in", values, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterBetween(Long value1, Long value2) {
            addCriterion("register between", value1, value2, "register");
            return (Criteria) this;
        }

        public Criteria andRegisterNotBetween(Long value1, Long value2) {
            addCriterion("register not between", value1, value2, "register");
            return (Criteria) this;
        }

        public Criteria andQuitIsNull() {
            addCriterion("quit is null");
            return (Criteria) this;
        }

        public Criteria andQuitIsNotNull() {
            addCriterion("quit is not null");
            return (Criteria) this;
        }

        public Criteria andQuitEqualTo(Long value) {
            addCriterion("quit =", value, "quit");
            return (Criteria) this;
        }

        public Criteria andQuitNotEqualTo(Long value) {
            addCriterion("quit <>", value, "quit");
            return (Criteria) this;
        }

        public Criteria andQuitGreaterThan(Long value) {
            addCriterion("quit >", value, "quit");
            return (Criteria) this;
        }

        public Criteria andQuitGreaterThanOrEqualTo(Long value) {
            addCriterion("quit >=", value, "quit");
            return (Criteria) this;
        }

        public Criteria andQuitLessThan(Long value) {
            addCriterion("quit <", value, "quit");
            return (Criteria) this;
        }

        public Criteria andQuitLessThanOrEqualTo(Long value) {
            addCriterion("quit <=", value, "quit");
            return (Criteria) this;
        }

        public Criteria andQuitIn(List<Long> values) {
            addCriterion("quit in", values, "quit");
            return (Criteria) this;
        }

        public Criteria andQuitNotIn(List<Long> values) {
            addCriterion("quit not in", values, "quit");
            return (Criteria) this;
        }

        public Criteria andQuitBetween(Long value1, Long value2) {
            addCriterion("quit between", value1, value2, "quit");
            return (Criteria) this;
        }

        public Criteria andQuitNotBetween(Long value1, Long value2) {
            addCriterion("quit not between", value1, value2, "quit");
            return (Criteria) this;
        }

        public Criteria andPersonalIsNull() {
            addCriterion("personal is null");
            return (Criteria) this;
        }

        public Criteria andPersonalIsNotNull() {
            addCriterion("personal is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalEqualTo(Long value) {
            addCriterion("personal =", value, "personal");
            return (Criteria) this;
        }

        public Criteria andPersonalNotEqualTo(Long value) {
            addCriterion("personal <>", value, "personal");
            return (Criteria) this;
        }

        public Criteria andPersonalGreaterThan(Long value) {
            addCriterion("personal >", value, "personal");
            return (Criteria) this;
        }

        public Criteria andPersonalGreaterThanOrEqualTo(Long value) {
            addCriterion("personal >=", value, "personal");
            return (Criteria) this;
        }

        public Criteria andPersonalLessThan(Long value) {
            addCriterion("personal <", value, "personal");
            return (Criteria) this;
        }

        public Criteria andPersonalLessThanOrEqualTo(Long value) {
            addCriterion("personal <=", value, "personal");
            return (Criteria) this;
        }

        public Criteria andPersonalIn(List<Long> values) {
            addCriterion("personal in", values, "personal");
            return (Criteria) this;
        }

        public Criteria andPersonalNotIn(List<Long> values) {
            addCriterion("personal not in", values, "personal");
            return (Criteria) this;
        }

        public Criteria andPersonalBetween(Long value1, Long value2) {
            addCriterion("personal between", value1, value2, "personal");
            return (Criteria) this;
        }

        public Criteria andPersonalNotBetween(Long value1, Long value2) {
            addCriterion("personal not between", value1, value2, "personal");
            return (Criteria) this;
        }

        public Criteria andSceneIsNull() {
            addCriterion("scene is null");
            return (Criteria) this;
        }

        public Criteria andSceneIsNotNull() {
            addCriterion("scene is not null");
            return (Criteria) this;
        }

        public Criteria andSceneEqualTo(Long value) {
            addCriterion("scene =", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneNotEqualTo(Long value) {
            addCriterion("scene <>", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneGreaterThan(Long value) {
            addCriterion("scene >", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneGreaterThanOrEqualTo(Long value) {
            addCriterion("scene >=", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneLessThan(Long value) {
            addCriterion("scene <", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneLessThanOrEqualTo(Long value) {
            addCriterion("scene <=", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneIn(List<Long> values) {
            addCriterion("scene in", values, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneNotIn(List<Long> values) {
            addCriterion("scene not in", values, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneBetween(Long value1, Long value2) {
            addCriterion("scene between", value1, value2, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneNotBetween(Long value1, Long value2) {
            addCriterion("scene not between", value1, value2, "scene");
            return (Criteria) this;
        }

        public Criteria andLoginIsNull() {
            addCriterion("login is null");
            return (Criteria) this;
        }

        public Criteria andLoginIsNotNull() {
            addCriterion("login is not null");
            return (Criteria) this;
        }

        public Criteria andLoginEqualTo(Long value) {
            addCriterion("login =", value, "login");
            return (Criteria) this;
        }

        public Criteria andLoginNotEqualTo(Long value) {
            addCriterion("login <>", value, "login");
            return (Criteria) this;
        }

        public Criteria andLoginGreaterThan(Long value) {
            addCriterion("login >", value, "login");
            return (Criteria) this;
        }

        public Criteria andLoginGreaterThanOrEqualTo(Long value) {
            addCriterion("login >=", value, "login");
            return (Criteria) this;
        }

        public Criteria andLoginLessThan(Long value) {
            addCriterion("login <", value, "login");
            return (Criteria) this;
        }

        public Criteria andLoginLessThanOrEqualTo(Long value) {
            addCriterion("login <=", value, "login");
            return (Criteria) this;
        }

        public Criteria andLoginIn(List<Long> values) {
            addCriterion("login in", values, "login");
            return (Criteria) this;
        }

        public Criteria andLoginNotIn(List<Long> values) {
            addCriterion("login not in", values, "login");
            return (Criteria) this;
        }

        public Criteria andLoginBetween(Long value1, Long value2) {
            addCriterion("login between", value1, value2, "login");
            return (Criteria) this;
        }

        public Criteria andLoginNotBetween(Long value1, Long value2) {
            addCriterion("login not between", value1, value2, "login");
            return (Criteria) this;
        }

        public Criteria andShoesIsNull() {
            addCriterion("shoes is null");
            return (Criteria) this;
        }

        public Criteria andShoesIsNotNull() {
            addCriterion("shoes is not null");
            return (Criteria) this;
        }

        public Criteria andShoesEqualTo(Long value) {
            addCriterion("shoes =", value, "shoes");
            return (Criteria) this;
        }

        public Criteria andShoesNotEqualTo(Long value) {
            addCriterion("shoes <>", value, "shoes");
            return (Criteria) this;
        }

        public Criteria andShoesGreaterThan(Long value) {
            addCriterion("shoes >", value, "shoes");
            return (Criteria) this;
        }

        public Criteria andShoesGreaterThanOrEqualTo(Long value) {
            addCriterion("shoes >=", value, "shoes");
            return (Criteria) this;
        }

        public Criteria andShoesLessThan(Long value) {
            addCriterion("shoes <", value, "shoes");
            return (Criteria) this;
        }

        public Criteria andShoesLessThanOrEqualTo(Long value) {
            addCriterion("shoes <=", value, "shoes");
            return (Criteria) this;
        }

        public Criteria andShoesIn(List<Long> values) {
            addCriterion("shoes in", values, "shoes");
            return (Criteria) this;
        }

        public Criteria andShoesNotIn(List<Long> values) {
            addCriterion("shoes not in", values, "shoes");
            return (Criteria) this;
        }

        public Criteria andShoesBetween(Long value1, Long value2) {
            addCriterion("shoes between", value1, value2, "shoes");
            return (Criteria) this;
        }

        public Criteria andShoesNotBetween(Long value1, Long value2) {
            addCriterion("shoes not between", value1, value2, "shoes");
            return (Criteria) this;
        }

        public Criteria andAccessoriesIsNull() {
            addCriterion("accessories is null");
            return (Criteria) this;
        }

        public Criteria andAccessoriesIsNotNull() {
            addCriterion("accessories is not null");
            return (Criteria) this;
        }

        public Criteria andAccessoriesEqualTo(Long value) {
            addCriterion("accessories =", value, "accessories");
            return (Criteria) this;
        }

        public Criteria andAccessoriesNotEqualTo(Long value) {
            addCriterion("accessories <>", value, "accessories");
            return (Criteria) this;
        }

        public Criteria andAccessoriesGreaterThan(Long value) {
            addCriterion("accessories >", value, "accessories");
            return (Criteria) this;
        }

        public Criteria andAccessoriesGreaterThanOrEqualTo(Long value) {
            addCriterion("accessories >=", value, "accessories");
            return (Criteria) this;
        }

        public Criteria andAccessoriesLessThan(Long value) {
            addCriterion("accessories <", value, "accessories");
            return (Criteria) this;
        }

        public Criteria andAccessoriesLessThanOrEqualTo(Long value) {
            addCriterion("accessories <=", value, "accessories");
            return (Criteria) this;
        }

        public Criteria andAccessoriesIn(List<Long> values) {
            addCriterion("accessories in", values, "accessories");
            return (Criteria) this;
        }

        public Criteria andAccessoriesNotIn(List<Long> values) {
            addCriterion("accessories not in", values, "accessories");
            return (Criteria) this;
        }

        public Criteria andAccessoriesBetween(Long value1, Long value2) {
            addCriterion("accessories between", value1, value2, "accessories");
            return (Criteria) this;
        }

        public Criteria andAccessoriesNotBetween(Long value1, Long value2) {
            addCriterion("accessories not between", value1, value2, "accessories");
            return (Criteria) this;
        }

        public Criteria andClothingIsNull() {
            addCriterion("clothing is null");
            return (Criteria) this;
        }

        public Criteria andClothingIsNotNull() {
            addCriterion("clothing is not null");
            return (Criteria) this;
        }

        public Criteria andClothingEqualTo(Long value) {
            addCriterion("clothing =", value, "clothing");
            return (Criteria) this;
        }

        public Criteria andClothingNotEqualTo(Long value) {
            addCriterion("clothing <>", value, "clothing");
            return (Criteria) this;
        }

        public Criteria andClothingGreaterThan(Long value) {
            addCriterion("clothing >", value, "clothing");
            return (Criteria) this;
        }

        public Criteria andClothingGreaterThanOrEqualTo(Long value) {
            addCriterion("clothing >=", value, "clothing");
            return (Criteria) this;
        }

        public Criteria andClothingLessThan(Long value) {
            addCriterion("clothing <", value, "clothing");
            return (Criteria) this;
        }

        public Criteria andClothingLessThanOrEqualTo(Long value) {
            addCriterion("clothing <=", value, "clothing");
            return (Criteria) this;
        }

        public Criteria andClothingIn(List<Long> values) {
            addCriterion("clothing in", values, "clothing");
            return (Criteria) this;
        }

        public Criteria andClothingNotIn(List<Long> values) {
            addCriterion("clothing not in", values, "clothing");
            return (Criteria) this;
        }

        public Criteria andClothingBetween(Long value1, Long value2) {
            addCriterion("clothing between", value1, value2, "clothing");
            return (Criteria) this;
        }

        public Criteria andClothingNotBetween(Long value1, Long value2) {
            addCriterion("clothing not between", value1, value2, "clothing");
            return (Criteria) this;
        }

        public Criteria andHairstyleIsNull() {
            addCriterion("hairstyle is null");
            return (Criteria) this;
        }

        public Criteria andHairstyleIsNotNull() {
            addCriterion("hairstyle is not null");
            return (Criteria) this;
        }

        public Criteria andHairstyleEqualTo(Long value) {
            addCriterion("hairstyle =", value, "hairstyle");
            return (Criteria) this;
        }

        public Criteria andHairstyleNotEqualTo(Long value) {
            addCriterion("hairstyle <>", value, "hairstyle");
            return (Criteria) this;
        }

        public Criteria andHairstyleGreaterThan(Long value) {
            addCriterion("hairstyle >", value, "hairstyle");
            return (Criteria) this;
        }

        public Criteria andHairstyleGreaterThanOrEqualTo(Long value) {
            addCriterion("hairstyle >=", value, "hairstyle");
            return (Criteria) this;
        }

        public Criteria andHairstyleLessThan(Long value) {
            addCriterion("hairstyle <", value, "hairstyle");
            return (Criteria) this;
        }

        public Criteria andHairstyleLessThanOrEqualTo(Long value) {
            addCriterion("hairstyle <=", value, "hairstyle");
            return (Criteria) this;
        }

        public Criteria andHairstyleIn(List<Long> values) {
            addCriterion("hairstyle in", values, "hairstyle");
            return (Criteria) this;
        }

        public Criteria andHairstyleNotIn(List<Long> values) {
            addCriterion("hairstyle not in", values, "hairstyle");
            return (Criteria) this;
        }

        public Criteria andHairstyleBetween(Long value1, Long value2) {
            addCriterion("hairstyle between", value1, value2, "hairstyle");
            return (Criteria) this;
        }

        public Criteria andHairstyleNotBetween(Long value1, Long value2) {
            addCriterion("hairstyle not between", value1, value2, "hairstyle");
            return (Criteria) this;
        }

        public Criteria andGalleryIsNull() {
            addCriterion("gallery is null");
            return (Criteria) this;
        }

        public Criteria andGalleryIsNotNull() {
            addCriterion("gallery is not null");
            return (Criteria) this;
        }

        public Criteria andGalleryEqualTo(Long value) {
            addCriterion("gallery =", value, "gallery");
            return (Criteria) this;
        }

        public Criteria andGalleryNotEqualTo(Long value) {
            addCriterion("gallery <>", value, "gallery");
            return (Criteria) this;
        }

        public Criteria andGalleryGreaterThan(Long value) {
            addCriterion("gallery >", value, "gallery");
            return (Criteria) this;
        }

        public Criteria andGalleryGreaterThanOrEqualTo(Long value) {
            addCriterion("gallery >=", value, "gallery");
            return (Criteria) this;
        }

        public Criteria andGalleryLessThan(Long value) {
            addCriterion("gallery <", value, "gallery");
            return (Criteria) this;
        }

        public Criteria andGalleryLessThanOrEqualTo(Long value) {
            addCriterion("gallery <=", value, "gallery");
            return (Criteria) this;
        }

        public Criteria andGalleryIn(List<Long> values) {
            addCriterion("gallery in", values, "gallery");
            return (Criteria) this;
        }

        public Criteria andGalleryNotIn(List<Long> values) {
            addCriterion("gallery not in", values, "gallery");
            return (Criteria) this;
        }

        public Criteria andGalleryBetween(Long value1, Long value2) {
            addCriterion("gallery between", value1, value2, "gallery");
            return (Criteria) this;
        }

        public Criteria andGalleryNotBetween(Long value1, Long value2) {
            addCriterion("gallery not between", value1, value2, "gallery");
            return (Criteria) this;
        }

        public Criteria andStandardStatureIsNull() {
            addCriterion("standard_stature is null");
            return (Criteria) this;
        }

        public Criteria andStandardStatureIsNotNull() {
            addCriterion("standard_stature is not null");
            return (Criteria) this;
        }

        public Criteria andStandardStatureEqualTo(Long value) {
            addCriterion("standard_stature =", value, "standardStature");
            return (Criteria) this;
        }

        public Criteria andStandardStatureNotEqualTo(Long value) {
            addCriterion("standard_stature <>", value, "standardStature");
            return (Criteria) this;
        }

        public Criteria andStandardStatureGreaterThan(Long value) {
            addCriterion("standard_stature >", value, "standardStature");
            return (Criteria) this;
        }

        public Criteria andStandardStatureGreaterThanOrEqualTo(Long value) {
            addCriterion("standard_stature >=", value, "standardStature");
            return (Criteria) this;
        }

        public Criteria andStandardStatureLessThan(Long value) {
            addCriterion("standard_stature <", value, "standardStature");
            return (Criteria) this;
        }

        public Criteria andStandardStatureLessThanOrEqualTo(Long value) {
            addCriterion("standard_stature <=", value, "standardStature");
            return (Criteria) this;
        }

        public Criteria andStandardStatureIn(List<Long> values) {
            addCriterion("standard_stature in", values, "standardStature");
            return (Criteria) this;
        }

        public Criteria andStandardStatureNotIn(List<Long> values) {
            addCriterion("standard_stature not in", values, "standardStature");
            return (Criteria) this;
        }

        public Criteria andStandardStatureBetween(Long value1, Long value2) {
            addCriterion("standard_stature between", value1, value2, "standardStature");
            return (Criteria) this;
        }

        public Criteria andStandardStatureNotBetween(Long value1, Long value2) {
            addCriterion("standard_stature not between", value1, value2, "standardStature");
            return (Criteria) this;
        }

        public Criteria andHealthyIsNull() {
            addCriterion("healthy is null");
            return (Criteria) this;
        }

        public Criteria andHealthyIsNotNull() {
            addCriterion("healthy is not null");
            return (Criteria) this;
        }

        public Criteria andHealthyEqualTo(Long value) {
            addCriterion("healthy =", value, "healthy");
            return (Criteria) this;
        }

        public Criteria andHealthyNotEqualTo(Long value) {
            addCriterion("healthy <>", value, "healthy");
            return (Criteria) this;
        }

        public Criteria andHealthyGreaterThan(Long value) {
            addCriterion("healthy >", value, "healthy");
            return (Criteria) this;
        }

        public Criteria andHealthyGreaterThanOrEqualTo(Long value) {
            addCriterion("healthy >=", value, "healthy");
            return (Criteria) this;
        }

        public Criteria andHealthyLessThan(Long value) {
            addCriterion("healthy <", value, "healthy");
            return (Criteria) this;
        }

        public Criteria andHealthyLessThanOrEqualTo(Long value) {
            addCriterion("healthy <=", value, "healthy");
            return (Criteria) this;
        }

        public Criteria andHealthyIn(List<Long> values) {
            addCriterion("healthy in", values, "healthy");
            return (Criteria) this;
        }

        public Criteria andHealthyNotIn(List<Long> values) {
            addCriterion("healthy not in", values, "healthy");
            return (Criteria) this;
        }

        public Criteria andHealthyBetween(Long value1, Long value2) {
            addCriterion("healthy between", value1, value2, "healthy");
            return (Criteria) this;
        }

        public Criteria andHealthyNotBetween(Long value1, Long value2) {
            addCriterion("healthy not between", value1, value2, "healthy");
            return (Criteria) this;
        }

        public Criteria andNaturalIsNull() {
            addCriterion("natural is null");
            return (Criteria) this;
        }

        public Criteria andNaturalIsNotNull() {
            addCriterion("natural is not null");
            return (Criteria) this;
        }

        public Criteria andNaturalEqualTo(Long value) {
            addCriterion("natural =", value, "natural");
            return (Criteria) this;
        }

        public Criteria andNaturalNotEqualTo(Long value) {
            addCriterion("natural <>", value, "natural");
            return (Criteria) this;
        }

        public Criteria andNaturalGreaterThan(Long value) {
            addCriterion("natural >", value, "natural");
            return (Criteria) this;
        }

        public Criteria andNaturalGreaterThanOrEqualTo(Long value) {
            addCriterion("natural >=", value, "natural");
            return (Criteria) this;
        }

        public Criteria andNaturalLessThan(Long value) {
            addCriterion("natural <", value, "natural");
            return (Criteria) this;
        }

        public Criteria andNaturalLessThanOrEqualTo(Long value) {
            addCriterion("natural <=", value, "natural");
            return (Criteria) this;
        }

        public Criteria andNaturalIn(List<Long> values) {
            addCriterion("natural in", values, "natural");
            return (Criteria) this;
        }

        public Criteria andNaturalNotIn(List<Long> values) {
            addCriterion("natural not in", values, "natural");
            return (Criteria) this;
        }

        public Criteria andNaturalBetween(Long value1, Long value2) {
            addCriterion("natural between", value1, value2, "natural");
            return (Criteria) this;
        }

        public Criteria andNaturalNotBetween(Long value1, Long value2) {
            addCriterion("natural not between", value1, value2, "natural");
            return (Criteria) this;
        }

        public Criteria andRuddyIsNull() {
            addCriterion("ruddy is null");
            return (Criteria) this;
        }

        public Criteria andRuddyIsNotNull() {
            addCriterion("ruddy is not null");
            return (Criteria) this;
        }

        public Criteria andRuddyEqualTo(Long value) {
            addCriterion("ruddy =", value, "ruddy");
            return (Criteria) this;
        }

        public Criteria andRuddyNotEqualTo(Long value) {
            addCriterion("ruddy <>", value, "ruddy");
            return (Criteria) this;
        }

        public Criteria andRuddyGreaterThan(Long value) {
            addCriterion("ruddy >", value, "ruddy");
            return (Criteria) this;
        }

        public Criteria andRuddyGreaterThanOrEqualTo(Long value) {
            addCriterion("ruddy >=", value, "ruddy");
            return (Criteria) this;
        }

        public Criteria andRuddyLessThan(Long value) {
            addCriterion("ruddy <", value, "ruddy");
            return (Criteria) this;
        }

        public Criteria andRuddyLessThanOrEqualTo(Long value) {
            addCriterion("ruddy <=", value, "ruddy");
            return (Criteria) this;
        }

        public Criteria andRuddyIn(List<Long> values) {
            addCriterion("ruddy in", values, "ruddy");
            return (Criteria) this;
        }

        public Criteria andRuddyNotIn(List<Long> values) {
            addCriterion("ruddy not in", values, "ruddy");
            return (Criteria) this;
        }

        public Criteria andRuddyBetween(Long value1, Long value2) {
            addCriterion("ruddy between", value1, value2, "ruddy");
            return (Criteria) this;
        }

        public Criteria andRuddyNotBetween(Long value1, Long value2) {
            addCriterion("ruddy not between", value1, value2, "ruddy");
            return (Criteria) this;
        }

        public Criteria andFairIsNull() {
            addCriterion("fair is null");
            return (Criteria) this;
        }

        public Criteria andFairIsNotNull() {
            addCriterion("fair is not null");
            return (Criteria) this;
        }

        public Criteria andFairEqualTo(Long value) {
            addCriterion("fair =", value, "fair");
            return (Criteria) this;
        }

        public Criteria andFairNotEqualTo(Long value) {
            addCriterion("fair <>", value, "fair");
            return (Criteria) this;
        }

        public Criteria andFairGreaterThan(Long value) {
            addCriterion("fair >", value, "fair");
            return (Criteria) this;
        }

        public Criteria andFairGreaterThanOrEqualTo(Long value) {
            addCriterion("fair >=", value, "fair");
            return (Criteria) this;
        }

        public Criteria andFairLessThan(Long value) {
            addCriterion("fair <", value, "fair");
            return (Criteria) this;
        }

        public Criteria andFairLessThanOrEqualTo(Long value) {
            addCriterion("fair <=", value, "fair");
            return (Criteria) this;
        }

        public Criteria andFairIn(List<Long> values) {
            addCriterion("fair in", values, "fair");
            return (Criteria) this;
        }

        public Criteria andFairNotIn(List<Long> values) {
            addCriterion("fair not in", values, "fair");
            return (Criteria) this;
        }

        public Criteria andFairBetween(Long value1, Long value2) {
            addCriterion("fair between", value1, value2, "fair");
            return (Criteria) this;
        }

        public Criteria andFairNotBetween(Long value1, Long value2) {
            addCriterion("fair not between", value1, value2, "fair");
            return (Criteria) this;
        }

        public Criteria andNormalColorIsNull() {
            addCriterion("normal_color is null");
            return (Criteria) this;
        }

        public Criteria andNormalColorIsNotNull() {
            addCriterion("normal_color is not null");
            return (Criteria) this;
        }

        public Criteria andNormalColorEqualTo(Long value) {
            addCriterion("normal_color =", value, "normalColor");
            return (Criteria) this;
        }

        public Criteria andNormalColorNotEqualTo(Long value) {
            addCriterion("normal_color <>", value, "normalColor");
            return (Criteria) this;
        }

        public Criteria andNormalColorGreaterThan(Long value) {
            addCriterion("normal_color >", value, "normalColor");
            return (Criteria) this;
        }

        public Criteria andNormalColorGreaterThanOrEqualTo(Long value) {
            addCriterion("normal_color >=", value, "normalColor");
            return (Criteria) this;
        }

        public Criteria andNormalColorLessThan(Long value) {
            addCriterion("normal_color <", value, "normalColor");
            return (Criteria) this;
        }

        public Criteria andNormalColorLessThanOrEqualTo(Long value) {
            addCriterion("normal_color <=", value, "normalColor");
            return (Criteria) this;
        }

        public Criteria andNormalColorIn(List<Long> values) {
            addCriterion("normal_color in", values, "normalColor");
            return (Criteria) this;
        }

        public Criteria andNormalColorNotIn(List<Long> values) {
            addCriterion("normal_color not in", values, "normalColor");
            return (Criteria) this;
        }

        public Criteria andNormalColorBetween(Long value1, Long value2) {
            addCriterion("normal_color between", value1, value2, "normalColor");
            return (Criteria) this;
        }

        public Criteria andNormalColorNotBetween(Long value1, Long value2) {
            addCriterion("normal_color not between", value1, value2, "normalColor");
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
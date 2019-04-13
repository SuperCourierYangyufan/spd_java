package com.my.spd.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderDetailsExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLotNumberIsNull() {
            addCriterion("lot_number is null");
            return (Criteria) this;
        }

        public Criteria andLotNumberIsNotNull() {
            addCriterion("lot_number is not null");
            return (Criteria) this;
        }

        public Criteria andLotNumberEqualTo(String value) {
            addCriterion("lot_number =", value, "lotNumber");
            return (Criteria) this;
        }

        public Criteria andLotNumberNotEqualTo(String value) {
            addCriterion("lot_number <>", value, "lotNumber");
            return (Criteria) this;
        }

        public Criteria andLotNumberGreaterThan(String value) {
            addCriterion("lot_number >", value, "lotNumber");
            return (Criteria) this;
        }

        public Criteria andLotNumberGreaterThanOrEqualTo(String value) {
            addCriterion("lot_number >=", value, "lotNumber");
            return (Criteria) this;
        }

        public Criteria andLotNumberLessThan(String value) {
            addCriterion("lot_number <", value, "lotNumber");
            return (Criteria) this;
        }

        public Criteria andLotNumberLessThanOrEqualTo(String value) {
            addCriterion("lot_number <=", value, "lotNumber");
            return (Criteria) this;
        }

        public Criteria andLotNumberLike(String value) {
            addCriterion("lot_number like", value, "lotNumber");
            return (Criteria) this;
        }

        public Criteria andLotNumberNotLike(String value) {
            addCriterion("lot_number not like", value, "lotNumber");
            return (Criteria) this;
        }

        public Criteria andLotNumberIn(List<String> values) {
            addCriterion("lot_number in", values, "lotNumber");
            return (Criteria) this;
        }

        public Criteria andLotNumberNotIn(List<String> values) {
            addCriterion("lot_number not in", values, "lotNumber");
            return (Criteria) this;
        }

        public Criteria andLotNumberBetween(String value1, String value2) {
            addCriterion("lot_number between", value1, value2, "lotNumber");
            return (Criteria) this;
        }

        public Criteria andLotNumberNotBetween(String value1, String value2) {
            addCriterion("lot_number not between", value1, value2, "lotNumber");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andGoodIdIsNull() {
            addCriterion("good_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodIdIsNotNull() {
            addCriterion("good_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodIdEqualTo(Integer value) {
            addCriterion("good_id =", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotEqualTo(Integer value) {
            addCriterion("good_id <>", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdGreaterThan(Integer value) {
            addCriterion("good_id >", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("good_id >=", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdLessThan(Integer value) {
            addCriterion("good_id <", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdLessThanOrEqualTo(Integer value) {
            addCriterion("good_id <=", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdIn(List<Integer> values) {
            addCriterion("good_id in", values, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotIn(List<Integer> values) {
            addCriterion("good_id not in", values, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdBetween(Integer value1, Integer value2) {
            addCriterion("good_id between", value1, value2, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotBetween(Integer value1, Integer value2) {
            addCriterion("good_id not between", value1, value2, "goodId");
            return (Criteria) this;
        }

        public Criteria andReceivableIsNull() {
            addCriterion("receivable is null");
            return (Criteria) this;
        }

        public Criteria andReceivableIsNotNull() {
            addCriterion("receivable is not null");
            return (Criteria) this;
        }

        public Criteria andReceivableEqualTo(Long value) {
            addCriterion("receivable =", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableNotEqualTo(Long value) {
            addCriterion("receivable <>", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableGreaterThan(Long value) {
            addCriterion("receivable >", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableGreaterThanOrEqualTo(Long value) {
            addCriterion("receivable >=", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableLessThan(Long value) {
            addCriterion("receivable <", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableLessThanOrEqualTo(Long value) {
            addCriterion("receivable <=", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableIn(List<Long> values) {
            addCriterion("receivable in", values, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableNotIn(List<Long> values) {
            addCriterion("receivable not in", values, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableBetween(Long value1, Long value2) {
            addCriterion("receivable between", value1, value2, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableNotBetween(Long value1, Long value2) {
            addCriterion("receivable not between", value1, value2, "receivable");
            return (Criteria) this;
        }

        public Criteria andActuallyReceivedIsNull() {
            addCriterion("actually_received is null");
            return (Criteria) this;
        }

        public Criteria andActuallyReceivedIsNotNull() {
            addCriterion("actually_received is not null");
            return (Criteria) this;
        }

        public Criteria andActuallyReceivedEqualTo(Long value) {
            addCriterion("actually_received =", value, "actuallyReceived");
            return (Criteria) this;
        }

        public Criteria andActuallyReceivedNotEqualTo(Long value) {
            addCriterion("actually_received <>", value, "actuallyReceived");
            return (Criteria) this;
        }

        public Criteria andActuallyReceivedGreaterThan(Long value) {
            addCriterion("actually_received >", value, "actuallyReceived");
            return (Criteria) this;
        }

        public Criteria andActuallyReceivedGreaterThanOrEqualTo(Long value) {
            addCriterion("actually_received >=", value, "actuallyReceived");
            return (Criteria) this;
        }

        public Criteria andActuallyReceivedLessThan(Long value) {
            addCriterion("actually_received <", value, "actuallyReceived");
            return (Criteria) this;
        }

        public Criteria andActuallyReceivedLessThanOrEqualTo(Long value) {
            addCriterion("actually_received <=", value, "actuallyReceived");
            return (Criteria) this;
        }

        public Criteria andActuallyReceivedIn(List<Long> values) {
            addCriterion("actually_received in", values, "actuallyReceived");
            return (Criteria) this;
        }

        public Criteria andActuallyReceivedNotIn(List<Long> values) {
            addCriterion("actually_received not in", values, "actuallyReceived");
            return (Criteria) this;
        }

        public Criteria andActuallyReceivedBetween(Long value1, Long value2) {
            addCriterion("actually_received between", value1, value2, "actuallyReceived");
            return (Criteria) this;
        }

        public Criteria andActuallyReceivedNotBetween(Long value1, Long value2) {
            addCriterion("actually_received not between", value1, value2, "actuallyReceived");
            return (Criteria) this;
        }

        public Criteria andProductionTimeIsNull() {
            addCriterion("production_time is null");
            return (Criteria) this;
        }

        public Criteria andProductionTimeIsNotNull() {
            addCriterion("production_time is not null");
            return (Criteria) this;
        }

        public Criteria andProductionTimeEqualTo(Date value) {
            addCriterion("production_time =", value, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeNotEqualTo(Date value) {
            addCriterion("production_time <>", value, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeGreaterThan(Date value) {
            addCriterion("production_time >", value, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("production_time >=", value, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeLessThan(Date value) {
            addCriterion("production_time <", value, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeLessThanOrEqualTo(Date value) {
            addCriterion("production_time <=", value, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeIn(List<Date> values) {
            addCriterion("production_time in", values, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeNotIn(List<Date> values) {
            addCriterion("production_time not in", values, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeBetween(Date value1, Date value2) {
            addCriterion("production_time between", value1, value2, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeNotBetween(Date value1, Date value2) {
            addCriterion("production_time not between", value1, value2, "productionTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeIsNull() {
            addCriterion("expiration_time is null");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeIsNotNull() {
            addCriterion("expiration_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeEqualTo(Date value) {
            addCriterion("expiration_time =", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeNotEqualTo(Date value) {
            addCriterion("expiration_time <>", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeGreaterThan(Date value) {
            addCriterion("expiration_time >", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expiration_time >=", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeLessThan(Date value) {
            addCriterion("expiration_time <", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeLessThanOrEqualTo(Date value) {
            addCriterion("expiration_time <=", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeIn(List<Date> values) {
            addCriterion("expiration_time in", values, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeNotIn(List<Date> values) {
            addCriterion("expiration_time not in", values, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeBetween(Date value1, Date value2) {
            addCriterion("expiration_time between", value1, value2, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeNotBetween(Date value1, Date value2) {
            addCriterion("expiration_time not between", value1, value2, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andSurplusQuantityIsNull() {
            addCriterion("surplus_quantity is null");
            return (Criteria) this;
        }

        public Criteria andSurplusQuantityIsNotNull() {
            addCriterion("surplus_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andSurplusQuantityEqualTo(Long value) {
            addCriterion("surplus_quantity =", value, "surplusQuantity");
            return (Criteria) this;
        }

        public Criteria andSurplusQuantityNotEqualTo(Long value) {
            addCriterion("surplus_quantity <>", value, "surplusQuantity");
            return (Criteria) this;
        }

        public Criteria andSurplusQuantityGreaterThan(Long value) {
            addCriterion("surplus_quantity >", value, "surplusQuantity");
            return (Criteria) this;
        }

        public Criteria andSurplusQuantityGreaterThanOrEqualTo(Long value) {
            addCriterion("surplus_quantity >=", value, "surplusQuantity");
            return (Criteria) this;
        }

        public Criteria andSurplusQuantityLessThan(Long value) {
            addCriterion("surplus_quantity <", value, "surplusQuantity");
            return (Criteria) this;
        }

        public Criteria andSurplusQuantityLessThanOrEqualTo(Long value) {
            addCriterion("surplus_quantity <=", value, "surplusQuantity");
            return (Criteria) this;
        }

        public Criteria andSurplusQuantityIn(List<Long> values) {
            addCriterion("surplus_quantity in", values, "surplusQuantity");
            return (Criteria) this;
        }

        public Criteria andSurplusQuantityNotIn(List<Long> values) {
            addCriterion("surplus_quantity not in", values, "surplusQuantity");
            return (Criteria) this;
        }

        public Criteria andSurplusQuantityBetween(Long value1, Long value2) {
            addCriterion("surplus_quantity between", value1, value2, "surplusQuantity");
            return (Criteria) this;
        }

        public Criteria andSurplusQuantityNotBetween(Long value1, Long value2) {
            addCriterion("surplus_quantity not between", value1, value2, "surplusQuantity");
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
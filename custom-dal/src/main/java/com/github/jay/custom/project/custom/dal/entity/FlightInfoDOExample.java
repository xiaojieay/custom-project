package com.github.jay.custom.project.custom.dal.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightInfoDOExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FlightInfoDOExample() {
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
            return (Criteria)this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria)this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria)this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria)this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria)this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria)this;
        }

        public Criteria andFlightNoIsNull() {
            addCriterion("flight_no is null");
            return (Criteria)this;
        }

        public Criteria andFlightNoIsNotNull() {
            addCriterion("flight_no is not null");
            return (Criteria)this;
        }

        public Criteria andFlightNoEqualTo(String value) {
            addCriterion("flight_no =", value, "flightNo");
            return (Criteria)this;
        }

        public Criteria andFlightNoNotEqualTo(String value) {
            addCriterion("flight_no <>", value, "flightNo");
            return (Criteria)this;
        }

        public Criteria andFlightNoGreaterThan(String value) {
            addCriterion("flight_no >", value, "flightNo");
            return (Criteria)this;
        }

        public Criteria andFlightNoGreaterThanOrEqualTo(String value) {
            addCriterion("flight_no >=", value, "flightNo");
            return (Criteria)this;
        }

        public Criteria andFlightNoLessThan(String value) {
            addCriterion("flight_no <", value, "flightNo");
            return (Criteria)this;
        }

        public Criteria andFlightNoLessThanOrEqualTo(String value) {
            addCriterion("flight_no <=", value, "flightNo");
            return (Criteria)this;
        }

        public Criteria andFlightNoLike(String value) {
            addCriterion("flight_no like", value, "flightNo");
            return (Criteria)this;
        }

        public Criteria andFlightNoNotLike(String value) {
            addCriterion("flight_no not like", value, "flightNo");
            return (Criteria)this;
        }

        public Criteria andFlightNoIn(List<String> values) {
            addCriterion("flight_no in", values, "flightNo");
            return (Criteria)this;
        }

        public Criteria andFlightNoNotIn(List<String> values) {
            addCriterion("flight_no not in", values, "flightNo");
            return (Criteria)this;
        }

        public Criteria andFlightNoBetween(String value1, String value2) {
            addCriterion("flight_no between", value1, value2, "flightNo");
            return (Criteria)this;
        }

        public Criteria andFlightNoNotBetween(String value1, String value2) {
            addCriterion("flight_no not between", value1, value2, "flightNo");
            return (Criteria)this;
        }

        public Criteria andFlightDateIsNull() {
            addCriterion("flight_date is null");
            return (Criteria)this;
        }

        public Criteria andFlightDateIsNotNull() {
            addCriterion("flight_date is not null");
            return (Criteria)this;
        }

        public Criteria andFlightDateEqualTo(Date value) {
            addCriterion("flight_date =", value, "flightDate");
            return (Criteria)this;
        }

        public Criteria andFlightDateNotEqualTo(Date value) {
            addCriterion("flight_date <>", value, "flightDate");
            return (Criteria)this;
        }

        public Criteria andFlightDateGreaterThan(Date value) {
            addCriterion("flight_date >", value, "flightDate");
            return (Criteria)this;
        }

        public Criteria andFlightDateGreaterThanOrEqualTo(Date value) {
            addCriterion("flight_date >=", value, "flightDate");
            return (Criteria)this;
        }

        public Criteria andFlightDateLessThan(Date value) {
            addCriterion("flight_date <", value, "flightDate");
            return (Criteria)this;
        }

        public Criteria andFlightDateLessThanOrEqualTo(Date value) {
            addCriterion("flight_date <=", value, "flightDate");
            return (Criteria)this;
        }

        public Criteria andFlightDateIn(List<Date> values) {
            addCriterion("flight_date in", values, "flightDate");
            return (Criteria)this;
        }

        public Criteria andFlightDateNotIn(List<Date> values) {
            addCriterion("flight_date not in", values, "flightDate");
            return (Criteria)this;
        }

        public Criteria andFlightDateBetween(Date value1, Date value2) {
            addCriterion("flight_date between", value1, value2, "flightDate");
            return (Criteria)this;
        }

        public Criteria andFlightDateNotBetween(Date value1, Date value2) {
            addCriterion("flight_date not between", value1, value2, "flightDate");
            return (Criteria)this;
        }

        public Criteria andComTicketPriceIsNull() {
            addCriterion("com_ticket_price is null");
            return (Criteria)this;
        }

        public Criteria andComTicketPriceIsNotNull() {
            addCriterion("com_ticket_price is not null");
            return (Criteria)this;
        }

        public Criteria andComTicketPriceEqualTo(BigDecimal value) {
            addCriterion("com_ticket_price =", value, "comTicketPrice");
            return (Criteria)this;
        }

        public Criteria andComTicketPriceNotEqualTo(BigDecimal value) {
            addCriterion("com_ticket_price <>", value, "comTicketPrice");
            return (Criteria)this;
        }

        public Criteria andComTicketPriceGreaterThan(BigDecimal value) {
            addCriterion("com_ticket_price >", value, "comTicketPrice");
            return (Criteria)this;
        }

        public Criteria andComTicketPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("com_ticket_price >=", value, "comTicketPrice");
            return (Criteria)this;
        }

        public Criteria andComTicketPriceLessThan(BigDecimal value) {
            addCriterion("com_ticket_price <", value, "comTicketPrice");
            return (Criteria)this;
        }

        public Criteria andComTicketPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("com_ticket_price <=", value, "comTicketPrice");
            return (Criteria)this;
        }

        public Criteria andComTicketPriceIn(List<BigDecimal> values) {
            addCriterion("com_ticket_price in", values, "comTicketPrice");
            return (Criteria)this;
        }

        public Criteria andComTicketPriceNotIn(List<BigDecimal> values) {
            addCriterion("com_ticket_price not in", values, "comTicketPrice");
            return (Criteria)this;
        }

        public Criteria andComTicketPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("com_ticket_price between", value1, value2, "comTicketPrice");
            return (Criteria)this;
        }

        public Criteria andComTicketPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("com_ticket_price not between", value1, value2, "comTicketPrice");
            return (Criteria)this;
        }

        public Criteria andOfficialPriceIsNull() {
            addCriterion("official_price is null");
            return (Criteria)this;
        }

        public Criteria andOfficialPriceIsNotNull() {
            addCriterion("official_price is not null");
            return (Criteria)this;
        }

        public Criteria andOfficialPriceEqualTo(BigDecimal value) {
            addCriterion("official_price =", value, "officialPrice");
            return (Criteria)this;
        }

        public Criteria andOfficialPriceNotEqualTo(BigDecimal value) {
            addCriterion("official_price <>", value, "officialPrice");
            return (Criteria)this;
        }

        public Criteria andOfficialPriceGreaterThan(BigDecimal value) {
            addCriterion("official_price >", value, "officialPrice");
            return (Criteria)this;
        }

        public Criteria andOfficialPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("official_price >=", value, "officialPrice");
            return (Criteria)this;
        }

        public Criteria andOfficialPriceLessThan(BigDecimal value) {
            addCriterion("official_price <", value, "officialPrice");
            return (Criteria)this;
        }

        public Criteria andOfficialPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("official_price <=", value, "officialPrice");
            return (Criteria)this;
        }

        public Criteria andOfficialPriceIn(List<BigDecimal> values) {
            addCriterion("official_price in", values, "officialPrice");
            return (Criteria)this;
        }

        public Criteria andOfficialPriceNotIn(List<BigDecimal> values) {
            addCriterion("official_price not in", values, "officialPrice");
            return (Criteria)this;
        }

        public Criteria andOfficialPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("official_price between", value1, value2, "officialPrice");
            return (Criteria)this;
        }

        public Criteria andOfficialPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("official_price not between", value1, value2, "officialPrice");
            return (Criteria)this;
        }

        public Criteria andTopPriceIsNull() {
            addCriterion("top_price is null");
            return (Criteria)this;
        }

        public Criteria andTopPriceIsNotNull() {
            addCriterion("top_price is not null");
            return (Criteria)this;
        }

        public Criteria andTopPriceEqualTo(BigDecimal value) {
            addCriterion("top_price =", value, "topPrice");
            return (Criteria)this;
        }

        public Criteria andTopPriceNotEqualTo(BigDecimal value) {
            addCriterion("top_price <>", value, "topPrice");
            return (Criteria)this;
        }

        public Criteria andTopPriceGreaterThan(BigDecimal value) {
            addCriterion("top_price >", value, "topPrice");
            return (Criteria)this;
        }

        public Criteria andTopPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("top_price >=", value, "topPrice");
            return (Criteria)this;
        }

        public Criteria andTopPriceLessThan(BigDecimal value) {
            addCriterion("top_price <", value, "topPrice");
            return (Criteria)this;
        }

        public Criteria andTopPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("top_price <=", value, "topPrice");
            return (Criteria)this;
        }

        public Criteria andTopPriceIn(List<BigDecimal> values) {
            addCriterion("top_price in", values, "topPrice");
            return (Criteria)this;
        }

        public Criteria andTopPriceNotIn(List<BigDecimal> values) {
            addCriterion("top_price not in", values, "topPrice");
            return (Criteria)this;
        }

        public Criteria andTopPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("top_price between", value1, value2, "topPrice");
            return (Criteria)this;
        }

        public Criteria andTopPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("top_price not between", value1, value2, "topPrice");
            return (Criteria)this;
        }

        public Criteria andSellTimeIsNull() {
            addCriterion("sell_time is null");
            return (Criteria)this;
        }

        public Criteria andSellTimeIsNotNull() {
            addCriterion("sell_time is not null");
            return (Criteria)this;
        }

        public Criteria andSellTimeEqualTo(Date value) {
            addCriterion("sell_time =", value, "sellTime");
            return (Criteria)this;
        }

        public Criteria andSellTimeNotEqualTo(Date value) {
            addCriterion("sell_time <>", value, "sellTime");
            return (Criteria)this;
        }

        public Criteria andSellTimeGreaterThan(Date value) {
            addCriterion("sell_time >", value, "sellTime");
            return (Criteria)this;
        }

        public Criteria andSellTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sell_time >=", value, "sellTime");
            return (Criteria)this;
        }

        public Criteria andSellTimeLessThan(Date value) {
            addCriterion("sell_time <", value, "sellTime");
            return (Criteria)this;
        }

        public Criteria andSellTimeLessThanOrEqualTo(Date value) {
            addCriterion("sell_time <=", value, "sellTime");
            return (Criteria)this;
        }

        public Criteria andSellTimeIn(List<Date> values) {
            addCriterion("sell_time in", values, "sellTime");
            return (Criteria)this;
        }

        public Criteria andSellTimeNotIn(List<Date> values) {
            addCriterion("sell_time not in", values, "sellTime");
            return (Criteria)this;
        }

        public Criteria andSellTimeBetween(Date value1, Date value2) {
            addCriterion("sell_time between", value1, value2, "sellTime");
            return (Criteria)this;
        }

        public Criteria andSellTimeNotBetween(Date value1, Date value2) {
            addCriterion("sell_time not between", value1, value2, "sellTime");
            return (Criteria)this;
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
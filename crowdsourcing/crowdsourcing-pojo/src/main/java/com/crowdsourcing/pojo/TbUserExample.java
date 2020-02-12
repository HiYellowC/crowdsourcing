package com.crowdsourcing.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbUserExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltIsNull() {
            addCriterion("password_salt is null");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltIsNotNull() {
            addCriterion("password_salt is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltEqualTo(String value) {
            addCriterion("password_salt =", value, "passwordSalt");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltNotEqualTo(String value) {
            addCriterion("password_salt <>", value, "passwordSalt");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltGreaterThan(String value) {
            addCriterion("password_salt >", value, "passwordSalt");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltGreaterThanOrEqualTo(String value) {
            addCriterion("password_salt >=", value, "passwordSalt");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltLessThan(String value) {
            addCriterion("password_salt <", value, "passwordSalt");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltLessThanOrEqualTo(String value) {
            addCriterion("password_salt <=", value, "passwordSalt");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltLike(String value) {
            addCriterion("password_salt like", value, "passwordSalt");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltNotLike(String value) {
            addCriterion("password_salt not like", value, "passwordSalt");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltIn(List<String> values) {
            addCriterion("password_salt in", values, "passwordSalt");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltNotIn(List<String> values) {
            addCriterion("password_salt not in", values, "passwordSalt");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltBetween(String value1, String value2) {
            addCriterion("password_salt between", value1, value2, "passwordSalt");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltNotBetween(String value1, String value2) {
            addCriterion("password_salt not between", value1, value2, "passwordSalt");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andRoleIsNull() {
            addCriterion("role is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("role is not null");
            return (Criteria) this;
        }

        public Criteria andRoleEqualTo(String value) {
            addCriterion("role =", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotEqualTo(String value) {
            addCriterion("role <>", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThan(String value) {
            addCriterion("role >", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(String value) {
            addCriterion("role >=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThan(String value) {
            addCriterion("role <", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThanOrEqualTo(String value) {
            addCriterion("role <=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLike(String value) {
            addCriterion("role like", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotLike(String value) {
            addCriterion("role not like", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleIn(List<String> values) {
            addCriterion("role in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotIn(List<String> values) {
            addCriterion("role not in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleBetween(String value1, String value2) {
            addCriterion("role between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotBetween(String value1, String value2) {
            addCriterion("role not between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andIsLockIsNull() {
            addCriterion("is_lock is null");
            return (Criteria) this;
        }

        public Criteria andIsLockIsNotNull() {
            addCriterion("is_lock is not null");
            return (Criteria) this;
        }

        public Criteria andIsLockEqualTo(Boolean value) {
            addCriterion("is_lock =", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockNotEqualTo(Boolean value) {
            addCriterion("is_lock <>", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockGreaterThan(Boolean value) {
            addCriterion("is_lock >", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_lock >=", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockLessThan(Boolean value) {
            addCriterion("is_lock <", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockLessThanOrEqualTo(Boolean value) {
            addCriterion("is_lock <=", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockIn(List<Boolean> values) {
            addCriterion("is_lock in", values, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockNotIn(List<Boolean> values) {
            addCriterion("is_lock not in", values, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockBetween(Boolean value1, Boolean value2) {
            addCriterion("is_lock between", value1, value2, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_lock not between", value1, value2, "isLock");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andTask1QuantityIsNull() {
            addCriterion("task1_quantity is null");
            return (Criteria) this;
        }

        public Criteria andTask1QuantityIsNotNull() {
            addCriterion("task1_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andTask1QuantityEqualTo(Integer value) {
            addCriterion("task1_quantity =", value, "task1Quantity");
            return (Criteria) this;
        }

        public Criteria andTask1QuantityNotEqualTo(Integer value) {
            addCriterion("task1_quantity <>", value, "task1Quantity");
            return (Criteria) this;
        }

        public Criteria andTask1QuantityGreaterThan(Integer value) {
            addCriterion("task1_quantity >", value, "task1Quantity");
            return (Criteria) this;
        }

        public Criteria andTask1QuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("task1_quantity >=", value, "task1Quantity");
            return (Criteria) this;
        }

        public Criteria andTask1QuantityLessThan(Integer value) {
            addCriterion("task1_quantity <", value, "task1Quantity");
            return (Criteria) this;
        }

        public Criteria andTask1QuantityLessThanOrEqualTo(Integer value) {
            addCriterion("task1_quantity <=", value, "task1Quantity");
            return (Criteria) this;
        }

        public Criteria andTask1QuantityIn(List<Integer> values) {
            addCriterion("task1_quantity in", values, "task1Quantity");
            return (Criteria) this;
        }

        public Criteria andTask1QuantityNotIn(List<Integer> values) {
            addCriterion("task1_quantity not in", values, "task1Quantity");
            return (Criteria) this;
        }

        public Criteria andTask1QuantityBetween(Integer value1, Integer value2) {
            addCriterion("task1_quantity between", value1, value2, "task1Quantity");
            return (Criteria) this;
        }

        public Criteria andTask1QuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("task1_quantity not between", value1, value2, "task1Quantity");
            return (Criteria) this;
        }

        public Criteria andTask2QuantityIsNull() {
            addCriterion("task2_quantity is null");
            return (Criteria) this;
        }

        public Criteria andTask2QuantityIsNotNull() {
            addCriterion("task2_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andTask2QuantityEqualTo(Integer value) {
            addCriterion("task2_quantity =", value, "task2Quantity");
            return (Criteria) this;
        }

        public Criteria andTask2QuantityNotEqualTo(Integer value) {
            addCriterion("task2_quantity <>", value, "task2Quantity");
            return (Criteria) this;
        }

        public Criteria andTask2QuantityGreaterThan(Integer value) {
            addCriterion("task2_quantity >", value, "task2Quantity");
            return (Criteria) this;
        }

        public Criteria andTask2QuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("task2_quantity >=", value, "task2Quantity");
            return (Criteria) this;
        }

        public Criteria andTask2QuantityLessThan(Integer value) {
            addCriterion("task2_quantity <", value, "task2Quantity");
            return (Criteria) this;
        }

        public Criteria andTask2QuantityLessThanOrEqualTo(Integer value) {
            addCriterion("task2_quantity <=", value, "task2Quantity");
            return (Criteria) this;
        }

        public Criteria andTask2QuantityIn(List<Integer> values) {
            addCriterion("task2_quantity in", values, "task2Quantity");
            return (Criteria) this;
        }

        public Criteria andTask2QuantityNotIn(List<Integer> values) {
            addCriterion("task2_quantity not in", values, "task2Quantity");
            return (Criteria) this;
        }

        public Criteria andTask2QuantityBetween(Integer value1, Integer value2) {
            addCriterion("task2_quantity between", value1, value2, "task2Quantity");
            return (Criteria) this;
        }

        public Criteria andTask2QuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("task2_quantity not between", value1, value2, "task2Quantity");
            return (Criteria) this;
        }

        public Criteria andTask3QuantityIsNull() {
            addCriterion("task3_quantity is null");
            return (Criteria) this;
        }

        public Criteria andTask3QuantityIsNotNull() {
            addCriterion("task3_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andTask3QuantityEqualTo(Integer value) {
            addCriterion("task3_quantity =", value, "task3Quantity");
            return (Criteria) this;
        }

        public Criteria andTask3QuantityNotEqualTo(Integer value) {
            addCriterion("task3_quantity <>", value, "task3Quantity");
            return (Criteria) this;
        }

        public Criteria andTask3QuantityGreaterThan(Integer value) {
            addCriterion("task3_quantity >", value, "task3Quantity");
            return (Criteria) this;
        }

        public Criteria andTask3QuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("task3_quantity >=", value, "task3Quantity");
            return (Criteria) this;
        }

        public Criteria andTask3QuantityLessThan(Integer value) {
            addCriterion("task3_quantity <", value, "task3Quantity");
            return (Criteria) this;
        }

        public Criteria andTask3QuantityLessThanOrEqualTo(Integer value) {
            addCriterion("task3_quantity <=", value, "task3Quantity");
            return (Criteria) this;
        }

        public Criteria andTask3QuantityIn(List<Integer> values) {
            addCriterion("task3_quantity in", values, "task3Quantity");
            return (Criteria) this;
        }

        public Criteria andTask3QuantityNotIn(List<Integer> values) {
            addCriterion("task3_quantity not in", values, "task3Quantity");
            return (Criteria) this;
        }

        public Criteria andTask3QuantityBetween(Integer value1, Integer value2) {
            addCriterion("task3_quantity between", value1, value2, "task3Quantity");
            return (Criteria) this;
        }

        public Criteria andTask3QuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("task3_quantity not between", value1, value2, "task3Quantity");
            return (Criteria) this;
        }

        public Criteria andTask1DoubtfulQuantityIsNull() {
            addCriterion("task1_doubtful_quantity is null");
            return (Criteria) this;
        }

        public Criteria andTask1DoubtfulQuantityIsNotNull() {
            addCriterion("task1_doubtful_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andTask1DoubtfulQuantityEqualTo(Integer value) {
            addCriterion("task1_doubtful_quantity =", value, "task1DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask1DoubtfulQuantityNotEqualTo(Integer value) {
            addCriterion("task1_doubtful_quantity <>", value, "task1DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask1DoubtfulQuantityGreaterThan(Integer value) {
            addCriterion("task1_doubtful_quantity >", value, "task1DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask1DoubtfulQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("task1_doubtful_quantity >=", value, "task1DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask1DoubtfulQuantityLessThan(Integer value) {
            addCriterion("task1_doubtful_quantity <", value, "task1DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask1DoubtfulQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("task1_doubtful_quantity <=", value, "task1DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask1DoubtfulQuantityIn(List<Integer> values) {
            addCriterion("task1_doubtful_quantity in", values, "task1DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask1DoubtfulQuantityNotIn(List<Integer> values) {
            addCriterion("task1_doubtful_quantity not in", values, "task1DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask1DoubtfulQuantityBetween(Integer value1, Integer value2) {
            addCriterion("task1_doubtful_quantity between", value1, value2, "task1DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask1DoubtfulQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("task1_doubtful_quantity not between", value1, value2, "task1DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask2DoubtfulQuantityIsNull() {
            addCriterion("task2_doubtful_quantity is null");
            return (Criteria) this;
        }

        public Criteria andTask2DoubtfulQuantityIsNotNull() {
            addCriterion("task2_doubtful_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andTask2DoubtfulQuantityEqualTo(Integer value) {
            addCriterion("task2_doubtful_quantity =", value, "task2DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask2DoubtfulQuantityNotEqualTo(Integer value) {
            addCriterion("task2_doubtful_quantity <>", value, "task2DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask2DoubtfulQuantityGreaterThan(Integer value) {
            addCriterion("task2_doubtful_quantity >", value, "task2DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask2DoubtfulQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("task2_doubtful_quantity >=", value, "task2DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask2DoubtfulQuantityLessThan(Integer value) {
            addCriterion("task2_doubtful_quantity <", value, "task2DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask2DoubtfulQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("task2_doubtful_quantity <=", value, "task2DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask2DoubtfulQuantityIn(List<Integer> values) {
            addCriterion("task2_doubtful_quantity in", values, "task2DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask2DoubtfulQuantityNotIn(List<Integer> values) {
            addCriterion("task2_doubtful_quantity not in", values, "task2DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask2DoubtfulQuantityBetween(Integer value1, Integer value2) {
            addCriterion("task2_doubtful_quantity between", value1, value2, "task2DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask2DoubtfulQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("task2_doubtful_quantity not between", value1, value2, "task2DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask3DoubtfulQuantityIsNull() {
            addCriterion("task3_doubtful_quantity is null");
            return (Criteria) this;
        }

        public Criteria andTask3DoubtfulQuantityIsNotNull() {
            addCriterion("task3_doubtful_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andTask3DoubtfulQuantityEqualTo(Integer value) {
            addCriterion("task3_doubtful_quantity =", value, "task3DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask3DoubtfulQuantityNotEqualTo(Integer value) {
            addCriterion("task3_doubtful_quantity <>", value, "task3DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask3DoubtfulQuantityGreaterThan(Integer value) {
            addCriterion("task3_doubtful_quantity >", value, "task3DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask3DoubtfulQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("task3_doubtful_quantity >=", value, "task3DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask3DoubtfulQuantityLessThan(Integer value) {
            addCriterion("task3_doubtful_quantity <", value, "task3DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask3DoubtfulQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("task3_doubtful_quantity <=", value, "task3DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask3DoubtfulQuantityIn(List<Integer> values) {
            addCriterion("task3_doubtful_quantity in", values, "task3DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask3DoubtfulQuantityNotIn(List<Integer> values) {
            addCriterion("task3_doubtful_quantity not in", values, "task3DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask3DoubtfulQuantityBetween(Integer value1, Integer value2) {
            addCriterion("task3_doubtful_quantity between", value1, value2, "task3DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andTask3DoubtfulQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("task3_doubtful_quantity not between", value1, value2, "task3DoubtfulQuantity");
            return (Criteria) this;
        }

        public Criteria andPermissionIsNull() {
            addCriterion("permission is null");
            return (Criteria) this;
        }

        public Criteria andPermissionIsNotNull() {
            addCriterion("permission is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionEqualTo(Integer value) {
            addCriterion("permission =", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotEqualTo(Integer value) {
            addCriterion("permission <>", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionGreaterThan(Integer value) {
            addCriterion("permission >", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionGreaterThanOrEqualTo(Integer value) {
            addCriterion("permission >=", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionLessThan(Integer value) {
            addCriterion("permission <", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionLessThanOrEqualTo(Integer value) {
            addCriterion("permission <=", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionIn(List<Integer> values) {
            addCriterion("permission in", values, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotIn(List<Integer> values) {
            addCriterion("permission not in", values, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionBetween(Integer value1, Integer value2) {
            addCriterion("permission between", value1, value2, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotBetween(Integer value1, Integer value2) {
            addCriterion("permission not between", value1, value2, "permission");
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
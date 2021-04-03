package com.me2me.user.model;

import com.me2me.common.web.BaseEntity;

public class UserToken implements BaseEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_token.id
     *
     * @mbggenerated Mon Feb 29 15:09:33 CST 2016
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_token.uid
     *
     * @mbggenerated Mon Feb 29 15:09:33 CST 2016
     */
    private Long uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_token.token
     *
     * @mbggenerated Mon Feb 29 15:09:33 CST 2016
     */
    private String token;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_token.id
     *
     * @return the value of user_token.id
     *
     * @mbggenerated Mon Feb 29 15:09:33 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_token.id
     *
     * @param id the value for user_token.id
     *
     * @mbggenerated Mon Feb 29 15:09:33 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_token.uid
     *
     * @return the value of user_token.uid
     *
     * @mbggenerated Mon Feb 29 15:09:33 CST 2016
     */
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_token.uid
     *
     * @param uid the value for user_token.uid
     *
     * @mbggenerated Mon Feb 29 15:09:33 CST 2016
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_token.token
     *
     * @return the value of user_token.token
     *
     * @mbggenerated Mon Feb 29 15:09:33 CST 2016
     */
    public String getToken() {
        return token;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_token.token
     *
     * @param token the value for user_token.token
     *
     * @mbggenerated Mon Feb 29 15:09:33 CST 2016
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }
}
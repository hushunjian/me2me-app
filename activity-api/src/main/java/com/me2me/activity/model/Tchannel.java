package com.me2me.activity.model;

import com.me2me.common.web.BaseEntity;

public class Tchannel implements BaseEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_channel.id
     *
     * @mbggenerated Thu Dec 15 19:35:29 CST 2016
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_channel.name
     *
     * @mbggenerated Thu Dec 15 19:35:29 CST 2016
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_channel.code
     *
     * @mbggenerated Thu Dec 15 19:35:29 CST 2016
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_channel.type
     *
     * @mbggenerated Thu Dec 15 19:35:29 CST 2016
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_channel.parent_id
     *
     * @mbggenerated Thu Dec 15 19:35:29 CST 2016
     */
    private Long parentId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_channel.id
     *
     * @return the value of t_channel.id
     *
     * @mbggenerated Thu Dec 15 19:35:29 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_channel.id
     *
     * @param id the value for t_channel.id
     *
     * @mbggenerated Thu Dec 15 19:35:29 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_channel.name
     *
     * @return the value of t_channel.name
     *
     * @mbggenerated Thu Dec 15 19:35:29 CST 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_channel.name
     *
     * @param name the value for t_channel.name
     *
     * @mbggenerated Thu Dec 15 19:35:29 CST 2016
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_channel.code
     *
     * @return the value of t_channel.code
     *
     * @mbggenerated Thu Dec 15 19:35:29 CST 2016
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_channel.code
     *
     * @param code the value for t_channel.code
     *
     * @mbggenerated Thu Dec 15 19:35:29 CST 2016
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_channel.type
     *
     * @return the value of t_channel.type
     *
     * @mbggenerated Thu Dec 15 19:35:29 CST 2016
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_channel.type
     *
     * @param type the value for t_channel.type
     *
     * @mbggenerated Thu Dec 15 19:35:29 CST 2016
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_channel.parent_id
     *
     * @return the value of t_channel.parent_id
     *
     * @mbggenerated Thu Dec 15 19:35:29 CST 2016
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_channel.parent_id
     *
     * @param parentId the value for t_channel.parent_id
     *
     * @mbggenerated Thu Dec 15 19:35:29 CST 2016
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
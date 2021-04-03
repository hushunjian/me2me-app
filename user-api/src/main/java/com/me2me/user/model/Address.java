package com.me2me.user.model;

import com.me2me.common.web.BaseEntity;

public class Address implements BaseEntity{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.id
     *
     * @mbggenerated Mon Feb 29 16:27:09 CST 2016
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.code
     *
     * @mbggenerated Mon Feb 29 16:27:09 CST 2016
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.name
     *
     * @mbggenerated Mon Feb 29 16:27:09 CST 2016
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.pid
     *
     * @mbggenerated Mon Feb 29 16:27:09 CST 2016
     */
    private Long pid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.id
     *
     * @return the value of address.id
     *
     * @mbggenerated Mon Feb 29 16:27:09 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.id
     *
     * @param id the value for address.id
     *
     * @mbggenerated Mon Feb 29 16:27:09 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.code
     *
     * @return the value of address.code
     *
     * @mbggenerated Mon Feb 29 16:27:09 CST 2016
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.code
     *
     * @param code the value for address.code
     *
     * @mbggenerated Mon Feb 29 16:27:09 CST 2016
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.name
     *
     * @return the value of address.name
     *
     * @mbggenerated Mon Feb 29 16:27:09 CST 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.name
     *
     * @param name the value for address.name
     *
     * @mbggenerated Mon Feb 29 16:27:09 CST 2016
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.pid
     *
     * @return the value of address.pid
     *
     * @mbggenerated Mon Feb 29 16:27:09 CST 2016
     */
    public Long getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.pid
     *
     * @param pid the value for address.pid
     *
     * @mbggenerated Mon Feb 29 16:27:09 CST 2016
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }
}
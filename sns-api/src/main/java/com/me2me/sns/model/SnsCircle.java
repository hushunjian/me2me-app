package com.me2me.sns.model;

import com.me2me.common.web.BaseEntity;

import java.util.Date;

public class SnsCircle implements BaseEntity{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sns_circle.id
     *
     * @mbggenerated Mon Jun 27 15:11:26 CST 2016
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sns_circle.uid
     *
     * @mbggenerated Mon Jun 27 15:11:26 CST 2016
     */
    private Long uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sns_circle.owner
     *
     * @mbggenerated Mon Jun 27 15:11:26 CST 2016
     */
    private Long owner;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sns_circle.internal_status
     *
     * @mbggenerated Mon Jun 27 15:11:26 CST 2016
     */
    private Integer internalStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sns_circle.create_time
     *
     * @mbggenerated Mon Jun 27 15:11:26 CST 2016
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sns_circle.id
     *
     * @return the value of sns_circle.id
     *
     * @mbggenerated Mon Jun 27 15:11:26 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sns_circle.id
     *
     * @param id the value for sns_circle.id
     *
     * @mbggenerated Mon Jun 27 15:11:26 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sns_circle.uid
     *
     * @return the value of sns_circle.uid
     *
     * @mbggenerated Mon Jun 27 15:11:26 CST 2016
     */
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sns_circle.uid
     *
     * @param uid the value for sns_circle.uid
     *
     * @mbggenerated Mon Jun 27 15:11:26 CST 2016
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sns_circle.owner
     *
     * @return the value of sns_circle.owner
     *
     * @mbggenerated Mon Jun 27 15:11:26 CST 2016
     */
    public Long getOwner() {
        return owner;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sns_circle.owner
     *
     * @param owner the value for sns_circle.owner
     *
     * @mbggenerated Mon Jun 27 15:11:26 CST 2016
     */
    public void setOwner(Long owner) {
        this.owner = owner;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sns_circle.internal_status
     *
     * @return the value of sns_circle.internal_status
     *
     * @mbggenerated Mon Jun 27 15:11:26 CST 2016
     */
    public Integer getInternalStatus() {
        return internalStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sns_circle.internal_status
     *
     * @param internalStatus the value for sns_circle.internal_status
     *
     * @mbggenerated Mon Jun 27 15:11:26 CST 2016
     */
    public void setInternalStatus(Integer internalStatus) {
        this.internalStatus = internalStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sns_circle.create_time
     *
     * @return the value of sns_circle.create_time
     *
     * @mbggenerated Mon Jun 27 15:11:26 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sns_circle.create_time
     *
     * @param createTime the value for sns_circle.create_time
     *
     * @mbggenerated Mon Jun 27 15:11:26 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
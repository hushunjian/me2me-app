package com.me2me.content.model;

import com.me2me.common.web.BaseEntity;

import java.util.Date;

public class ContentReview implements BaseEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column content_review.id
     *
     * @mbggenerated Tue Nov 15 10:49:26 CST 2016
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column content_review.uid
     *
     * @mbggenerated Tue Nov 15 10:49:26 CST 2016
     */
    private Long uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column content_review.review
     *
     * @mbggenerated Tue Nov 15 10:49:26 CST 2016
     */
    private String review;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column content_review.cid
     *
     * @mbggenerated Tue Nov 15 10:49:26 CST 2016
     */
    private Long cid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column content_review.create_time
     *
     * @mbggenerated Tue Nov 15 10:49:26 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column content_review.at_uid
     *
     * @mbggenerated Tue Nov 15 10:49:26 CST 2016
     */
    private Long atUid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column content_review.extra
     *
     * @mbggenerated Tue Nov 15 10:49:26 CST 2016
     */
    private String extra;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column content_review.status
     *
     * @mbggenerated Tue Nov 15 10:49:26 CST 2016
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column content_review.id
     *
     * @return the value of content_review.id
     *
     * @mbggenerated Tue Nov 15 10:49:26 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column content_review.id
     *
     * @param id the value for content_review.id
     *
     * @mbggenerated Tue Nov 15 10:49:26 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column content_review.uid
     *
     * @return the value of content_review.uid
     *
     * @mbggenerated Tue Nov 15 10:49:26 CST 2016
     */
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column content_review.uid
     *
     * @param uid the value for content_review.uid
     *
     * @mbggenerated Tue Nov 15 10:49:26 CST 2016
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column content_review.review
     *
     * @return the value of content_review.review
     *
     * @mbggenerated Tue Nov 15 10:49:26 CST 2016
     */
    public String getReview() {
        return review;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column content_review.review
     *
     * @param review the value for content_review.review
     *
     * @mbggenerated Tue Nov 15 10:49:26 CST 2016
     */
    public void setReview(String review) {
        this.review = review == null ? null : review.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column content_review.cid
     *
     * @return the value of content_review.cid
     *
     * @mbggenerated Tue Nov 15 10:49:26 CST 2016
     */
    public Long getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column content_review.cid
     *
     * @param cid the value for content_review.cid
     *
     * @mbggenerated Tue Nov 15 10:49:26 CST 2016
     */
    public void setCid(Long cid) {
        this.cid = cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column content_review.create_time
     *
     * @return the value of content_review.create_time
     *
     * @mbggenerated Tue Nov 15 10:49:26 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column content_review.create_time
     *
     * @param createTime the value for content_review.create_time
     *
     * @mbggenerated Tue Nov 15 10:49:26 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column content_review.at_uid
     *
     * @return the value of content_review.at_uid
     *
     * @mbggenerated Tue Nov 15 10:49:26 CST 2016
     */
    public Long getAtUid() {
        return atUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column content_review.at_uid
     *
     * @param atUid the value for content_review.at_uid
     *
     * @mbggenerated Tue Nov 15 10:49:26 CST 2016
     */
    public void setAtUid(Long atUid) {
        this.atUid = atUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column content_review.extra
     *
     * @return the value of content_review.extra
     *
     * @mbggenerated Tue Nov 15 10:49:26 CST 2016
     */
    public String getExtra() {
        return extra;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column content_review.extra
     *
     * @param extra the value for content_review.extra
     *
     * @mbggenerated Tue Nov 15 10:49:26 CST 2016
     */
    public void setExtra(String extra) {
        this.extra = extra == null ? null : extra.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column content_review.status
     *
     * @return the value of content_review.status
     *
     * @mbggenerated Tue Nov 15 10:49:26 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column content_review.status
     *
     * @param status the value for content_review.status
     *
     * @mbggenerated Tue Nov 15 10:49:26 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}
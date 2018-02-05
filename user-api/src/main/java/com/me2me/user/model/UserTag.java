package com.me2me.user.model;

import java.util.Date;

import com.me2me.common.web.BaseEntity;

public class UserTag  implements BaseEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_tag.id
     *
     * @mbggenerated Thu Oct 12 10:35:02 CST 2017
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_tag.uid
     *
     * @mbggenerated Thu Oct 12 10:35:02 CST 2017
     */
    private Long uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_tag.tag_id
     *
     * @mbggenerated Thu Oct 12 10:35:02 CST 2017
     */
    private Long tagId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_tag.type
     *
     * @mbggenerated Thu Oct 12 10:35:02 CST 2017
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_tag.score
     *
     * @mbggenerated Thu Oct 12 10:35:02 CST 2017
     */
    private Integer score;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_tag.is_top
     *
     * @mbggenerated Thu Oct 12 10:35:02 CST 2017
     */
    private Integer isTop;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_tag.top_time
     *
     * @mbggenerated Thu Oct 12 10:35:02 CST 2017
     */
    private Date topTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_tag.create_time
     *
     * @mbggenerated Thu Oct 12 10:35:02 CST 2017
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_tag.id
     *
     * @return the value of user_tag.id
     *
     * @mbggenerated Thu Oct 12 10:35:02 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_tag.id
     *
     * @param id the value for user_tag.id
     *
     * @mbggenerated Thu Oct 12 10:35:02 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_tag.uid
     *
     * @return the value of user_tag.uid
     *
     * @mbggenerated Thu Oct 12 10:35:02 CST 2017
     */
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_tag.uid
     *
     * @param uid the value for user_tag.uid
     *
     * @mbggenerated Thu Oct 12 10:35:02 CST 2017
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_tag.tag_id
     *
     * @return the value of user_tag.tag_id
     *
     * @mbggenerated Thu Oct 12 10:35:02 CST 2017
     */
    public Long getTagId() {
        return tagId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_tag.tag_id
     *
     * @param tagId the value for user_tag.tag_id
     *
     * @mbggenerated Thu Oct 12 10:35:02 CST 2017
     */
    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_tag.type
     *
     * @return the value of user_tag.type
     *
     * @mbggenerated Thu Oct 12 10:35:02 CST 2017
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_tag.type
     *
     * @param type the value for user_tag.type
     *
     * @mbggenerated Thu Oct 12 10:35:02 CST 2017
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_tag.score
     *
     * @return the value of user_tag.score
     *
     * @mbggenerated Thu Oct 12 10:35:02 CST 2017
     */
    public Integer getScore() {
        return score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_tag.score
     *
     * @param score the value for user_tag.score
     *
     * @mbggenerated Thu Oct 12 10:35:02 CST 2017
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_tag.is_top
     *
     * @return the value of user_tag.is_top
     *
     * @mbggenerated Thu Oct 12 10:35:02 CST 2017
     */
    public Integer getIsTop() {
        return isTop;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_tag.is_top
     *
     * @param isTop the value for user_tag.is_top
     *
     * @mbggenerated Thu Oct 12 10:35:02 CST 2017
     */
    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_tag.top_time
     *
     * @return the value of user_tag.top_time
     *
     * @mbggenerated Thu Oct 12 10:35:02 CST 2017
     */
    public Date getTopTime() {
        return topTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_tag.top_time
     *
     * @param topTime the value for user_tag.top_time
     *
     * @mbggenerated Thu Oct 12 10:35:02 CST 2017
     */
    public void setTopTime(Date topTime) {
        this.topTime = topTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_tag.create_time
     *
     * @return the value of user_tag.create_time
     *
     * @mbggenerated Thu Oct 12 10:35:02 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_tag.create_time
     *
     * @param createTime the value for user_tag.create_time
     *
     * @mbggenerated Thu Oct 12 10:35:02 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
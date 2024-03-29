package com.me2me.live.model;

import java.util.Date;

import com.me2me.common.web.BaseEntity;

public class TopicUserForbid implements BaseEntity{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_user_forbid.id
     *
     * @mbggenerated Tue Nov 07 17:28:38 CST 2017
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_user_forbid.topic_id
     *
     * @mbggenerated Tue Nov 07 17:28:38 CST 2017
     */
    private Long topicId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_user_forbid.uid
     *
     * @mbggenerated Tue Nov 07 17:28:38 CST 2017
     */
    private Long uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_user_forbid.forbid_pattern
     *
     * @mbggenerated Tue Nov 07 17:28:38 CST 2017
     */
    private Integer forbidPattern;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_user_forbid.opt_uid
     *
     * @mbggenerated Tue Nov 07 17:28:38 CST 2017
     */
    private Long optUid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_user_forbid.create_time
     *
     * @mbggenerated Tue Nov 07 17:28:38 CST 2017
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_user_forbid.id
     *
     * @return the value of topic_user_forbid.id
     *
     * @mbggenerated Tue Nov 07 17:28:38 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_user_forbid.id
     *
     * @param id the value for topic_user_forbid.id
     *
     * @mbggenerated Tue Nov 07 17:28:38 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_user_forbid.topic_id
     *
     * @return the value of topic_user_forbid.topic_id
     *
     * @mbggenerated Tue Nov 07 17:28:38 CST 2017
     */
    public Long getTopicId() {
        return topicId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_user_forbid.topic_id
     *
     * @param topicId the value for topic_user_forbid.topic_id
     *
     * @mbggenerated Tue Nov 07 17:28:38 CST 2017
     */
    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_user_forbid.uid
     *
     * @return the value of topic_user_forbid.uid
     *
     * @mbggenerated Tue Nov 07 17:28:38 CST 2017
     */
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_user_forbid.uid
     *
     * @param uid the value for topic_user_forbid.uid
     *
     * @mbggenerated Tue Nov 07 17:28:38 CST 2017
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_user_forbid.forbid_pattern
     *
     * @return the value of topic_user_forbid.forbid_pattern
     *
     * @mbggenerated Tue Nov 07 17:28:38 CST 2017
     */
    public Integer getForbidPattern() {
        return forbidPattern;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_user_forbid.forbid_pattern
     *
     * @param forbidPattern the value for topic_user_forbid.forbid_pattern
     *
     * @mbggenerated Tue Nov 07 17:28:38 CST 2017
     */
    public void setForbidPattern(Integer forbidPattern) {
        this.forbidPattern = forbidPattern;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_user_forbid.opt_uid
     *
     * @return the value of topic_user_forbid.opt_uid
     *
     * @mbggenerated Tue Nov 07 17:28:38 CST 2017
     */
    public Long getOptUid() {
        return optUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_user_forbid.opt_uid
     *
     * @param optUid the value for topic_user_forbid.opt_uid
     *
     * @mbggenerated Tue Nov 07 17:28:38 CST 2017
     */
    public void setOptUid(Long optUid) {
        this.optUid = optUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_user_forbid.create_time
     *
     * @return the value of topic_user_forbid.create_time
     *
     * @mbggenerated Tue Nov 07 17:28:38 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_user_forbid.create_time
     *
     * @param createTime the value for topic_user_forbid.create_time
     *
     * @mbggenerated Tue Nov 07 17:28:38 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
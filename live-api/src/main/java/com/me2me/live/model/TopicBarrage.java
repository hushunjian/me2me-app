package com.me2me.live.model;

import com.me2me.common.web.BaseEntity;

import java.util.Date;

public class TopicBarrage implements BaseEntity{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_barrage.id
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_barrage.topic_id
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    private Long topicId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_barrage.uid
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    private Long uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_barrage.fragment_image
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    private String fragmentImage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_barrage.type
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_barrage.content_type
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    private Integer contentType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_barrage.top_id
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    private Long topId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_barrage.bottom_id
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    private Long bottomId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_barrage.create_time
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_barrage.fid
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    private Long fid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_barrage.status
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_barrage.fragment
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    private String fragment;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_barrage.id
     *
     * @return the value of topic_barrage.id
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_barrage.id
     *
     * @param id the value for topic_barrage.id
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_barrage.topic_id
     *
     * @return the value of topic_barrage.topic_id
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    public Long getTopicId() {
        return topicId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_barrage.topic_id
     *
     * @param topicId the value for topic_barrage.topic_id
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_barrage.uid
     *
     * @return the value of topic_barrage.uid
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_barrage.uid
     *
     * @param uid the value for topic_barrage.uid
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_barrage.fragment_image
     *
     * @return the value of topic_barrage.fragment_image
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    public String getFragmentImage() {
        return fragmentImage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_barrage.fragment_image
     *
     * @param fragmentImage the value for topic_barrage.fragment_image
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    public void setFragmentImage(String fragmentImage) {
        this.fragmentImage = fragmentImage == null ? null : fragmentImage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_barrage.type
     *
     * @return the value of topic_barrage.type
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_barrage.type
     *
     * @param type the value for topic_barrage.type
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_barrage.content_type
     *
     * @return the value of topic_barrage.content_type
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    public Integer getContentType() {
        return contentType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_barrage.content_type
     *
     * @param contentType the value for topic_barrage.content_type
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_barrage.top_id
     *
     * @return the value of topic_barrage.top_id
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    public Long getTopId() {
        return topId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_barrage.top_id
     *
     * @param topId the value for topic_barrage.top_id
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    public void setTopId(Long topId) {
        this.topId = topId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_barrage.bottom_id
     *
     * @return the value of topic_barrage.bottom_id
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    public Long getBottomId() {
        return bottomId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_barrage.bottom_id
     *
     * @param bottomId the value for topic_barrage.bottom_id
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    public void setBottomId(Long bottomId) {
        this.bottomId = bottomId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_barrage.create_time
     *
     * @return the value of topic_barrage.create_time
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_barrage.create_time
     *
     * @param createTime the value for topic_barrage.create_time
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_barrage.fid
     *
     * @return the value of topic_barrage.fid
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    public Long getFid() {
        return fid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_barrage.fid
     *
     * @param fid the value for topic_barrage.fid
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    public void setFid(Long fid) {
        this.fid = fid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_barrage.status
     *
     * @return the value of topic_barrage.status
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_barrage.status
     *
     * @param status the value for topic_barrage.status
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_barrage.fragment
     *
     * @return the value of topic_barrage.fragment
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    public String getFragment() {
        return fragment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_barrage.fragment
     *
     * @param fragment the value for topic_barrage.fragment
     *
     * @mbggenerated Sat Oct 08 18:01:28 CST 2016
     */
    public void setFragment(String fragment) {
        this.fragment = fragment == null ? null : fragment.trim();
    }
}
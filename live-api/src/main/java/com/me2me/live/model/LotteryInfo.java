package com.me2me.live.model;

import java.util.Date;

import com.me2me.common.web.BaseEntity;

public class LotteryInfo  implements BaseEntity{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lottery_info.id
     *
     * @mbggenerated Mon Aug 07 10:57:33 CST 2017
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lottery_info.topic_id
     *
     * @mbggenerated Mon Aug 07 10:57:33 CST 2017
     */
    private Long topicId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lottery_info.uid
     *
     * @mbggenerated Mon Aug 07 10:57:33 CST 2017
     */
    private Long uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lottery_info.title
     *
     * @mbggenerated Mon Aug 07 10:57:33 CST 2017
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lottery_info.summary
     *
     * @mbggenerated Mon Aug 07 10:57:33 CST 2017
     */
    private String summary;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lottery_info.win_number
     *
     * @mbggenerated Mon Aug 07 10:57:33 CST 2017
     */
    private Integer winNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lottery_info.create_time
     *
     * @mbggenerated Mon Aug 07 10:57:33 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lottery_info.end_time
     *
     * @mbggenerated Mon Aug 07 10:57:33 CST 2017
     */
    private Date endTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lottery_info.status
     *
     * @mbggenerated Mon Aug 07 10:57:33 CST 2017
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lottery_info.id
     *
     * @return the value of lottery_info.id
     *
     * @mbggenerated Mon Aug 07 10:57:33 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lottery_info.id
     *
     * @param id the value for lottery_info.id
     *
     * @mbggenerated Mon Aug 07 10:57:33 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lottery_info.topic_id
     *
     * @return the value of lottery_info.topic_id
     *
     * @mbggenerated Mon Aug 07 10:57:33 CST 2017
     */
    public Long getTopicId() {
        return topicId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lottery_info.topic_id
     *
     * @param topicId the value for lottery_info.topic_id
     *
     * @mbggenerated Mon Aug 07 10:57:33 CST 2017
     */
    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lottery_info.uid
     *
     * @return the value of lottery_info.uid
     *
     * @mbggenerated Mon Aug 07 10:57:33 CST 2017
     */
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lottery_info.uid
     *
     * @param uid the value for lottery_info.uid
     *
     * @mbggenerated Mon Aug 07 10:57:33 CST 2017
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lottery_info.title
     *
     * @return the value of lottery_info.title
     *
     * @mbggenerated Mon Aug 07 10:57:33 CST 2017
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lottery_info.title
     *
     * @param title the value for lottery_info.title
     *
     * @mbggenerated Mon Aug 07 10:57:33 CST 2017
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lottery_info.summary
     *
     * @return the value of lottery_info.summary
     *
     * @mbggenerated Mon Aug 07 10:57:33 CST 2017
     */
    public String getSummary() {
        return summary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lottery_info.summary
     *
     * @param summary the value for lottery_info.summary
     *
     * @mbggenerated Mon Aug 07 10:57:33 CST 2017
     */
    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lottery_info.win_number
     *
     * @return the value of lottery_info.win_number
     *
     * @mbggenerated Mon Aug 07 10:57:33 CST 2017
     */
    public Integer getWinNumber() {
        return winNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lottery_info.win_number
     *
     * @param winNumber the value for lottery_info.win_number
     *
     * @mbggenerated Mon Aug 07 10:57:33 CST 2017
     */
    public void setWinNumber(Integer winNumber) {
        this.winNumber = winNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lottery_info.create_time
     *
     * @return the value of lottery_info.create_time
     *
     * @mbggenerated Mon Aug 07 10:57:33 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lottery_info.create_time
     *
     * @param createTime the value for lottery_info.create_time
     *
     * @mbggenerated Mon Aug 07 10:57:33 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lottery_info.end_time
     *
     * @return the value of lottery_info.end_time
     *
     * @mbggenerated Mon Aug 07 10:57:33 CST 2017
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lottery_info.end_time
     *
     * @param endTime the value for lottery_info.end_time
     *
     * @mbggenerated Mon Aug 07 10:57:33 CST 2017
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lottery_info.status
     *
     * @return the value of lottery_info.status
     *
     * @mbggenerated Mon Aug 07 10:57:33 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lottery_info.status
     *
     * @param status the value for lottery_info.status
     *
     * @mbggenerated Mon Aug 07 10:57:33 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}
package com.me2me.activity.model;

import com.me2me.common.web.BaseEntity;

public class AmiliData implements BaseEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column a_mili_data.id
     *
     * @mbggenerated Fri Jan 06 16:19:16 CST 2017
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column a_mili_data.mkey
     *
     * @mbggenerated Fri Jan 06 16:19:16 CST 2017
     */
    private String mkey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column a_mili_data.type
     *
     * @mbggenerated Fri Jan 06 16:19:16 CST 2017
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column a_mili_data.link_url
     *
     * @mbggenerated Fri Jan 06 16:19:16 CST 2017
     */
    private String linkUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column a_mili_data.orderby
     *
     * @mbggenerated Fri Jan 06 16:19:16 CST 2017
     */
    private Integer orderby;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column a_mili_data.status
     *
     * @mbggenerated Fri Jan 06 16:19:16 CST 2017
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column a_mili_data.activity_id
     *
     * @mbggenerated Fri Jan 06 16:19:16 CST 2017
     */
    private Long activityId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column a_mili_data.content
     *
     * @mbggenerated Fri Jan 06 16:19:16 CST 2017
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column a_mili_data.id
     *
     * @return the value of a_mili_data.id
     *
     * @mbggenerated Fri Jan 06 16:19:16 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column a_mili_data.id
     *
     * @param id the value for a_mili_data.id
     *
     * @mbggenerated Fri Jan 06 16:19:16 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column a_mili_data.mkey
     *
     * @return the value of a_mili_data.mkey
     *
     * @mbggenerated Fri Jan 06 16:19:16 CST 2017
     */
    public String getMkey() {
        return mkey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column a_mili_data.mkey
     *
     * @param mkey the value for a_mili_data.mkey
     *
     * @mbggenerated Fri Jan 06 16:19:16 CST 2017
     */
    public void setMkey(String mkey) {
        this.mkey = mkey == null ? null : mkey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column a_mili_data.type
     *
     * @return the value of a_mili_data.type
     *
     * @mbggenerated Fri Jan 06 16:19:16 CST 2017
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column a_mili_data.type
     *
     * @param type the value for a_mili_data.type
     *
     * @mbggenerated Fri Jan 06 16:19:16 CST 2017
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column a_mili_data.link_url
     *
     * @return the value of a_mili_data.link_url
     *
     * @mbggenerated Fri Jan 06 16:19:16 CST 2017
     */
    public String getLinkUrl() {
        return linkUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column a_mili_data.link_url
     *
     * @param linkUrl the value for a_mili_data.link_url
     *
     * @mbggenerated Fri Jan 06 16:19:16 CST 2017
     */
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column a_mili_data.orderby
     *
     * @return the value of a_mili_data.orderby
     *
     * @mbggenerated Fri Jan 06 16:19:16 CST 2017
     */
    public Integer getOrderby() {
        return orderby;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column a_mili_data.orderby
     *
     * @param orderby the value for a_mili_data.orderby
     *
     * @mbggenerated Fri Jan 06 16:19:16 CST 2017
     */
    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column a_mili_data.status
     *
     * @return the value of a_mili_data.status
     *
     * @mbggenerated Fri Jan 06 16:19:16 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column a_mili_data.status
     *
     * @param status the value for a_mili_data.status
     *
     * @mbggenerated Fri Jan 06 16:19:16 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column a_mili_data.activity_id
     *
     * @return the value of a_mili_data.activity_id
     *
     * @mbggenerated Fri Jan 06 16:19:16 CST 2017
     */
    public Long getActivityId() {
        return activityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column a_mili_data.activity_id
     *
     * @param activityId the value for a_mili_data.activity_id
     *
     * @mbggenerated Fri Jan 06 16:19:16 CST 2017
     */
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column a_mili_data.content
     *
     * @return the value of a_mili_data.content
     *
     * @mbggenerated Fri Jan 06 16:19:16 CST 2017
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column a_mili_data.content
     *
     * @param content the value for a_mili_data.content
     *
     * @mbggenerated Fri Jan 06 16:19:16 CST 2017
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
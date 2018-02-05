package com.me2me.user.model;

import java.io.Serializable;
import java.util.Date;

public class AppHttpAccess implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_http_access.id
     *
     * @mbggenerated Wed Dec 27 17:13:41 CST 2017
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_http_access.uid
     *
     * @mbggenerated Wed Dec 27 17:13:41 CST 2017
     */
    private Long uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_http_access.request_uri
     *
     * @mbggenerated Wed Dec 27 17:13:41 CST 2017
     */
    private String requestUri;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_http_access.request_method
     *
     * @mbggenerated Wed Dec 27 17:13:41 CST 2017
     */
    private String requestMethod;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_http_access.start_time
     *
     * @mbggenerated Wed Dec 27 17:13:41 CST 2017
     */
    private Long startTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_http_access.end_time
     *
     * @mbggenerated Wed Dec 27 17:13:41 CST 2017
     */
    private Long endTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_http_access.create_time
     *
     * @mbggenerated Wed Dec 27 17:13:41 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_http_access.request_params
     *
     * @mbggenerated Wed Dec 27 17:13:41 CST 2017
     */
    private String requestParams;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_http_access.id
     *
     * @return the value of app_http_access.id
     *
     * @mbggenerated Wed Dec 27 17:13:41 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_http_access.id
     *
     * @param id the value for app_http_access.id
     *
     * @mbggenerated Wed Dec 27 17:13:41 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_http_access.uid
     *
     * @return the value of app_http_access.uid
     *
     * @mbggenerated Wed Dec 27 17:13:41 CST 2017
     */
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_http_access.uid
     *
     * @param uid the value for app_http_access.uid
     *
     * @mbggenerated Wed Dec 27 17:13:41 CST 2017
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_http_access.request_uri
     *
     * @return the value of app_http_access.request_uri
     *
     * @mbggenerated Wed Dec 27 17:13:41 CST 2017
     */
    public String getRequestUri() {
        return requestUri;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_http_access.request_uri
     *
     * @param requestUri the value for app_http_access.request_uri
     *
     * @mbggenerated Wed Dec 27 17:13:41 CST 2017
     */
    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri == null ? null : requestUri.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_http_access.request_method
     *
     * @return the value of app_http_access.request_method
     *
     * @mbggenerated Wed Dec 27 17:13:41 CST 2017
     */
    public String getRequestMethod() {
        return requestMethod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_http_access.request_method
     *
     * @param requestMethod the value for app_http_access.request_method
     *
     * @mbggenerated Wed Dec 27 17:13:41 CST 2017
     */
    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod == null ? null : requestMethod.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_http_access.start_time
     *
     * @return the value of app_http_access.start_time
     *
     * @mbggenerated Wed Dec 27 17:13:41 CST 2017
     */
    public Long getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_http_access.start_time
     *
     * @param startTime the value for app_http_access.start_time
     *
     * @mbggenerated Wed Dec 27 17:13:41 CST 2017
     */
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_http_access.end_time
     *
     * @return the value of app_http_access.end_time
     *
     * @mbggenerated Wed Dec 27 17:13:41 CST 2017
     */
    public Long getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_http_access.end_time
     *
     * @param endTime the value for app_http_access.end_time
     *
     * @mbggenerated Wed Dec 27 17:13:41 CST 2017
     */
    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_http_access.create_time
     *
     * @return the value of app_http_access.create_time
     *
     * @mbggenerated Wed Dec 27 17:13:41 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_http_access.create_time
     *
     * @param createTime the value for app_http_access.create_time
     *
     * @mbggenerated Wed Dec 27 17:13:41 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_http_access.request_params
     *
     * @return the value of app_http_access.request_params
     *
     * @mbggenerated Wed Dec 27 17:13:41 CST 2017
     */
    public String getRequestParams() {
        return requestParams;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_http_access.request_params
     *
     * @param requestParams the value for app_http_access.request_params
     *
     * @mbggenerated Wed Dec 27 17:13:41 CST 2017
     */
    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams == null ? null : requestParams.trim();
    }
}
package com.me2me.content.model;

import com.me2me.common.web.BaseEntity;

public class HighQualityContent implements BaseEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column high_quality_content.id
     *
     * @mbggenerated Thu Apr 07 14:52:39 CST 2016
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column high_quality_content.cid
     *
     * @mbggenerated Thu Apr 07 14:52:39 CST 2016
     */
    private Long cid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column high_quality_content.id
     *
     * @return the value of high_quality_content.id
     *
     * @mbggenerated Thu Apr 07 14:52:39 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column high_quality_content.id
     *
     * @param id the value for high_quality_content.id
     *
     * @mbggenerated Thu Apr 07 14:52:39 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column high_quality_content.cid
     *
     * @return the value of high_quality_content.cid
     *
     * @mbggenerated Thu Apr 07 14:52:39 CST 2016
     */
    public Long getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column high_quality_content.cid
     *
     * @param cid the value for high_quality_content.cid
     *
     * @mbggenerated Thu Apr 07 14:52:39 CST 2016
     */
    public void setCid(Long cid) {
        this.cid = cid;
    }
}
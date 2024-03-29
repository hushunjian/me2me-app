package com.me2me.activity.model;

import java.util.Date;

import com.me2me.common.web.BaseEntity;

public class GameUserRecordHis implements BaseEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column game_user_record_his.id
     *
     * @mbggenerated Fri Oct 13 16:12:13 CST 2017
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column game_user_record_his.game_id
     *
     * @mbggenerated Fri Oct 13 16:12:13 CST 2017
     */
    private Long gameId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column game_user_record_his.uid
     *
     * @mbggenerated Fri Oct 13 16:12:13 CST 2017
     */
    private Long uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column game_user_record_his.record
     *
     * @mbggenerated Fri Oct 13 16:12:13 CST 2017
     */
    private Integer record;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column game_user_record_his.create_time
     *
     * @mbggenerated Fri Oct 13 16:12:13 CST 2017
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column game_user_record_his.id
     *
     * @return the value of game_user_record_his.id
     *
     * @mbggenerated Fri Oct 13 16:12:13 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column game_user_record_his.id
     *
     * @param id the value for game_user_record_his.id
     *
     * @mbggenerated Fri Oct 13 16:12:13 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column game_user_record_his.game_id
     *
     * @return the value of game_user_record_his.game_id
     *
     * @mbggenerated Fri Oct 13 16:12:13 CST 2017
     */
    public Long getGameId() {
        return gameId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column game_user_record_his.game_id
     *
     * @param gameId the value for game_user_record_his.game_id
     *
     * @mbggenerated Fri Oct 13 16:12:13 CST 2017
     */
    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column game_user_record_his.uid
     *
     * @return the value of game_user_record_his.uid
     *
     * @mbggenerated Fri Oct 13 16:12:13 CST 2017
     */
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column game_user_record_his.uid
     *
     * @param uid the value for game_user_record_his.uid
     *
     * @mbggenerated Fri Oct 13 16:12:13 CST 2017
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column game_user_record_his.record
     *
     * @return the value of game_user_record_his.record
     *
     * @mbggenerated Fri Oct 13 16:12:13 CST 2017
     */
    public Integer getRecord() {
        return record;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column game_user_record_his.record
     *
     * @param record the value for game_user_record_his.record
     *
     * @mbggenerated Fri Oct 13 16:12:13 CST 2017
     */
    public void setRecord(Integer record) {
        this.record = record;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column game_user_record_his.create_time
     *
     * @return the value of game_user_record_his.create_time
     *
     * @mbggenerated Fri Oct 13 16:12:13 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column game_user_record_his.create_time
     *
     * @param createTime the value for game_user_record_his.create_time
     *
     * @mbggenerated Fri Oct 13 16:12:13 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
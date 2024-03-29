package com.me2me.user.mapper;

import com.me2me.user.model.UserLastChannel;
import com.me2me.user.model.UserLastChannelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLastChannelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_last_channel
     *
     * @mbggenerated Thu Nov 09 14:53:25 CST 2017
     */
    int countByExample(UserLastChannelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_last_channel
     *
     * @mbggenerated Thu Nov 09 14:53:25 CST 2017
     */
    int deleteByExample(UserLastChannelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_last_channel
     *
     * @mbggenerated Thu Nov 09 14:53:25 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_last_channel
     *
     * @mbggenerated Thu Nov 09 14:53:25 CST 2017
     */
    int insert(UserLastChannel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_last_channel
     *
     * @mbggenerated Thu Nov 09 14:53:25 CST 2017
     */
    int insertSelective(UserLastChannel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_last_channel
     *
     * @mbggenerated Thu Nov 09 14:53:25 CST 2017
     */
    List<UserLastChannel> selectByExample(UserLastChannelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_last_channel
     *
     * @mbggenerated Thu Nov 09 14:53:25 CST 2017
     */
    UserLastChannel selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_last_channel
     *
     * @mbggenerated Thu Nov 09 14:53:25 CST 2017
     */
    int updateByExampleSelective(@Param("record") UserLastChannel record, @Param("example") UserLastChannelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_last_channel
     *
     * @mbggenerated Thu Nov 09 14:53:25 CST 2017
     */
    int updateByExample(@Param("record") UserLastChannel record, @Param("example") UserLastChannelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_last_channel
     *
     * @mbggenerated Thu Nov 09 14:53:25 CST 2017
     */
    int updateByPrimaryKeySelective(UserLastChannel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_last_channel
     *
     * @mbggenerated Thu Nov 09 14:53:25 CST 2017
     */
    int updateByPrimaryKey(UserLastChannel record);
}
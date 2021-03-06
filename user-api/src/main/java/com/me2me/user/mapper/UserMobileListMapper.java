package com.me2me.user.mapper;

import com.me2me.user.model.UserMobileList;
import com.me2me.user.model.UserMobileListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMobileListMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_mobile_list
     *
     * @mbggenerated Wed May 10 16:15:16 CST 2017
     */
    int countByExample(UserMobileListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_mobile_list
     *
     * @mbggenerated Wed May 10 16:15:16 CST 2017
     */
    int deleteByExample(UserMobileListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_mobile_list
     *
     * @mbggenerated Wed May 10 16:15:16 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_mobile_list
     *
     * @mbggenerated Wed May 10 16:15:16 CST 2017
     */
    int insert(UserMobileList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_mobile_list
     *
     * @mbggenerated Wed May 10 16:15:16 CST 2017
     */
    int insertSelective(UserMobileList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_mobile_list
     *
     * @mbggenerated Wed May 10 16:15:16 CST 2017
     */
    List<UserMobileList> selectByExample(UserMobileListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_mobile_list
     *
     * @mbggenerated Wed May 10 16:15:16 CST 2017
     */
    UserMobileList selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_mobile_list
     *
     * @mbggenerated Wed May 10 16:15:16 CST 2017
     */
    int updateByExampleSelective(@Param("record") UserMobileList record, @Param("example") UserMobileListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_mobile_list
     *
     * @mbggenerated Wed May 10 16:15:16 CST 2017
     */
    int updateByExample(@Param("record") UserMobileList record, @Param("example") UserMobileListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_mobile_list
     *
     * @mbggenerated Wed May 10 16:15:16 CST 2017
     */
    int updateByPrimaryKeySelective(UserMobileList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_mobile_list
     *
     * @mbggenerated Wed May 10 16:15:16 CST 2017
     */
    int updateByPrimaryKey(UserMobileList record);
}
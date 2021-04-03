package com.me2me.user.mapper;

import com.me2me.user.model.UserDevice;
import com.me2me.user.model.UserDeviceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDeviceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_device
     *
     * @mbggenerated Wed Jun 01 21:47:50 CST 2016
     */
    int countByExample(UserDeviceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_device
     *
     * @mbggenerated Wed Jun 01 21:47:50 CST 2016
     */
    int deleteByExample(UserDeviceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_device
     *
     * @mbggenerated Wed Jun 01 21:47:50 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_device
     *
     * @mbggenerated Wed Jun 01 21:47:50 CST 2016
     */
    int insert(UserDevice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_device
     *
     * @mbggenerated Wed Jun 01 21:47:50 CST 2016
     */
    int insertSelective(UserDevice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_device
     *
     * @mbggenerated Wed Jun 01 21:47:50 CST 2016
     */
    List<UserDevice> selectByExample(UserDeviceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_device
     *
     * @mbggenerated Wed Jun 01 21:47:50 CST 2016
     */
    UserDevice selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_device
     *
     * @mbggenerated Wed Jun 01 21:47:50 CST 2016
     */
    int updateByExampleSelective(@Param("record") UserDevice record, @Param("example") UserDeviceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_device
     *
     * @mbggenerated Wed Jun 01 21:47:50 CST 2016
     */
    int updateByExample(@Param("record") UserDevice record, @Param("example") UserDeviceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_device
     *
     * @mbggenerated Wed Jun 01 21:47:50 CST 2016
     */
    int updateByPrimaryKeySelective(UserDevice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_device
     *
     * @mbggenerated Wed Jun 01 21:47:50 CST 2016
     */
    int updateByPrimaryKey(UserDevice record);
}
package com.me2me.monitor.mapper;

import com.me2me.monitor.model.HttpAccess;
import com.me2me.monitor.model.HttpAccessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HttpAccessMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table http_access
     *
     * @mbggenerated Fri Apr 21 14:02:01 CST 2017
     */
    int countByExample(HttpAccessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table http_access
     *
     * @mbggenerated Fri Apr 21 14:02:01 CST 2017
     */
    int deleteByExample(HttpAccessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table http_access
     *
     * @mbggenerated Fri Apr 21 14:02:01 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table http_access
     *
     * @mbggenerated Fri Apr 21 14:02:01 CST 2017
     */
    int insert(HttpAccess record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table http_access
     *
     * @mbggenerated Fri Apr 21 14:02:01 CST 2017
     */
    int insertSelective(HttpAccess record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table http_access
     *
     * @mbggenerated Fri Apr 21 14:02:01 CST 2017
     */
    List<HttpAccess> selectByExample(HttpAccessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table http_access
     *
     * @mbggenerated Fri Apr 21 14:02:01 CST 2017
     */
    HttpAccess selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table http_access
     *
     * @mbggenerated Fri Apr 21 14:02:01 CST 2017
     */
    int updateByExampleSelective(@Param("record") HttpAccess record, @Param("example") HttpAccessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table http_access
     *
     * @mbggenerated Fri Apr 21 14:02:01 CST 2017
     */
    int updateByExample(@Param("record") HttpAccess record, @Param("example") HttpAccessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table http_access
     *
     * @mbggenerated Fri Apr 21 14:02:01 CST 2017
     */
    int updateByPrimaryKeySelective(HttpAccess record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table http_access
     *
     * @mbggenerated Fri Apr 21 14:02:01 CST 2017
     */
    int updateByPrimaryKey(HttpAccess record);
}
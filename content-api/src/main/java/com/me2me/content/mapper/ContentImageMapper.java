package com.me2me.content.mapper;

import com.me2me.content.model.ContentImage;
import com.me2me.content.model.ContentImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContentImageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table content_image
     *
     * @mbggenerated Fri Mar 25 13:38:25 CST 2016
     */
    int countByExample(ContentImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table content_image
     *
     * @mbggenerated Fri Mar 25 13:38:25 CST 2016
     */
    int deleteByExample(ContentImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table content_image
     *
     * @mbggenerated Fri Mar 25 13:38:25 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table content_image
     *
     * @mbggenerated Fri Mar 25 13:38:25 CST 2016
     */
    int insert(ContentImage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table content_image
     *
     * @mbggenerated Fri Mar 25 13:38:25 CST 2016
     */
    int insertSelective(ContentImage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table content_image
     *
     * @mbggenerated Fri Mar 25 13:38:25 CST 2016
     */
    List<ContentImage> selectByExample(ContentImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table content_image
     *
     * @mbggenerated Fri Mar 25 13:38:25 CST 2016
     */
    ContentImage selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table content_image
     *
     * @mbggenerated Fri Mar 25 13:38:25 CST 2016
     */
    int updateByExampleSelective(@Param("record") ContentImage record, @Param("example") ContentImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table content_image
     *
     * @mbggenerated Fri Mar 25 13:38:25 CST 2016
     */
    int updateByExample(@Param("record") ContentImage record, @Param("example") ContentImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table content_image
     *
     * @mbggenerated Fri Mar 25 13:38:25 CST 2016
     */
    int updateByPrimaryKeySelective(ContentImage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table content_image
     *
     * @mbggenerated Fri Mar 25 13:38:25 CST 2016
     */
    int updateByPrimaryKey(ContentImage record);
}
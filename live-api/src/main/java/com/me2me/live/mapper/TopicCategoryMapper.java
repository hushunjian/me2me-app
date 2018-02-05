package com.me2me.live.mapper;

import com.me2me.live.model.TopicCategory;
import com.me2me.live.model.TopicCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TopicCategoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_category
     *
     * @mbggenerated Tue Sep 19 11:03:27 CST 2017
     */
    int countByExample(TopicCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_category
     *
     * @mbggenerated Tue Sep 19 11:03:27 CST 2017
     */
    int deleteByExample(TopicCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_category
     *
     * @mbggenerated Tue Sep 19 11:03:27 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_category
     *
     * @mbggenerated Tue Sep 19 11:03:27 CST 2017
     */
    int insert(TopicCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_category
     *
     * @mbggenerated Tue Sep 19 11:03:27 CST 2017
     */
    int insertSelective(TopicCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_category
     *
     * @mbggenerated Tue Sep 19 11:03:27 CST 2017
     */
    List<TopicCategory> selectByExample(TopicCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_category
     *
     * @mbggenerated Tue Sep 19 11:03:27 CST 2017
     */
    TopicCategory selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_category
     *
     * @mbggenerated Tue Sep 19 11:03:27 CST 2017
     */
    int updateByExampleSelective(@Param("record") TopicCategory record, @Param("example") TopicCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_category
     *
     * @mbggenerated Tue Sep 19 11:03:27 CST 2017
     */
    int updateByExample(@Param("record") TopicCategory record, @Param("example") TopicCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_category
     *
     * @mbggenerated Tue Sep 19 11:03:27 CST 2017
     */
    int updateByPrimaryKeySelective(TopicCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_category
     *
     * @mbggenerated Tue Sep 19 11:03:27 CST 2017
     */
    int updateByPrimaryKey(TopicCategory record);
}
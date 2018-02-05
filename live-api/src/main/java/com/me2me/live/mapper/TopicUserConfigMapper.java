package com.me2me.live.mapper;

import com.me2me.live.model.TopicUserConfig;
import com.me2me.live.model.TopicUserConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TopicUserConfigMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_user_config
     *
     * @mbggenerated Mon Mar 20 09:24:34 CST 2017
     */
    int countByExample(TopicUserConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_user_config
     *
     * @mbggenerated Mon Mar 20 09:24:34 CST 2017
     */
    int deleteByExample(TopicUserConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_user_config
     *
     * @mbggenerated Mon Mar 20 09:24:34 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_user_config
     *
     * @mbggenerated Mon Mar 20 09:24:34 CST 2017
     */
    int insert(TopicUserConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_user_config
     *
     * @mbggenerated Mon Mar 20 09:24:34 CST 2017
     */
    int insertSelective(TopicUserConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_user_config
     *
     * @mbggenerated Mon Mar 20 09:24:34 CST 2017
     */
    List<TopicUserConfig> selectByExample(TopicUserConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_user_config
     *
     * @mbggenerated Mon Mar 20 09:24:34 CST 2017
     */
    TopicUserConfig selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_user_config
     *
     * @mbggenerated Mon Mar 20 09:24:34 CST 2017
     */
    int updateByExampleSelective(@Param("record") TopicUserConfig record, @Param("example") TopicUserConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_user_config
     *
     * @mbggenerated Mon Mar 20 09:24:34 CST 2017
     */
    int updateByExample(@Param("record") TopicUserConfig record, @Param("example") TopicUserConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_user_config
     *
     * @mbggenerated Mon Mar 20 09:24:34 CST 2017
     */
    int updateByPrimaryKeySelective(TopicUserConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_user_config
     *
     * @mbggenerated Mon Mar 20 09:24:34 CST 2017
     */
    int updateByPrimaryKey(TopicUserConfig record);
}
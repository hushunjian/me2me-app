package com.me2me.live.mapper;

import com.me2me.live.model.BlockTopic;
import com.me2me.live.model.BlockTopicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlockTopicMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table block_topic
     *
     * @mbggenerated Tue May 09 10:00:25 CST 2017
     */
    int countByExample(BlockTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table block_topic
     *
     * @mbggenerated Tue May 09 10:00:25 CST 2017
     */
    int deleteByExample(BlockTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table block_topic
     *
     * @mbggenerated Tue May 09 10:00:25 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table block_topic
     *
     * @mbggenerated Tue May 09 10:00:25 CST 2017
     */
    int insert(BlockTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table block_topic
     *
     * @mbggenerated Tue May 09 10:00:25 CST 2017
     */
    int insertSelective(BlockTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table block_topic
     *
     * @mbggenerated Tue May 09 10:00:25 CST 2017
     */
    List<BlockTopic> selectByExample(BlockTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table block_topic
     *
     * @mbggenerated Tue May 09 10:00:25 CST 2017
     */
    BlockTopic selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table block_topic
     *
     * @mbggenerated Tue May 09 10:00:25 CST 2017
     */
    int updateByExampleSelective(@Param("record") BlockTopic record, @Param("example") BlockTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table block_topic
     *
     * @mbggenerated Tue May 09 10:00:25 CST 2017
     */
    int updateByExample(@Param("record") BlockTopic record, @Param("example") BlockTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table block_topic
     *
     * @mbggenerated Tue May 09 10:00:25 CST 2017
     */
    int updateByPrimaryKeySelective(BlockTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table block_topic
     *
     * @mbggenerated Tue May 09 10:00:25 CST 2017
     */
    int updateByPrimaryKey(BlockTopic record);
}
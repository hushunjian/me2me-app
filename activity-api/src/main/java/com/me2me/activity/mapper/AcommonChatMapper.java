package com.me2me.activity.mapper;

import com.me2me.activity.model.AcommonChat;
import com.me2me.activity.model.AcommonChatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcommonChatMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_common_chat
     *
     * @mbggenerated Thu Apr 20 22:39:59 CST 2017
     */
    int countByExample(AcommonChatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_common_chat
     *
     * @mbggenerated Thu Apr 20 22:39:59 CST 2017
     */
    int deleteByExample(AcommonChatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_common_chat
     *
     * @mbggenerated Thu Apr 20 22:39:59 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_common_chat
     *
     * @mbggenerated Thu Apr 20 22:39:59 CST 2017
     */
    int insert(AcommonChat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_common_chat
     *
     * @mbggenerated Thu Apr 20 22:39:59 CST 2017
     */
    int insertSelective(AcommonChat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_common_chat
     *
     * @mbggenerated Thu Apr 20 22:39:59 CST 2017
     */
    List<AcommonChat> selectByExample(AcommonChatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_common_chat
     *
     * @mbggenerated Thu Apr 20 22:39:59 CST 2017
     */
    AcommonChat selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_common_chat
     *
     * @mbggenerated Thu Apr 20 22:39:59 CST 2017
     */
    int updateByExampleSelective(@Param("record") AcommonChat record, @Param("example") AcommonChatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_common_chat
     *
     * @mbggenerated Thu Apr 20 22:39:59 CST 2017
     */
    int updateByExample(@Param("record") AcommonChat record, @Param("example") AcommonChatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_common_chat
     *
     * @mbggenerated Thu Apr 20 22:39:59 CST 2017
     */
    int updateByPrimaryKeySelective(AcommonChat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_common_chat
     *
     * @mbggenerated Thu Apr 20 22:39:59 CST 2017
     */
    int updateByPrimaryKey(AcommonChat record);
}
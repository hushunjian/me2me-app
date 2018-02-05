package com.me2me.user.mapper;

import com.me2me.user.model.UserContentTags;
import com.me2me.user.model.UserContentTagsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserContentTagsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_content_tags
     *
     * @mbggenerated Fri Apr 01 16:44:01 CST 2016
     */
    int countByExample(UserContentTagsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_content_tags
     *
     * @mbggenerated Fri Apr 01 16:44:01 CST 2016
     */
    int deleteByExample(UserContentTagsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_content_tags
     *
     * @mbggenerated Fri Apr 01 16:44:01 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_content_tags
     *
     * @mbggenerated Fri Apr 01 16:44:01 CST 2016
     */
    int insert(UserContentTags record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_content_tags
     *
     * @mbggenerated Fri Apr 01 16:44:01 CST 2016
     */
    int insertSelective(UserContentTags record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_content_tags
     *
     * @mbggenerated Fri Apr 01 16:44:01 CST 2016
     */
    List<UserContentTags> selectByExample(UserContentTagsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_content_tags
     *
     * @mbggenerated Fri Apr 01 16:44:01 CST 2016
     */
    UserContentTags selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_content_tags
     *
     * @mbggenerated Fri Apr 01 16:44:01 CST 2016
     */
    int updateByExampleSelective(@Param("record") UserContentTags record, @Param("example") UserContentTagsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_content_tags
     *
     * @mbggenerated Fri Apr 01 16:44:01 CST 2016
     */
    int updateByExample(@Param("record") UserContentTags record, @Param("example") UserContentTagsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_content_tags
     *
     * @mbggenerated Fri Apr 01 16:44:01 CST 2016
     */
    int updateByPrimaryKeySelective(UserContentTags record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_content_tags
     *
     * @mbggenerated Fri Apr 01 16:44:01 CST 2016
     */
    int updateByPrimaryKey(UserContentTags record);
}
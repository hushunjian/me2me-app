package com.me2me.user.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.me2me.user.dto.SearchFansDto;
import com.me2me.user.dto.SearchUserDto;
import com.me2me.user.model.UserProfile;
import com.me2me.user.model.UserProfileExample;

public interface UserProfileMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_profile
     *
     * @mbggenerated Fri Jan 12 09:41:20 CST 2018
     */
    int countByExample(UserProfileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_profile
     *
     * @mbggenerated Fri Jan 12 09:41:20 CST 2018
     */
    int deleteByExample(UserProfileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_profile
     *
     * @mbggenerated Fri Jan 12 09:41:20 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_profile
     *
     * @mbggenerated Fri Jan 12 09:41:20 CST 2018
     */
    int insert(UserProfile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_profile
     *
     * @mbggenerated Fri Jan 12 09:41:20 CST 2018
     */
    int insertSelective(UserProfile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_profile
     *
     * @mbggenerated Fri Jan 12 09:41:20 CST 2018
     */
    List<UserProfile> selectByExample(UserProfileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_profile
     *
     * @mbggenerated Fri Jan 12 09:41:20 CST 2018
     */
    UserProfile selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_profile
     *
     * @mbggenerated Fri Jan 12 09:41:20 CST 2018
     */
    int updateByExampleSelective(@Param("record") UserProfile record, @Param("example") UserProfileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_profile
     *
     * @mbggenerated Fri Jan 12 09:41:20 CST 2018
     */
    int updateByExample(@Param("record") UserProfile record, @Param("example") UserProfileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_profile
     *
     * @mbggenerated Fri Jan 12 09:41:20 CST 2018
     */
    int updateByPrimaryKeySelective(UserProfile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_profile
     *
     * @mbggenerated Fri Jan 12 09:41:20 CST 2018
     */
    int updateByPrimaryKey(UserProfile record);
    
    List<UserProfile> searchFans(SearchFansDto searchFansDto);

    int countFans(SearchFansDto searchFansDto);

    /**
     * 搜索用户。
     * @author zhangjiwei
     * @date Mar 22, 2017
     * @param queries
     * @return
     */
	List<SearchUserDto> searchUserPage(Map<String, Object> queries);

	 int countSearchUserForPage(Map<String, Object> queries);
	/**
	 * 每日统计一下用户数据。
	 * @author zhangjiwei
	 * @date Apr 10, 2017
	 */
	void countUserByDay();
	/**
	 * 删除用户信息统计。
	 * @author zhangjiwei
	 * @date Apr 10, 2017
	 */
	void delUserCountDay();
	
	int updateAvailableCoin(UserProfile record);
}
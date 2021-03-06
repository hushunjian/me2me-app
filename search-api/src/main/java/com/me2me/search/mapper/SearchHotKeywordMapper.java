package com.me2me.search.mapper;

import com.me2me.search.model.SearchHotKeyword;
import com.me2me.search.model.SearchHotKeywordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SearchHotKeywordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hot_keyword
     *
     * @mbggenerated Wed Apr 05 11:41:54 CST 2017
     */
    int countByExample(SearchHotKeywordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hot_keyword
     *
     * @mbggenerated Wed Apr 05 11:41:54 CST 2017
     */
    int deleteByExample(SearchHotKeywordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hot_keyword
     *
     * @mbggenerated Wed Apr 05 11:41:54 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hot_keyword
     *
     * @mbggenerated Wed Apr 05 11:41:54 CST 2017
     */
    int insert(SearchHotKeyword record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hot_keyword
     *
     * @mbggenerated Wed Apr 05 11:41:54 CST 2017
     */
    int insertSelective(SearchHotKeyword record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hot_keyword
     *
     * @mbggenerated Wed Apr 05 11:41:54 CST 2017
     */
    List<SearchHotKeyword> selectByExample(SearchHotKeywordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hot_keyword
     *
     * @mbggenerated Wed Apr 05 11:41:54 CST 2017
     */
    SearchHotKeyword selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hot_keyword
     *
     * @mbggenerated Wed Apr 05 11:41:54 CST 2017
     */
    int updateByExampleSelective(@Param("record") SearchHotKeyword record, @Param("example") SearchHotKeywordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hot_keyword
     *
     * @mbggenerated Wed Apr 05 11:41:54 CST 2017
     */
    int updateByExample(@Param("record") SearchHotKeyword record, @Param("example") SearchHotKeywordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hot_keyword
     *
     * @mbggenerated Wed Apr 05 11:41:54 CST 2017
     */
    int updateByPrimaryKeySelective(SearchHotKeyword record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hot_keyword
     *
     * @mbggenerated Wed Apr 05 11:41:54 CST 2017
     */
    int updateByPrimaryKey(SearchHotKeyword record);
}
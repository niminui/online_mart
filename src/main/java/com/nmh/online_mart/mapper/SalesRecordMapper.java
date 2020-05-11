package com.nmh.online_mart.mapper;

import com.nmh.online_mart.model.SalesRecord;
import com.nmh.online_mart.model.SalesRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sales_record
     *
     * @mbg.generated Mon May 11 10:56:56 CST 2020
     */
    long countByExample(SalesRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sales_record
     *
     * @mbg.generated Mon May 11 10:56:56 CST 2020
     */
    int deleteByExample(SalesRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sales_record
     *
     * @mbg.generated Mon May 11 10:56:56 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sales_record
     *
     * @mbg.generated Mon May 11 10:56:56 CST 2020
     */
    int insert(SalesRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sales_record
     *
     * @mbg.generated Mon May 11 10:56:56 CST 2020
     */
    int insertSelective(SalesRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sales_record
     *
     * @mbg.generated Mon May 11 10:56:56 CST 2020
     */
    List<SalesRecord> selectByExample(SalesRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sales_record
     *
     * @mbg.generated Mon May 11 10:56:56 CST 2020
     */
    SalesRecord selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sales_record
     *
     * @mbg.generated Mon May 11 10:56:56 CST 2020
     */
    int updateByExampleSelective(@Param("record") SalesRecord record, @Param("example") SalesRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sales_record
     *
     * @mbg.generated Mon May 11 10:56:56 CST 2020
     */
    int updateByExample(@Param("record") SalesRecord record, @Param("example") SalesRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sales_record
     *
     * @mbg.generated Mon May 11 10:56:56 CST 2020
     */
    int updateByPrimaryKeySelective(SalesRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sales_record
     *
     * @mbg.generated Mon May 11 10:56:56 CST 2020
     */
    int updateByPrimaryKey(SalesRecord record);
}
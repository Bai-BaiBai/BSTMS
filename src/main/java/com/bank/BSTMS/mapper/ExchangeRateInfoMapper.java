package com.bank.BSTMS.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bank.BSTMS.pojo.ExchangeRateInfo;

/**
 * ExchangeRateInfoMapper
 * @ClassName: ExchangeRateInfoMapper
 * @Description: ExchangeRateInfoMapper
 * @author BaiZehong
 * @date 2019年6月27日
 * @since JDK 1.8
 */
@Mapper
public interface ExchangeRateInfoMapper {
    /**
     * 删除
     * @Title: deleteByPrimaryKey
     * @Description: 删除
     * @param exchangeRateId
     * @return
     */
    int deleteByPrimaryKey(Integer exchangeRateId);

    /**
     * 插入
     * @Title: insert
     * @Description: 插入
     * @param record
     * @return
     */
    int insert(ExchangeRateInfo record);

    /**
     * 插入
     * @Title: insertSelective
     * @Description: 插入
     * @param record
     * @return
     */
    int insertSelective(ExchangeRateInfo record);

    /**
     * 查询
     * @Title: selectByPrimaryKey
     * @Description: 查询
     * @param exchangeRateId
     * @return
     */
    ExchangeRateInfo selectByPrimaryKey(Integer exchangeRateId);

    /**
     * 更新
     * @Title: updateByPrimaryKeySelective
     * @Description: 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ExchangeRateInfo record);

    /**
     * 更新
     * @Title: updateByPrimaryKey
     * @Description: 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(ExchangeRateInfo record);
    
    /**
     * 查询所有
     * @Title: selectAll
     * @Description: 查询所有
     * @return
     */
    List<ExchangeRateInfo> selectAll();
}
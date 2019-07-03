package com.bank.BSTMS.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bank.BSTMS.pojo.InterestRateInfo;

/**
 * InterestRateInfoMapper
 * @ClassName: InterestRateInfoMapper
 * @Description: InterestRateInfoMapper
 * @author BaiZehong
 * @date 2019年6月27日
 * @since JDK 1.8
 */
@Mapper
public interface InterestRateInfoMapper {
    /**
     * 删除
     * @Title: deleteByPrimaryKey
     * @Description:删除
     * @param interestRateId
     * @return
     */
    int deleteByPrimaryKey(Integer interestRateId);

    /**
     * 插入
     * @Title: insert
     * @Description:插入
     * @param record
     * @return
     */
    int insert(InterestRateInfo record);

    /**
     * 插入
     * @Title: insertSelective
     * @Description: 插入
     * @param record
     * @return
     */
    int insertSelective(InterestRateInfo record);

    /**
     * 查询
     * @Title: selectByPrimaryKey
     * @Description:查询
     * @param interestRateId
     * @return
     */
    InterestRateInfo selectByPrimaryKey(Integer interestRateId);

    /**
     * 更新
     * @Title: updateByPrimaryKeySelective
     * @Description: 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(InterestRateInfo record);

    /**
     * 更新
     * @Title: updateByPrimaryKey
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param record
     * @return
     */
    int updateByPrimaryKey(InterestRateInfo record);
}
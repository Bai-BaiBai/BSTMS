package com.bank.BSTMS.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bank.BSTMS.pojo.BillInfo;

/**
 * BillInfoMapper
 * @ClassName: BillInfoMapper
 * @Description: BillInfoMapper
 * @author BaiZehong
 * @date 2019年6月27日
 * @since JDK 1.8
 */
@Mapper
public interface BillInfoMapper {
    
	/**
	 * 删除
	 * @Title: deleteByPrimaryKey
	 * @Description: 删除
	 * @param billId
	 * @return
	 */
    int deleteByPrimaryKey(Integer billId);

    /**
     * 插入
     * @Title: insert
     * @Description: 插入
     * @param record
     * @return
     */
    int insert(BillInfo record);

    /**
     * 插入
     * @Title: insertSelective
     * @Description: 插入
     * @param record
     * @return
     */
    int insertSelective(BillInfo record);

    /**
     * 查询单条记录
     * @Title: selectByPrimaryKey
     * @Description: 查询单条记录
     * @param billId
     * @return
     */
    BillInfo selectByPrimaryKey(Integer billId);

    /**
     * 更新
     * @Title: updateByPrimaryKeySelective
     * @Description: 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BillInfo record);

    /**
     * 更新
     * @Title: updateByPrimaryKey
     * @Description: 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(BillInfo record);
}
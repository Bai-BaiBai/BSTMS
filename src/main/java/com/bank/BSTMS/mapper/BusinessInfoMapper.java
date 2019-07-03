package com.bank.BSTMS.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bank.BSTMS.pojo.BusinessInfo;

/**
 * BusinessInfoMapper
 * @ClassName: BusinessInfoMapper
 * @Description: BusinessInfoMapper
 * @author BaiZehong
 * @date 2019年6月27日
 * @since JDK 1.8
 */
@Mapper
public interface BusinessInfoMapper {
    
	/**
	 * 删除
	 * @Title: deleteByPrimaryKey
	 * @Description: 删除
	 * @param businessId
	 * @return
	 */
    int deleteByPrimaryKey(Integer businessId);

    /**
     * 插入
     * @Title: insert
     * @Description: 插入
     * @param record
     * @return
     */
    int insert(BusinessInfo record);

    /**
     * 插入
     * @Title: insertSelective
     * @Description: 插入
     * @param record
     * @return
     */
    int insertSelective(BusinessInfo record);

    /**
     * 查询
     * @Title: selectByPrimaryKey
     * @Description: 查询
     * @param businessId
     * @return
     */
    BusinessInfo selectByPrimaryKey(Integer businessId);

    /**
     * 更新
     * @Title: updateByPrimaryKeySelective
     * @Description: 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BusinessInfo record);

    /**
     * 更新
     * @Title: updateByPrimaryKey
     * @Description: 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(BusinessInfo record);
    
    /**
     * 查询所有
     * @Title: selectAll
     * @Description: 查询所有
     * @return
     */
    List<BusinessInfo> selectAll();
}
package com.bank.BSTMS.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bank.BSTMS.pojo.CardInfo;

/**
 * CardInfoMapper
 * @ClassName: CardInfoMapper
 * @Description: CardInfoMapper
 * @author BaiZehong
 * @date 2019年6月27日
 * @since JDK 1.8
 */
@Mapper
public interface CardInfoMapper {
    
	/**
	 * 删除
	 * @Title: deleteByPrimaryKey
	 * @Description:删除
	 * @param cardId
	 * @return
	 */
    int deleteByPrimaryKey(Long cardId);

    /**
     * 插入
     * @Title: insert
     * @Description: 插入
     * @param record
     * @return
     */
    int insert(CardInfo record);

    /**
     * 
     * 插入
     * @Title: insertSelective
     * @Description: 插入
     * @param record
     * @return
     */
    int insertSelective(CardInfo record);

    /**
     * 查询
     * @Title: selectByPrimaryKey
     * @Description:查询
     * @param cardId
     * @return
     */
    CardInfo selectByPrimaryKey(Long cardId);

    /**
     * 更新
     * @Title: updateByPrimaryKeySelective
     * @Description: 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(CardInfo record);

    /**
     * 更新
     * @Title: updateByPrimaryKey
     * @Description: 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(CardInfo record);
}
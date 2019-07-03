package com.bank.BSTMS.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bank.BSTMS.pojo.UserInfo;

/**
 * UserInfoMapper
 * @ClassName: UserInfoMapper
 * @Description: UserInfoMapper
 * @author BaiZehong
 * @date 2019年6月27日
 * @since JDK 1.8
 */
@Mapper
public interface UserInfoMapper {
    /**
     * 删除
     * @Title: deleteByPrimaryKey
     * @Description: 删除
     * @param idNumbers
     * @return
     */
    int deleteByPrimaryKey(String idNumbers);

    /**
     * 插入
     * @Title: insert
     * @Description: 插入
     * @param record
     * @return
     */
    int insert(UserInfo record);

    /**
     * 插入
     * @Title: insertSelective
     * @Description: 插入
     * @param record
     * @return
     */
    int insertSelective(UserInfo record);

    /**
     * 查询
     * @Title: selectByPrimaryKey
     * @Description: 查询
     * @param idNumbers
     * @return
     */
    UserInfo selectByPrimaryKey(String idNumbers);

    /**
     * 更新
     * @Title: updateByPrimaryKeySelective
     * @Description: 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(UserInfo record);

    /**
     * 更新
     * @Title: updateByPrimaryKey
     * @Description: 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(UserInfo record);
}
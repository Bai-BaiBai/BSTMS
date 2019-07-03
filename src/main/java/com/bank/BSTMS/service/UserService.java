package com.bank.BSTMS.service;

import com.bank.BSTMS.pojo.UserInfo;

/**
 * 用户相关服务
 * @ClassName: UserService
 * @Description: 用户相关服务
 * @author BaiZehong
 * @date 2019年6月27日
 * @since JDK 1.8
 */
public interface UserService {

	/**
	 * 验证用户信息，成功返回该用户信息，失败返回null
	 * @Title: verifyUser
	 * @Description: 验证用户信息
	 * @param idNumbers
	 * @param username
	 * @param phone
	 * @return
	 */
	UserInfo verifyUser(String idNumbers, String username, String phone);
}

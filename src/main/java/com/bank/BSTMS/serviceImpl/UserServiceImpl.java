package com.bank.BSTMS.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.BSTMS.mapper.UserInfoMapper;
import com.bank.BSTMS.pojo.UserInfo;
import com.bank.BSTMS.service.UserService;

/**
 * UserService实现类
 * @ClassName: UserServiceImpl
 * @Description: UserService实现类
 * @author BaiZehong
 * @date 2019年6月27日
 * @since JDK 1.8
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Override
	public UserInfo verifyUser(String idNumbers, String username, String phone) {

		UserInfo userInfo = userInfoMapper.selectByPrimaryKey(idNumbers);
		
		// 姓名和手机号均能认证成功，返回UserInfo
		if (userInfo != null && username.equals(userInfo.getUsername())
							 && phone.equals(userInfo.getPhone())) {
			return userInfo;
		}
		// 否则返回null
		else {
			return null;
		}
	}

	@Override
	public UserInfo selectByIdNumbers(String idNumbers) {
		return userInfoMapper.selectByPrimaryKey(idNumbers);
	}

}

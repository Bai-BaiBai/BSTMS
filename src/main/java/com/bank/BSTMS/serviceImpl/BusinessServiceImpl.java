package com.bank.BSTMS.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.BSTMS.mapper.BusinessInfoMapper;
import com.bank.BSTMS.mapper.ExchangeRateInfoMapper;
import com.bank.BSTMS.pojo.BusinessInfo;
import com.bank.BSTMS.pojo.ExchangeRateInfo;
import com.bank.BSTMS.service.BusinessService;

/**
 * BusinessService实现类
 * @ClassName: BusinessServiceImpl
 * @Description: BusinessService实现类
 * @author BaiZehong
 * @date 2019年6月27日
 * @since JDK 1.8
 */
@Service
public class BusinessServiceImpl implements BusinessService {
	
	@Autowired
	BusinessInfoMapper businessInfoMapper;
	
	@Autowired
	ExchangeRateInfoMapper exchangeRateInfoMapper;

	@Override
	public List<BusinessInfo> checkBusinessInfos() {
		return businessInfoMapper.selectAll();
	}

	@Override
	public List<ExchangeRateInfo> checkExchangeRateInfos() {
		// TODO 调用selectAll
		return exchangeRateInfoMapper.selectAll();
	}

}

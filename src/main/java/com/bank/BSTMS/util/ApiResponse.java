package com.bank.BSTMS.util;

/**
 * 返回前端类
 * @ClassName: ApiResponse
 * @Description: 返回前端类
 * @author BaiZehong
 * @date 2019年6月27日
 * @since JDK 1.8
 */
public class ApiResponse<T> {
	
	public static final int SUCCESS_CODE = 0;
	public static final int ERROR_CODE = 1;
	
	/**
	 * 请求是否处理成功
	 */
	private int code;
	/**
	 * 错误信息
	 */
	private String error;
	/**
	 * 返回数据
	 */
	private T data;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public static int getSuccessCode() {
		return SUCCESS_CODE;
	}
	public static int getErrorCode() {
		return ERROR_CODE;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if (code == SUCCESS_CODE) {
			return "请求成功" + data.toString();
		}else {
			return "error : " + error;
		}
	}
	
}

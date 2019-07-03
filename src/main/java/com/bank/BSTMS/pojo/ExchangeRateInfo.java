package com.bank.BSTMS.pojo;

import java.io.Serializable;

/**
 * ExchangeRateInfo
 * @ClassName: ExchangeRateInfo
 * @Description: ExchangeRateInfo
 * @author BaiZehong
 * @date 2019年6月27日
 * @since JDK 1.8
 */
public class ExchangeRateInfo implements Serializable {
    /**
     * Database Column Remarks:
     *   ����id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exchange_rate_info.exchange_rate_id
     *
     * @mbg.generated
     */
    private Integer exchangeRateId;

    /**
     * Database Column Remarks:
     *   ��������
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exchange_rate_info.currency_type
     *
     * @mbg.generated
     */
    private String currencyType;

    /**
     * Database Column Remarks:
     *   ����ֵ��ֵ=����/�����
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exchange_rate_info.exchange_rate
     *
     * @mbg.generated
     */
    private Double exchangeRate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table exchange_rate_info
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchange_rate_info.exchange_rate_id
     *
     * @return the value of exchange_rate_info.exchange_rate_id
     *
     * @mbg.generated
     */
    public Integer getExchangeRateId() {
        return exchangeRateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchange_rate_info.exchange_rate_id
     *
     * @param exchangeRateId the value for exchange_rate_info.exchange_rate_id
     *
     * @mbg.generated
     */
    public void setExchangeRateId(Integer exchangeRateId) {
        this.exchangeRateId = exchangeRateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchange_rate_info.currency_type
     *
     * @return the value of exchange_rate_info.currency_type
     *
     * @mbg.generated
     */
    public String getCurrencyType() {
        return currencyType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchange_rate_info.currency_type
     *
     * @param currencyType the value for exchange_rate_info.currency_type
     *
     * @mbg.generated
     */
    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchange_rate_info.exchange_rate
     *
     * @return the value of exchange_rate_info.exchange_rate
     *
     * @mbg.generated
     */
    public Double getExchangeRate() {
        return exchangeRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchange_rate_info.exchange_rate
     *
     * @param exchangeRate the value for exchange_rate_info.exchange_rate
     *
     * @mbg.generated
     */
    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
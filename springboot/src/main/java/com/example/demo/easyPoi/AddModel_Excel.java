package com.example.demo.easyPoi;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;
//这里没有转装用途，因为只有充值功能

/**
 * 和涉及文档相比少了字段：
 * 付款人账号、收款人名称，收款人账号
 */
public class AddModel_Excel {
    @Excel(name = "行数")
    private String rowNum;
    //这里要求excel中的格式有规定
    @Excel(name = "转账日期",format = "yyyy/MM/dd")
    private Date transferTime;
    @Excel(name = "流水号")
    private String 	serialNumber;
    @Excel(name = "开户银行")
    private String bankName;
    @Excel(name = "付款人名称")
    private String customerName;
    @Excel(name = "转账金额")
    private String transferAmount;
    @Excel(name = "充值金额")
    private String rechargeAmount;

    public String getRowNum() {
        return rowNum;
    }

    public void setRowNum(String rowNum) {
        this.rowNum = rowNum;
    }

    public Date getTransferTime() {
        return transferTime;
    }

    public void setTransferTime(Date transferTime) {
        this.transferTime = transferTime;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(String transferAmount) {
        this.transferAmount = transferAmount;
    }

    public String getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(String rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public AddModel_Excel() {
    }

    public AddModel_Excel(String rowNum, Date transferTime, String serialNumber, String bankName, String customerName, String transferAmount, String rechargeAmount) {
        this.rowNum = rowNum;
        this.transferTime = transferTime;
        this.serialNumber = serialNumber;
        this.bankName = bankName;
        this.customerName = customerName;
        this.transferAmount = transferAmount;
        this.rechargeAmount = rechargeAmount;
    }


}

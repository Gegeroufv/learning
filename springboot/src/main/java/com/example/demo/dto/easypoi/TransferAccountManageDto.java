package com.example.demo.dto.easypoi;

import java.io.Serializable;

/**
 * @author PJJ
 * @Date 2018-03-12
 * @Description 转账接口
 * 参数接受方式全部改为字符串
 */
public class TransferAccountManageDto implements Serializable {

    //统一接口，可复用，增加分页字段
    private String page;

    private String pageSize;

    private String id;

    //后台随机码6位
    private String random;

    //客户名称
    private String customerName;

    //转账金额
    private String transferAmount;

    //交易用途 1、充值2、电子标签 3、充值宝 4 充值+电子标签 5、充值+充值宝 6、电子标签+充值宝 7、充值+电子标签+充值宝
    private String transferUse;

    //是否选择充值
    private boolean charge;

    //是否选择电子标签
    private boolean obu;

    //是否选择充值宝
    private boolean treasure;

    //充值金额
    private String rechargeAmount;

    //剩余充值金额
    private String sufRechargeAmount;

    private String oilAmount;

    private String sufOilAmount;

    private String obuName;

    //电子标签单价
    private String obuPrice;

    private String obuNum;

    private String sufObuNum;

    private String treasureName;

    //充值宝单价
    private String treasurePrice;

    private String treasureNum;

    private String sufTreasureNum;

    private String consumeStatus;

    private String inputPerson;

    private String inputTime;

    private String transferTime;

    private String remove;

    private String updateBy;

    private String updateTime;

    private String spare1;

    private String spare2;

    private String spare3;
    //流水号
    private String serialNumber;
    //开户银行
    private String bankName;
    //开户行编码
    private Integer bankNum;

    public Integer getBankNum() {
        return bankNum;
    }

    @Override
    public String toString() {
        return "TransferAccountManageDto{" +
                "page='" + page + '\'' +
                ", pageSize='" + pageSize + '\'' +
                ", id='" + id + '\'' +
                ", random='" + random + '\'' +
                ", customerName='" + customerName + '\'' +
                ", transferAmount='" + transferAmount + '\'' +
                ", transferUse='" + transferUse + '\'' +
                ", charge=" + charge +
                ", obu=" + obu +
                ", treasure=" + treasure +
                ", rechargeAmount='" + rechargeAmount + '\'' +
                ", sufRechargeAmount='" + sufRechargeAmount + '\'' +
                ", oilAmount='" + oilAmount + '\'' +
                ", sufOilAmount='" + sufOilAmount + '\'' +
                ", obuName='" + obuName + '\'' +
                ", obuPrice='" + obuPrice + '\'' +
                ", obuNum='" + obuNum + '\'' +
                ", sufObuNum='" + sufObuNum + '\'' +
                ", treasureName='" + treasureName + '\'' +
                ", treasurePrice='" + treasurePrice + '\'' +
                ", treasureNum='" + treasureNum + '\'' +
                ", sufTreasureNum='" + sufTreasureNum + '\'' +
                ", consumeStatus='" + consumeStatus + '\'' +
                ", inputPerson='" + inputPerson + '\'' +
                ", inputTime='" + inputTime + '\'' +
                ", transferTime='" + transferTime + '\'' +
                ", remove='" + remove + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", spare1='" + spare1 + '\'' +
                ", spare2='" + spare2 + '\'' +
                ", spare3='" + spare3 + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankNum=" + bankNum +
                '}';
    }

    public void setBankNum(Integer bankNum) {
        this.bankNum = bankNum;
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

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
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

    public String getTransferUse() {
        return transferUse;
    }

    public void setTransferUse(String transferUse) {
        this.transferUse = transferUse;
    }

    public boolean isCharge() {
        return charge;
    }

    public void setCharge(boolean charge) {
        this.charge = charge;
    }

    public boolean isObu() {
        return obu;
    }

    public void setObu(boolean obu) {
        this.obu = obu;
    }

    public boolean isTreasure() {
        return treasure;
    }

    public void setTreasure(boolean treasure) {
        this.treasure = treasure;
    }

    public String getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(String rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public String getSufRechargeAmount() {
        return sufRechargeAmount;
    }

    public void setSufRechargeAmount(String sufRechargeAmount) {
        this.sufRechargeAmount = sufRechargeAmount;
    }

    public String getOilAmount() {
        return oilAmount;
    }

    public void setOilAmount(String oilAmount) {
        this.oilAmount = oilAmount;
    }

    public String getSufOilAmount() {
        return sufOilAmount;
    }

    public void setSufOilAmount(String sufOilAmount) {
        this.sufOilAmount = sufOilAmount;
    }

    public String getObuName() {
        return obuName;
    }

    public void setObuName(String obuName) {
        this.obuName = obuName;
    }

    public String getObuPrice() {
        return obuPrice;
    }

    public void setObuPrice(String obuPrice) {
        this.obuPrice = obuPrice;
    }

    public String getObuNum() {
        return obuNum;
    }

    public void setObuNum(String obuNum) {
        this.obuNum = obuNum;
    }

    public String getSufObuNum() {
        return sufObuNum;
    }

    public void setSufObuNum(String sufObuNum) {
        this.sufObuNum = sufObuNum;
    }

    public String getTreasureName() {
        return treasureName;
    }

    public void setTreasureName(String treasureName) {
        this.treasureName = treasureName;
    }

    public String getTreasurePrice() {
        return treasurePrice;
    }

    public void setTreasurePrice(String treasurePrice) {
        this.treasurePrice = treasurePrice;
    }

    public String getTreasureNum() {
        return treasureNum;
    }

    public void setTreasureNum(String treasureNum) {
        this.treasureNum = treasureNum;
    }

    public String getSufTreasureNum() {
        return sufTreasureNum;
    }

    public void setSufTreasureNum(String sufTreasureNum) {
        this.sufTreasureNum = sufTreasureNum;
    }

    public String getConsumeStatus() {
        return consumeStatus;
    }

    public void setConsumeStatus(String consumeStatus) {
        this.consumeStatus = consumeStatus;
    }

    public String getInputPerson() {
        return inputPerson;
    }

    public void setInputPerson(String inputPerson) {
        this.inputPerson = inputPerson;
    }

    public String getInputTime() {
        return inputTime;
    }

    public void setInputTime(String inputTime) {
        this.inputTime = inputTime;
    }

    public String getTransferTime() {
        return transferTime;
    }

    public void setTransferTime(String transferTime) {
        this.transferTime = transferTime;
    }

    public String getRemove() {
        return remove;
    }

    public void setRemove(String remove) {
        this.remove = remove;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getSpare1() {
        return spare1;
    }

    public void setSpare1(String spare1) {
        this.spare1 = spare1;
    }

    public String getSpare2() {
        return spare2;
    }

    public void setSpare2(String spare2) {
        this.spare2 = spare2;
    }

    public String getSpare3() {
        return spare3;
    }

    public void setSpare3(String spare3) {
        this.spare3 = spare3;
    }
}

package com.pret.api.vo.general.res;

/**
 * 订单支付接口
 *
 * @author wujinsong
 */
public class PRPayVo {
    private PRPayItemVo weixinInfo;

    private String alipayInfo;

    private String ylpayInfo;

    private PRPayWpItemVo worldpayInfo;

    private PRPaySageItemVo sageInfo;

    public PRPayItemVo getWeixinInfo() {
        return weixinInfo;
    }

    public void setWeixinInfo(PRPayItemVo weixinInfo) {
        this.weixinInfo = weixinInfo;
    }

    public String getAlipayInfo() {
        return alipayInfo;
    }

    public void setAlipayInfo(String alipayInfo) {
        this.alipayInfo = alipayInfo;
    }

    public String getYlpayInfo() {
        return ylpayInfo;
    }

    public void setYlpayInfo(String ylpayInfo) {
        this.ylpayInfo = ylpayInfo;
    }

    public PRPayWpItemVo getWorldpayInfo() {
        return worldpayInfo;
    }

    public void setWorldpayInfo(PRPayWpItemVo worldpayInfo) {
        this.worldpayInfo = worldpayInfo;
    }

    public PRPaySageItemVo getSageInfo() {
        return sageInfo;
    }

    public void setSageInfo(PRPaySageItemVo sageInfo) {
        this.sageInfo = sageInfo;
    }
}

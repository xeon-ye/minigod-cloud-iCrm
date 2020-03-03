package com.minigod.api.mktserver.ext;

import java.io.*;

/**
 * @author: PENGFENG
 * @description: 盘前盘后行情
 * @date: Created in 11:20 2017/11/24
 * @modified By:
 */
public class QuotationVO implements Serializable {
    protected static final long serialVersionUID = 7184505879193249169L;

    /** 资产ID */
    protected String assetId;
    /** 时区 **/
    protected String timeZoneId = "EST";
    /** 日期 */
    protected String date;
    /** 时间 */
    protected String time;
    /** 名称 */
    protected String stkName;
    /** 代码 */
    protected String stkCode;
    /** 公司代码 */
    protected int corpCode;
    /** 最新价 */
    protected double price;
    /** 昨收 */
    protected double prevClose;
    /** 今开 */
    protected double open;
    /** 最高 */
    protected double high;
    /** 最低 */
    protected double low;
    /** 盘前/盘后时段内累计交易总额 */
    protected double turnOver = 0;
    /** 盘前/盘后时段内累计交易总量 */
    protected double totalVolume = 0;
    /** 上一分钟交易总量 */
    protected double lastVol = 0;
    /** 上一分钟交易总额 */
    protected double lastTurnover = 0;
    /** 均价 */
    protected double avgPrice = 0;
    /** 涨跌幅 */
    protected double changePct = 0;
    /** 涨跌额 */
    protected double change = 0;
    /** 分笔累计成交量(一个周期(天)内累计成交量) */
    protected double tktVol = 0;
    /** 分笔累计成交金额 (一个周期(天)内累计成交金额)*/
    protected double tktTo = 0;
    /** 更新时间 */
    protected long updateTime;

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStkName() {
        return stkName;
    }

    public void setStkName(String stkName) {
        this.stkName = stkName;
    }

    public String getStkCode() {
        return stkCode;
    }

    public void setStkCode(String stkCode) {
        this.stkCode = stkCode;
    }

    public int getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(int corpCode) {
        this.corpCode = corpCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrevClose() {
        return prevClose;
    }

    public void setPrevClose(double prevClose) {
        this.prevClose = prevClose;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getTurnOver() {
        return turnOver;
    }

    public void setTurnOver(double turnOver) {
        this.turnOver = turnOver;
    }

    public double getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(double totalVolume) {
        this.totalVolume = totalVolume;
    }

    public double getLastVol() {
        return lastVol;
    }

    public void setLastVol(double lastVol) {
        this.lastVol = lastVol;
    }

    public double getLastTurnover() {
        return lastTurnover;
    }

    public void setLastTurnover(double lastTurnover) {
        this.lastTurnover = lastTurnover;
    }

    public double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public double getChangePct() {
        return changePct;
    }

    public void setChangePct(double changePct) {
        this.changePct = changePct;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public double getTktVol() {
        return tktVol;
    }

    public void setTktVol(double tktVol) {
        this.tktVol = tktVol;
    }

    public double getTktTo() {
        return tktTo;
    }

    public void setTktTo(double tktTo) {
        this.tktTo = tktTo;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 深层拷贝 - 需要类继承序列化接口
     * @param <T>
     * @param obj
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static <T extends QuotationVO>  T deepCopy(T obj) throws Exception {
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;

        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;

        Object o = null;
        //如果子类没有继承该接口，这一步会报错
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            bais = new ByteArrayInputStream(baos.toByteArray());
            ois = new ObjectInputStream(bais);

            o = ois.readObject();
            return (T) o;
        } catch (Exception e) {
            throw new Exception("对象中包含没有继承序列化的对象");
        } finally{
            try {
                baos.close();
                oos.close();
                bais.close();
                ois.close();
            } catch (Exception e2) {
                //这里报错不需要处理
            }
        }
    }

    @Override
    public String toString() {
        return "UsQuotationVO{" +
                "assetId='" + assetId + '\'' +
                ", timeZoneId='" + timeZoneId + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", stkName='" + stkName + '\'' +
                ", stkCode='" + stkCode + '\'' +
                ", corpCode=" + corpCode +
                ", price=" + price +
                ", prevClose=" + prevClose +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", turnOver=" + turnOver +
                ", totalVolume=" + totalVolume +
                ", lastVol=" + lastVol +
                ", lastTurnover=" + lastTurnover +
                ", avgPrice=" + avgPrice +
                ", changePct=" + changePct +
                ", change=" + change +
                ", tktVol=" + tktVol +
                ", tktTo=" + tktTo +
                '}';
    }
}

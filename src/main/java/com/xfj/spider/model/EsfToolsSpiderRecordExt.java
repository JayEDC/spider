package com.xfj.spider.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "esf_tools_spider_record_ext")
public class EsfToolsSpiderRecordExt {
    @Id
    @Column(name = "record_id")
    private Integer recordId;

    /**
     * 房屋二级类型
     */
    @Column(name = "cagegory_desc")
    private String cagegoryDesc;

    /**
     * 家私配套
     */
    private String furniture;

    /**
     * 房间数量
     */
    @Column(name = "bed_units")
    private Integer bedUnits;

    /**
     * 房间数量最少
     */
    @Column(name = "bed_units_low")
    private Integer bedUnitsLow;

    /**
     * 房间数量最多
     */
    @Column(name = "bed_units_hight")
    private Integer bedUnitsHight;

    /**
     * 大厅数量
     */
    @Column(name = "hall_units")
    private Integer hallUnits;

    /**
     * 卫生间数量
     */
    @Column(name = "bath_units")
    private Integer bathUnits;

    /**
     * 厨房数量
     */
    @Column(name = "cook_untis")
    private Integer cookUntis;

    /**
     * 建筑面积最少
     */
    @Column(name = "area_untis_low")
    private BigDecimal areaUntisLow;

    @Column(name = "area_units_hight")
    private BigDecimal areaUnitsHight;

    /**
     * 租赁方式
     */
    @Column(name = "rent_type")
    private String rentType;

    /**
     * 总价最低
     */
    @Column(name = "total_price_low")
    private BigDecimal totalPriceLow;

    /**
     * 总价最高
     */
    @Column(name = "total_price_hight")
    private BigDecimal totalPriceHight;

    /**
     * 租金
     */
    private BigDecimal price;

    /**
     * 租金最低
     */
    @Column(name = "price_low")
    private BigDecimal priceLow;

    /**
     * 租金最高
     */
    @Column(name = "price_hight")
    private BigDecimal priceHight;

    /**
     * 建筑年代
     */
    @Column(name = "bulid_timer")
    private String bulidTimer;

    /**
     * 是否有电梯
     */
    @Column(name = "has_lift")
    private Boolean hasLift;

    /**
     * 产权
     */
    private String equities;

    /**
     * 押付方式
     */
    @Column(name = "pay_method")
    private String payMethod;

    /**
     * 物业管理费
     */
    @Column(name = "manage_fee")
    private BigDecimal manageFee;

    /**
     * @return record_id
     */
    public Integer getRecordId() {
        return recordId;
    }

    /**
     * @param recordId
     */
    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    /**
     * 获取房屋二级类型
     *
     * @return cagegory_desc - 房屋二级类型
     */
    public String getCagegoryDesc() {
        return cagegoryDesc;
    }

    /**
     * 设置房屋二级类型
     *
     * @param cagegoryDesc 房屋二级类型
     */
    public void setCagegoryDesc(String cagegoryDesc) {
        this.cagegoryDesc = cagegoryDesc;
    }

    /**
     * 获取家私配套
     *
     * @return furniture - 家私配套
     */
    public String getFurniture() {
        return furniture;
    }

    /**
     * 设置家私配套
     *
     * @param furniture 家私配套
     */
    public void setFurniture(String furniture) {
        this.furniture = furniture;
    }

    /**
     * 获取房间数量
     *
     * @return bed_units - 房间数量
     */
    public Integer getBedUnits() {
        return bedUnits;
    }

    /**
     * 设置房间数量
     *
     * @param bedUnits 房间数量
     */
    public void setBedUnits(Integer bedUnits) {
        this.bedUnits = bedUnits;
    }

    /**
     * 获取房间数量最少
     *
     * @return bed_units_low - 房间数量最少
     */
    public Integer getBedUnitsLow() {
        return bedUnitsLow;
    }

    /**
     * 设置房间数量最少
     *
     * @param bedUnitsLow 房间数量最少
     */
    public void setBedUnitsLow(Integer bedUnitsLow) {
        this.bedUnitsLow = bedUnitsLow;
    }

    /**
     * 获取房间数量最多
     *
     * @return bed_units_hight - 房间数量最多
     */
    public Integer getBedUnitsHight() {
        return bedUnitsHight;
    }

    /**
     * 设置房间数量最多
     *
     * @param bedUnitsHight 房间数量最多
     */
    public void setBedUnitsHight(Integer bedUnitsHight) {
        this.bedUnitsHight = bedUnitsHight;
    }

    /**
     * 获取大厅数量
     *
     * @return hall_units - 大厅数量
     */
    public Integer getHallUnits() {
        return hallUnits;
    }

    /**
     * 设置大厅数量
     *
     * @param hallUnits 大厅数量
     */
    public void setHallUnits(Integer hallUnits) {
        this.hallUnits = hallUnits;
    }

    /**
     * 获取卫生间数量
     *
     * @return bath_units - 卫生间数量
     */
    public Integer getBathUnits() {
        return bathUnits;
    }

    /**
     * 设置卫生间数量
     *
     * @param bathUnits 卫生间数量
     */
    public void setBathUnits(Integer bathUnits) {
        this.bathUnits = bathUnits;
    }

    /**
     * 获取厨房数量
     *
     * @return cook_untis - 厨房数量
     */
    public Integer getCookUntis() {
        return cookUntis;
    }

    /**
     * 设置厨房数量
     *
     * @param cookUntis 厨房数量
     */
    public void setCookUntis(Integer cookUntis) {
        this.cookUntis = cookUntis;
    }

    /**
     * 获取建筑面积最少
     *
     * @return area_untis_low - 建筑面积最少
     */
    public BigDecimal getAreaUntisLow() {
        return areaUntisLow;
    }

    /**
     * 设置建筑面积最少
     *
     * @param areaUntisLow 建筑面积最少
     */
    public void setAreaUntisLow(BigDecimal areaUntisLow) {
        this.areaUntisLow = areaUntisLow;
    }

    /**
     * @return area_units_hight
     */
    public BigDecimal getAreaUnitsHight() {
        return areaUnitsHight;
    }

    /**
     * @param areaUnitsHight
     */
    public void setAreaUnitsHight(BigDecimal areaUnitsHight) {
        this.areaUnitsHight = areaUnitsHight;
    }

    /**
     * 获取租赁方式
     *
     * @return rent_type - 租赁方式
     */
    public String getRentType() {
        return rentType;
    }

    /**
     * 设置租赁方式
     *
     * @param rentType 租赁方式
     */
    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    /**
     * 获取总价最低
     *
     * @return total_price_low - 总价最低
     */
    public BigDecimal getTotalPriceLow() {
        return totalPriceLow;
    }

    /**
     * 设置总价最低
     *
     * @param totalPriceLow 总价最低
     */
    public void setTotalPriceLow(BigDecimal totalPriceLow) {
        this.totalPriceLow = totalPriceLow;
    }

    /**
     * 获取总价最高
     *
     * @return total_price_hight - 总价最高
     */
    public BigDecimal getTotalPriceHight() {
        return totalPriceHight;
    }

    /**
     * 设置总价最高
     *
     * @param totalPriceHight 总价最高
     */
    public void setTotalPriceHight(BigDecimal totalPriceHight) {
        this.totalPriceHight = totalPriceHight;
    }

    /**
     * 获取租金
     *
     * @return price - 租金
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置租金
     *
     * @param price 租金
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取租金最低
     *
     * @return price_low - 租金最低
     */
    public BigDecimal getPriceLow() {
        return priceLow;
    }

    /**
     * 设置租金最低
     *
     * @param priceLow 租金最低
     */
    public void setPriceLow(BigDecimal priceLow) {
        this.priceLow = priceLow;
    }

    /**
     * 获取租金最高
     *
     * @return price_hight - 租金最高
     */
    public BigDecimal getPriceHight() {
        return priceHight;
    }

    /**
     * 设置租金最高
     *
     * @param priceHight 租金最高
     */
    public void setPriceHight(BigDecimal priceHight) {
        this.priceHight = priceHight;
    }

    /**
     * 获取建筑年代
     *
     * @return bulid_timer - 建筑年代
     */
    public String getBulidTimer() {
        return bulidTimer;
    }

    /**
     * 设置建筑年代
     *
     * @param bulidTimer 建筑年代
     */
    public void setBulidTimer(String bulidTimer) {
        this.bulidTimer = bulidTimer;
    }

    /**
     * 获取是否有电梯
     *
     * @return has_lift - 是否有电梯
     */
    public Boolean getHasLift() {
        return hasLift;
    }

    /**
     * 设置是否有电梯
     *
     * @param hasLift 是否有电梯
     */
    public void setHasLift(Boolean hasLift) {
        this.hasLift = hasLift;
    }

    /**
     * 获取产权
     *
     * @return equities - 产权
     */
    public String getEquities() {
        return equities;
    }

    /**
     * 设置产权
     *
     * @param equities 产权
     */
    public void setEquities(String equities) {
        this.equities = equities;
    }

    /**
     * 获取押付方式
     *
     * @return pay_method - 押付方式
     */
    public String getPayMethod() {
        return payMethod;
    }

    /**
     * 设置押付方式
     *
     * @param payMethod 押付方式
     */
    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    /**
     * 获取物业管理费
     *
     * @return manage_fee - 物业管理费
     */
    public BigDecimal getManageFee() {
        return manageFee;
    }

    /**
     * 设置物业管理费
     *
     * @param manageFee 物业管理费
     */
    public void setManageFee(BigDecimal manageFee) {
        this.manageFee = manageFee;
    }
}
package cn.sjxy.shop.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Goods {

	private int id;
	private int typeId;
	private String goodsName;
	private String introduce;
	private BigDecimal price;
	private BigDecimal nowPrice;
	private String picture;
	private Date inTime;
	private int newGoods;
	private int sale;
	private int hit;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getNowPrice() {
		return nowPrice;
	}
	public void setNowPrice(BigDecimal nowPrice) {
		this.nowPrice = nowPrice;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	public int getNewGoods() {
		return newGoods;
	}
	public void setNewGoods(int newGoods) {
		this.newGoods = newGoods;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", typeId=" + typeId + ", goodsName=" + goodsName + ", introduce=" + introduce
				+ ", price=" + price + ", nowPrice=" + nowPrice + ", picture=" + picture + ", inTime=" + inTime
				+ ", newGoods=" + newGoods + ", sale=" + sale + ", hit=" + hit + "]";
	}
	
}

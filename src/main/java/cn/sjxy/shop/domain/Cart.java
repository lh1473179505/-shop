package cn.sjxy.shop.domain;

import java.math.BigDecimal;
import java.util.List;
/**
 * 
 * id int not null primary key,
	
	number int not null default 0,
	picture varchar(100),
	goodsName varchar(200) not null,
	price decimal(15,2)*/
public class Cart {

	public int id; 			//商品ID
    public BigDecimal price;	//现价
    public int number;		//数量
    public String picture;
    public String goodsName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", price=" + price + ", number=" + number + ", picture=" + picture + ", goodsName="
				+ goodsName + "]";
	}
    
    
    
    
}

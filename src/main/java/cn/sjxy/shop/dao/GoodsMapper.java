package cn.sjxy.shop.dao;

import java.util.List;

import cn.sjxy.shop.domain.Goods;

public interface GoodsMapper {

	public List<Goods> findAll();
	
	public List<Goods> findAll1();
	
	public List<Goods> findAll2();
	
	public Goods findById(int id);
	
}

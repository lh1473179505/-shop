package cn.sjxy.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.sjxy.shop.dao.GoodsMapper;
import cn.sjxy.shop.domain.Goods;

@Service
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
public class GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;

	public GoodsMapper getGoodsMapper() {
		return goodsMapper;
	}

	public void setGoodsMapper(GoodsMapper goodsMapper) {
		this.goodsMapper = goodsMapper;
	}
	
	
	public List<Goods> findAllGoods(){
		return goodsMapper.findAll();
	}
	
	public List<Goods> findAllGoods1(){
		return goodsMapper.findAll1();
	}
	
	public List<Goods> findAllGoods2(){
		return goodsMapper.findAll2();
	}
	
	public Goods findOneGoods(int id) {
		return goodsMapper.findById(id);
	}
}

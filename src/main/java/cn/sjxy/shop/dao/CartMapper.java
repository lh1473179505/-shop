package cn.sjxy.shop.dao;

import java.util.List;

import cn.sjxy.shop.domain.Cart;

public interface CartMapper {

	public void insert(Cart cart);
	
	public void update(Cart cart);
	
	public void delete(int id);
	
	public Cart find(int id);
	
	public List<Cart> findAll();
	
	public void deleteAll();
}

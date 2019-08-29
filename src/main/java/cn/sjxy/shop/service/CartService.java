package cn.sjxy.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.sjxy.shop.dao.CartMapper;
import cn.sjxy.shop.domain.Cart;

@Service
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
public class CartService {

	@Autowired
	private CartMapper cartMapper;

	public CartMapper getCartMapper() {
		return cartMapper;
	}

	public void setCartMapper(CartMapper cartMapper) {
		this.cartMapper = cartMapper;
	}
	
	
	public void insertCart(Cart cart) {
		cartMapper.insert(cart);
	}
	
	public void updateCart(Cart cart) {
		cartMapper.update(cart);
	}
	
	public void deleteCart(int id) {
		cartMapper.delete(id);
	}
	
	public Cart findCart(int id) {
		return cartMapper.find(id) ;
	}
	
	public List<Cart> findAllCart(){
		return cartMapper.findAll() ;
	}
	
	public void deleteAll() {
		cartMapper.deleteAll();
	}
	
}

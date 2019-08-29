package cn.sjxy.shop.handler;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.sjxy.shop.domain.Cart;
import cn.sjxy.shop.domain.Goods;
import cn.sjxy.shop.service.CartService;
import cn.sjxy.shop.service.GoodsService;

@Controller
public class CartHandler {

	@Autowired
	private GoodsService goodsService;

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	@Autowired
	private CartService cartService;

	public CartService getCartService() {
		return cartService;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	
	
	@RequestMapping(value="/insertCart")
	public String addCart(@RequestParam(value="goodsID",required=false)int goodsID,
			@RequestParam(value="num",required=false)int num,
			Cart cart,HttpServletRequest request) {
		if(request.getSession().getAttribute("username")!=null) {
			if(cartService.findCart(goodsID)!=null) {
				//System.out.println("1"+cartService.findCart(goodsID).toString());
				cart.setId(goodsID);
				cart.setNumber(num);
				//System.out.println("2"+cart.toString());
				cartService.updateCart(cart);
			}else {
				//System.out.println("22222222222222222222222221");
				Goods goods=goodsService.findOneGoods(goodsID);
				//System.out.println("1"+goods.toString());
				
				cart.setId(goods.getId());
				cart.setGoodsName(goods.getGoodsName());
				cart.setPicture(goods.getPicture());
				cart.setPrice(goods.getNowPrice());
				cart.setNumber(num);
				//System.out.println("2444444444"+cart.toString());
				cartService.insertCart(cart);
				//System.out.println("2"+cart.toString());
			}
			
			
			String msg="添加成功";
			request.setAttribute("msg", msg);
			request.setAttribute("url", "/front/includeCart_see.jsp");
			return "forward";
		}else {
			String msg="你还未登录！";
			request.setAttribute("msg", msg);
			request.setAttribute("url", "front/login.jsp");
			return "forward";
		}
		
	}
	
	
	@RequestMapping(value="/insertCart1")
	public String addCart1(HttpServletRequest request,@RequestParam(value="goodsID",required=false)int goodsID,
			@RequestParam(value="num",required=false)int num,
			Cart cart) {
		if(request.getSession().getAttribute("username")!=null) {
			if(cartService.findCart(goodsID)!=null) {
				//System.out.println("1"+cartService.findCart(goodsID).toString());
				cart.setId(goodsID);
				cart.setNumber(num);
				//System.out.println("2"+cart.toString());
				cartService.updateCart(cart);
			}else {
				
Goods goods=goodsService.findOneGoods(goodsID);
				
				cart.setId(goods.getId());
				cart.setGoodsName(goods.getGoodsName());
				cart.setPicture(goods.getPicture());
				cart.setPrice(goods.getNowPrice());
				cart.setNumber(num);
				cartService.insertCart(cart);
				//System.out.println("3"+cart.toString());
			}
			String msg="添加成功";
			request.setAttribute("msg", msg);
			request.setAttribute("url", "/front/includeCart_see.jsp");
			return "forward";
		}else {
			String msg="你还未登录！";
			request.setAttribute("msg", msg);
			request.setAttribute("url", "front/login.jsp");
			return "forward";
		}
		
	}
	
	@RequestMapping(value="/insertCart2",method=RequestMethod.POST)
	public String addCart2(HttpServletRequest request,@RequestParam(value="goodsID",required=false)int goodsID,Cart cart) {
		if(request.getSession().getAttribute("username")!=null) {
			if(cartService.findCart(goodsID)!=null) {
				//System.out.println("1"+cartService.findCart(goodsID).toString());
				cart.setId(goodsID);
				
			
				//System.out.println("2"+cart.toString());
				cartService.updateCart(cart);
			}else {
				
Goods goods=goodsService.findOneGoods(goodsID);
				
				cart.setId(goods.getId());
				cart.setGoodsName(goods.getGoodsName());
				cart.setPicture(goods.getPicture());
				cart.setPrice(goods.getNowPrice());
				
				
				cartService.insertCart(cart);
				//System.out.println("3"+cart.toString());
			}
			String msg="添加成功";
			request.setAttribute("msg", msg);
			request.setAttribute("url", "/front/includeCart_see.jsp");
			return "forward";
		}else {
			String msg="你还未登录！";
			request.setAttribute("msg", msg);
			request.setAttribute("url", "front/login.jsp");
			return "forward";
		}
		
	}
	
	@RequestMapping(value="/findAllCart")
	public String findAll(Map<String,Object>map) {
		float sum=0;
		int [] b=new int [5000];
		int i=0;
		List<Cart> list=cartService.findAllCart();
		map.put("carts",cartService.findAllCart());
		for(Cart a:list) {
			int aprice=a.price.intValue();
			sum=sum+a.number*aprice;
			b[i]=a.number*aprice;
			i++;
			//System.out.println(a.toString());


		}
		map.put("b", b);
		map.put("sum", sum);
		
		return "front/cart_see";
		
	}
	
	@RequestMapping(value="/deleteCart")
	public String deleteCart(@RequestParam(value="ID",defaultValue="0")int ID,
			HttpServletRequest request) {
		cartService.deleteCart(ID);
		String msg="删除成功！";
		request.setAttribute("msg", msg);
		request.setAttribute("url", "front/includeCart_see.jsp");
		return "forward";
	}
	
	@RequestMapping(value="/deleteAll")
	public String deleteAll(HttpServletRequest request) {
		cartService.deleteAll();
		request.setAttribute("msg", "成功清空购物车");
		request.setAttribute("url", "front/includeCart_see.jsp");
		return "forward";
	}
	
	
	@RequestMapping(value="/myCart")
	public String showCart(HttpServletRequest request) {
		
		request.setAttribute("url", "front/includeCart_see.jsp");
		return "front/forward";
	}
}

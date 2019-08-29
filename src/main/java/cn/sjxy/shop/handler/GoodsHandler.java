package cn.sjxy.shop.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.sjxy.shop.service.GoodsService;

@Controller
public class GoodsHandler {

	@Autowired
	private GoodsService goodsService;

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	@RequestMapping(value="/findAllGoods")
	public String findAllGoods(Map<String,Object> map) {
		map.put("newGoods", goodsService.findAllGoods());
		map.put("newGoods1", goodsService.findAllGoods1());
		map.put("newGoods2", goodsService.findAllGoods2());
		return "front/index";
	}
	
	@RequestMapping(value="/showOneGoods")
	public String showOneGoods(@RequestParam(value="ID",defaultValue="0",required=false)int ID,
			Map<String,Object>map,HttpServletRequest request,HttpSession session) {
		map.put("newGoods", goodsService.findAllGoods());
		map.put("goods",goodsService.findOneGoods(ID) );
	
		session.setAttribute("id",goodsService.findOneGoods(ID).getId() );
		//System.out.println(goodsService.findOneGoods(ID).getId());
		map.put("newGoods2", goodsService.findAllGoods2());
		return "front/goodsDetail1";
	}
	
	@RequestMapping(value="/showGoods")
	public String showGoods(@RequestParam(value="Page",required=false,defaultValue="1")Integer Page,HttpServletRequest request,Map<String,Object> map,@RequestParam(value="type",defaultValue="0",required=false)int type) {
		PageHelper.startPage(Page, 12);
		PageInfo pageInfo = new PageInfo(goodsService.findAllGoods());
		
		map.put("newGoods2", goodsService.findAllGoods2());
		map.put("newGoods", pageInfo);
		
		map.put("type", type);
		String typeName="";
		if(type==14) {
			typeName="图书类";
		}else if(type==15) {
			typeName="家电类";
		}else if(type==16) {
			typeName="服装类";
		}else if(type==17) {
			typeName="电子类";
		}
		
		map.put("typeName", typeName);
		
		return "front/goodsList";
	}
}

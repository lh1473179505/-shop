package cn.sjxy.shop.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sjxy.shop.domain.Member;
import cn.sjxy.shop.service.MemberService;
import cn.sjxy.shop.utils.MD5Code;

@Controller
public class MemberHandler {

	@Autowired
	private MemberService memberService;

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping(value="/addMember",method=RequestMethod.POST)
	public String addMember(Member member,HttpServletRequest request) {
		String msg="";
		memberService.insert(member);
		msg="插入成功！";
		request.setAttribute("msg", msg);
		request.setAttribute("url", "front/register.jsp");
		return "forward";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Member member,HttpSession session,HttpServletRequest request) {
		String msg="";
		String url="";
		//System.out.println(request.getParameter("checkCode"));
		//System.out.println(request.getSession().getAttribute("randCheckCode"));
		
		//验证码
		if(request.getParameter("checkCode").equals(request.getSession().getAttribute("randCheckCode"))&&
				request.getParameter("checkCode")!=null) {
			session.setAttribute("verifyCode", new MD5Code().getMD5ofStr(Math.random()+""));
			
			//获取shiro令牌
		//UserNamePasswordToken token=new UserNamePasswordToken();
			if(memberService.login(member)!=null) {
				session.setAttribute("username", member.getUserName());
				msg="登录成功！";
				url="front/includeIndex.jsp";
			}else {
				msg="用户名或密码错误！";
				url="front/includeLogin.jsp";
			}
		}else {
			msg="验证码错误！";
			url="front/login.jsp";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "forward";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session,HttpServletRequest request) {
		String msg="";
		session.invalidate();
		msg="退出成功！";
		request.setAttribute("msg", msg);
		request.setAttribute("url", "front/includeIndex.jsp");
		return "forward";
		
		
	}
	
	@RequestMapping(value="/index")
	public String index(HttpServletRequest request) {
				String msg="成功加入购物车！";
				String url="front/includeIndex.jsp";
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "forward";
	}
}

package cn.sjxy.shop.dao;

import cn.sjxy.shop.domain.Member;

public interface MemberMapper {

	public void insertMember(Member member);
	
	public Member login(Member member);
}

package cn.sjxy.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.sjxy.shop.dao.MemberMapper;
import cn.sjxy.shop.domain.Member;

@Service
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;

	public MemberMapper getMemberMapper() {
		return memberMapper;
	}

	public void setMemberMapper(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	
	public void insert(Member member) {
		memberMapper.insertMember(member);
	}
	
	public Member login(Member member) {
		return memberMapper.login(member);
	}
}

package com.javaguides.springboot.service;

import java.util.List;

import com.javaguides.springboot.model.Member;

public interface MemberService {
	Member saveMember(Member member);
	
	List<Member> getAllMembers();
	Member getMemberByID(long id);
	Member updateMember(Member member, long id);
	void deleteMember(long id);
}

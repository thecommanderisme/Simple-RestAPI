package com.javaguides.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javaguides.springboot.exception.ResourceNotFoundException;
import com.javaguides.springboot.model.Member;
import com.javaguides.springboot.repository.MemberRepository;
import com.javaguides.springboot.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	private MemberRepository memberRepository;
	
	public MemberServiceImpl(MemberRepository memberRepository) {
		super();
		this.memberRepository = memberRepository;
	}

	@Override
	public Member saveMember(Member member) {
		return memberRepository.saveAndFlush(member);
	}

	@Override
	public List<Member> getAllMembers() {
		return memberRepository.findAll();
	}

	@Override
	public Member getMemberByID(long id) {
		Optional<Member> member = memberRepository.findById(id);
		if(member.isPresent()) {
			return member.get();
		} 
		throw new ResourceNotFoundException("Member", "Id", id);
	}

	@Override
	public Member updateMember(Member member, long id) {
		
		 Member existingMember = memberRepository.findById(id).orElseThrow(
				 () -> new ResourceNotFoundException("Member", "Id", id));
		
		existingMember.setFirstName(member.getFirstName());
		existingMember.setLastName(member.getLastName());
		existingMember.setEmail(member.getEmail());

		memberRepository.save(existingMember);
		return existingMember;
	}

	@Override
	public void deleteMember(long id) {
		
		memberRepository.findById(id).orElseThrow(
				 () -> new ResourceNotFoundException("Member", "Id", id));

		memberRepository.deleteById(id);
	}

	
}

package com.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaguides.springboot.model.Member;
import com.javaguides.springboot.service.MemberService;

@RestController
@RequestMapping("api/members")
@Validated
public class MemberController {

	//Create the dependency injection
	private MemberService memberService;

	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}

	// build create member REST API
	//PostMapping annotation for the method to handle POST HTTP Request
	@PostMapping()
	public ResponseEntity<Member> saveMember(@RequestBody Member member) {
		return new ResponseEntity<Member>(memberService.saveMember(member), HttpStatus.CREATED);
	}
	
	// build get all member REST API
	@GetMapping
	public List<Member> getAllMembers() {
		return memberService.getAllMembers();
	}
	
	// build get member by ID REST API
	@GetMapping("{id}")
	public ResponseEntity<Member> getMemberById(@PathVariable("id") long memberId) {
		return new ResponseEntity<Member>(memberService.getMemberByID(memberId), HttpStatus.OK);
	}
	
	// build update member REST API
	@PutMapping("{id}")
	public ResponseEntity<Member> updateMember(@PathVariable("id") long memberId, 
			@RequestBody Member member) {
		return new ResponseEntity<Member>(memberService.updateMember(member, memberId), HttpStatus.OK);
	}
	
	// build delete member REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteMember(@PathVariable("id") long memberId) {
		memberService.deleteMember(memberId);
		return new ResponseEntity<String>("Member deleted successfully", HttpStatus.OK);
	}
}

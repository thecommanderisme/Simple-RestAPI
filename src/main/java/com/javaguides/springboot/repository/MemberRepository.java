package com.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javaguides.springboot.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

}

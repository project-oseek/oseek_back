package com.foodfinder.oseek.repository;


import com.foodfinder.oseek.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}

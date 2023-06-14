package com.foodfinder.oseek.repository;


import com.foodfinder.oseek.domain.memberFoodKeyword.MemberFoodKeyword;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberFoodKeywordRepository extends JpaRepository<MemberFoodKeyword, Long> {

    long deleteAllByMemberId(Long memberId);

}

package com.foodfinder.oseek.service;

import com.foodfinder.oseek.domain.memberFoodKeyword.MemberFoodKeyword;
import com.foodfinder.oseek.dto.memberFoodKeyword.MemberFoodKeyWordResDto;
import com.foodfinder.oseek.dto.memberFoodKeyword.MemberFoodKeywordReqDto;
import com.foodfinder.oseek.repository.MemberFoodKeywordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberFoodKeywordService {

    private final MemberFoodKeywordRepository memberFoodKeywordRepository;

    @Transactional
    public int saveMemberFoodKeyword(Long memberId, List<MemberFoodKeywordReqDto> reqDtoList){

        memberFoodKeywordRepository.deleteAllByMemberId(memberId);

        List<MemberFoodKeyword> memberFoodKeywords = reqDtoList.stream().
                map(resDto -> MemberFoodKeyword.builder()
                        .memberId(memberId)
                        .foodKeyword(resDto.getFoodKeyword())
                        .build()).collect(Collectors.toList());
        memberFoodKeywordRepository.
                saveAll(memberFoodKeywords);

        return memberFoodKeywords.size();
    }

    @Transactional
    public List<MemberFoodKeyWordResDto> findMemberFoodKeywords(Long memberId){
        return memberFoodKeywordRepository.findAllByMemberId(memberId).stream()
                .map(MemberFoodKeyWordResDto::new)
                .collect(Collectors.toList());
    }
}

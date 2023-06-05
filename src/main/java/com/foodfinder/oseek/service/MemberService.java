package com.foodfinder.oseek.service;

import com.foodfinder.oseek.domain.member.Member;
import com.foodfinder.oseek.dto.member.MemberInfoResDTO;
import com.foodfinder.oseek.dto.member.MemberReqDto;
import com.foodfinder.oseek.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long memberSave(MemberReqDto reqDto){
        return memberRepository.save(reqDto.toEntity()).getMemberId();
    }

    @Transactional
    public MemberInfoResDTO findMemberInfo(Long memberId){
        return new MemberInfoResDTO(getMember(memberId));
    }

    public Member getMember(Long memberId){
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + memberId));
    }

}

package com.foodfinder.oseek.service;

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
        return memberRepository.save(reqDto.toEntity()).getId();
    }

}

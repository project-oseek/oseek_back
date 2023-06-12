package com.foodfinder.oseek.controller.member;

import com.foodfinder.oseek.common.CommController;
import com.foodfinder.oseek.dto.member.MemberReqDto;
import com.foodfinder.oseek.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController extends CommController {

    @Autowired
    private MemberService memberService;

    @PostMapping()
    public ResponseEntity saveMember(@RequestBody MemberReqDto reqDto){
        return SuccessReturn(memberService.memberSave(reqDto));
    }

//    //TODO jwt적용 시 pathVariable 삭제
//    @GetMapping("/info/{memberId}")
//    public ResponseEntity findMemberInfo(@PathVariable Long memberId){
//        return SuccessReturn(memberService.findMemberInfo(memberId));
//    }

    //TODO jwt적용 시 pathVariable 삭제
    @GetMapping("/info")
    public ResponseEntity findMemberInfo(@AuthenticationPrincipal User user){
        return SuccessReturn(user);
    }


}

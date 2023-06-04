package com.foodfinder.oseek.controller.member;


import com.foodfinder.oseek.common.CommController;
import com.foodfinder.oseek.dto.member.MemberReqDto;
import com.foodfinder.oseek.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

}

package com.foodfinder.oseek.domain.member;


import com.foodfinder.oseek.common.RegisterDateBaseTimeEntity;
import com.foodfinder.oseek.dto.member.MemberModifyReqDto;
import com.foodfinder.oseek.enums.AuthProvider;
import com.foodfinder.oseek.enums.Role;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member extends RegisterDateBaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    private String nickname;
    private String email;
    private String location;

    @Enumerated(EnumType.STRING)
    private AuthProvider authProvider;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Member modify(MemberModifyReqDto reqDto) {
        this.nickname = reqDto.getNickname();
        this.location = reqDto.getLocation();
        return this;
    }

}

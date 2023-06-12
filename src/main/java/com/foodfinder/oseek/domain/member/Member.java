package com.foodfinder.oseek.domain.member;


import com.foodfinder.oseek.common.RegisterDateBaseTimeEntity;
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
    private String address;


    @Enumerated(EnumType.STRING)
    private AuthProvider authProvider;

//    private String oauth2Id;

    @Enumerated(EnumType.STRING)
    private Role role;

}

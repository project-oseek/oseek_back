package com.foodfinder.oseek.domain.memberFoodKeyword;

import com.foodfinder.oseek.common.RegisterDateBaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Table(name = "MemberFoodKeyword")
public class MemberFoodKeyword extends RegisterDateBaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberFoodKeywordId;

    private Long memberId;

    private String foodKeyword;
}

package com.foodfinder.oseek.domain.code;


import com.foodfinder.oseek.common.RegisterDateBaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@IdClass(CodeId.class)
public class Code extends RegisterDateBaseTimeEntity {

    @Id
    private String code;

    @Id
    private String codeGroup;

    private int codeId;

    private String codeName;

    private int codeOrderNo;

    private int isUse;

    private String codeDescription;

}

package com.daily.routine.member.dto;

import com.daily.routine.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JoinRequestDto {

    private String name;
    private String email;
    private String password;

    public Member toEntity(JoinRequestDto dto) {
        return Member.builder()
                .email(dto.getEmail())
                .name(dto.getName())
                .password(dto.getPassword())
                .build();
    }
}

package com.daily.routine.member;

import com.daily.routine.member.dto.FixRequestDto;
import com.daily.routine.member.dto.JoinRequestDto;
import com.daily.routine.member.dto.ReadResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {

    void join(JoinRequestDto dto);

    Long login(String email, String password);

    ReadResponseDto readMyAccount(Long memberId);

    void fixMyAccount(Long memberId, FixRequestDto dto);

    void deleteAccount(Long memberId);

}

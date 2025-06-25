package com.daily.routine.member;

import org.springframework.stereotype.Service;

@Service
public interface MemberService {

    void join(Member member);

    Long login(String email, String password);

    Member readMyAccount(Long memberId);

    void fixMyAccount(Long memberId);

    void deleteAccount(Long memberId);

}

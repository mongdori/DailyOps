package com.daily.routine.member;

import com.daily.routine.member.dto.FixRequestDto;
import com.daily.routine.member.dto.JoinRequestDto;
import com.daily.routine.member.dto.ReadResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public void join(JoinRequestDto dto) { // Member 타입의 인자를 직접 받으면 서비스 내부에서 직접 생성하는 것이기에 단일 책임 원칙 SRP 위반. 객체 생성은 다른 곳에서 (ex) dto)
        Member entity = dto.toEntity(dto);
        memberRepository.save(entity);
    }

    @Override
    public Long login(String email, String password) {
//        Member byEmail = memberRepository.findByEmail(email); // 이게 만약 NULL일 경우? NPE 발생. 방어 코드 필요
        Member byEmail = Optional.ofNullable(memberRepository.findByEmail(email))
                .orElseThrow(() -> new IllegalArgumentException("해당 이메일에 대한 계정이 존재하지 않아요."));
        if (!byEmail.getPassword().equals(password)) {
            throw new IllegalArgumentException("패스워드를 확인해주세요.");
        } else {
            return byEmail.getId();
        }
    }

    @Override
    public ReadResponseDto readMyAccount(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("해당 id에 대한 계정이 존재하지 않아요."));
        return member.toDto(member);
    }

    @Override
    @Transactional
    public void fixMyAccount(Long memberId, FixRequestDto requestDto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("해당 id가 존재하지 않아요."));
        if (member.getPassword().equals(requestDto.getPassword())) {
            member.update(requestDto.getName(), requestDto.getEmail(), requestDto.getPassword());
        } else {
            throw new IllegalArgumentException("패스워드가 일치하지 않아요.");
        }
    }

    @Override
    public void deleteAccount(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("해당 id에 대한 멤버가 존재하지 않아요."));
        memberRepository.delete(member);
    }
}

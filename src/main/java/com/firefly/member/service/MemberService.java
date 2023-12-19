package com.firefly.member.service;

import com.firefly.member.entity.Member;
import com.firefly.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void createMember(Member member, String email) {
        verifyExistsByEmail(email);
        memberRepository.save(member);
    }

    public Member updateMember(Long memberId, Member member) {
        Member findMember = findMember(memberId);
        findMember.update(memberId,
                member.getNickname(),
                member.getPassword(),
                member.getInterestStack(),
                member.getJobRole());

        return findMember;
    }

    @Transactional(readOnly = true)
    public Member findMember(Long memberId) {
        Optional<Member> findMember = memberRepository.findById(memberId);

        return findMember.orElseThrow(() ->
                new IllegalArgumentException("회원이 존재하지 않습니다."));
    }

    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }

    public void verifyExistsByEmail(String email) {
        Optional<Member> findMember = memberRepository.findByEmail(email);

        if (findMember.isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }
    }
}

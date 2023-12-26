package com.firefly.member.service;

import com.firefly.member.dto.MemberCreationDto;
import com.firefly.member.dto.MemberUpdateDto;
import com.firefly.member.entity.Member;
import com.firefly.member.mapper.MemberMapper;
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
    private final MemberMapper mapper;

    public void createMember(MemberCreationDto memberDto) {
        verifyExistsByEmail(memberDto.getEmail());
        Member member = mapper.memberPostDtoToMember(memberDto);

        memberRepository.save(member);
    }

    public Member updateMember(Long memberId, MemberUpdateDto memberDto) {
        Member findMember = findMember(memberId);
        findMember.update(memberDto);

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

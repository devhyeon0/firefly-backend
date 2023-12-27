package com.firefly.post.service;

import com.firefly.member.entity.Member;
import com.firefly.member.repository.MemberRepository;
import com.firefly.post.dto.LikeDto;
import com.firefly.post.entity.Like;
import com.firefly.post.entity.Post;
import com.firefly.post.mapper.PostMapper;
import com.firefly.post.repository.LikeRepository;
import com.firefly.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LikeService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final LikeRepository likeRepository;
    private final PostMapper mapper;

    public void addLike(LikeDto likeDto) {
        Post post = findPost(likeDto.getPostId());
        Member member = findMember(likeDto.getMemberId());

        if (likeRepository.findByPostAndMember(post, member).isPresent()) {
            throw new IllegalArgumentException("이미 좋아요한 게시글입니다.");
        }

        Like like = mapper.likeRequestDtoToLike(likeDto);
        likeRepository.save(like);
    }

    private Post findPost(Long postId) {
       return postRepository.findById(postId)
               .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
    }

    private Member findMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));
    }
}

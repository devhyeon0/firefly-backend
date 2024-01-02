package com.firefly.post.service;

import com.firefly.member.entity.Member;
import com.firefly.member.mapper.MemberMapper;
import com.firefly.member.repository.MemberRepository;
import com.firefly.post.dto.PostCreationDto;
import com.firefly.post.dto.PostUpdateDto;
import com.firefly.post.entity.Post;
import com.firefly.post.entity.PostStatus;
import com.firefly.post.mapper.PostMapper;
import com.firefly.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final PostMapper mapper;
    private final MemberMapper memberMapper;

    public void createPost(PostCreationDto postDto) {
        Member member = memberRepository.findByNickname(postDto.getMember().getNickname());
        postDto.setMember(memberMapper.memberToMemberResponseDto(member));
        Post post = mapper.postCreationDtoToPost(postDto);

        postRepository.save(post);
    }

    public Post updatePost(Long postId, PostUpdateDto postDto) {
        Post findPost = findPost(postId);
        findPost.update(postDto);

        return findPost;
    }

    @Transactional(readOnly = true)
    public Post findPost(Long postId) {
        Optional<Post> findPost = postRepository.findById(postId);

        return findPost.orElseThrow(() ->
                new IllegalArgumentException("게시글이 존재하지 않습니다."));
    }

    @Transactional(readOnly = true)
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public void deletePost(Long postId) {
        Post findPost = findPost(postId);

        findPost.setStatus(PostStatus.DELETED);
    }
}

package com.firefly.post.service;

import com.firefly.post.entity.Post;
import com.firefly.post.entity.PostStatus;
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

    public void createPost(Post post) {
        postRepository.save(post);
    }

    public Post updatePost(Long postId, Post post) {
        Post findPost = findPost(postId);
        findPost.update(post.getTitle(),
                post.getContent(),
                post.getRecruitMember(),
                post.getRecruitField(),
                post.getRecruitType(),
                post.getContact(),
                post.getContactLink(),
                post.getTechStack(),
                post.getDeadline(),
                post.getEstimatedPeriod(),
                post.getStatus());

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

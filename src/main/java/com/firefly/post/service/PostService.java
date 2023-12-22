package com.firefly.post.service;

import com.firefly.post.entity.Post;
import com.firefly.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void createPost(Post post) {
        postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public Post findPost(Long postId) {
        Optional<Post> findPost = postRepository.findById(postId);

        return findPost.orElseThrow(() ->
                new IllegalArgumentException("게시글이 존재하지 않습니다."));
    }
}

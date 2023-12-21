package com.firefly.post.service;

import com.firefly.post.entity.Post;
import com.firefly.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void createPost(Post post) {
        postRepository.save(post);
    }
}

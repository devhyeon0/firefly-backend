package com.firefly.post.controller;

import com.firefly.post.dto.PostCreationDto;
import com.firefly.post.dto.PostResponseDto;
import com.firefly.post.dto.PostUpdateDto;
import com.firefly.post.entity.Post;
import com.firefly.post.mapper.PostMapper;
import com.firefly.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final PostMapper mapper;

    @PostMapping
    public ResponseEntity<Objects> createPost(@Valid @RequestBody PostCreationDto requestBody) {
        postService.createPost(mapper.postCreationDtoToPost(requestBody));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PostResponseDto> patchPost(@PathVariable("id") Long postId,
                                                     @Valid @RequestBody PostUpdateDto requestBody) {
        Post post = postService.updatePost(postId, mapper.postUpdateDtoToPost(requestBody));

        return ResponseEntity.ok(mapper.postToPostResponseDto(post));
    }
}
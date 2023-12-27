package com.firefly.post.controller;

import com.firefly.post.dto.LikeDto;
import com.firefly.post.service.LikeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;

@RestController
@RequestMapping("/api/like")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping
    public ResponseEntity<Objects> postLike(@Valid @RequestBody LikeDto requestBody) {
        likeService.addLike(requestBody);

        return ResponseEntity.ok().build();
    }
}
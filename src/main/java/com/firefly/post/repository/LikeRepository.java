package com.firefly.post.repository;

import com.firefly.member.entity.Member;
import com.firefly.post.entity.Like;
import com.firefly.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByPostAndMember(Post post, Member member);
}

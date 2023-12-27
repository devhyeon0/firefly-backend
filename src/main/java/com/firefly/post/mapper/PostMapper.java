package com.firefly.post.mapper;

import com.firefly.post.dto.LikeDto;
import com.firefly.post.dto.PostCreationDto;
import com.firefly.post.dto.PostResponseDto;
import com.firefly.post.dto.PostUpdateDto;
import com.firefly.post.entity.Like;
import com.firefly.post.entity.Post;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    Post postCreationDtoToPost(PostCreationDto postDto);
    Post postUpdateDtoToPost(PostUpdateDto postDto);
    PostResponseDto postToPostResponseDto(Post post);
    List<PostResponseDto> postToPostResponseDtos(List<Post> posts);

    Like likeRequestDtoToLike(LikeDto likeDto);
}

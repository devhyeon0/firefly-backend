package com.firefly.post.mapper;

import com.firefly.post.dto.PostCreationDto;
import com.firefly.post.dto.PostResponseDto;
import com.firefly.post.dto.PostUpdateDto;
import com.firefly.post.entity.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {

    Post postCreationDtoToPost(PostCreationDto postDto);
    Post postUpdateDtoToPost(PostUpdateDto postDto);
    PostResponseDto postToPostResponseDto(Post post);
}

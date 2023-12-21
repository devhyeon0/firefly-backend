package com.firefly.post.mapper;

import com.firefly.post.dto.PostCreationDto;
import com.firefly.post.entity.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {

    Post postCreationDtoToPost(PostCreationDto postDto);
}

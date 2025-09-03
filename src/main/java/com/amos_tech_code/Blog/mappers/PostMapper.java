package com.amos_tech_code.Blog.mappers;

import com.amos_tech_code.Blog.domain.CreatePostRequest;
import com.amos_tech_code.Blog.domain.dtos.CreatePostRequestDto;
import com.amos_tech_code.Blog.domain.dtos.PostDto;
import com.amos_tech_code.Blog.domain.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    @Mapping(target = "author", source = "author")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "tags", source = "tags")
    PostDto toDto(Post post);

    CreatePostRequest toCreatePostRequest(CreatePostRequestDto dto);
}

package com.amos_tech_code.Blog.mappers;

import com.amos_tech_code.Blog.domain.PostStatus;
import com.amos_tech_code.Blog.domain.dtos.TagDto;
import com.amos_tech_code.Blog.domain.entities.Post;
import com.amos_tech_code.Blog.domain.entities.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TagMapper {

    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    TagDto toTagResponse(Tag tag);

    @Named("calculatePostCount")
    default Integer calculatePostCount(Set<Post> posts) {
        if (posts == null) {
            return 0;
        }
        return (int) posts.stream()
                .filter( post -> PostStatus.PUBLISHED.equals(post.getStatus()))
                .count();
    }
}

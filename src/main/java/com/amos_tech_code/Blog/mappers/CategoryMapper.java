package com.amos_tech_code.Blog.mappers;

import com.amos_tech_code.Blog.domain.PostStatus;
import com.amos_tech_code.Blog.domain.dtos.CategoryDto;
import com.amos_tech_code.Blog.domain.dtos.CreateCategoryRequest;
import com.amos_tech_code.Blog.domain.entities.Category;
import com.amos_tech_code.Blog.domain.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    CategoryDto toDto(Category category);

    Category toEntity(CreateCategoryRequest createCategoryRequest);

    @Named("calculatePostCount")
    default long calculatePostCount(List<Post> posts) {
        if (null == posts) {
            return 0;
        }
        return posts.stream()
                .filter( post -> PostStatus.PUBLISHED.equals(post.getStatus()))
                .count();
    }
}

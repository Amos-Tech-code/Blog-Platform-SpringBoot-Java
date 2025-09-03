package com.amos_tech_code.Blog.repositories;

import com.amos_tech_code.Blog.domain.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TagRepository extends JpaRepository<Tag, UUID> {
}

package org.example1.springbootdeveloper1.repository;

import org.example1.springbootdeveloper1.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}

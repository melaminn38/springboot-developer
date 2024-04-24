package org.example1.springbootdeveloper1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example1.springbootdeveloper1.domain.Article;

@NoArgsConstructor//기본생성자 추가
@AllArgsConstructor//모든 필드값을 파라미터로 받는 생성자추가
@Getter
public class AddArticleRequest {
    private String title;

    private String content;

    public Article toEntity(String author) {
        return Article.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}

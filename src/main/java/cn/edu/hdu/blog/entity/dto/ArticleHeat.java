package cn.edu.hdu.blog.entity.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class ArticleHeat {
    @Id
    private Integer articleId;
    @Column(columnDefinition = "bigint default 1")
    private Long hits;
    @Column(columnDefinition = "bigint default 0")
    private Long comments;

    public ArticleHeat() {
    }

    public ArticleHeat( Integer articleId, Long hits, Long comments) {
        this.articleId = articleId;
        this.hits = hits;
        this.comments = comments;
    }


    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Long getHits() {
        return hits;
    }

    public void setHits(Long hits) {
        this.hits = hits;
    }

    public Long getComments() {
        return comments;
    }

    public void setComments(Long comments) {
        this.comments = comments;
    }
}

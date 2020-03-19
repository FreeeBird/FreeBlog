package cn.edu.hdu.blog.entity.dto;


import cn.edu.hdu.blog.entity.enums.ArticleStatus;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;



public class Article {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String thumbnailUrl;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private Integer categoryId;
    @Column
    private Integer status;
    @Column
    private Integer hits = 0;
    @Column
    private Integer comments = 0;
    @Column(updatable = false)
    @CreatedDate
    private Date createTime;
    @Column
    @LastModifiedDate
    private Date updateTime;

    public Article() {
    }

    public Article(String thumbnailUrl, String title, String content, Integer categoryId, Integer status) {
        this.thumbnailUrl = thumbnailUrl;
        this.title = title;
        this.content = content;
        this.categoryId = categoryId;
        this.status = status;
    }

    public Article(String thumbnailUrl, String title, String content, Integer categoryId, Integer status, Integer hits, Integer comments, Date createTime, Date updateTime) {
        this.thumbnailUrl = thumbnailUrl;
        this.title = title;
        this.content = content;
        this.categoryId = categoryId;
        this.status = status;
        this.hits = hits;
        this.comments = comments;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

package cn.edu.hdu.blog.entity.vo;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

public class ArticleDetailVo {

    private Integer id;
    private String thumbnailUrl;
    private String title;
    private String summary;
    private String content;
    private Integer categoryId;
    private String category;
    private Integer status;// 0-公开 1-草稿
    private Integer type;// 0-普通 1-Markdown格式
    private Long hits;
    private Long comments;
    private Date createTime;
    private Date updateTime;

    public ArticleDetailVo() {
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public ArticleDetailVo(Integer id, String thumbnailUrl, String title, String summary, String content, Integer categoryId, String category, Integer status, Integer type, Long hits, Long comments, Date createTime, Date updateTime) {
        this.id = id;
        this.thumbnailUrl = thumbnailUrl;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.categoryId = categoryId;
        this.category = category;
        this.status = status;
        this.type = type;
        this.hits = hits;
        this.comments = comments;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ArticleDetailVo{" +
                "id=" + id +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", categoryId=" + categoryId +
                ", category='" + category + '\'' +
                ", status=" + status +
                ", type=" + type +
                ", hits=" + hits +
                ", comments=" + comments +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

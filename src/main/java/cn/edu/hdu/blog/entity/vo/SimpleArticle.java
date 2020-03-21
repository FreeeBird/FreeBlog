package cn.edu.hdu.blog.entity.vo;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;


public class SimpleArticle implements Serializable {

    private Integer id;
    private String title;
    private String thumbnailUrl;
    private Integer categoryId;
    private String category;
    private Integer status;
    private Integer hits;
    private Integer comments;
    private Date createTime;
    private Date updateTime;

    public SimpleArticle() {
    }

    public SimpleArticle(Integer id, String title, String thumbnailUrl, Integer categoryId, String category, Integer status, Integer hits, Integer comments, Date createTime, Date updateTime) {
        this.id = id;
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
        this.categoryId = categoryId;
        this.category = category;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
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

    @Override
    public String toString() {
        return "SimpleArticle{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", categoryId=" + categoryId +
                ", category='" + category + '\'' +
                ", status=" + status +
                ", hits=" + hits +
                ", comments=" + comments +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

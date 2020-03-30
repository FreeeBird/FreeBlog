package cn.edu.hdu.blog.entity.vo;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;


public class ArticleWithCountVo implements Serializable {

    // ID
    private Integer id;
    // 标题
    private String title;
    // 摘要
    private String summary;
    // 封面图链接
    private String thumbnailUrl;
    // 分类ID
    private Integer categoryId;
    // 分类名称
    private String category;
    // 点击数
    private Long hits;
    // 评论数
    private Long comments;
    private Date createTime;
    private Date updateTime;

    public ArticleWithCountVo() {
    }

    public ArticleWithCountVo(Integer id, String thumbnailUrl, String title, String summary,
                              Integer categoryId, String category, Long hits, Long comments,
                              Date createTime, Date updateTime) {
        this.id = id;
        this.thumbnailUrl = thumbnailUrl;
        this.title = title;
        this.summary = summary;
        this.categoryId = categoryId;
        this.category = category;
        this.hits = hits;
        this.comments = comments;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ArticleWithCountVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", categoryId=" + categoryId +
                ", category='" + category + '\'' +
                ", hits=" + hits +
                ", comments=" + comments +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
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
}

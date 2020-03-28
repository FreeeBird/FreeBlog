package cn.edu.hdu.blog.entity.vo;

import java.io.Serializable;
import java.util.Date;


public class ArticleVo implements Serializable {

    private Integer id;
    private String thumbnailUrl;
    private String title;
    private String summary;
    private Integer categoryId;
    private String category;
    private Date createTime;
    private Date updateTime;

    public ArticleVo() {
    }

    public ArticleVo(Integer id, String thumbnailUrl, String title, String summary, Integer categoryId, String category, Date createTime, Date updateTime) {
        this.id = id;
        this.thumbnailUrl = thumbnailUrl;
        this.title = title;
        this.summary = summary;
        this.categoryId = categoryId;
        this.category = category;
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

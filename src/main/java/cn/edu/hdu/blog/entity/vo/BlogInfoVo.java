package cn.edu.hdu.blog.entity.vo;

import javax.persistence.Column;

public class BlogInfoVo {

    private String title;
    private String keywords;
    private String description;

    public BlogInfoVo() {
    }

    public BlogInfoVo(String title, String keywords, String description) {
        this.title = title;
        this.keywords = keywords;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BlogInfoVo{" +
                "title='" + title + '\'' +
                ", keywords='" + keywords + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

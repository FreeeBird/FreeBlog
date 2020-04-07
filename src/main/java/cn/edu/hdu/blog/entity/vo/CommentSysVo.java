package cn.edu.hdu.blog.entity.vo;

import cn.edu.hdu.blog.entity.dto.Comment;

import java.util.Date;

public class CommentSysVo extends Comment {
    private String articleTitle;

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public CommentSysVo(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public CommentSysVo(Integer id, Integer articleId, String articleTitle, String nickname, String email, String content, Integer parentId, Date createTime) {
        super(id, articleId, nickname, email, content, parentId, createTime);
        this.articleTitle = articleTitle;
    }
}

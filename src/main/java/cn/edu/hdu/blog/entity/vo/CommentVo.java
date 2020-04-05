package cn.edu.hdu.blog.entity.vo;

public class CommentVo {
    private Integer articleId;
    private String nickname;
    private String email;
    private String content;

    public CommentVo() {
    }

    public CommentVo(Integer articleId, String nickname, String email, String content) {
        this.articleId = articleId;
        this.nickname = nickname;
        this.email = email;
        this.content = content;
    }

    @Override
    public String toString() {
        return "CommentVo{" +
                "articleId=" + articleId +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

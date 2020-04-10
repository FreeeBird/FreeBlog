package cn.edu.hdu.blog.entity.vo;

import cn.edu.hdu.blog.entity.dto.Statistics;

public class StatisticsVo extends Statistics {

    private Long articleNum;
    private Long categoryNum;
    private Long commentNum;
    private Long messageNum;

    public StatisticsVo() {
    }

    public StatisticsVo(Long articleNum, Long categoryNum, Long commentNum, Long messageNum) {
        this.articleNum = articleNum;
        this.categoryNum = categoryNum;
        this.commentNum = commentNum;
        this.messageNum = messageNum;
    }

    public Long getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(Long articleNum) {
        this.articleNum = articleNum;
    }

    public Long getCategoryNum() {
        return categoryNum;
    }

    public void setCategoryNum(Long categoryNum) {
        this.categoryNum = categoryNum;
    }

    public Long getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Long commentNum) {
        this.commentNum = commentNum;
    }

    public Long getMessageNum() {
        return messageNum;
    }

    public void setMessageNum(Long messageNum) {
        this.messageNum = messageNum;
    }

    @Override
    public String toString() {
        return "StatisticsVo{" +
                "articleNum=" + articleNum +
                ", CategoryNum=" + categoryNum +
                ", commentNum=" + commentNum +
                ", messageNum=" + messageNum +
                '}';
    }
}

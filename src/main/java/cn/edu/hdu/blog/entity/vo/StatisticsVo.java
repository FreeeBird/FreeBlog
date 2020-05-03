package cn.edu.hdu.blog.entity.vo;

import cn.edu.hdu.blog.entity.dto.Statistics;

public class StatisticsVo extends Statistics {

    private Integer articleNum;
    private Integer categoryNum;
    private Integer commentNum;
    private Integer messageNum;
    private Integer dayVisit;
    private Integer dayHits;

    public StatisticsVo() {
    }

    public StatisticsVo(Integer articleNum, Integer categoryNum, Integer commentNum, Integer messageNum) {
        this.articleNum = articleNum;
        this.categoryNum = categoryNum;
        this.commentNum = commentNum;
        this.messageNum = messageNum;
    }

    public Integer getDayVisit() {
        return dayVisit;
    }

    public void setDayVisit(Integer dayVisit) {
        this.dayVisit = dayVisit;
    }

    public Integer getDayHits() {
        return dayHits;
    }

    public void setDayHits(Integer dayHits) {
        this.dayHits = dayHits;
    }

    public Integer getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(Integer articleNum) {
        this.articleNum = articleNum;
    }

    public Integer getCategoryNum() {
        return categoryNum;
    }

    public void setCategoryNum(Integer categoryNum) {
        this.categoryNum = categoryNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getMessageNum() {
        return messageNum;
    }

    public void setMessageNum(Integer messageNum) {
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

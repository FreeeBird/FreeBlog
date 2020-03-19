package cn.edu.hdu.blog.entity.enums;


/**
 * 文章状态类型
 */
public enum ArticleStatus {
    PUBLIC(0,"公开"),
    DRAFT(1,"草稿"),
    PRIVATE(2,"私密")
    ;

    private Integer code;
    private String status;

    ArticleStatus() {
    }

    ArticleStatus(Integer code, String status) {
        this.code = code;
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

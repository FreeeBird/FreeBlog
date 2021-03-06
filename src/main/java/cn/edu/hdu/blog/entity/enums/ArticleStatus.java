package cn.edu.hdu.blog.entity.enums;


/**
 * 文章状态
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


    public String getStatus() {
        return status;
    }

}

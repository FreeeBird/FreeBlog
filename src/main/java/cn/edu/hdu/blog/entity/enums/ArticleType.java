package cn.edu.hdu.blog.entity.enums;


/**
 * 文章类型
 */
public enum ArticleType {
    TEXT(0,"普通文本"),
    MARKDOWN(1,"Markdown文本")
    ;

    private Integer code;
    private String type;

    ArticleType() {
    }

    ArticleType(Integer code, String status) {
        this.code = code;
        this.type = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return type;
    }

    public void setStatus(String status) {
        this.type = status;
    }
}

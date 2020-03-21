package cn.edu.hdu.blog.response;


/**
 * 消息类型描述
 */
public enum MsgType {
    SUCCESS(2000,"SUCCESS"),
    FAILED(3000,"FAILURE"),

    PARAM_IS_INVALID(3100,"PARAM_IS_INVALID"),
    PERMISSION_DENIED(3200,"PERMISSION_DENIED"),
    NOT_LOGIN(3300,"NOT LOGIN"),

    PAGE_PARAM_IS_INVALID(3400,"PAGE_PARAM_IS_INVALID");

    ;
    private Integer code;
    private String message;
    MsgType() {}
    MsgType(Integer code) {
        this.code = code;
    }
    MsgType(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}

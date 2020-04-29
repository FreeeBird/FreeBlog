package cn.edu.hdu.blog.response;


/**
 * 消息类型描述
 */
public enum MsgType {
    SUCCESS(2000,"成功"),
    FAILED(3000,"失败"),

    PARAM_IS_INVALID(3100,"参数错误"),
    PAGE_PARAM_IS_INVALID(3101,"分页参数不正确"),
    EMAIL_IS_EMPTY(3102,"邮箱为空"),
    NICKNAME_IS_EMPTY(3103,"昵称为空"),

    ARTICLE_IS_NOT_FOUND(3110,"文章不存在"),

    PERMISSION_DENIED(3200,"权限不允许"),
    NOT_LOGIN(3300,"没有登录"),
    LOGIN_FAILED(3400,"用户名或密码不对"),
    LOGIN_USERNAME_IS_NULL(3401,"用户名不能为空"),
    LOGIN_PASS_IS_NULL(3402,"密码不能为空"),


    SYSTEM_DATA_ERROR(5100,"系统数据错误"),
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
    public String getMessage() {
        return message;
    }

}

package cn.edu.hdu.blog.entity.vo;


public class BloggerSysVo {

    private String username;
    private String nickname;
    private String email;
    private String address;
    private String introduction;
    private String portraitUrl;

    public BloggerSysVo() {
    }

    public BloggerSysVo(String username, String nickname, String email, String address, String introduction, String portraitUrl) {
        this.username = username;
        this.nickname = nickname;
        this.email = email;
        this.address = address;
        this.introduction = introduction;
        this.portraitUrl = portraitUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BloggerSysVo(String nickname, String email, String address, String introduction, String portraitUrl) {
        this.nickname = nickname;
        this.email = email;
        this.address = address;
        this.introduction = introduction;
        this.portraitUrl = portraitUrl;
    }

    @Override
    public String toString() {
        return "BloggerVo{" +
                "nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", introduction='" + introduction + '\'' +
                ", portraitUrl='" + portraitUrl + '\'' +
                '}';
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPortraitUrl() {
        return portraitUrl;
    }

    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl;
    }
}

package cn.edu.hdu.blog.entity.vo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BloggerVo {
    private String nickname;
    private String email;
    private String address;
    private String introduction;
    private String portraitUrl;

    public BloggerVo() {
    }

    public BloggerVo(String nickname, String email, String address, String introduction, String portraitUrl) {
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

package cn.edu.hdu.blog.entity.enums;

public enum BlogKey {
    BLOG_TOKEN("blogToken"),

    BLOGGER("bloggerInfo"),
    BLOG_INFO("blogInfo"),

    BLOG_STATISTICS("blogStatistics"),
    ARTICLE_NUM("articleNum"),
    CATEGORY_NUM("CategoryNum"),
    COMMENT_NUM("CommentNum"),
    MESSAGE_NUM("messageNum"),
    VISIT_NUM("visitNum"),
    HITS("hits"),
    DAY_VISIT("dayVisit"),
    DAY_HITS("dayHits"),

    ARTICLE("article"),

    ;

    private String key;


    BlogKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}

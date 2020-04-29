package cn.edu.hdu.blog.utils;

import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;

import java.util.Arrays;

public class Markdown2HtmlUtils {

    public static String markdown2Html(String content){
        String html = parse(content);
        return html;
    }

    public static String parse(String content){
        MutableDataSet options = new MutableDataSet();
        options.setFrom(ParserEmulationProfile.MARKDOWN);
        //enable table parse
        options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create()));
        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();
        Node doc = parser.parse(content);
        return renderer.render(doc);
    }

    public static void main(String[] args) {
        String s = "# 引子\n" +
                "有个知友邀请我回答问题，问道：([MySQL 每次查询一条数据查 10 次和一次查询 10 条数据效率有多少差距？](https://www.zhihu.com/question/28422374)))\n" +
                "\n" +
                "总体上来说，一次查询 10 条数据效率是高于每次查询一条数据查 10 次的。但究竟差距多少，具体的数据很难说。这本来是一个很简单的问题，但我还是想亲身实践下，给以后碰到这个问题的朋友一点参考。我先做一个模拟，然后在文末给出一个分析。\n" +
                "\n" +
                "# 模拟\n" +
                "在做模拟之前，得有数据。所以我创建了一组测试数据，如下：\n" +
                "```\n" +
                "mysql> USE test;\n" +
                "Database changed\n" +
                "\n" +
                "mysql> CREATE TABLE user\n" +
                "    -> (id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                "    -> name VARCHAR(20),\n" +
                "    -> age INT,\n" +
                "    -> sex CHAR(2),\n" +
                "    -> city VARCHAR(20),\n" +
                "    -> work VARCHAR(10)\n" +
                "    -> ) DEFAULT CHARSET utf8 ENGINE = INNODB;\n" +
                "Query OK, 0 rows affected (0.10 sec)\n" +
                "\n" +
                "mysql> INSERT INTO user(name, age, sex, city, work) \\\n" +
                "    -> VALUES(\"robin01\",19,\"M\",\"GuangZhou\",\"DBA\"),\\\n" +
                "    -> (\"robin02\",19,\"M\",\"GuangZhou\",\"DBA\"),\\\n" +
                "    -> (\"robin03\",19,\"M\",\"GuangZhou\",\"DBA\"),\\\n" +
                "    -> (\"robin04\",19,\"M\",\"GuangZhou\",\"DBA\"),\\\n" +
                "    -> (\"robin05\",19,\"M\",\"GuangZhou\",\"DBA\"),\\\n" +
                "    -> (\"robin06\",19,\"M\",\"GuangZhou\",\"DBA\"),\\\n" +
                "    -> (\"robin07\",19,\"M\",\"GuangZhou\",\"DBA\"),\\\n" +
                "    -> (\"robin08\",19,\"M\",\"GuangZhou\",\"DBA\"),\\\n" +
                "    -> (\"robin09\",19,\"M\",\"GuangZhou\",\"DBA\"),\\\n" +
                "    -> (\"robin10\",19,\"M\",\"GuangZhou\",\"DBA\"),\\\n" +
                "    -> (\"robin11\",19,\"M\",\"GuangZhou\",\"DBA\"),\\\n" +
                "    -> (\"robin12\",19,\"M\",\"GuangZhou\",\"DBA\"),\\\n" +
                "    -> (\"robin13\",19,\"M\",\"GuangZhou\",\"DBA\"),\\\n" +
                "    -> (\"robin14\",19,\"M\",\"GuangZhou\",\"DBA\"),\\\n" +
                "    -> (\"robin15\",19,\"M\",\"GuangZhou\",\"DBA\");\n" +
                "Query OK, 15 rows affected (0.03 sec)\n" +
                "Records: 15  Duplicates: 0  Warnings: 0\n" +
                "```\n" +
                "接着，为了模拟一条数据查询十次，我写了一个存储过程。这个存储过程也很简单，如下：\n" +
                "\n" +
                "**说明：这里的模拟如果这样会更好：不用循环，写十条 SQL，ID 不同。查询相同的数据会受查询缓存的影响，多少有些偏差。数据少，差别不是太大，所以这里还是这样模拟了**";
        System.out.println(markdown2Html(s));

    }
}

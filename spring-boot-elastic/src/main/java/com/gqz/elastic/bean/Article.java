package com.gqz.elastic.bean;

import io.searchbox.annotations.JestId;

/**
 * @ClassName Article
 * @Description
 * @Author ganquanzhong
 * @Date2019/10/23 23:30
 * @Version
 **/
public class Article {

    //设置id为es文档的id
    @JestId
    private Integer id;
    private String author;
    private String title;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

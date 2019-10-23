package com.gqz.elastic.bean;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @ClassName Book
 * @Description
 * @Author ganquanzhong
 * @Date2019/10/24 0:31
 * @Version
 **/

//该注解表明Book类存在那个索引index（数据库），那个类型下面（表）
@Document(indexName = "gqz",type = "book")
public class Book {

    private Integer id;
    private String bookName;
    private String Author;

    public Book() {
    }

    public Book(Integer id, String bookName, String author) {
        this.id = id;
        this.bookName = bookName;
        Author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", Author='" + Author + '\'' +
                '}';
    }
}

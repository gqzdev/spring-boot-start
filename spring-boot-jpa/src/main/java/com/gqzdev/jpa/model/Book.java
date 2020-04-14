package com.gqzdev.jpa.model;

import javax.persistence.*;

/**
 * @ClassName: Book
 * @author: ganquanzhong
 * @date: 2020/4/14 16:42
 */

@Entity(name = "t_book")
public class Book {

    //主键ID  及生成策略 strategy
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "book_name",nullable = false)
    private String name;

    private String author;

    private Float price;

//    不参与生成
    @Transient
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

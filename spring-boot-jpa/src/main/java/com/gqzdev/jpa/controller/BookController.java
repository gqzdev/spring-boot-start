package com.gqzdev.jpa.controller;

import com.gqzdev.jpa.model.Book;
import com.gqzdev.jpa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: BookController
 * @author: ganquanzhong
 * @date: 2020/4/14 17:17
 */

@RestController
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/findAll")
    public Page<Book> findAll(){
        PageRequest pageable = PageRequest.of(2, 3);
        Page<Book> page = bookService.getBookByPage(pageable);
        System.out.println("总页数："+page.getTotalPages());
        System.out.println("总记录数："+page.getTotalElements());
        System.out.println("查询结果："+page.getContent());

        System.out.println("当前页数:"+(page.getNumber()+1));
        System.out.println("当前页记录数:"+page.getNumberOfElements());
        System.out.println("每页记录数:"+page.getSize());
        return page;
    }

    @GetMapping("/search")
    public List<Book> search(String author){
        List<Book> books = bookService.getBooksByAuthorStartingWith(author);
        return books;
    }

    @GetMapping("/add")
    public void add(Book book){
        bookService.addBook(book);
    }
}

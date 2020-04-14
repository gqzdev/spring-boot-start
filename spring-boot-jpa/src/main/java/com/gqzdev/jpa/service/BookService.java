package com.gqzdev.jpa.service;

import com.gqzdev.jpa.dao.BookDao;
import com.gqzdev.jpa.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: BookService
 * @author: ganquanzhong
 * @date: 2020/4/14 17:01
 */

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;


    public void addBook(Book book){
        bookDao.save(book);
    }

    public Page<Book> getBookByPage(Pageable pageable){
        return bookDao.findAll(pageable);
    }

    public List<Book> getBooksByAuthorStartingWith(String author){
        return bookDao.getBooksByAuthorStartingWith(author);
    }

    public List<Book> getBooksByPriceGreaterThan(Float price){
        return bookDao.getBooksByPriceGreaterThan(price);
    }

    public Book getMaxIdBook(){
        return bookDao.getMaxIdBook();
    }

    public List<Book> getBookByIdAndAuthor(String author , Integer id){
        return bookDao.getBookByIdAndAuthor(author,id);
    }

    public List<Book> getBookByIdAndName(String name,Integer id){
        return bookDao.getBooksByIdAndName(name,id);
    }

}

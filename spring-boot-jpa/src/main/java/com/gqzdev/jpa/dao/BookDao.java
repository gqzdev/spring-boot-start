package com.gqzdev.jpa.dao;

import com.gqzdev.jpa.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @ClassName: BookDao
 * @author: ganquanzhong
 * @date: 2020/4/14 16:49
 */
public interface BookDao extends JpaRepository<Book,Integer> {
    List<Book> getBooksByAuthorStartingWith(String author);

    List<Book> getBooksByPriceGreaterThan(Float price);

    @Query(value = "select * from t_book where id=(select max(id) from t_book)",nativeQuery = true)
    Book getMaxIdBook();

    //用：id、：name这种方式来进行参数绑定
    @Query("select b from t_book b where b.id>:id and b.author=:author")
    List<Book> getBookByIdAndAuthor(@Param("author") String author,Integer id);

    //    参方式使用？1、?2这种方式
    @Query("select b from t_book b where b.id<?2 and b.name like %?1%")
    List<Book> getBooksByIdAndName(String name, Integer id);
}


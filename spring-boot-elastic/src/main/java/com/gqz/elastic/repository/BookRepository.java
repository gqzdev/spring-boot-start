package com.gqz.elastic.repository;

import com.gqz.elastic.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @ClassName BookRepository
 * @Description
 * @Author ganquanzhong
 * @Date2019/10/24 0:30
 * @Version
 **/
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
}

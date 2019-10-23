package com.gqz.elastic;

import com.gqz.elastic.bean.Article;
import com.gqz.elastic.bean.Book;
import com.gqz.elastic.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.DocumentResult;

import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class SpringBootElasticApplicationTests {

    @Autowired
    JestClient jestClient;

    @Autowired
    BookRepository bookRepository;

    @Test
    void contextLoads() {
    }

   /* 测试通过Jest client操作
            添加索引（保存数据）
    */
   //1.给ES中索引一个文档（保存）
    @Test
    public void addIndexByJestClient(){

        Article article = new Article();
        article.setId(1);
        article.setAuthor("gqzdev");
        article.setTitle("测试通过Jest Client索引一个文档id为1");
        article.setContent("Hello World  this is add index by jest client");
        //构建一个索引
        Index index = new Index.Builder(article).index("gqz").type("news").build();

        //执行
        try {
            DocumentResult execute = jestClient.execute(index);
            System.out.println(execute.getIndex()+"  "+execute.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //测试搜索
    @Test
    public void searchByJest(){

        //查询表达式
        String json = "{\n" +
                "       \"query\":{\n" +
                "            \"match\":{\n" +
                "                \"content\":\"hello\"\n" +
                "         }\n" +
                "      }\n" +
                "}";

        //构建搜索功能
        Search search = new Search.Builder(json).addIndex("gqz").addType("news").build();

        //执行
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /* 测试通过SpringData ElasticSearch操作
            添加索引（保存数据）
    */
    @Test
    public void addIndexByES(){
        //构建文档数据
        Book book = new Book(101, "Spring Boot入门到精通", "甘全中");
        bookRepository.index(book);

    }
}

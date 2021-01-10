package com.elastic;

import com.elastic.pojo.Article;
import com.elastic.pojo.Book;
import com.elastic.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ElasticApplicationTests {

    @Autowired
    private JestClient jestClient;

    @Autowired
    BookRepository bookRepository;

    @Test
    void testRepository() {
//        bookRepository.index(new Book(1,"sdfsdf"));
//        System.out.println(bookRepository.findByAuthorLike("a"));
    }


    @Test
    void contextLoads() {

        Article article = new Article(3,"qqq","wwww","cccc");

        //构建索引（保存）
        Index build = new Index.Builder(article).index("book").type("news").build();

        try {
            jestClient.execute(build);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    void search() {
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"constant_score\" : {\n" +
                "            \"filter\" : {\n" +
                "                \"term\" : {\n" +
                "                    \"content\" : \"cccc\"\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Search build = new Search.Builder(json).addIndex("book").addType("news").build();

        try {
            SearchResult result = jestClient.execute(build);
            System.out.println(result.getJsonObject());
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}

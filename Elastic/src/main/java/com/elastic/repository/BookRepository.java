package com.elastic.repository;

import com.elastic.pojo.Book;
//import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author lijichen
 * @date 2021/1/9 - 20:11
 */
public interface BookRepository /*extends ElasticsearchRepository<Book,Integer>*/ {

    public List<Book> findByAuthorLike(String author);
}

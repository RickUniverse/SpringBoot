package com.elastic.pojo;


/**
 * @author lijichen
 * @date 2021/1/9 - 20:09
 */
public class Book {

    private int id;
    private String author;

    public Book() {
    }

    public Book(int id, String author) {
        this.id = id;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public Book setId(int id) {
        this.id = id;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                '}';
    }
}

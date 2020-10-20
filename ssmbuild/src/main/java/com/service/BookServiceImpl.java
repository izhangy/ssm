package com.service;

import com.dao.BookMapper;
import com.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService{

    //调用dao层的操作，设置一个set接口
    private BookMapper bookMapper;

    public BookServiceImpl() {
    }

    public BookServiceImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public BookMapper getBookMapper() {
        return bookMapper;
    }

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public String toString() {
        return "BookServiceImpl{" +
                "bookMapper=" + bookMapper +
                '}';
    }

    @Override
    public int addBook(Books book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteById(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBooks(books);
    }

    @Override
    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }
}

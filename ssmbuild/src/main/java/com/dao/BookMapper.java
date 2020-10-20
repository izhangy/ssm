package com.dao;

import com.pojo.Books;

import java.util.List;

public interface BookMapper {

    //增加一本书
    int addBook(Books books);

    //根据id删除一本书
    int deleteById(int id);

    //修改一本书的信息
    int updateBooks(Books books);

    //根据id查询一本书
    Books queryBookById(int id);

    //查询数据库中所有的书目
    List<Books> queryAllBook();

}

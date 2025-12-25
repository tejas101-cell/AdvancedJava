package com.example.Question1.DAO;

import com.example.Question1.Entities.Book;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface BookDAO {
    public List<Book> getBooks();
    public void addBook(Book book);
    public Book getBook(Integer id);
    public void updateBook(Book book);
    public void deleteBook(Integer id);
    public List<Book> getBookByauthor(String author);
    public List<Book> getBookByDate(LocalDate date);
}

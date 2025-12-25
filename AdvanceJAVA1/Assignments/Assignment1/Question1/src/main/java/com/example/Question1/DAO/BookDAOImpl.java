package com.example.Question1.DAO;

import com.example.Question1.Entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO{
    EntityManager entityManager;

    @Autowired
    public BookDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Book> getBooks() {
        TypedQuery<Book> query = entityManager.createQuery("From Book", Book.class);
        List<Book> books = query.getResultList();
        return books;
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        entityManager.persist(book);
    }

    @Override
    @Transactional
    public Book getBook(Integer id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        entityManager.merge(book);
    }

    @Override
    @Transactional
    public void deleteBook(Integer id) {
        Book book = entityManager.find(Book.class, id);
        entityManager.remove(book);
    }

    @Override
    @Transactional
    public List<Book> getBookByauthor(String author) {
        // find method is only there to find the row based on the primary key
        TypedQuery<Book> query = entityManager.createQuery("From Book where author=:author_name", Book.class);
        query.setParameter("author_name", author);
        List<Book> books = query.getResultList();
        return books;
    }

    @Override
    @Transactional
    public List<Book> getBookByDate(LocalDate date) {
        // sql cannot read the normal date
        // therefore use Date (java.sql) to convert normal date format into sql format
        Date convertedDate = java.sql.Date.valueOf(date);
        TypedQuery<Book> query = entityManager.createQuery("From Book where publishedDate >:date", Book.class);
        query.setParameter("date", convertedDate);
        List<Book> books = query.getResultList();
        return books;
    }

}

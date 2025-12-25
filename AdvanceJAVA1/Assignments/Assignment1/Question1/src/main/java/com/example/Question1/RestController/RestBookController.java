package com.example.Question1.RestController;

import com.example.Question1.DAO.BookDAO;
import com.example.Question1.DAO.BookDAOImpl;
import com.example.Question1.Entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestBookController {

    BookDAO bookDAO;

    @Autowired
    public RestBookController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookDAO.getBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookByID(@PathVariable("id")Integer bid){
        return bookDAO.getBook(bid);
    }

    @PutMapping("/books")
    public String updatedBook(@RequestBody Book book){
        bookDAO.updateBook(book);
        return "Updated successfully";
    }

    @DeleteMapping("/books/{id}")
    public String deletedBook(@PathVariable("id") Integer bid){
        bookDAO.deleteBook(bid);
        return "Deleted Successfully";
    }
    @GetMapping("/booksByAuthor")
    public List<Book> getBookByAuthor(@RequestBody String author){
        List<Book> books = bookDAO.getBookByauthor(author);
        return books;
    }
    @PostMapping("/books")
    public String addedBook(@RequestBody Book book){
        bookDAO.addBook(book);
        return "Added Successfully";
    }
    @GetMapping("/booksByDate")
    public List<Book> gotBookByDate(@RequestBody String year){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(year, formatter);
        System.out.println(date);
        List<Book> books = bookDAO.getBookByDate(date);
        System.out.println(books);
        return books;
    }
}

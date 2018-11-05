package com.spring.demo.springdemo.controller;


import com.spring.demo.springdemo.model.Author;
import com.spring.demo.springdemo.model.Book;
import com.spring.demo.springdemo.model.Category;
import com.spring.demo.springdemo.repository.AuthorRepository;
import com.spring.demo.springdemo.repository.BookRepository;
import com.spring.demo.springdemo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class Controller {

    private BookRepository repo;
    private CategoryRepository repo2;
    private AuthorRepository repo3;

    @Autowired
    public Controller(BookRepository repo, CategoryRepository repo2, AuthorRepository repo3) {
        this.repo = repo;
        this.repo2 = repo2;
        this.repo3 = repo3;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(){
        return "SIEMANO";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "TEST";
    }

    @RequestMapping(value = "/api/books", method = RequestMethod.GET)
    public List<Book> books(){
        List<Book> books = repo.findAll();
        return books;
    }

    @RequestMapping(value = "/api/books", method = RequestMethod.POST)
    public Book addBook(@RequestBody Book book){
        repo.save(book);
        return book;
    }

    @RequestMapping(value = "/api/categories", method = RequestMethod.POST)
        public Category addCategory(@RequestBody Category category){
        repo2.save(category);
        return category;
    }

    @RequestMapping(value = "/api/categories", method = RequestMethod.GET)
    public List<Category> categories(){
        return repo2.findAll();
    }

    @RequestMapping(value = "/api/authors", method = RequestMethod.POST)
    public Author addAuthor(@RequestBody Author author){
        repo3.save(author);
        return author;
    }

    @RequestMapping(value = "/api/authors", method = RequestMethod.GET)
    public List<Author> authors(){
        return repo3.findAll();
    }
}

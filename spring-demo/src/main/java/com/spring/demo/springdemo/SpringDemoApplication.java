package com.spring.demo.springdemo;

import com.spring.demo.springdemo.model.Author;
import com.spring.demo.springdemo.model.Book;
import com.spring.demo.springdemo.model.Category;
import com.spring.demo.springdemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringDemoApplication implements CommandLineRunner {

	private BookRepository bookRepository;

	@Autowired
	public SpringDemoApplication(BookRepository bookRepository){
		this.bookRepository = bookRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Book book = new Book();
		Author author = new Author();
		author.setName("SuperImięAutora");
		author.setLastname("SuperNazwiskoAutora");
		Set<Author> as = new HashSet<>();
		as.add(author);
		Category category = new Category();
		category.setName("SuperKategoria");
		book.setTitle("SuperTytuł");
		book.setAuthors(as);
		book.setCategory(category);

		bookRepository.save(book);
	}
}

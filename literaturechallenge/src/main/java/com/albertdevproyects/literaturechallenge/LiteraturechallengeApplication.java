package com.albertdevproyects.literaturechallenge;

import com.albertdevproyects.literaturechallenge.main.Main;
import com.albertdevproyects.literaturechallenge.repository.AuthorRepository;
import com.albertdevproyects.literaturechallenge.repository.BookRepository;
import com.albertdevproyects.literaturechallenge.services.API;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
@SpringBootApplication
public class LiteraturechallengeApplication implements CommandLineRunner {
	@Autowired
	private BookRepository repository;
	@Autowired
	private AuthorRepository authorRepository;
	public static void main(String[] args) {
		SpringApplication.run(LiteraturechallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	Main main = new Main(authorRepository, repository);
	main.showMenu();
	}
}

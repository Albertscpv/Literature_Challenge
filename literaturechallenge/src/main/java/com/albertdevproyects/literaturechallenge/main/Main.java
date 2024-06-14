package com.albertdevproyects.literaturechallenge.main;

import com.albertdevproyects.literaturechallenge.models.*;
import com.albertdevproyects.literaturechallenge.repository.AuthorRepository;
import com.albertdevproyects.literaturechallenge.repository.BookRepository;
import com.albertdevproyects.literaturechallenge.services.API;
import com.albertdevproyects.literaturechallenge.services.ConvertData;
import org.springframework.boot.reactor.ReactorEnvironmentPostProcessor;

import java.util.List;
import java.util.Scanner;

public class Main {
        private Scanner input = new Scanner(System.in);
        private API apiQuery = new API();
        private ConvertData convertData = new ConvertData();
        private String url_base = "https://gutendex.com/books/";
        private List<BooksData> booksDataList;
        private BookRepository repository;
        private AuthorRepository authorRepository;
        private String menu = """
                -----------------Welcome to Literbry-----------------
                -----------------------------------------------------
                -----------------------Lobby-------------------------
                1. Search Books.
                2. Search Books by Author.
                3. Show searched books.
                4. Search Books by language.
                5. Exit.
                """;
        public Main(AuthorRepository authorRepository, BookRepository repository){
            this.authorRepository = authorRepository;
            this.repository = repository;
        }

        public void showMenu(){
            var option = -1;
            while(option != 5) {
                System.out.println(menu);
                try{
                option = Integer.parseInt(input.nextLine());
                    switch (option){
                        case 1: searchBook();
                                break;
                        case 2: searchBookByAuthor();
                                break;
                        case 3: showSearchedBooks();
                                break;
                        case 4: searchBooksByLanguage();
                                break;
                        case 5:
                            System.out.println("Thanks for use Literbry");
                            System.out.println("Closing the app :D");
                        default:
                            System.out.println("Unknown option");
                    }
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }

            }

        }

        public Data getDataBook(){
            System.out.println("Type a book to search: ");
            var book = input.nextLine();
            var json = apiQuery.getData(url_base + "?search=" + book.replaceAll(" ", "+"));
            Data bookInfo = convertData.convertDataClass(json, Data.class);
            System.out.println(bookInfo);
            return bookInfo;
        }
        private BooksData createBook(Books books, AuthorsData authorsData){
            BooksData booksData = new BooksData(books);
            return repository.save(booksData);
        }
        private void searchBook(){
            Data data = getDataBook();

            if(!data.results().isEmpty()){
                Books books = data.results().get(0);
                Authors authors = books.authorsData().get(0);
                BooksData booksDataDB = repository.findByTitle(books.title());
                if (booksDataDB == null){
                    AuthorsData authorsData = new AuthorsData(authors);
                    BooksData booksData = createBook(books, authorsData);
                    System.out.println(booksData);
                }else{
                    AuthorsData authorsDataDB = authorRepository.findByName(authors.name());
                    if(authorsDataDB == null){
                        AuthorsData authorsData = new AuthorsData(authors);
                        authorRepository.save(authorsData);
                        BooksData booksData = createBook(books, authorsData);
                        System.out.println(booksData);
                    }else{
                        BooksData booksData = createBook(books, authorsDataDB);
                        System.out.println(booksData);
                    }
                }
            }
        }
    private void showSearchedBooks(){
            booksDataList = repository.findAll();
            booksDataList.forEach(System.out::println);
    }
    private void searchBookByAuthor(){
        System.out.println("Working in it");
    }
    private void searchBooksByLanguage(){
        System.out.println("Type a language to search: ");
        System.out.println("Search by encoded language: en, es, pt");
        var language = input.nextLine();

        if (language.equals("es")){
            List<BooksData> booksByLanguage = repository.findByLanguages(language);
            booksByLanguage.forEach(System.out::println);
        }if (language.equals("en")){
            List<BooksData> booksByLanguage = repository.findByLanguages(language);
            booksByLanguage.forEach(System.out::println);
        }if(language.equals("pt")){
            List<BooksData> booksByLanguage = repository.findByLanguages(language);
            booksByLanguage.forEach(System.out::println);
        }else{
            System.out.println("Language not found");
        }

    }
}

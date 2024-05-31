package com.albertdevproyects.literaturechallenge.main;

import com.albertdevproyects.literaturechallenge.models.AuthorsData;
import com.albertdevproyects.literaturechallenge.models.Books;
import com.albertdevproyects.literaturechallenge.models.BooksData;
import com.albertdevproyects.literaturechallenge.models.Data;
import com.albertdevproyects.literaturechallenge.repository.BookRepository;
import com.albertdevproyects.literaturechallenge.services.API;
import com.albertdevproyects.literaturechallenge.services.ConvertData;

import java.util.Scanner;

public class Main {
        private Scanner input = new Scanner(System.in);
        private API apiQuery = new API();
        private ConvertData convertData = new ConvertData();
        private String url_base = "https://gutendex.com/books/";

        private String menu = """
                -----------------Welcome to literbry-----------------
                -----------------------------------------------------
                -----------------------Lobby-------------------------
                1. Search Books.
                2. Search Books by Author.
                3. Show searched books.
                4. Search Books by language.
                5. Exit.
                """;

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
                        case 4: SearchBooksByLanguage();
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

        public Data searchBook(){
            System.out.println("Type a book to search: ");
            var book = input.nextLine();
            var json = apiQuery.getData(url_base + "?search=" + book.replaceAll("", "+"));
            System.out.println(json);
            Data data = convertData.convertDataClass(json, Data.class);

            return data;
        }
        private BooksData createBook(Books books, AuthorsData authorsData){
            BooksData booksData = new BooksData(books);
            return BookRepository.save(booksData);
        }

}

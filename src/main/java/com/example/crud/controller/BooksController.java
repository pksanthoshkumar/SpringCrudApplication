package com.example.crud.controller;

import com.example.crud.domain.Books;
import com.example.crud.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/books")
public class BooksController {

    @Autowired
    BookRepo repo;

    @GetMapping ("/get")
    public ResponseEntity<List<Books>> getBooks () {
        List <Books> books = repo.findAll();
        if (books.isEmpty()) books = new ArrayList<>();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }


    @PostMapping ("/save")
    public ResponseEntity<Books> addBook (@RequestBody Books book) {
        try {
            book = repo.save(book);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(book, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping ("/update")
    public ResponseEntity<Books> updateBook (@RequestBody Books book) {
        try {
            Optional<Books> bookData = repo.findById(book.getId());

            if (bookData.isPresent()){
                Books newBook = bookData.get();
                newBook.setTitle(book.getTitle());
                newBook.setAuthor(book.getAuthor());
                book = repo.save(newBook);
            }
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity deleteBook (@PathVariable Long id) {
        Optional<Books> theBook = repo.findById(id);
        if (theBook.isPresent()) {
            repo.delete(theBook.get());

            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>("Could not delete the Book : " + id, HttpStatus.BAD_REQUEST);
    }
}

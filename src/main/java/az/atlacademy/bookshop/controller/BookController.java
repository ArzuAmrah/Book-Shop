package az.atlacademy.bookshop.controller;

import az.atlacademy.bookshop.entity.BookEntity;
import az.atlacademy.bookshop.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor

public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<BookEntity> getAllBooks(){
      return  bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookEntity getBookByID(@PathVariable Long id){
        return bookService.findBookById(id);
    }

    @PostMapping
    public BookEntity createBook(@RequestBody BookEntity book){
        return bookService.createBook(book);
    }

    @PutMapping("/{id}")
    public BookEntity updateBook(@PathVariable Long id, @RequestBody BookEntity bookDetails){
        return bookService.updateBook(id, bookDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}

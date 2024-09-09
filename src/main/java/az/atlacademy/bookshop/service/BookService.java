package az.atlacademy.bookshop.service;
import az.atlacademy.bookshop.entity.BookEntity;
import az.atlacademy.bookshop.exception.ResourceNotFoundException;
import az.atlacademy.bookshop.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

//    public BookService(BookRepository bookRepository){
//        this.bookRepository = bookRepository;
//    }

    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    public BookEntity findBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Kitab tapılmadı"));
    }

    public BookEntity createBook(BookEntity book) {
        return bookRepository.save(book);
    }

    public BookEntity updateBook(Long id, BookEntity bookDetails) {
        BookEntity book = findBookById(id);
        book.setName(bookDetails.getName());
        book.setCount(bookDetails.getCount());
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        BookEntity book = findBookById(id);
        bookRepository.delete(book);
    }

}


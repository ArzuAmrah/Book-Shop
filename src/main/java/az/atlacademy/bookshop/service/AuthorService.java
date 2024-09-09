package az.atlacademy.bookshop.service;
import az.atlacademy.bookshop.entity.AuthorEntity;
import az.atlacademy.bookshop.exception.ResourceNotFoundException;
import az.atlacademy.bookshop.repository.AuthorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional

public class AuthorService {

    private final AuthorRepository authorRepository;

//    public AuthorService (AuthorRepository authorRepository){
//        this.authorRepository = authorRepository;
//    }

    public List<AuthorEntity> getAllAuthors() {
        return authorRepository.findAll();
    }

    public AuthorEntity findAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author tapılmadı"));
    }

    public AuthorEntity createAuthor(AuthorEntity author) {
        return authorRepository.save(author);
    }

    public AuthorEntity updateAuthor(Long id, AuthorEntity authorDetails) {
        AuthorEntity author = findAuthorById(id);
        author.setName(authorDetails.getName());
        author.setSurname(authorDetails.getSurname());
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        AuthorEntity author = findAuthorById(id);
        authorRepository.delete(author);
    }

    public AuthorEntity saveAuthor(AuthorEntity author) {
        log.info("Saving author: {}", author.getName());
        return authorRepository.save(author);
    }

}

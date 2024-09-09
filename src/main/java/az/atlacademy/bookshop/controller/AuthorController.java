package az.atlacademy.bookshop.controller;


import az.atlacademy.bookshop.entity.AuthorEntity;
import az.atlacademy.bookshop.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public List<AuthorEntity> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public AuthorEntity getAuthorById(@PathVariable Long id) {
        return authorService.findAuthorById(id);
    }

    @PostMapping
    public AuthorEntity createAuthor(@RequestBody AuthorEntity author) {
        return authorService.createAuthor(author);
    }


    @PutMapping
    public AuthorEntity updateAuthor(@PathVariable Long id, @RequestBody AuthorEntity authorDetails) {
        return authorService.updateAuthor(id, authorDetails);
    }

    @DeleteMapping
    public ResponseEntity deleteAuthor(@PathVariable Long id){
          authorService.deleteAuthor(id);
          return ResponseEntity.ok().build();
    }
}

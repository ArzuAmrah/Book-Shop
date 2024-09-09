package az.atlacademy.bookshop.mapper;
import az.atlacademy.bookshop.dto.AuthorDTO;
import az.atlacademy.bookshop.entity.AuthorEntity;
import org.springframework.stereotype.Component;


@Component
public class AuthorMapper {

    public AuthorDTO toDTO(AuthorEntity author) {
        AuthorDTO dto = new AuthorDTO();
        dto.setId(author.getId());
        dto.setName(author.getName());
        dto.setSurname(author.getSurname());
        return dto;
    }

    public AuthorEntity toEntity(AuthorDTO dto) {
        AuthorEntity author = new AuthorEntity();
        author.setId(dto.getId());
        author.setName(dto.getName());
        author.setSurname(dto.getSurname());
        return author;
    }
}

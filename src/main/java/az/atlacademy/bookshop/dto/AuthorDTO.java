package az.atlacademy.bookshop.dto;

import lombok.Data;

@Data
public class AuthorDTO {
    private Long id;

//    @NotBlank(message = "Name is required")
    private String name;

//    @NotBlank(message = "Surname is required")
    private String surname;
}
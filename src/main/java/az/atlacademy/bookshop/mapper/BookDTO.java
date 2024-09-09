package az.atlacademy.bookshop.mapper;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookDTO {
    private Long id;

//    @NotBlank(message = "Book name is required")
    private String name;

//    @Min(value = 0, message = "Count must be greater than or equal to zero")
    private int count;
}

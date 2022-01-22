package desafio.desafio.requests;

import desafio.desafio.Models.Admin;
import desafio.desafio.Models.Category;
import desafio.desafio.Models.Provider;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ProductsPutRequestBody {
    private Long productId;
    @NotEmpty(message = "The admin need have a color")
    private String color;

    @NotNull
    @NotEmpty(message = "The admin need to be a name")
    private String name;

    private Date addDate;

    @NotNull
    @NotEmpty(message = "The admin need to be a price")
    private Float price;

    @NotNull
    @NotEmpty(message = "The admin need to be a admin")
    private Admin adminId;

    @NotNull
    @NotEmpty(message = "The admin need to be a category")
    private Category categoryId;

    @NotNull
    @NotEmpty(message = "The admin need to be a provider")
    private Provider providerId;
}

package desafio.desafio.requests;

import desafio.desafio.Models.Admin;
import desafio.desafio.Models.Category;
import desafio.desafio.Models.Provider;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class ProductsPostRequestBody<addDate> {

    @NotEmpty(message = "The admin need have a color")
    private String color;

    @NotEmpty(message = "The admin need to be a name")
    private String name;

    private Date addDate;

    @NotEmpty(message = "The admin need to be a price")
    private Float price;

    @NotEmpty(message = "The admin need to be a admin")
    private Admin adminId;

    @NotEmpty(message = "The admin need to be a category")
    private Category categoryId;

    @NotEmpty(message = "The admin need to be a provider")
    private Provider providerId;
}

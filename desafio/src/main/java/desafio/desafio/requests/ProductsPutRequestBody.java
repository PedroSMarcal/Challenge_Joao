package desafio.desafio.requests;

import desafio.desafio.Models.Admin;
import desafio.desafio.Models.Category;
import desafio.desafio.Models.Provider;
import lombok.Data;

import java.util.Date;

@Data
public class ProductsPutRequestBody {
    private Long productId;
    private String color;
    private String name;
    private Date addDate;
    private Float price;
    private Admin adminId;
    private Category categoryId;
    private Provider providerId;
}

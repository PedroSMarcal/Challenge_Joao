package desafio.desafio.requests;

import desafio.desafio.Models.Products;
import lombok.Data;

@Data
public class CarShopPostRequestBody {
    private Float totalValue;
    private Boolean pay;
    private Products products;
}

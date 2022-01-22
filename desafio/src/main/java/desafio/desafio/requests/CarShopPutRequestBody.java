package desafio.desafio.requests;

import desafio.desafio.Models.Products;
import lombok.Data;

@Data
public class CarShopPutRequestBody {
    private Long carShopId;
    private Float totalValue;
    private Boolean pay;
    private Products products;
}

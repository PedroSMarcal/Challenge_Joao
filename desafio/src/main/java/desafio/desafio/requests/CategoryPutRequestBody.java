package desafio.desafio.requests;

import lombok.Data;

@Data
public class CategoryPutRequestBody {
    private Long categoryId;
    private String name;
    private String Description;
}

package desafio.desafio.util;

import desafio.desafio.Models.Category;

public class CategoryCreator {
    public static Category createCategoryToBeSaved(){
        return Category.builder()
                .name("Bota")
                .Description("This is a category Test")
                .build();
    }

    public static Category createValidCategory(){
        return Category.builder()
                .name("Bota")
                .categoryId(1L)
                .Description("This is a category Test")
                .build();
    }

    public static Category createValidUpdatCategory(){
        return Category.builder()
                .categoryId(1L)
                .name("Tenis")
                .Description("This is a category Test")
                .build();
    }
}

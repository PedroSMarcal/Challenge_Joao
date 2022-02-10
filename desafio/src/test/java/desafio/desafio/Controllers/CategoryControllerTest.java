package desafio.desafio.Controllers;

import desafio.desafio.Models.Category;
import desafio.desafio.Service.CategoryService;
import desafio.desafio.util.CategoryCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
class CategoryControllerTest {

    // Usar para a testar a classe em especifico.
    @InjectMocks
    private CategoryController categoryController;

    // Testar classes dentro de category controler, define
    @Mock
    private CategoryService categoryServiceMock;

    // Retornar os valores que seria retornados normalmente
    @BeforeEach
    void setUp(){
        PageImpl<Category> categoryPage = new PageImpl<>(List.of(CategoryCreator.createValidCategory()));

        BDDMockito.when(categoryServiceMock.listAll(ArgumentMatchers.any()))
            .thenReturn(categoryPage);
    }
    @Test
    @DisplayName("List returns list of category inside page when successful")
    void list_ReturnsListOfCategoriesPageObject_WhenSuccessful(){
        String expectedName = CategoryCreator.createValidCategory().getName();

        Page<Category> categoryPage = categoryController.listAll(null).getBody();

        Assertions.assertThat(categoryPage).isNotNull();

        Assertions.assertThat(categoryPage.toList()).isNotEmpty().hasSize(1);

        Assertions.assertThat(categoryPage.toList().get(0).getName()).isEqualTo(expectedName);
    }

}
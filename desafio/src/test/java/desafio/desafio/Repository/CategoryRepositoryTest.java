package desafio.desafio.Repository;

import desafio.desafio.Models.Category;
import desafio.desafio.util.CategoryCreator;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@DisplayName("Test for Category Repository")
@Log4j2
class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @DisplayName("Save category when Success")
    void save_PersistCateogry_WhenSuccessful(){
        Category category = CategoryCreator.createValidCategory();

        Category savedCategory = this.categoryRepository.save(category);

        Assertions.assertThat(savedCategory).isNotNull();

        Assertions.assertThat(savedCategory.getCategoryId()).isNotNull();
        Assertions.assertThat(savedCategory.getName()).isEqualTo(category.getName());
    }

    @Test
    @DisplayName("Update category when Success")
    void update_UpdateCategory_WhenSuccessful(){
        Category category = CategoryCreator.createValidCategory();
        Category savedCategory = this.categoryRepository.save(category);

        savedCategory.setName("Marçal");

        Category updateCategory = this.categoryRepository.save(savedCategory);

        Assertions.assertThat(updateCategory).isNotNull();
        Assertions.assertThat(updateCategory.getCategoryId()).isNotNull();
        Assertions.assertThat(updateCategory.getName()).isEqualTo(savedCategory.getName());
    }

    @Test
    @DisplayName("Delete category when Success")
    void delete_RemoveCategory_WhenSuccessful(){
        Category category = CategoryCreator.createValidCategory();
        Category savedCategory = this.categoryRepository.save(category);

        this.categoryRepository.delete(savedCategory);

        Optional<Category> categoryOptional = this.categoryRepository.findById(savedCategory.getCategoryId());

        Assertions.assertThat(categoryOptional).isEmpty();
    }

    @Test
    @DisplayName("Find By Name category when Success")
    void FindByName_ReturnListOfCategory_WhenSuccessful(){
        Category category = CategoryCreator.createValidCategory();
        Category savedCategory = this.categoryRepository.save(category);

        String name = savedCategory.getName();

        List<Category> categories = categoryRepository.findByName(name);

        Assertions.assertThat(categories).isNotEmpty();
        Assertions.assertThat(categories).contains(savedCategory);

    }

    @Test
    @DisplayName("Find By Name return empty List category when no category is found")
    void FindByName_ReturnEmptyListOfCategory_WhenACategoryisNotFound(){
        List<Category> categories = categoryRepository.findByName("name");

        Assertions.assertThat(categories).isEmpty();
    }

    @Test
    @DisplayName("Save throw ConstraintValidationException when category is empty")
    void save_ThrowsConstraintViolationException_WhenCategoryIsEmpty(){
        Category category = new Category();

        Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
                .isThrownBy(()-> this.categoryRepository.save(category))
                .withMessageContaining("The Category could not be empty");

    }

}
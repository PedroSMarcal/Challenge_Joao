package desafio.desafio.Service;

import desafio.desafio.Exception.BadRequestException;
import desafio.desafio.Models.Category;
import desafio.desafio.Repository.CategoryRepository;
import desafio.desafio.mapper.CategoryMapper;
import desafio.desafio.requests.CategoryPostRequestBody;
import desafio.desafio.requests.CategoryPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Page<Category> listAll(Pageable pageable){
        return categoryRepository.findAll(pageable);
    }

    public List<Category> findByName(String name){
        return categoryRepository.findByName(name);
    };

    public Category findById(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Category not Found"));

    }

    public Category addCategory(CategoryPostRequestBody categoryPostRequestBody){
        return categoryRepository.save(CategoryMapper.INSTANCE.toCategory(categoryPostRequestBody));
    }

    public void deleteCategory(Long id){
        categoryRepository.delete(findById(id));
    }

    public void replaceCategory(CategoryPutRequestBody categoryPutRequestBody){
        Category savedCategory = findById(categoryPutRequestBody.getCategoryId());
        Category category = CategoryMapper.INSTANCE.toCategory(categoryPutRequestBody);
        category.setCategoryId(savedCategory.getCategoryId());
    }
}

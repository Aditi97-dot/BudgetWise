package in.sp.Expense.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import in.sp.Expense.Exceptions.ResourceNotFoundException;
import in.sp.Expense.Service.CategoryService;
import in.sp.Expense.dto.CategoryDto;
import in.sp.Expense.entity.Category;
import in.sp.Expense.mapper.CategoryMapper;
import in.sp.Expense.repository.CategoryRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{
	
	private CategoryRepository categoryRepository;

	@Override
	//Create method
	public CategoryDto createcategory(CategoryDto categoryDto) {
	  
		//convert categoryDto to category
		Category category= CategoryMapper.maptoCategory(categoryDto);
		
		//save category into database table
		
		Category savedCategory= categoryRepository.save(category);
		
		////convert category to categoryDto
		
		return CategoryMapper.maptoCategoryDto(savedCategory);
	}

	@Override
	//get category by Id method
	public CategoryDto getCategoryById(Long categoryId) {
		// TODO Auto-generated method stub
		
		Category category= categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException ("Category not found with id :" +categoryId));
		
		return CategoryMapper.maptoCategoryDto(category);
	}

	@Override
	//get all category by Id method
	public List<CategoryDto> getAllCategories() {
		// TODO Auto-generated method stub
		 List<Category> categories = categoryRepository.findAll();
	        return categories.stream()
	                .map((category) -> CategoryMapper.maptoCategoryDto(category))
	                .collect(Collectors.toList());
	}

	@Override
	public CategoryDto updateCategory(Long categoryId, CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		
		
		// get category entity from the database by category id
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException ("Category not found with id: " + categoryId));

        // update the category entity object and save to database table
        category.setName(categoryDto.name());
        Category updatedCategory = categoryRepository.save(category); // performs update operation
        return CategoryMapper.maptoCategoryDto(updatedCategory);
	}

	@Override
	public void deleteCategory(Long categoryId) {
		// TODO Auto-generated method stub
		// Check if a category with given if exists in a database
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new  ResourceNotFoundException ("Category not found with id: " + categoryId));

        categoryRepository.delete(category);
		
	}
	
	}



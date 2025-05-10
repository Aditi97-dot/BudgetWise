package in.sp.Expense.Service;

import java.util.List;

import in.sp.Expense.dto.CategoryDto;

public interface CategoryService {
	
	CategoryDto createcategory(CategoryDto categoryDto);

	CategoryDto getCategoryById(Long categoryId);

	List<CategoryDto> getAllCategories();
	
	CategoryDto updateCategory(Long categoryId, CategoryDto categoryDto);
	
	void deleteCategory(Long categoryId);
}


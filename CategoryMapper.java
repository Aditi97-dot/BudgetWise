package in.sp.Expense.mapper;

import in.sp.Expense.dto.CategoryDto;
import in.sp.Expense.entity.Category;

public class CategoryMapper {

	//map categoryDto to category entity
	
	public static Category maptoCategory(CategoryDto categoryDto) {
		return new Category(categoryDto.id(),
				categoryDto.name()
				);
		
		
	}
	
	
	//map category to categoryDto 
	
		public static CategoryDto maptoCategoryDto(Category category) {
			return new CategoryDto(category.getId(),
					category.getName()
					);
			
			
		}
}

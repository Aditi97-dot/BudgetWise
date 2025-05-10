package in.sp.Expense.mapper;

import in.sp.Expense.dto.CategoryDto;
import in.sp.Expense.dto.ExpenseDto;
import in.sp.Expense.entity.Category;
import in.sp.Expense.entity.Expense;

public class ExpenseMapper {

	//map expense to expenseDto
	
	public static ExpenseDto maptoExpenseDto(Expense expense) {
		
		return new ExpenseDto(
				expense.getId(),
				expense.getAmount(),
				expense.getExpenseDate(),
				new CategoryDto(
						expense.getCategory().getId(),
						expense.getCategory().getName()
						)
				);
				     
	}
	// map expenseDto to expense
public static Expense maptoExpense(ExpenseDto expenseDto) {
		
	Category category= new Category();
	category.setId(expenseDto.categoryDto().id());
	
		return new Expense(
				expenseDto.id(),
				expenseDto.amount(),
				expenseDto.expenseDate(),
				category);
				
			
				     
	}
}

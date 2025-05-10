package in.sp.Expense.Service;



import java.util.List;

import in.sp.Expense.dto.ExpenseDto;



public interface ExpenseService {
	
	ExpenseDto createExpense(ExpenseDto expenseDto);

	ExpenseDto getExpenseById(Long expenseId);
	
	List<ExpenseDto> getAllExpenses();
	
	ExpenseDto updateExpense(Long expenseId, ExpenseDto expenseDto);
	
	void deleteExpense(Long expenseId);
}

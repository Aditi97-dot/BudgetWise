package in.sp.Expense.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import in.sp.Expense.Exceptions.ResourceNotFoundException;
import in.sp.Expense.Service.ExpenseService;
import in.sp.Expense.dto.ExpenseDto;
import in.sp.Expense.entity.Category;
import in.sp.Expense.entity.Expense;
import in.sp.Expense.mapper.ExpenseMapper;
import in.sp.Expense.repository.ExpenseRepository;
import lombok.AllArgsConstructor;
import in.sp.Expense.repository.CategoryRepository;


@AllArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService{
	
private ExpenseRepository expenseRepository;

private CategoryRepository categoryRepository;

	@Override
	public ExpenseDto createExpense(ExpenseDto expenseDto) {
		// TODO Auto-generated method stub
		//convert expenseDto to expense
		
		Expense expense= ExpenseMapper.maptoExpense(expenseDto);
		
		//save expense entity to dataBase
		
		Expense savedExpense=expenseRepository.save(expense);
		
		//convert expense to dto
		
		return ExpenseMapper.maptoExpenseDto(savedExpense);
	}

	@Override
	public ExpenseDto getExpenseById(Long expenseId) {
		// TODO Auto-generated method stub
		
		//get expense by id  from database
		Expense expense=expenseRepository.findById(expenseId).orElseThrow(() ->new ResourceNotFoundException ("not found with id "+expenseId));
		
		//convert expense to dto
		return ExpenseMapper.maptoExpenseDto(expense);
	}

	@Override
	public List<ExpenseDto> getAllExpenses() {
		// TODO Auto-generated method stub
		
		List<Expense> expenses=expenseRepository.findAll();
		
		return expenses.stream()
		 .map((expense)->ExpenseMapper.maptoExpenseDto(expense))
        .collect(Collectors.toList());
		
	}

	@Override
	public ExpenseDto updateExpense(Long expenseId, ExpenseDto expenseDto) {
		// TODO Auto-generated method stub
		
		Expense expense=expenseRepository.findById(expenseId).orElseThrow(() ->new ResourceNotFoundException ("not found with id "+expenseId));
		
		// update expense amount
		expense.setAmount(expenseDto.amount());
		
		//update expense date
		
		expense.setExpenseDate(expenseDto.expenseDate());
		
		//update category
		
		if(expenseDto.categoryDto() != null){

            // get the category entity by id
            Category category = categoryRepository.findById(expenseDto.categoryDto().id())
                    .orElseThrow(() -> new ResourceNotFoundException ("Category not found with id:" + expenseDto.categoryDto().id()));

            expense.setCategory(category);
        }

        // update expense entity into database
        Expense updatedExpense = expenseRepository.save(expense);

        // convert expense entity into ExpenseDto
        return ExpenseMapper.maptoExpenseDto(updatedExpense);
    
	}

	@Override
	public void deleteExpense(Long expenseId) {
		
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new ResourceNotFoundException ("Expense not found with id: " + expenseId));

        expenseRepository.delete(expense);

		
	}

}

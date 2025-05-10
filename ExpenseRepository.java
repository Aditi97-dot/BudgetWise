package in.sp.Expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.Expense.entity.Expense;

public interface ExpenseRepository  extends JpaRepository <Expense, Long>{

}

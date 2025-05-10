package in.sp.Expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.Expense.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}

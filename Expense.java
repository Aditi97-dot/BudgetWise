package in.sp.Expense.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="expenses")
public class Expense {
     
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable =false)
	private BigDecimal amount;
	
	@Column(nullable =false)
	private LocalDate expenseDate;
	
	// many to one relationship- many expenses mapped to one category
	@ManyToOne
	@JoinColumn(name="category_id",nullable =false)// foreign key
	private Category category;
}

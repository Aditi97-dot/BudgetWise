package in.sp.Expense.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sp.Expense.Service.ExpenseService;
import in.sp.Expense.dto.ExpenseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(
        name = "CRUD REST APIs for Expense Resource",
        description = "CRUD REST APIs for Expense Resource - " +
                "Create Expense, Update Expense, Read Expense, and Delete Expense"
)
@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*")  
@RequestMapping("/api/expenses")//base URL
public class ExpenseController {
	
	private ExpenseService expenseService;
	
	 @Operation(
	            summary = "Create Expense REST API",
	            description = "Create Expense REST API to save a expense in a database"
	    )

	    @ApiResponse(
	            responseCode = "201",
	            description = "HTTP Status 201 CREATED"
	    )

	// Build Create expense Rest API
	@PostMapping
	public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto){
		
		ExpenseDto savedExpense=expenseService.createExpense(expenseDto);
		
		return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);
		
		
	}
	  @Operation(
	            summary = "Get Expense REST API",
	            description = "Get Expense REST API to get a expense from database"
	    )

	    @ApiResponse(
	            responseCode = "200",
	            description = "HTTP Status 200 OK"
	    )
	
	// build get by id Rest api
	
	@GetMapping("{id}")
	public ResponseEntity<ExpenseDto> getByIdExpense(@PathVariable("id") Long expenseId){
		
		ExpenseDto savedExpense=expenseService.getExpenseById(expenseId);
		
		return ResponseEntity.ok(savedExpense);
		
		
	}
	  @Operation(
	            summary = "Get All Expenses REST API",
	            description = "Get All Expenses REST API to get all expenses from database"
	    )

	    @ApiResponse(
	            responseCode = "200",
	            description = "HTTP Status 200 OK"
	    )
	
	// Build getall Rest API
	@GetMapping
	public ResponseEntity<List<ExpenseDto>> getByAllExpense(){
		
		List<ExpenseDto> savedExpense=expenseService. getAllExpenses();
		
		return ResponseEntity.ok(savedExpense);
		
		
	}
	  @Operation(
	            summary = "Update Expense REST API",
	            description = "Update Expense REST API to update an existing expense in database"
	    )

	    @ApiResponse(
	            responseCode = "200",
	            description = "HTTP Status 200 OK"
	    )
	// Build update expense REST API
    @PutMapping("{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable("id") Long expenseId,
                                                    @RequestBody ExpenseDto expenseDto){

        ExpenseDto updatedExpense = expenseService.updateExpense(expenseId, expenseDto);

        return ResponseEntity.ok(updatedExpense);

    }
	  @Operation(
	            summary = "Delete Expense REST API",
	            description = "Delete Expense REST API to delete an existing expense from the database"
	    )

	    @ApiResponse(
	            responseCode = "200",
	            description = "HTTP Status 200 OK"
	    )
    
    // Build delete expense REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id") Long expenseId){
        expenseService.deleteExpense(expenseId);
        return ResponseEntity.ok("Expense deleted successfully!");
    }
	
}

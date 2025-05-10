package in.sp.Expense.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        description = "Expense DTO (Data Transfer Object) to " +
                "transfer the data between client and server"
)
public record ExpenseDto(Long id,

                         @Schema(
                                 description = "Expense amount"
                         )
                         BigDecimal amount,

                         @Schema(
                                 description = "Expense created date"
                         )
                         LocalDate expenseDate,

                         @Schema(
                                 description = "Associated Expense category"
                         )
                         CategoryDto categoryDto) {
}

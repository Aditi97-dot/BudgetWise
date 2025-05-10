package in.sp.Expense;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
				title = "Expense Tracker REST API Documentation",
				description = "Expense Tracker REST API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Aditi",
						email = "arohigarg2001@gmail.com"
						
				),
				license = @License(
					name = "Apache 2.0"
					
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Expense Tracker REST API Documentation for Developers"
				
		)
)
@SpringBootApplication
public class ExpenseTrackerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerAppApplication.class, args);
	}

}

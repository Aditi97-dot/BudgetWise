package in.sp.Expense.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	//handle specific exception
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,WebRequest webRequest){
		
		
		ErrorDetails errorDetails=new ErrorDetails();
		errorDetails.setMessage(exception.getMessage());
		errorDetails.setErrorCode("RESOURCE_NOT_FOUND");
		errorDetails.setDetails(webRequest.getDescription(false));
		errorDetails.setTimestamp(LocalDateTime.now());
		
		
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
			
	}
	//handle generic exception
	
		@ExceptionHandler(Exception.class)
		@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
		public ResponseEntity<ErrorDetails> handleGenericException(Exception exception,WebRequest webRequest){
			
			
			ErrorDetails errorDetails=new ErrorDetails();
			errorDetails.setMessage(exception.getMessage());
			errorDetails.setErrorCode("INTERNAL_SERVER_ERROR");
			errorDetails.setDetails(webRequest.getDescription(false));
			errorDetails.setTimestamp(LocalDateTime.now());
			
			
			return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
				
		}
	

}

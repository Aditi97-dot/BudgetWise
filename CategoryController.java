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

import in.sp.Expense.Service.CategoryService;
import in.sp.Expense.dto.CategoryDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(
        name = "CRUD REST APIs for Category Resource",
        description = "CRUD REST APIs for Category Resource - Create Category" +
                "Update Category, Get Category, and Delete Category"
)
@AllArgsConstructor
@RestController
@RequestMapping("/api/categories") // Define the base URI
public class CategoryController {

    private CategoryService categoryService;

    @Operation(
            summary = "Create Category REST API",
            description = "Create Category REST API to save category into database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 CREATED"
    )
    // Build create category REST API
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(
            @RequestBody CategoryDto categoryDto){

        CategoryDto category = categoryService.createcategory(categoryDto);

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @Operation(
            summary = "GET Category REST API",
            description = "Get Category REST API to get category from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    // Build Get category by id REST API
    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") Long categoryId){
        CategoryDto category = categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(category);
    }

    @Operation(
            summary = "GET All Categories REST API",
            description = "Get All Categories REST API to get all categories from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    // Build Get All Categories REST API
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        List<CategoryDto> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @Operation(
            summary = "Update Category REST API",
            description = "Update Category REST API to category in a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    // Build update category REST API
    @PutMapping("{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") Long categoryId,
                                                      @RequestBody CategoryDto categoryDto){

        CategoryDto updatedCategory = categoryService.updateCategory(categoryId, categoryDto);

        return ResponseEntity.ok(updatedCategory);
    }

    @Operation(
            summary = "DeleteCategory REST API",
            description = "Delete Category REST API to delete a category in a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    // Build delete category REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId){

        categoryService.deleteCategory(categoryId);

        return ResponseEntity.ok("Category deleted successfully.");
    }
}


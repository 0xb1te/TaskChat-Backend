package com.six.taskchat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.six.taskchat.entity.Category;
import com.six.taskchat.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = { "http://localhost:4200" })
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping()
	public List<Category> getAllCategories() {
		return categoryService.getAllCategories();
	}

	@PostMapping
	public Category createCategory(@RequestBody Category category) {
		return categoryService.createCategory(category);
	}
}
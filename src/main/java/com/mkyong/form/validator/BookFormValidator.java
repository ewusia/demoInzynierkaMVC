package com.mkyong.form.validator;

import com.mkyong.form.model.Book;
import com.mkyong.form.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

//http://docs.spring.io/spring/docs/current/spring-framework-reference/html/validation.html#validation-mvc-configuring
@Component
public class BookFormValidator implements Validator {
	
	@Autowired
	BookService bookService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Book.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Book book = (Book) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "NotEmpty.bookForm.title");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "NotEmpty.bookForm.year");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "NotEmpty.bookForm.author");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "NotEmpty.bookForm.category");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cover","NotEmpty.bookForm.cover");
		// walidacje todo

	}

}
package com.mkyong.form.model;

import java.util.List;

public class Book {
	// form:hidden - hidden value
	Integer id;

	// form:input - textbox
	String title;

	// form:input - textbox
	String year;

	// form:textarea - textarea
	// form:input - textbox
	String cover;

	// form:textarea - textarea
	// form:input - textbox
	String author;

	// form:checkboxes - multiple checkboxes
	// form:select - form:option - dropdown - single select
	String category;

	public boolean isNew() {
		return (this.id == null);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", title=" + title + ", year=" + year + ", author=" + author
				+ ", category=" + category + ", cover=" + cover + "]" + isNew();

	}

}

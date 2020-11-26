package com.ts.housejoy.dto;

import java.util.List;

public class SubCategory {
	private int id;
	private String type;
	private boolean deleted;
	private int categoryId;
	private String subCategoryImage;
	private Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getSubCategoryImage() {
		return subCategoryImage;
	}

	public void setSubCategoryImage(String subCategoryImage) {
		this.subCategoryImage = subCategoryImage;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}

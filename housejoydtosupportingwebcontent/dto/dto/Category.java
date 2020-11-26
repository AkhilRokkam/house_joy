package com.ts.housejoy.dto;

import java.util.*;

public class Category {

	private int id;
	private String type;	
	private boolean deleted;
	private String categoryImage;	
	
		
	public void setId(int id) {
		this.id = id;
	}	
	
	public int getId() {
		return id;
	}	
	
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	public String getCategoryImage() {
		return categoryImage;
	}

	public void setCategoryImage(String categoryImage) {
		this.categoryImage = categoryImage;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}		
}

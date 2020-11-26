package com.ts.housejoy.dao;

import com.ts.housejoy.dto.Category;

public class test {

	public static void main(String[] args) {
		Category c = new Category();
		c.setType("cleaning1");
		c.setCategoryImage("image");
		System.out.println(CategoryDAO.add(c));

	}

}

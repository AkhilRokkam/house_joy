package com.ts.housejoy.dao;

import com.ts.housejoy.dto.Category;
import com.ts.housejoy.dto.Service;
import com.ts.housejoy.dto.SubCategory;

public class testing {

	public static void main(String[] args) {

		/*
		 * Subcategory sb = new Subcategory(); sb.setType("programer");
		 * sb.setImage("imagename1"); Category c=new Category(); c.setId(109);
		 * sb.setCategory(c);
		 */

		/*
		 * SubCategoryDAO.delete(1015); System.out.println("deleted");
		 */

		/* SubCategoryDAO.get(1014); */

		SubCategoryDAO.getSubCategories();
		/*
		 * Service s = new Service(); s.setDescription("Desricption");
		 * s.setApprox_price(145); Subcategory sb = new Subcategory(); sb.setId(1014);
		 * s.setSubcategory(sb); ServiceDAO.add(s);
		 */

	}

}

package com.ts.housejoy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ts.housejoy.dto.Category;
import com.ts.housejoy.dto.SubCategory;
import com.ts.housejoy.util.DBUtil;

public class SubCategoryDAO {
	public static boolean add(SubCategory subCategory) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBUtil.openConnection();
			ps = (PreparedStatement) con
					.prepareStatement("insert into subcategory(type,image,deleted,category_id) values(?,?,0,?)");
			ps.setString(1, subCategory.getType());
			ps.setString(2, subCategory.getSubCategoryImage() + ".jpg");
			ps.setInt(3, subCategory.getCategoryId());

			if (ps.executeUpdate() > 0) {

				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection();
		}

		return false;
	}

	public static boolean delete(int subCategoryId) {

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBUtil.openConnection();
			ps = (PreparedStatement) con.prepareStatement("update subcategory set deleted=1 where id = ?");
			ps.setInt(1, subCategoryId);
			if (ps.executeUpdate() > 0) {
				System.out.println("executed");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection();
		}

		return false;
	}

	public static SubCategory get(int subCategoryId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		SubCategory sc = null;

		try {
			con = DBUtil.openConnection();
			ps = (PreparedStatement) con.prepareStatement("select * from subcategory where deleted =0 and id = ?");
			ps.setInt(1, subCategoryId);
			rs = ps.executeQuery();
			if (rs.next()) {
				sc = new SubCategory();
				sc.setId(rs.getInt("id"));
				sc.setType(rs.getString("type"));
				sc.setSubCategoryImage(rs.getString("image"));
				sc.setCategoryId(rs.getInt("category_id"));

				if (rs.getInt("deleted") != 0)
					sc.setDeleted(true);
				else
					sc.setDeleted(false);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection();
		}
		return sc;

	}

	public static List<SubCategory> getSubCategories() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<SubCategory> subCategoriesList = null;

		try {
			con = DBUtil.openConnection();
			ps = (PreparedStatement) con.prepareStatement("select * from subcategory where deleted = 0");
			rs = ps.executeQuery();

			subCategoriesList = new ArrayList<>();

			while (rs.next()) {

				SubCategory sc = new SubCategory();
				sc.setId(rs.getInt("id"));
				sc.setType(rs.getString("type"));
				sc.setSubCategoryImage(rs.getString("image"));
				sc.setCategoryId(rs.getInt("category_id"));

				if (rs.getInt("deleted") != 0)
					sc.setDeleted(true);
				else
					sc.setDeleted(false);

				subCategoriesList.add(sc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection();
		}

		return subCategoriesList;
	}

	public static List<SubCategory> getSubCategories(int categoryId) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<SubCategory> subcategoriesList = null;

		try {
			con = DBUtil.openConnection();
			ps = (PreparedStatement) con
					.prepareStatement("select * from subcategory where deleted=0 and category_id=?");
			ps.setInt(1, categoryId);
			rs = ps.executeQuery();

			subcategoriesList = new ArrayList<>();

			while (rs.next()) {

				SubCategory sc = new SubCategory();
				sc.setId(rs.getInt("id"));
				sc.setType(rs.getString("type"));
				sc.setSubCategoryImage(rs.getString("image"));
				sc.setCategoryId(rs.getInt("category_id"));

				if (rs.getInt("deleted") != 0)
					sc.setDeleted(true);
				else
					sc.setDeleted(false);

				subcategoriesList.add(sc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection();
		}

		return subcategoriesList;
	}

}

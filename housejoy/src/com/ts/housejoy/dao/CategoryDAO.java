package com.ts.housejoy.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ts.housejoy.dto.Category;
import com.ts.housejoy.util.DBUtil;

public class CategoryDAO {
	public static boolean add(Category category) {

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBUtil.openConnection();
			ps = con.prepareStatement("insert into category(type,image,deleted) values(?,?,0)");
			ps.setString(1, category.getType());
			ps.setString(2, category.getCategoryImage() + ".jpg");

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

	public static boolean delete(int categoryId) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBUtil.openConnection();
			ps = con.prepareStatement("update category set deleted=1 where id = ?");
			ps.setInt(1, categoryId);
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection();
		}

		return false;
	}

	public static Category get(int categoryId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Category category = null;

		try {
			con = DBUtil.openConnection();
			ps = con.prepareStatement("select * from category where deleted =0 and id = ?");
			ps.setInt(1, categoryId);
			rs = ps.executeQuery();
			if (rs.next()) {
				category = new Category();
				category.setId(rs.getInt("id"));
				category.setType(rs.getString("type"));
				category.setCategoryImage(rs.getString("image"));

				if (rs.getInt("deleted") != 0)
					category.setDeleted(true);
				else
					category.setDeleted(false);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection();
		}

		return category;
	}

	public static List<Category> getCategories() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Category> categoriesList = null;

		try {
			con = DBUtil.openConnection();
			ps = con.prepareStatement("select * from category where deleted = 0");
			rs = ps.executeQuery();

			categoriesList = new ArrayList<>();

			while (rs.next()) {

				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setType(rs.getString("type"));
				category.setCategoryImage(rs.getString("image"));

				if (rs.getInt("deleted") != 0)
					category.setDeleted(true);
				else
					category.setDeleted(false);

				categoriesList.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection();
		}

		return categoriesList;
	}

}

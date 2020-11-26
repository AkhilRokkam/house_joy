package com.ts.housejoy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ts.housejoy.dto.Category;
import com.ts.housejoy.dto.Service;
import com.ts.housejoy.dto.SubCategory;
import com.ts.housejoy.util.DBUtil;

public class ServiceDAO {

	public static boolean add(Service service) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBUtil.openConnection();
			ps = (PreparedStatement) con.prepareStatement(
					"insert service(description,approx_price,subcategory_id,deleted) values(?,?,?,0)");

			ps.setString(1, service.getDescription());
			ps.setDouble(2, service.getApproxPrice());
			ps.setInt(3, service.getSubCategoryId());
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

	public static boolean delete(int serviceId) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBUtil.openConnection();
			ps = (PreparedStatement) con.prepareStatement("update service set deleted=1 where id = ?");
			ps.setInt(1, serviceId);
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

	public static Service get(int serviceId) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Service s = new Service();

		try {
			con = DBUtil.openConnection();
			ps = (PreparedStatement) con.prepareStatement("select * from service where deleted =0 and id = ?");
			ps.setInt(1, serviceId);
			rs = ps.executeQuery();
			if (rs.next()) {

				s.setId(rs.getInt("id"));
				s.setDescription(rs.getString("description"));
				s.setApproxPrice(rs.getFloat("approx_price"));
				s.setSubCategoryId(rs.getInt("subcategory_id"));

				if (rs.getInt("deleted") != 0)
					s.setDeleted(true);
				else
					s.setDeleted(false);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection();
		}
		return s;

	}

	public static List<Service> getServices(int subcategoriesId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Service> servicelist = null;

		try {
			con = DBUtil.openConnection();
			ps = (PreparedStatement) con
					.prepareStatement("select * from service where deleted = 0 and subcategory_id=?");
			ps.setInt(1, subcategoriesId);
			rs = ps.executeQuery();

			servicelist = new ArrayList<>();

			while (rs.next()) {

				Service s = new Service();
				s.setId(rs.getInt("id"));
				s.setDescription(rs.getString("description"));
				s.setApproxPrice(rs.getFloat("approx_price"));
				s.setSubCategoryId(rs.getInt("subcategory_id"));

				if (rs.getInt("deleted") != 0)
					s.setDeleted(true);
				else
					s.setDeleted(false);

				servicelist.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection();
		}

		return servicelist;

	}

	public static List<Service> getForceService(int userId) {

		return null;
	}

	public static List<Service> getServices() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Service> servicesList = null;

		try {
			con = DBUtil.openConnection();
			ps = (PreparedStatement) con.prepareStatement("select * from service where deleted = 0");
			rs = ps.executeQuery();

			servicesList = new ArrayList<>();

			while (rs.next()) {

				Service s = new Service();
				s.setId(rs.getInt("id"));
				s.setDescription(rs.getString("description"));
				s.setApproxPrice(rs.getFloat("approx_price"));
				s.setSubCategoryId(rs.getInt("subcategory_id"));

				if (rs.getInt("deleted") != 0)
					s.setDeleted(true);
				else
					s.setDeleted(false);

				servicesList.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection();
		}

		return servicesList;
	}

}

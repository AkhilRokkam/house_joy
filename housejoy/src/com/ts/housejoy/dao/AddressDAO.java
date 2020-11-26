package com.ts.housejoy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ts.housejoy.dto.Address;
import com.ts.housejoy.dto.SubCategory;
import com.ts.housejoy.util.DBUtil;

public class AddressDAO {

	public static Address add(Address address) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBUtil.openConnection();
			ps = (PreparedStatement) con.prepareStatement(
					"insert into address(door_number,street,city,state,postal_code,user_id,deleted) values(?,?,?,?,?,?,?,0)");
			ps.setString(1, address.getDoorno());
			ps.setString(2, address.getStreet());
			ps.setString(3, address.getCity());
			ps.setString(4, address.getState());
			ps.setString(5, address.getPostalCode());
			ps.setInt(6, address.getUserId());
			ps.setBoolean(7, address.isDeleted());

			if (ps.executeUpdate() > 0) {

				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection();
		}

		return null;
	}

	public static boolean delete(int addressId) {

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBUtil.openConnection();
			ps = (PreparedStatement) con.prepareStatement("update adddress set deleted=1 where id=?");
			ps.setInt(1, addressId);

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

	public static Address get(int addressId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Address a = new Address();
		try {
			con = DBUtil.openConnection();
			ps = (PreparedStatement) con.prepareStatement("select * from address where  deleted =0 and id =?");
			ps.setInt(1, addressId);
			rs = ps.executeQuery();
			if (rs.next()) {

				a.setId(rs.getInt("id"));
				a.setDoorno(rs.getString("door_number"));
				a.setStreet(rs.getString("street"));
				a.setCity(rs.getString("city"));
				a.setPostalCode(rs.getString("postal_code"));
				a.setUserId(rs.getInt("user_id"));
				a.setDeleted(rs.getBoolean("deleted"));

				if (rs.getInt("deleted") != 0)
					a.setDeleted(true);
				else
					a.setDeleted(false);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection();
		}

		return a;

	}

	public static List<Address> getAddressList(int userId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Address> addressList = null;

		try {
			con = DBUtil.openConnection();
			ps = (PreparedStatement) con.prepareStatement("select * from address where deleted = 0 and user_id=?");
			ps.setInt(1, userId);
			rs = ps.executeQuery();

			addressList = new ArrayList<>();

			while (rs.next()) {
				Address a = new Address();
				a.setId(rs.getInt("id"));
				a.setDoorno(rs.getString("door_number"));
				a.setStreet(rs.getString("street"));
				a.setCity(rs.getString("city"));
				a.setPostalCode(rs.getString("postal_code"));
				a.setUserId(rs.getInt("user_id"));
				a.setDeleted(rs.getBoolean("deleted"));

				if (rs.getInt("deleted") != 0)
					a.setDeleted(true);
				else
					a.setDeleted(false);

				addressList.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection();
		}

		return addressList;

	}

}
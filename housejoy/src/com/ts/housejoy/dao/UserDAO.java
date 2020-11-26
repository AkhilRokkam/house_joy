package com.ts.housejoy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ts.housejoy.dto.User;
import com.ts.housejoy.util.DBUtil;

public class UserDAO {
	public static User register(User user) {

		Connection con = null;
		PreparedStatement ps = null;

		if (search(user.getEmailId()))
			return null;

		try {
			con = DBUtil.openConnection();
			ps = con.prepareStatement(
					"insert into user(name,password,email,register_date,mobile_number,role) values(?,?,?,?,?,'user')",
					PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmailId());
			ps.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			ps.setLong(5, user.getMobileNumber());

			if (ps.executeUpdate() > 0) {

				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					user.setId(rs.getInt(1));
				}

				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection();
		}
		return user;

	}

	private static boolean search(String email) {

		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = DBUtil.openConnection();
			ps = con.prepareStatement("select * from user where email = ?");
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();

			if (rs.next())
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection();

		}

		return false;

	}

	public static User login(String email, String password) {
		Connection con = null;
		PreparedStatement ps = null;

		User user = null;

		try {

			con = DBUtil.openConnection();
			ps = con.prepareStatement("select * from user where role='user' and email = ? and password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmailId(rs.getString("email"));
				user.setMobileNumber(rs.getLong("mobile_number"));
				user.setRegistrationDate(rs.getDate("register_date"));

				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection();
		}

		return user;

	}

	public static User loginAdmin(String email, String password) {
		Connection con = null;
		PreparedStatement ps = null;
		User user = null;

		try {

			con = DBUtil.openConnection();
			ps = con.prepareStatement("select * from user where role='admin' and email = ? and password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmailId(rs.getString("email"));
				user.setMobileNumber(rs.getLong("mobile_number"));
				user.setRegistrationDate(rs.getDate("register_date"));

				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection();
		}

		return user;

	}

	public static User get(int userId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			con = DBUtil.openConnection();
			ps = con.prepareStatement("select * from user where id = ?");
			ps.setInt(1, userId);
			rs = ps.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmailId(rs.getString("email"));
				user.setMobileNumber(rs.getLong("mobile_number"));
				user.setRegistrationDate(rs.getDate("register_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection();
		}

		return user;

	}

	public static User get(String emailId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			con = DBUtil.openConnection();
			ps = con.prepareStatement("select * from user where email = ?");
			ps.setString(1, emailId);
			rs = ps.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmailId(rs.getString("email"));
				user.setMobileNumber(rs.getLong("mobile_number"));
				user.setRegistrationDate(rs.getDate("register_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection();
		}

		return user;

	}

	public boolean updateUserDetails(String password, long mobile_number, int userId) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBUtil.openConnection();
			ps = con.prepareStatement("update user set mobile_number = ? , password = ? where id = ?");
			ps.setLong(1, mobile_number);
			ps.setString(2, password);
			ps.setInt(3, userId);
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection();
		}

		return false;

	}

}

package com.ts.housejoy.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ts.housejoy.dto.Address;
import com.ts.housejoy.dto.Service;
import com.ts.housejoy.dto.SubCategory;
import com.ts.housejoy.dto.Work;
import com.ts.housejoy.util.DBUtil;

public class WorkDAO {

	public boolean add(Work work) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBUtil.openConnection();
			ps = con.prepareStatement(
					"insert work(posted_date,description,status,user_id,service_id,address_id) values(?,?,0,?,?,?)");
			ps.setDate(1, (Date) work.getPostedDate());
			ps.setString(2, work.getDescription());
			ps.setInt(3, work.getId());
			ps.setInt(4, work.getService_id());
			ps.setInt(5, work.getAddress_id());
			if (ps.executeUpdate() > 0) {

				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}

		return false;
	}

	public Work get(int workId) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Work w = new Work();

		try {
			con = DBUtil.openConnection();
			ps = (PreparedStatement) con.prepareStatement("select * from work where status=0 and id = ?");
			ps.setInt(1, workId);
			rs = ps.executeQuery();
			if (rs.next()) {

				w.setId(rs.getInt("id"));
				w.setPostedDate(rs.getDate("posted_date"));
				w.setDescription(rs.getString("description"));
				w.setId(rs.getInt("user_id"));
				w.setService_id(rs.getInt("service_id"));
				w.setAddress_id(rs.getInt("address_id"));

				if (rs.getInt("status") == 0)
					w.setStatus(true);
				else
					w.setStatus(false);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection();
		}
		return w;

	}

	public List<Work> getWorks(int userId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Work> worksList = null;

		try {
			con = DBUtil.openConnection();
			ps = (PreparedStatement) con.prepareStatement("select * from work where status = 0 and user_id=?");
			ps.setInt(1, userId);
			rs = ps.executeQuery();

			worksList = new ArrayList<>();

			while (rs.next()) {

				Work w = new Work();
				w.setId(rs.getInt("id"));
				w.setPostedDate(rs.getDate("posted_date"));
				w.setDescription(rs.getString("description"));
				w.setId(rs.getInt("user_id"));
				w.setService_id(rs.getInt("service_id"));
				w.setAddress_id(rs.getInt("address_id"));

				if (rs.getInt("stutus") != 0)
					w.setStatus(true);
				else
					w.setStatus(false);

				worksList.add(w);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection();
		}

		return worksList;
	}

	public List<Work> getActiveWorks(int forceId) {
		Service service = new Service();
		Address address = new Address();
		Work work = new Work();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Work> worksList = null;

		try {
			con = DBUtil.openConnection();
			ps = (PreparedStatement) con.prepareStatement("select * from work where status = 0 and service_id=?");
			ps.setInt(1, forceId);
			rs = ps.executeQuery();

			worksList = new ArrayList<>();

			while (rs.next()) {

				Work w = new Work();
				w.setId(rs.getInt("id"));
				w.setPostedDate(rs.getDate("posted_date"));
				w.setDescription(rs.getString("description"));
				w.setId(rs.getInt("user_id"));
				w.setService_id(rs.getInt("service_id"));
				w.setAddress_id(rs.getInt("address_id"));

				if (rs.getInt("status") != 0)
					w.setStatus(true);
				else
					w.setStatus(false);

				worksList.add(w);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection();
		}

		return worksList;

	}

	public boolean changeStatus(int workId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Work w = new Work();

		try {
			con = DBUtil.openConnection();
			ps = (PreparedStatement) con.prepareStatement("select * from work where status=0 and id = ?");
			ps.setInt(1, workId);
			rs = ps.executeQuery();

			if (rs.getInt("status") == 0)
				w.setStatus(true);
			else
				w.setStatus(false);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection();
		}

		return false;

	}

}

package org.comstudy21.myapp.users.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.comstudy21.myapp.users.model.Users;
import org.comstudy21.myapp.users.util.JdbcUtil;
import org.springframework.stereotype.Service;

@Service("usersService")
public class UsersServiceImpl implements UsersService {
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private int cnt = 0;

	@Override
	public int insertUser(Users usr) {
		// TODO Auto-generated method stub
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(INSERT_USER);
			stmt.setString(1, usr.getId());
			stmt.setString(2, usr.getPassword());
			stmt.setString(3, usr.getName());
			stmt.setString(4, usr.getRole());
			
			cnt = stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JdbcUtil.closeAll(conn, stmt, null);
		}
		
		return cnt;
	}

	@Override
	public int updateUser(Users usr) {
		// TODO Auto-generated method stub
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(UPDATE_USER);
			stmt.setString(1, usr.getName());
			stmt.setString(2, usr.getRole());
			stmt.setString(3, usr.getId());
			
			cnt = stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JdbcUtil.closeAll(conn, stmt, null);
		}
		
		return cnt;
	}

	@Override
	public int deleteUser(Users usr) {
		// TODO Auto-generated method stub
		
		try {
			conn = JdbcUtil.getConnection();
			
			stmt = conn.prepareStatement(DELETE_USER);
			stmt.setString(1, usr.getId());
			cnt = stmt.executeUpdate();
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JdbcUtil.closeAll(conn, stmt, null);
		}
		
		return cnt;
	}

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(DELETE_ALL);
			cnt = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JdbcUtil.closeAll(conn, stmt, null);
		}
		
		return cnt;
	}

	@Override
	public Users selectUser(Users usr) {
		// TODO Auto-generated method stub
		Users usrRS = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(SELECT_USER);
			stmt.setString(1, usr.getId());
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				usrRS = new Users();
				usrRS.setId(rs.getString(1));
				usrRS.setPassword(rs.getString(2));
				usrRS.setName(rs.getString(3));
				usrRS.setRole(rs.getString(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JdbcUtil.closeAll(conn, stmt, rs);
		}
		
		return usrRS;
	}

	@Override
	public List<Users> selectAll() {
		// TODO Auto-generated method stub
		List<Users> usrList = new ArrayList<Users>();
		Users usrRS = null;
		
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(SELECT_ALL);
			rs = stmt.executeQuery();
			while(rs.next()) {
				usrRS = new Users();
				usrRS.setId(rs.getString(1));
				usrRS.setPassword(rs.getString(2));
				usrRS.setName(rs.getString(3));
				usrRS.setRole(rs.getString(4));
				usrList.add(usrRS);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JdbcUtil.closeAll(conn, stmt, rs);
		}
		
		return usrList;
	}

}

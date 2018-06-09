package org.comstudy21.myapp.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.comstudy21.myapp.commons.JdbcUtil;
import org.comstudy21.myapp.users.service.UserService;
import org.comstudy21.myapp.users.vo.UserVo;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	private Connection conn = null;
	
	public void setConnection(Connection conn){
		this.conn = conn;
	}
	
	
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	
	private final String USER_GET = "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?";
	private final String USER_INSERT = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
	private final String USER_UPDATE = "UPDATE USERS SET PASSWORD = ?, NAME = ?, ROLE = ? WHERE ID = ?";	
	private final String USER_DELETE = "DELETE FROM USERS WHERE ID = ?";
	private final String USER_LIST = "SELECT * FROM USERS";
	
	
	public void insertUser(UserVo vo){
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(USER_INSERT);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getName());
			stmt.setString(4, vo.getRole());
			
			int res = stmt.executeUpdate();
			
			if(res != 1){
				System.out.println("입력 실패");
				conn.rollback();
			}
			else{
				System.out.println("입력 성공");
				conn.commit();
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JdbcUtil.close(null, stmt, conn);
		}
	}
	

	public void updateUser(UserVo vo){
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(USER_UPDATE);
			stmt.setString(1, vo.getPassword());
			stmt.setString(2, vo.getName());
			stmt.setString(3, vo.getRole());
			stmt.setString(4, vo.getId());
			
			int res = stmt.executeUpdate();
			
			if(res != 1){
				System.out.println("수정 실패");
				conn.rollback();
			}
			else{
				System.out.println("수정 성공");
				conn.commit();
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JdbcUtil.close(null, stmt, conn);
		}
	}
	
	public void deleteUser(UserVo vo){
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(USER_DELETE);
			stmt.setString(1, vo.getId());
			
			int res = stmt.executeUpdate();
			
			if(res != 1){
				System.out.println("삭제 실패");
				conn.rollback();
			}
			else{
				System.out.println("삭제 성공");
				conn.commit();
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JdbcUtil.close(null, stmt, conn);
		}
	}
	
	public UserVo getUser(UserVo vo){
		UserVo rsVo = null;
		
		try {
			//conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			
			rs = stmt.executeQuery();
			
			while(rs.next()){
				rsVo = new UserVo();
				rsVo.setId(rs.getString(1));
				rsVo.setPassword(rs.getString(2));
				rsVo.setName(rs.getString(3));
				rsVo.setRole(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JdbcUtil.close(rs, stmt, conn);
		}
		
		return rsVo;
	}
	
	
	public List<UserVo> getUserList(){
		List<UserVo> listVo = new ArrayList<UserVo>();
		UserVo rsVo = null;
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(USER_LIST);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				rsVo = new UserVo();
				rsVo.setId(rs.getString(1));
				rsVo.setPassword(rs.getString(2));
				rsVo.setName(rs.getString(3));
				rsVo.setRole(rs.getString(4));
				
				listVo.add(rsVo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JdbcUtil.close(rs, stmt, conn);
		}
		
		return listVo;
	}
}

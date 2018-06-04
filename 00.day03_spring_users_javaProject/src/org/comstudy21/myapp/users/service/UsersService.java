package org.comstudy21.myapp.users.service;

import java.util.List;

import org.comstudy21.myapp.users.model.Users;

public interface UsersService{
	public String INSERT_USER = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
	public String UPDATE_USER = "UPDATE USERS SET NAME = ?, ROLE = ? WHERE ID = ?";
	public String DELETE_USER = "DELETE FROM USER WHERE ID = ?";
	public String DELETE_ALL = "DELETE FROM USER";
	public String SELECT_USER = "SELECT * FROM USERS WHERE ID = ?";
	public String SELECT_ALL = "SELECT * FROM USERS";
	
	public int insertUser(Users usr);
	public int updateUser(Users usr);
	public int deleteUser(Users usr);
	public int deleteAll();
	public Users selectUser(Users usr);
	public List<Users> selectAll();
}

package org.comstudy21.myapp.users.service;

import java.util.List;

import org.comstudy21.myapp.users.vo.UserVo;

public interface UserService {

	void insertUser(UserVo vo);

	void updateUser(UserVo vo);

	void deleteUser(UserVo vo);

	UserVo getUser(UserVo vo);

	List<UserVo> getUserList();

}
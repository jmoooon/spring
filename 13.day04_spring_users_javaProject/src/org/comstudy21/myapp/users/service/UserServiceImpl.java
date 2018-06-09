package org.comstudy21.myapp.users.service;

import java.util.List;

import org.comstudy21.myapp.commons.JdbcUtil;
import org.comstudy21.myapp.users.dao.UserDao;
import org.comstudy21.myapp.users.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	/*
	 * UserDao에 @Repository라고 넣어 놨기 때문에 @Autowired를 해주면 자동으로 그 쪽과 연결된다. 
	 */
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public void insertUser(UserVo vo) {
		// TODO Auto-generated method stub
		/*
		 * UserDao에서 로칼에 설정한 setConnection으로 connection을 받았을 경우 반드시 여기서 connection을 넣어서 실행해 줘야 한다. 
		 */
		userDao.setConnection(JdbcUtil.getConnection());
		
		userDao.insertUser(vo);
	}

	@Override
	public void updateUser(UserVo vo) {
		// TODO Auto-generated method stub
		userDao.updateUser(vo);
	}

	@Override
	public void deleteUser(UserVo vo) {
		// TODO Auto-generated method stub
		userDao.deleteUser(vo);
	}

	@Override
	public UserVo getUser(UserVo vo) {
		// TODO Auto-generated method stub
		userDao.setConnection(JdbcUtil.getConnection());
		return userDao.getUser(vo);
	}

	@Override
	public List<UserVo> getUserList() {
		// TODO Auto-generated method stub
		return userDao.getUserList();
	}

}

package com.sandip.wf.service;
import java.util.List;

import com.sandip.wf.dao.UserDao;
import com.sandip.wf.dao.UserDaoImpl;
import com.sandip.wf.dto.UserDto;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();

	@Override
	public boolean saveUser(UserDto userDto) {
		return userDao.saveUser(userDto);
	}

	@Override
	public boolean updateUser(UserDto userDto) {
		return userDao.updateUser(userDto);
	}

	@Override
	public List<UserDto> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public UserDto getUserById(int userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public void deleteUser(int userId) {
		userDao.deleteUser(userId);

	}

	@Override
	public UserDto getUserByUserNameAndPassword(String username, String password) {
		return userDao.getUserByUserNameAndPassword(username, password);
	}

	@Override
	public UserDto getPasswordByEmail(String email) {

		return userDao.getPasswordByEmail(email);
	}

	@Override
	public UserDto getPasswordByPassword(String pwd) {

		return userDao.getPasswordByPassword(pwd);
	}

}

package com.sandip.wf.dao;

import java.util.List;

import com.sandip.wf.dto.UserDto;

public interface UserDao {
	public boolean saveUser(UserDto userDto);

	public boolean updateUser(UserDto userDto);

	public List<UserDto> getAllUsers();

	public UserDto getUserById(int userId);

	public void deleteUser(int userId);

	public UserDto getUserByUserNameAndPassword(String username, String password);
	
	public UserDto getPasswordByEmail(String email);
	
	public UserDto getPasswordByPassword(String pwd);
}



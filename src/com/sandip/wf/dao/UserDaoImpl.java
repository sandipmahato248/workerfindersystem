package com.sandip.wf.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sandip.wf.dto.UserDto;
import com.sandip.wf.util.DBUtil;
import com.sandip.wf.util.Queryutil;

public class UserDaoImpl implements UserDao {
	public boolean saveUser(UserDto userDto) {
		PreparedStatement ps = null;
		int savedUser = 0;
		try {
			ps = DBUtil.getConnection().prepareStatement(Queryutil.CREATE_USER);
			// ps.setNull(1, java.sql.Types.INTEGER);
			ps.setString(1, userDto.getFirstName());
			ps.setString(2, userDto.getLastName());
			ps.setString(3, userDto.getEmail());
			ps.setDate(4, new java.sql.Date(userDto.getDob().getTime()));
			ps.setString(5, userDto.getUsername());
			ps.setString(6, userDto.getPassword());
			savedUser = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.closeAll(ps);
		}
		if (savedUser >= 1) {
			return true;
		}
		return false;
	}

	public boolean updateUser(UserDto userDto) {
		PreparedStatement ps = null;
		int uUpdated = 0;
		try {
			ps = DBUtil.getConnection().prepareStatement(Queryutil.UPDATE_USER);
			ps.setString(1, userDto.getFirstName());
			ps.setString(2, userDto.getLastName());
			ps.setString(3, userDto.getEmail());
			ps.setDate(4, new java.sql.Date(userDto.getDob().getTime()));
			ps.setString(5, userDto.getPassword());
			ps.setInt(6, userDto.getUserId());
			uUpdated = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.closeAll(ps);
		}
		if (uUpdated >= 1) {
			return true;
		}
		return false;
	}

	public List<UserDto> getAllUsers() {
		List<UserDto> users = new ArrayList<UserDto>();
		PreparedStatement ps = null;
		try {
			ps = DBUtil.getConnection().prepareStatement(Queryutil.GET_ALL_USER);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserDto userDto = new UserDto();
				userDto.setUserId(rs.getInt("user_id"));
				userDto.setFirstName(rs.getString("first_name"));
				userDto.setLastName(rs.getString("last_name"));
				userDto.setDob(rs.getDate("dob"));
				userDto.setEmail(rs.getString("email"));
				userDto.setUsername(rs.getString("username"));
				users.add(userDto);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.closeAll(ps);
		}

		return users;
	}

	public UserDto getUserById(int userId) {
		UserDto user = new UserDto();
		PreparedStatement ps = null;
		try {
			ps = DBUtil.getConnection().prepareStatement(Queryutil.GET_USER_BY_ID);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setDob(rs.getDate("dob"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.closeAll(ps);
		}
		return user;
	}

	public void deleteUser(int userId) {
		PreparedStatement ps = null;
		try {
			ps = DBUtil.getConnection().prepareStatement(Queryutil.DELETE_USER);
			ps.setInt(1, userId);
			ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.closeAll(ps);
		}
	}

	public UserDto getUserByUserNameAndPassword(String username, String password) {
		UserDto user = new UserDto();
		PreparedStatement ps = null;
		try {
			ps = DBUtil.getConnection().prepareStatement(Queryutil.GET_USER_BY_USERNAME_AND_PASSWORD);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.closeAll(ps);
		}
		return user;
	}

	@Override
	public UserDto getPasswordByEmail(String email) {
		UserDto user = new UserDto();
		PreparedStatement ps = null;
		try {
			ps = DBUtil.getConnection().prepareStatement(Queryutil.GET_BY_EMAIL);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setDob(rs.getDate("dob"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.closeAll(ps);
		}
		return user;
	}

	@Override
	public UserDto getPasswordByPassword(String pwd) {

		UserDto user = new UserDto();
		PreparedStatement ps = null;
		try {
			ps = DBUtil.getConnection().prepareStatement(Queryutil.GET_PASSWORD_BY_PASSWORD);
			ps.setString(1, pwd);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setDob(rs.getDate("dob"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.closeAll(ps);
		}
		return user;
	}
}

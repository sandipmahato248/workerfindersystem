package com.sandip.wf.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sandip.wf.dto.WorkerDto;
import com.sandip.wf.util.DBUtil;
import com.sandip.wf.util.Queryutil;

public class WorkerDaoImpl implements WorkerDao {
	PreparedStatement ps = null;

	@Override
	public void saveWorkerInfo(WorkerDto workerDto) {
		try {
			ps = DBUtil.getConnection().prepareStatement(Queryutil.SAVE_WORKER);
			ps.setString(1, workerDto.getWorkerName());
			ps.setString(2, workerDto.getWorkCategory());
			ps.setString(3, workerDto.getGender());
			ps.setLong(4, workerDto.getPhone());
			ps.setString(5, workerDto.getAddress());

			ps.setInt(6, workerDto.getWages());
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void updateWorkerInfo(WorkerDto workerDto) {

		try {
			ps = DBUtil.getConnection().prepareStatement(Queryutil.UPDATE_WORKER);
			ps.setString(1, workerDto.getWorkerName());
			ps.setString(2, workerDto.getWorkCategory());
			ps.setLong(4, workerDto.getPhone());
			ps.setString(5, workerDto.getAddress());
			ps.setString(3, workerDto.getGender());

			ps.setInt(6, workerDto.getWages());
			ps.setInt(7, workerDto.getId());
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteWorkerInfo(int id) {
		try {
			ps = DBUtil.getConnection().prepareStatement(Queryutil.DELETE_WORKER);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<WorkerDto> getAllWorkerInfo() {
		List<WorkerDto> workerList = new ArrayList<>();

		try {
			ps = DBUtil.getConnection().prepareStatement(Queryutil.LIST_WORKER);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				WorkerDto workerDto = new WorkerDto();
				workerDto.setId(rs.getInt("id"));
				workerDto.setWorkerName(rs.getString("worker_name"));
				workerDto.setWorkCategory(rs.getString("work_category"));
				workerDto.setPhone(rs.getLong("phone"));
				workerDto.setGender(rs.getString("gender"));
				workerDto.setAddress(rs.getString("address"));

				workerDto.setWages(rs.getInt("wages"));
				workerList.add(workerDto);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return workerList;

	}

	@Override
	public WorkerDto getWorkerInfoById(int id) {
		WorkerDto workerDto = new WorkerDto();
		try {
			ps = DBUtil.getConnection().prepareStatement(Queryutil.GET_WORKER_BY_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				workerDto.setId(rs.getInt("id"));
				workerDto.setWorkerName(rs.getString("worker_name"));
				workerDto.setWorkCategory(rs.getString("work_category"));
				workerDto.setPhone(rs.getLong("phone"));
				workerDto.setAddress(rs.getString("address"));
				workerDto.setGender(rs.getString("gender"));

				workerDto.setWages(rs.getInt("wages"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return workerDto;
	}

	@Override
	public List<WorkerDto> getWorkerInfoByWorkCategory(String category) {
		
		List<WorkerDto> workerList=new ArrayList<>();
		try {
			ps = DBUtil.getConnection().prepareStatement(Queryutil.GET_WORKER_BY_WORKCATEGORY);
			ps.setString(1,category);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				WorkerDto workerDto = new WorkerDto();
				workerDto.setId(rs.getInt("id"));
				workerDto.setWorkerName(rs.getString("worker_name"));
				workerDto.setWorkCategory(rs.getString("work_category"));
				workerDto.setGender(rs.getString("gender"));
				workerDto.setPhone(rs.getLong("phone"));
				workerDto.setAddress(rs.getString("address"));
				workerDto.setWages(rs.getInt("wages"));
				workerList.add(workerDto);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return workerList;
	}

	@Override
	public List<WorkerDto> getWorkerInfoByWorkAddress(String address) {
		List<WorkerDto> workerList=new ArrayList<>();
		try {
			ps = DBUtil.getConnection().prepareStatement(Queryutil.GET_WORKER_BY_ADDRESS);
			ps.setString(1,address);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				WorkerDto workerDto = new WorkerDto();
				workerDto.setId(rs.getInt("id"));
				workerDto.setWorkerName(rs.getString("worker_name"));
				workerDto.setWorkCategory(rs.getString("work_category"));
				workerDto.setGender(rs.getString("gender"));
				workerDto.setPhone(rs.getLong("phone"));
				workerDto.setAddress(rs.getString("address"));
				workerDto.setWages(rs.getInt("wages"));
				workerList.add(workerDto);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return workerList;
	}

	@Override
	public List<WorkerDto> getWorkerByCategoryAddress(String category, String address) {
		List<WorkerDto> workerList=new ArrayList<>();
		try {
			ps = DBUtil.getConnection().prepareStatement(Queryutil.BY_CATEGORY_ADDRESS);
			ps.setString(1,category);
			ps.setString(2,address);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				WorkerDto workerDto = new WorkerDto();
				workerDto.setId(rs.getInt("id"));
				workerDto.setWorkerName(rs.getString("worker_name"));
				workerDto.setWorkCategory(rs.getString("work_category"));
				workerDto.setGender(rs.getString("gender"));
				workerDto.setPhone(rs.getLong("phone"));
				workerDto.setAddress(rs.getString("address"));
				workerDto.setWages(rs.getInt("wages"));
				workerList.add(workerDto);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return workerList;
	}

}

package com.sandip.wf.service;

import java.util.List;

import com.sandip.wf.dao.WorkerDao;
import com.sandip.wf.dao.WorkerDaoImpl;
import com.sandip.wf.dto.WorkerDto;

public class WorkerServiceImpl implements WorkerService {
	private WorkerDao  workerDao= new WorkerDaoImpl();;

	public WorkerServiceImpl() {
	}
	@Override
	public void saveWorkerInfo(WorkerDto workerDto) {
		workerDao.saveWorkerInfo(workerDto);
		
	}

	@Override
	public void updateWorkerInfo(WorkerDto workerDto) {
		workerDao.updateWorkerInfo(workerDto);
		
		
	}

	@Override
	public void deleteWorkerInfo(int id) {
		workerDao.deleteWorkerInfo(id);
		
	}

	@Override
	public List<WorkerDto> getAllWorkerInfo() {
		return workerDao.getAllWorkerInfo();
	}

	@Override
	public WorkerDto getWorkerInfoById(int id) {
		return workerDao.getWorkerInfoById(id);
	}
	@Override
	public List<WorkerDto> getWorkerInfoByWorkCategory(String category) {
		return workerDao.getWorkerInfoByWorkCategory(category);
	}
	@Override
	public List<WorkerDto> getWorkerInfoByWorkAddress(String address) {
		return workerDao.getWorkerInfoByWorkAddress(address);
	}
	@Override
	public List<WorkerDto> getWorkerByCategoryAddress(String category, String address) {
		return workerDao.getWorkerByCategoryAddress(category, address);
	}
	
}

package com.sandip.wf.dao;

import java.util.List;

import com.sandip.wf.dto.WorkerDto;

public interface WorkerDao {
public void saveWorkerInfo(WorkerDto workerDto);
public void updateWorkerInfo(WorkerDto workerDto);
public void deleteWorkerInfo(int id);
public List<WorkerDto> getAllWorkerInfo();
public WorkerDto getWorkerInfoById(int id);
public List<WorkerDto> getWorkerInfoByWorkCategory(String category) ;
public List<WorkerDto> getWorkerInfoByWorkAddress(String address) ;
public List<WorkerDto> getWorkerByCategoryAddress(String category,String address) ;
}

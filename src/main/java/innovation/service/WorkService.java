package innovation.service;

import java.util.List;

import innovation.model.Work;

public interface WorkService {

public int save(Work work);
	
	public void delete(int id);
	
	public Work getById(int id);
	
	//public List<User> getUsers(String name);
	
	public List<Work> getAll();
	
	public boolean ValidateWid(int wid);

	public Work query(int tid);
	
	public Work query1(int teachid1);
	
	public Work query2(int teachid2);
	
	public Work fileupdate(Work work);
	
	public Work fileupload(int tid);
}

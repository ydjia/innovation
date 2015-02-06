package innovation.service;

import java.util.HashMap;
import java.util.List;

import innovation.model.Work;

public interface WorkService {

public int save(Work work);
	
	public void delete(int id);
	
	public Work getById(int id);
	
	//public List<User> getUsers(String name);
	
	public List<Work> getAll();
	
	public boolean ValidateWid(int wid);
	
	public Work query3(int wid);

	public Work query(int tid);
	
	public List<HashMap<Integer, Object>> query0();
	
	public List<HashMap<Integer, Object>> query1(int teachid1);
	
	public List<HashMap<Integer, Object>> query2(int teachid2);
	
	public void fileupdate(Work work);
	
	public void filedelete(Work work);
	
	public Work fileupload(int tid);

	public void fileassign1(Work work);
	
	public void fileassign2(Work work);
}

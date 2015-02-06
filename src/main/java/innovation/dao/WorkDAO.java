package innovation.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import innovation.model.Work;

@Repository
public interface WorkDAO {

	public Work getById(int id);
	
	//public List<User> searchContacts(String name);
	
	public List<Work> getAllWorks();
	
	public int save(Work contact);
	
	public void fileupload(Work work);
	
	public void delete(int id);
	
	public int checkWidValidate(int wid);

	public void updatework(Work work);
	
	public void updatework2(Work work);
	
	public void updatework3(Work work);
	
	public void updatework4(Work work);

	public Work query3(int wid);
	
	public Work query(int tid);
	
	public List<HashMap<Integer, Object>> query0();
	
	public List<HashMap<Integer, Object>> query1(int teachid1);
	
	public List<HashMap<Integer, Object>> query2(int teachid2);

}

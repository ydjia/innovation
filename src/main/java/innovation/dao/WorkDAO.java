package innovation.dao;

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

	public Work updatework(Work work);

	public Work query(int tid);

}

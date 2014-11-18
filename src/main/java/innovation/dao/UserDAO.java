package innovation.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import innovation.model.User;

@Repository
public interface UserDAO {
 
    
	public User getById(int id);
	
	public User query(String name);
	
	//public List<User> searchContacts(String name);
	
	public List<User> getAllUsers();
	
	public int save(User contact);
	
	public void update(User user);
	
	public void delete(int id);
	
	public int checkNameValidate(String name);
     
     
}
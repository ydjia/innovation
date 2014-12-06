package innovation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 


import innovation.dao.UserDAO;
import innovation.model.User;
import innovation.service.UserService;
 
 
@Service
public class UserServiceImpl implements UserService{
 
    @Autowired
    private UserDAO userDAO;
     
    public void delete(int id) {
		userDAO.delete(id);
	}

	public List<User> getAll() {
		return userDAO.getAllUsers();
	}

	public User getById(int id) {
		return userDAO.getById(id);
	}

	public int save(User User) {
		return userDAO.save(User);
	}

	public void update(User User) {
		userDAO.update(User);
	}

	//public List<User> getUsers(String name) {
	//	return userDAO.searchUsers(name);
	//}

	public boolean ValidateName(String name) {
		if(userDAO.checkNameValidate(name)==0)
			return false;
		else return true;
	}
	
	public boolean register(User user){
		//User user1 = null;
		userDAO.insert(user);		
		return true;
	}

	public User login(User user) {
		User user2=userDAO.query(user.getName());
		if(user2!=null){	
			if(!user.getPassword().equals(user2.getPassword()))
			user2.setUid(0);
		}
		return user2;
	}
}
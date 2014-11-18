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

	public User login(String name, String password) {
		User user=userDAO.query(name);
		if(!password.equals(user.getPassword()))user.setUid(0);
		return user;
	}
 
}
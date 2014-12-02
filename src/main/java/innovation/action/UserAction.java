package innovation.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import innovation.utils.UserFormValidator;
import innovation.model.User;
import innovation.service.UserService;
import innovation.service.impl.UserServiceImpl;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport{

	//private Logger logger = LoggerFactory.getLogger(UserController.class);

	//private UserService userService;
	@Autowired
	UserService us = new UserServiceImpl();
	
	private Map<String, Object> dataMap;
	
	@Autowired
	private UserService userService;  
	private User user;	
	private String password;	
	private String name;	
	private int tid;
	
	
	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "login";
	}*/
	public String execute() throws Exception{
		return null;
	}
	
	public String dologin() throws Exception {  
	    User user = new User();
	    user.setName(name);
	    user.setPassword(password);
	    
	    dataMap = new HashMap<String, Object>();
	    //拦截逻辑
	    if(name.equals("")){
	    	dataMap.put("status","1003");
	    	return ERROR;
	    }else if(password.equals("")){
	    	dataMap.put("status","1004");
	    	return ERROR;
	    }
	    User user1 = userService.login(user);  
	    if (user1.getUid() != 0) {  
	        return SUCCESS;  
	    }else{
	    	dataMap.put("status","1002");
	    	return ERROR;
	    }	    		
    } 
	  
	public String doregister() throws Exception {
		//String name = getName();  
	    //String password = getPassword();  
	    //System.out.println(userName+"----"+passWord); 
	    User user=new User();  
	    user.setName(name);  
	    user.setPassword(password);  
	    user.setTid(tid);
		if(us.register(user)){
			return "registered";
		}else{
			return "error";
		}
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}  
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public Map<String,Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String,Object> hm) {
		this.dataMap = hm;
	}
}


package innovation.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import innovation.utils.UserFormValidator;
import innovation.model.User;
import innovation.service.UserService;
import innovation.service.impl.UserServiceImpl;

@Controller
@Scope("prototype")
public class UserController extends ActionSupport{

	//private Logger logger = LoggerFactory.getLogger(UserController.class);

	//private UserService userService;
	@Autowired
	UserService us = new UserServiceImpl();
	
	private UserFormValidator validator;
	
	@Autowired
	private UserService userService;  
	private User user;	
	private String password;	
	private String name;	
	private int tid;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}	
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
	    User user1 = userService.login(user);  
	    if (user1.getUid() != 0) {  
	        return SUCCESS;  
	    }else{
	    	this.addFieldError("user.username", "用户名或密码错误!"); 
	    	//待完善，目前输入出现格式错误后会报错。
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
}


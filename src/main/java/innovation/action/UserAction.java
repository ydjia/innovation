package innovation.action;

import innovation.model.User;
import innovation.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;



@Controller  
@Scope("prototype")  
public class UserAction extends ActionSupport {  
    @Autowired  
    private UserService userService;  
    private User user;   
  
    public String execute() throws Exception {  
        return null;  
    }  
  
    public String login() {  
        if (user != null) {  
            User user2 = userService.login(user);  
            if (user2.getUid() != 0) {  
                return SUCCESS;  
            }  
        }  
        this.addFieldError("user.username", "用户名或密码错误!");  
        return INPUT;  
    }  
  
   
  
    public User getUser() {  
        return user;  
    }  
  
    public void setUser(User user) {  
        this.user = user;  
    }  
  
 
}  

package innovation.test;
 
import net.sf.json.JSONObject;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import innovation.model.User;
import innovation.service.UserService;
 
 
 
public class UserTest {
 
private UserService userService;
//private UserFormValidator ufv;
     
    @Before
    public void before(){                                                                   
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml"
                ,"classpath:conf/spring-mybatis.xml","classpath:conf/test1.xml","classpath:conf/spring-mvc.xml"});
        //ApplicationContext context = new ClassPathXmlApplicationContext("classpath:conf/test1.xml");
        
        userService = (UserService) context.getBean("userServiceImpl");
      //  ufv=(UserFormValidator) context.getBean("userFormValidator");
        
    }
     
    @Test
    public void addUser(){
        User user = new User();
        
        user = userService.login("123456", "123456");
        JSONObject json_user = JSONObject.fromObject(user);
        System.out.println(json_user.toString());
       // System.out.println(userService.save(user));
    }
}
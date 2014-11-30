package innovation.action;

import innovation.model.Work;
import innovation.service.WorkService;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class WorkAction extends ActionSupport {

	//private Logger logger = LoggerFactory.getLogger(WorkController.class);
	
	@Autowired
	private WorkService workService;
	private int tid;
	private int wid;
	private String wname;
	private String wintro;
	


	public String execute() throws Exception{
		return null;
	}
	
	public String check() throws Exception{
		//Work work = new Work();
		//work.setTid(tid);
		Work work = workService.check(tid);
		if(work.getWid()==0){
			return ERROR;
		}else{
			return SUCCESS;
		}
	}

	//作品上传
/*	public void fileupload(@RequestParam(required = true,defaultValue = "") int tid,
			@ModelAttribute("fileupload") Work work){
		work = workService.fileupload(tid);
	}*/
	
	//作品信息更新	
	public String workupdate() throws Exception{
		Work work = new Work();
		work.setWid(wid);
		work.setWname(wname);
		work.setWintro(wintro);
		workService.fileupdate(work);
		return SUCCESS;
	} 
		
	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public String getWintro() {
		return wintro;
	}

	public void setWintro(String wintro) {
		this.wintro = wintro;
	}
}

package innovation.action;

import innovation.model.Work;
import innovation.service.WorkService;

import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


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
	private int teachid1;
	private int teachid2;
	private int teachid;

	private Map<String,Object> dataMap;

	public String execute() throws Exception{
		return null;
	}
	
	//作品搜索（根据tid）
	public String check() throws Exception{
		//Work work = new Work();
		//work.setTid(tid);
		dataMap = new HashMap<String,Object>();
		HashMap data = new HashMap<String,Object>();
		Work work = workService.query(tid);
		if(work.getWid()==0){
			dataMap.put("status", "1003");      //work is not exist
			return ERROR;
		}else{
			data.put("name", work.getWname());
			data.put("detail", work.getWintro());
			dataMap.put("data", data);
			dataMap.put("status", "2000");
			return SUCCESS;
		}
	}
	//作品搜索（根据teachid）
	public String checkByTeachid() throws Exception{
		dataMap = new HashMap<String,Object>();	
		//teachid=(session……)
		//teachid1=teachid2=teachid;
		Work work1 = workService.query1(teachid1);
		Work work2 = workService.query2(teachid2);
		if((work1.getWid()==0) && (work2.getWid()==0)){
			dataMap.put("status", "1004");      //work is not exist
			return ERROR;
		}else if(work1.getWid()==0){
			dataMap.put("name", work2.getWname());
			dataMap.put("detail", work2.getWintro());
			dataMap.put("score1",work2.getMark1());
			dataMap.put("score2",work2.getMark2());
			return SUCCESS;
		}else if(work2.getWid()==0){
			dataMap.put("name", work1.getWname());
			dataMap.put("detail", work1.getWintro());
			dataMap.put("score1",work1.getMark1());
			dataMap.put("score2",work1.getMark2());
			return SUCCESS;
		}else{
			dataMap.put("name", work1.getWname());
			dataMap.put("detail", work1.getWintro());
			dataMap.put("score1",work1.getMark1());
			dataMap.put("score2",work1.getMark2());
			dataMap.put("name", work2.getWname());
			dataMap.put("detail", work2.getWintro());
			dataMap.put("score1",work2.getMark1());
			dataMap.put("score2",work2.getMark2());
			return SUCCESS;
		}
	
	}
	//作品上传
/*	public void fileupload(@RequestParam(required = true,defaultValue = "") int tid,
			@ModelAttribute("fileupload") Work work){
		work = workService.fileupload(tid);
	}*/
	
	//作品更新
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
	
	public int getTeachid1() {
		return teachid1;
	}

	public void setTeachid1(int teachid1) {
		this.teachid1 = teachid1;
	}
	
	public int getTeachid2() {
		return teachid2;
	}

	public void setTeachid2(int teachid2) {
		this.teachid2 = teachid2;
	}
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
}

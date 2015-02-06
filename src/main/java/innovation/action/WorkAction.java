package innovation.action;

import innovation.model.Work;
import innovation.service.WorkService;

import java.util.List;
import java.util.ArrayList;
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
	
	//作品搜索（根据wid）  获得作品的详细信息(此方法适用于学生、老师和管理员查看作品)
		public String checkByWid() throws Exception{
			//Work work = new Work();
			//work.setTid(tid);
			dataMap = new HashMap<String,Object>();
			Work work = workService.query3(wid);
			if(work.getWid()==0){
				dataMap.put("status", "1003");      //work is not exist
				return ERROR;
			}else{
				dataMap.put("data", work);
				dataMap.put("status", "2000");
				return SUCCESS;
			}
		}
	//作品搜索（根据tid）  获得作品的简要信息（此方法用于在用户主页展示作品）
	public String check() throws Exception{
		//Work work = new Work();
		//work.setTid(tid);
		dataMap = new HashMap<String,Object>();
		HashMap<String, Object> data = new HashMap<String,Object>();
		Work work = workService.query(tid);
		if(work.getWid()==0){
			dataMap.put("status", "1003");      //work is not exist
			return ERROR;
		}else{
			data.put("detail", work.getWintro());   
			data.put("name", work.getWname());
			dataMap.put("data", data);
			dataMap.put("status", "2000");
			return SUCCESS;
		}
	}
	//作品搜索（根据teachid）  获得教师需要评阅的作品（此方法用于查询教师ID对应的所有作品）
	public String checkByTeachid() throws Exception{
		dataMap = new HashMap<String,Object>();	
		Work work = new Work();
		work.setTeachid1(teachid);
		work.setTeachid2(teachid);
		List<HashMap<Integer, Object>> list1 = new ArrayList<HashMap<Integer,Object>>();
		list1 = workService.query1(work.getTeachid1());
		List<HashMap<Integer, Object>> list2 = new ArrayList<HashMap<Integer,Object>>();
		list2 = workService.query2(work.getTeachid2());
		if((list1.isEmpty()) && (list2.isEmpty())){
			dataMap.put("status", "1004");      //work is not exist
			return ERROR;
		}else if(list1.isEmpty()){             //teachid1作品为空
			dataMap.put("work_info", list2);
			return SUCCESS;
		}else if(list2.isEmpty()){             //teachid2作品为空
			dataMap.put("work_info", list1);
			return SUCCESS;
		}else{                                 //都不为空，则把所有对应的所有作品检索出来
			List<HashMap<Integer, Object>> list = new ArrayList<HashMap<Integer,Object>>();
			list.addAll(list1);
			list.addAll(list2);
			dataMap.put("work_info", list);
			/*	dataMap.put("name", work1.getWname());
			dataMap.put("detail", work1.getWintro());
			dataMap.put("score1",work1.getMark1());
			dataMap.put("score2",work1.getMark2());
			dataMap.put("name", work2.getWname());
			dataMap.put("detail", work2.getWintro());
			dataMap.put("score1",work2.getMark1());
			dataMap.put("score2",work2.getMark2());*/
			return SUCCESS;
		}
	}
	
	//作品搜索（管理员查询全部作品）（此方法用于管理员获得所有作品信息）
	public String checkByAdmin(){
		dataMap = new HashMap<String,Object>();
		List<HashMap<Integer, Object>> list = new ArrayList<HashMap<Integer,Object>>();
		list = workService.query0();
		dataMap.put("AllWork_info", list);
		return SUCCESS;
	}
	
	//作品上传
/*	public void fileupload(@RequestParam(required = true,defaultValue = "") int tid,
			@ModelAttribute("fileupload") Work work){
		work = workService.fileupload(tid);
	}*/
	
	//作品更新
	public String workupdate() throws Exception{
		dataMap = new HashMap<String,Object>();
		Work work = new Work();
		work.setTid(tid);
		//work.setWid(wid);
		work.setWname(wname);
		//work.setWintro(wintro);
		workService.fileupdate(work);
		dataMap.put("status", "2000");    
		return SUCCESS;    
	} 
	
	//作品删除（管理员权限，根据wid）
	public String workdelete() throws Exception{
		dataMap = new HashMap<String,Object>();
		Work work = new Work();
		work.setWid(wid);
		workService.filedelete(work);
		dataMap.put("status", "2000");        //删除成功
		return SUCCESS; 
	}
		
	//作品分配（根据wid分配给对应的teachid）
	public String workassign() throws Exception{
		dataMap = new HashMap<String,Object>();
		//Work work = new Work();
		//work.setWid(wid);
		//work.setTeachid1(teachid);
		//work.setTeachid2(teachid);
		Work work = workService.query3(wid);
		if((work.getTeachid1()==0) && !(work.getTeachid2()==teachid)){
			work.setTeachid1(teachid);
			workService.fileassign1(work);
			dataMap.put("status", "2000");     //分配成功
			return SUCCESS;
		}else{
			if((work.getTeachid2()==0) && !(work.getTeachid1()==teachid)){
				work.setTeachid2(teachid);
				workService.fileassign2(work);
				dataMap.put("status", "2000");
				return SUCCESS;
			}else{
				dataMap.put("status", "1005");   //分配失败，作品已经分配
				return ERROR;
			}
		}
	}
	
	public String workReAssign() throws Exception{
		dataMap = new HashMap<String,Object>();
		Work work = workService.query3(wid);
		work.setTeachid1(teachid1);
		workService.fileassign1(work);
		work.setTeachid2(teachid2);
		workService.fileassign2(work);
		dataMap.put("status", "2000");
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

	public int getTeachid() {
		return teachid;
	}

	public void setTeachid(int teachid) {
		this.teachid = teachid;
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

package innovation.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import innovation.dao.WorkDAO;
import innovation.model.Work;
import innovation.service.WorkService;

@Service
public class WorkServiceImpl implements WorkService {

	@Autowired
	private WorkDAO workDAO;
	public int save(Work work) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		workDAO.delete(id);
	}

	

	public Work getById(int id) {
		// TODO Auto-generated method stub
		return workDAO.getById(id);
	}

	public List<Work> getAll() {
		// TODO Auto-generated method stub
		return workDAO.getAllWorks();
	}

	public boolean ValidateWid(int wid) {
		// TODO Auto-generated method stub
		if(workDAO.checkWidValidate(wid)==0)
		return false;
		else return true;
	}
	
	public Work fileupload(Work work){               //作品上传
		workDAO.fileupload(work);
		return work;	
	}

	public Work query3(int wid) {                     //作品查询
		// TODO Auto-generated method stub
		Work work= new Work(); 
		work = workDAO.query3(wid);
		if(work==null){
			//System.out.println("work is null");
			work=new Work();
			work.setWid(0);
		}
		return work; 
	}
	
	public Work query(int tid) {                     //作品查询
		// TODO Auto-generated method stub
		System.out.println(tid);
		Work work= new Work(); 
		work = workDAO.query(tid);
		if(work==null){
			//System.out.println("work is null");
			work=new Work();
			work.setWid(0);
		}
		return work; 
	}
	
	public List<HashMap<Integer, Object>> query0() {                      
		List<HashMap<Integer, Object>> list = new ArrayList<HashMap<Integer,Object>>();
		//Work work= new Work(); 
		list = workDAO.query0();
		return list;
	}
	
	public List<HashMap<Integer, Object>> query1(int teachid1) {                      
		List<HashMap<Integer, Object>> list = new ArrayList<HashMap<Integer,Object>>();
		list = workDAO.query1(teachid1);
		return list;
	}
	
	public List<HashMap<Integer, Object>> query2(int teachid2) {                      
		List<HashMap<Integer, Object>> list = new ArrayList<HashMap<Integer,Object>>();
		list = workDAO.query2(teachid2);
		return list;
	}
	
	public void fileupdate(Work work) {            //作品更新
		workDAO.updatework(work);	
	}
	
	public void filedelete(Work work) {            //作品删除标示
		workDAO.updatework2(work);	
	}
	
	public Work fileupload(int tid) {
		// TODO Auto-generated method stub
		return null;
	}

	public void fileassign1(Work work) {
		workDAO.updatework3(work);
	}
	public void fileassign2(Work work) {
		workDAO.updatework4(work);
	}
}

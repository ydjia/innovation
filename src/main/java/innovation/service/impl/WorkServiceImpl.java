package innovation.service.impl;

import java.util.List;

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
	
	public Work fileupload(Work work){                //作品上传
		workDAO.fileupload(work);
		return work;	
	}

	public Work query(int tid) {                      //作品查看
		// TODO Auto-generated method stub
		System.out.println(tid);
		Work work= new Work(); 
		work = workDAO.query(tid);
		if(work==null){
			System.out.println("work is null");
			work=new Work();
			work.setWid(0);
		}
		return work; 
	}
	
	public Work fileupdate(Work work) {    //作品信息更改，包括作品名和作品简介
		// TODO Auto-generated method stub
		workDAO.updatework(work);	
		//System.out.println(work.getWname());
		return null;
	}
	
	public Work fileupload(int tid) {
		// TODO Auto-generated method stub
		return null;
	}

}

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
	
	public Work fileupload(Work work){                //��Ʒ�ϴ�
		workDAO.fileupload(work);
		return work;	
	}

	public Work query(int tid) {                      //��Ʒ�鿴
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
	
	public Work query1(int teachid1) {                      //��Ʒ�鿴
		// TODO Auto-generated method stub
		System.out.println(teachid1);
		Work work= new Work(); 
		work = workDAO.query1(teachid1);
		if(work==null){
			System.out.println("work is null");
			work=new Work();
			work.setWid(0);
		}
		return work; 
	}
	
	public Work query2(int teachid2) {                      //��Ʒ�鿴
		// TODO Auto-generated method stub
		System.out.println(teachid2);
		Work work= new Work(); 
		work = workDAO.query1(teachid2);
		if(work==null){
			System.out.println("work is null");
			work=new Work();
			work.setWid(0);
		}
		return work; 
	}
	
	public Work fileupdate(Work work) {    //��Ʒ��Ϣ��ģ�������Ʒ�����Ʒ���
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

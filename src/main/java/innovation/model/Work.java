package innovation.model;

import java.io.Serializable;



public class Work implements Serializable {

	
	private static final long serialVersionUID = 2840312544577749648L;
	private int wid;
	private int tid;
    private String wname;
    private String wintro;
    private int teachid1;
    private int teachid2;
    private byte mark1;
    private byte mark2;

    public int getWid(){
    	return wid;
    }
    public void setWid(int wid){
    	this.wid = wid;
    }
    public int getTid(){
    	return tid;
    }
    public void setTid(int tid){
    	this.tid = tid;
    }
    public String getWname(){
    	return wname;
    }
    public void setWname(String wname){
    	this.wname = wname;
    }
    public String getWintro(){
    	return wintro;
    }
    public void setWintro(String wintro){
    	this.wintro = wintro;
    }
    public int getTeachid1(){
    	return teachid1;
    }
    public void setTeachid1(int teachid1){
    	this.teachid1 = teachid1;
    }
    public int getTeachid2(){
    	return teachid2;
    }
    public void setTeachid2(int teachid2){
    	this.teachid2 = teachid2;
    }
    public int getMark1(){
    	return mark1;
    }
    public void setMark1(byte mark1){
    	this.mark1 = mark1;
    }
    public int getMark2(){
    	return mark2;
    }
    public void setMark2(byte mark2){
    	this.mark2 = mark2;
    }
}

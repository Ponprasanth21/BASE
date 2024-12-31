package com.bornfire.entities;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
public class rec_no_id implements Serializable{
	
	@Id
	private String appl_ref_no;
	@Id
	private String rec_no;
	public String getAppl_ref_no() {
		return appl_ref_no;
	}
	public void setAppl_ref_no(String appl_ref_no) {
		this.appl_ref_no = appl_ref_no;
	}
	public String getRec_no() {
		return rec_no;
	}
	public void setRec_no(String rec_no) {
		this.rec_no = rec_no;
	}
	
	
	
}

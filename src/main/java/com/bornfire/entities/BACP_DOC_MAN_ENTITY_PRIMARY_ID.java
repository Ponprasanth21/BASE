package com.bornfire.entities;

import java.io.Serializable;

import javax.persistence.Id;

public class BACP_DOC_MAN_ENTITY_PRIMARY_ID implements Serializable{
	
	private String appl_ref_no;
	
	private String unique_id;

	public BACP_DOC_MAN_ENTITY_PRIMARY_ID(String appl_ref_no, String unique_id) {
		super();
		this.appl_ref_no = appl_ref_no;
		this.unique_id = unique_id;
	}
	public BACP_DOC_MAN_ENTITY_PRIMARY_ID() {
		
	}
	public String getAppl_ref_no() {
		return appl_ref_no;
	}
	public void setAppl_ref_no(String appl_ref_no) {
		this.appl_ref_no = appl_ref_no;
	}
	public String getId() {
		return unique_id;
	}
	public void setId(String unique_id) {
		this.unique_id = unique_id;
	}
	
	
}

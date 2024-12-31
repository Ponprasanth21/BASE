package com.bornfire.entities;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ibm.icu.math.BigDecimal;

@Entity
@IdClass(BACP_DOC_MAN_ENTITY_PRIMARY_ID.class)
@Table(name = "BACP_DOC_MAN")
public class BACP_DOC_MAN_ENTITY {
	private String document_type;
	private String document_type_desc;
	private String scan_req;
	private String min_document_req;
	private String document_code;
	private String place_of_issue;
	@Id
	private String unique_id;
	private String issue_date;
	private String expiry_date;
	private String path;
	//@Id
	private String cif_id;
	private String file_name;

	@Lob
	 //@Column (name="upd_file",length=1000)
	private byte[] upd_file;
	@Id
	private String appl_ref_no;
	private String rec_no;
	private String del_flg;

	
	
	public String getDocument_type() {
		return document_type;
	}



	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}



	public String getDocument_type_desc() {
		return document_type_desc;
	}



	public void setDocument_type_desc(String document_type_desc) {
		this.document_type_desc = document_type_desc;
	}



	public String getScan_req() {
		return scan_req;
	}



	public void setScan_req(String scan_req) {
		this.scan_req = scan_req;
	}



	public String getMin_document_req() {
		return min_document_req;
	}



	public void setMin_document_req(String min_document_req) {
		this.min_document_req = min_document_req;
	}



	public String getDocument_code() {
		return document_code;
	}



	public void setDocument_code(String document_code) {
		this.document_code = document_code;
	}



	public String getPlace_of_issue() {
		return place_of_issue;
	}



	public void setPlace_of_issue(String place_of_issue) {
		this.place_of_issue = place_of_issue;
	}



	public String getUnique_id() {
		return unique_id;
	}



	public void setUnique_id(String unique_id) {
		this.unique_id = unique_id;
	}



	public String getIssue_date() {
		return issue_date;
	}



	public void setIssue_date(String issue_date) {
		this.issue_date = issue_date;
	}



	public String getExpiry_date() {
		return expiry_date;
	}



	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}



	public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public String getCif_id() {
		return cif_id;
	}



	public void setCif_id(String cif_id) {
		this.cif_id = cif_id;
	}



	public String getFile_name() {
		return file_name;
	}



	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}



	public byte[] getUpd_file() {
		return upd_file;
	}



	public void setUpd_file(byte[] upd_file) {
		this.upd_file = upd_file;
	}



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



	public String getDel_flg() {
		return del_flg;
	}



	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}



	public BACP_DOC_MAN_ENTITY(String document_type, String document_type_desc, String scan_req,
			String min_document_req, String document_code, String place_of_issue, String unique_id, String issue_date,
			String expiry_date, String path, String cif_id, String file_name, byte[] upd_file, String appl_ref_no,
			String rec_no, String del_flg) {
		super();
		this.document_type = document_type;
		this.document_type_desc = document_type_desc;
		this.scan_req = scan_req;
		this.min_document_req = min_document_req;
		this.document_code = document_code;
		this.place_of_issue = place_of_issue;
		this.unique_id = unique_id;
		this.issue_date = issue_date;
		this.expiry_date = expiry_date;
		this.path = path;
		this.cif_id = cif_id;
		this.file_name = file_name;
		this.upd_file = upd_file;
		this.appl_ref_no = appl_ref_no;
		this.rec_no = rec_no;
		this.del_flg = del_flg;
	}



	public BACP_DOC_MAN_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	
}

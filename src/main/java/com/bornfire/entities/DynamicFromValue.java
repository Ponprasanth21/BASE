package com.bornfire.entities;

import java.sql.Blob;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DynamicFromValue {

	public String doctype;
	public String doccode;
	public String doctypesesc;
	public String uniqueid;
	public String placeofissue;
	public String issuedate;
	public String exprydate;
	public String filename;
	@JsonIgnore
	public Blob file;
	public String recno;
	public String getDoctype() {
		return doctype;
	}
	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}
	public String getDoccode() {
		return doccode;
	}
	public void setDoccode(String doccode) {
		this.doccode = doccode;
	}
	public String getDoctypesesc() {
		return doctypesesc;
	}
	public void setDoctypesesc(String doctypesesc) {
		this.doctypesesc = doctypesesc;
	}
	public String getUniqueid() {
		return uniqueid;
	}
	public void setUniqueid(String uniqueid) {
		this.uniqueid = uniqueid;
	}
	public String getPlaceofissue() {
		return placeofissue;
	}
	public void setPlaceofissue(String placeofissue) {
		this.placeofissue = placeofissue;
	}
	public String getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}
	public String getExprydate() {
		return exprydate;
	}
	public void setExprydate(String exprydate) {
		this.exprydate = exprydate;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Blob getFile() {
		return file;
	}
	public void setFile(Blob file) {
		this.file = file;
	}
	public String getRecno() {
		return recno;
	}
	public void setRecno(String recno) {
		this.recno = recno;
	}


	
	
}

package com.bornfire.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BGLS_DOCUMENT_MANAGER")
public class Bamdocumentmanager {

	private String	branch_id;
	private String	branch_name;
	private String	asset_srl_no;
	private String	asset_name;
	private String	doc_ref_no;
	@Id
	private String	doc_id;
	private String	doc_name;
	private String	doc_desc;
	private String	doc_type;
	private String	doc_group;
	private String	access_type;
	private String	access_group;
	private String	doc_folder;
	private String	doc_location;
	private String	doc_author;
	private String	doc_reviewer;
	private String	upload_flg;
	private String	scan_flg;
	private String	upload_user;
	private String	scan_user;
	private String	remarks_1;
	private String	remarks_2;
	private String	entry_user;
	private String	modify_user;
	private String	auth_user;
	private Date	entry_time;
	private Date	modify_time;
	private Date	auth_time;
	private String	del_flg;
	private String	entity_flg;
	private String	modify_flg;
	private byte[]	document;
	public String getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getAsset_srl_no() {
		return asset_srl_no;
	}
	public void setAsset_srl_no(String asset_srl_no) {
		this.asset_srl_no = asset_srl_no;
	}
	public String getAsset_name() {
		return asset_name;
	}
	public void setAsset_name(String asset_name) {
		this.asset_name = asset_name;
	}
	public String getDoc_ref_no() {
		return doc_ref_no;
	}
	public void setDoc_ref_no(String doc_ref_no) {
		this.doc_ref_no = doc_ref_no;
	}
	public String getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	public String getDoc_name() {
		return doc_name;
	}
	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}
	public String getDoc_desc() {
		return doc_desc;
	}
	public void setDoc_desc(String doc_desc) {
		this.doc_desc = doc_desc;
	}
	public String getDoc_type() {
		return doc_type;
	}
	public void setDoc_type(String doc_type) {
		this.doc_type = doc_type;
	}
	public String getDoc_group() {
		return doc_group;
	}
	public void setDoc_group(String doc_group) {
		this.doc_group = doc_group;
	}
	public String getAccess_type() {
		return access_type;
	}
	public void setAccess_type(String access_type) {
		this.access_type = access_type;
	}
	public String getAccess_group() {
		return access_group;
	}
	public void setAccess_group(String access_group) {
		this.access_group = access_group;
	}
	public String getDoc_folder() {
		return doc_folder;
	}
	public void setDoc_folder(String doc_folder) {
		this.doc_folder = doc_folder;
	}
	public String getDoc_location() {
		return doc_location;
	}
	public void setDoc_location(String doc_location) {
		this.doc_location = doc_location;
	}
	public String getDoc_author() {
		return doc_author;
	}
	public void setDoc_author(String doc_author) {
		this.doc_author = doc_author;
	}
	public String getDoc_reviewer() {
		return doc_reviewer;
	}
	public void setDoc_reviewer(String doc_reviewer) {
		this.doc_reviewer = doc_reviewer;
	}
	public String getUpload_flg() {
		return upload_flg;
	}
	public void setUpload_flg(String upload_flg) {
		this.upload_flg = upload_flg;
	}
	public String getScan_flg() {
		return scan_flg;
	}
	public void setScan_flg(String scan_flg) {
		this.scan_flg = scan_flg;
	}
	public String getUpload_user() {
		return upload_user;
	}
	public void setUpload_user(String upload_user) {
		this.upload_user = upload_user;
	}
	public String getScan_user() {
		return scan_user;
	}
	public void setScan_user(String scan_user) {
		this.scan_user = scan_user;
	}
	public String getRemarks_1() {
		return remarks_1;
	}
	public void setRemarks_1(String remarks_1) {
		this.remarks_1 = remarks_1;
	}
	public String getRemarks_2() {
		return remarks_2;
	}
	public void setRemarks_2(String remarks_2) {
		this.remarks_2 = remarks_2;
	}
	public String getEntry_user() {
		return entry_user;
	}
	public void setEntry_user(String entry_user) {
		this.entry_user = entry_user;
	}
	public String getModify_user() {
		return modify_user;
	}
	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}
	public String getAuth_user() {
		return auth_user;
	}
	public void setAuth_user(String auth_user) {
		this.auth_user = auth_user;
	}
	public Date getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}
	public Date getModify_time() {
		return modify_time;
	}
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	public Date getAuth_time() {
		return auth_time;
	}
	public void setAuth_time(Date auth_time) {
		this.auth_time = auth_time;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public String getEntity_flg() {
		return entity_flg;
	}
	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}
	public String getModify_flg() {
		return modify_flg;
	}
	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}
	public byte[] getDocument() {
		return document;
	}
	public void setDocument(byte[] document) {
		this.document = document;
	}
	public Bamdocumentmanager(String branch_id, String branch_name, String asset_srl_no, String asset_name,
			String doc_ref_no, String doc_id, String doc_name, String doc_desc, String doc_type, String doc_group,
			String access_type, String access_group, String doc_folder, String doc_location, String doc_author,
			String doc_reviewer, String upload_flg, String scan_flg, String upload_user, String scan_user,
			String remarks_1, String remarks_2, String entry_user, String modify_user, String auth_user,
			Date entry_time, Date modify_time, Date auth_time, String del_flg, String entity_flg, String modify_flg,
			byte[] document) {
		super();
		this.branch_id = branch_id;
		this.branch_name = branch_name;
		this.asset_srl_no = asset_srl_no;
		this.asset_name = asset_name;
		this.doc_ref_no = doc_ref_no;
		this.doc_id = doc_id;
		this.doc_name = doc_name;
		this.doc_desc = doc_desc;
		this.doc_type = doc_type;
		this.doc_group = doc_group;
		this.access_type = access_type;
		this.access_group = access_group;
		this.doc_folder = doc_folder;
		this.doc_location = doc_location;
		this.doc_author = doc_author;
		this.doc_reviewer = doc_reviewer;
		this.upload_flg = upload_flg;
		this.scan_flg = scan_flg;
		this.upload_user = upload_user;
		this.scan_user = scan_user;
		this.remarks_1 = remarks_1;
		this.remarks_2 = remarks_2;
		this.entry_user = entry_user;
		this.modify_user = modify_user;
		this.auth_user = auth_user;
		this.entry_time = entry_time;
		this.modify_time = modify_time;
		this.auth_time = auth_time;
		this.del_flg = del_flg;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.document = document;
	}
	public Bamdocumentmanager() {
		super();
		// TODO Auto-generated constructor stub
	}
}

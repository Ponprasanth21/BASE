package com.bornfire.services;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bornfire.entities.AuditTablePojo;
import com.bornfire.entities.BGLSAuditTable;
import com.bornfire.entities.BGLSBusinessTable_Entity;
import com.bornfire.entities.BGLSBusinessTable_Rep;
import com.bornfire.entities.BamDocumentMasRep;
import com.bornfire.entities.Bamdocumentmanager;
import com.bornfire.entities.Chart_Acc_Entity;
import com.bornfire.entities.Chart_Acc_Rep;
import com.bornfire.entities.GeneralLedgerEntity;
import com.bornfire.entities.GeneralLedgerRep;
import com.bornfire.entities.UserProfile;
import com.bornfire.entities.UserProfileRep;

@Service
public class AdminOperServices {
	
	@Autowired
	GeneralLedgerRep generalLedgerRep;
	
	@Autowired
	BamDocumentMasRep BamDocmasRep;
	
	@Autowired
	Chart_Acc_Rep chart_Acc_Rep;
	
	@Autowired
	BGLSBusinessTable_Rep bGLSBusinessTable_Rep;
	
	@Autowired
	UserProfileRep userProfileRep;
	


	public Chart_Acc_Entity getGeneralLedger(String acct_num) {

		/*if (generalLedgerRep.existsById(id)) {
			GeneralLedgerEntity up = generalLedgerRep.findById(id).get();
			return up;
		} else {
			return new GeneralLedgerEntity();
		}*/
		return chart_Acc_Rep.getaedit(acct_num);
	}
	
	public String addGeneralLedger(GeneralLedgerEntity getGeneralLedger, String formmode ,String glsh_code ,
			String GL_CODE ,String userid ) {

		String msg = "";
		 BGLSBusinessTable_Entity audit = new BGLSBusinessTable_Entity();
		if (formmode.equals("add")) {

			GeneralLedgerEntity up = getGeneralLedger;

			up.setDelFlg("N");

			up.setModifyFlg("N");

			generalLedgerRep.save(up);

			msg = "Added Successfully";
			
			 //FOR AUIDT
	        Long auditID = bGLSBusinessTable_Rep.getAuditRefUUID();
	        Optional<UserProfile> up1 = userProfileRep.findById(userid);
			UserProfile user = up1.get();
	       
	     
			LocalDateTime currentDateTime = LocalDateTime.now();
			Date dateValue = Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant());
			audit.setAudit_date(new Date());
			audit.setEntry_time(dateValue);
			audit.setEntry_user(user.getUserid());
			 audit.setFunc_code("Branch Id");
			audit.setRemarks("Added Successfully");
			audit.setAudit_table("BGLS_GENERAL_LED");
			audit.setAudit_screen("GENERAL LEDGER - ADD");
			audit.setEvent_id(user.getUserid());
			audit.setEvent_name(user.getUsername());
			//audit.setModi_details("Login Successfully");
			UserProfile auth_user = userProfileRep.getRole(user.getUserid());
			String auth_user_val = auth_user.getAuth_user();
			Date auth_user_date = auth_user.getAuth_time();
			audit.setAuth_user(auth_user_val);
			audit.setAuth_time(auth_user_date);
			audit.setAudit_ref_no(auditID.toString());
			audit.setField_name("-");
			
			bGLSBusinessTable_Rep.save(audit);
		}
		else if ("edit".equalsIgnoreCase(formmode)) {
			System.out.println("the service getting  gl code is " + GL_CODE);
			System.out.println("the service getting  glsh code is " + glsh_code);
			
			// Fetch existing entity based on GL_CODE and glsh_code
	        GeneralLedgerEntity existingEntity = generalLedgerRep.getsinglevaluedata(GL_CODE, glsh_code);

	        if (Objects.nonNull(existingEntity)) {
	            // Update the existing entity with new values
	            existingEntity.setGlCode(getGeneralLedger.getGlCode());
	            existingEntity.setGlDescription(getGeneralLedger.getGlDescription());
	            existingEntity.setModifyFlg("Y");
	            existingEntity.setDelFlg("N");

	            // Save the updated entity
	            generalLedgerRep.save(existingEntity);

	            msg = "Modify Successfully";
	        } else {
	            msg = "Data Not Found";
	        }

			return msg;
		}
		else if (formmode.equals("delete")) {
			System.out.println("the getting gl code is "+GL_CODE);
			GeneralLedgerEntity up =generalLedgerRep.getRefMaster(GL_CODE);
			up.setDelFlg("Y");
			generalLedgerRep.save(up);
			msg = "Deleted Successfully";
		}
		
		return msg;
	}
	
	//@Value("${document.folder.path}")
	private String documentFolderPath;

	public String DocManaaddedit(Bamdocumentmanager Bamdocumentmanager, String formmode, MultipartFile file) {
	    String msg = "";

	    try {
	        if (formmode.equals("edit")) {
	            Optional<Bamdocumentmanager> up = BamDocmasRep.findById(Bamdocumentmanager.getDoc_id());

	            if (up.isPresent()) {
	                Bamdocumentmanager bamcat = up.get();
	                if(file!=null) {
	                String filePath = saveFile(file, bamcat.getDoc_id());
	                bamcat.setDoc_location(filePath);
	                }
	                bamcat.setModify_time(new Date());
	                bamcat.setDel_flg("N");
	                BamDocmasRep.save(bamcat);
	                msg = "Modified Successfully";
	            }
	        } else if (formmode.equals("add")) {
	        	if(file!=null) {
	            String filePath = saveFile(file, Bamdocumentmanager.getDoc_id());
	            System.out.println(filePath);
	            Bamdocumentmanager.setDoc_location(filePath);
	        	}
	        	Bamdocumentmanager.setDel_flg("N");
	            BamDocmasRep.save(Bamdocumentmanager);
	            msg = "Added Successfully";
	        } else if (formmode.equals("verify")) {
	            Optional<Bamdocumentmanager> up = BamDocmasRep.findById(Bamdocumentmanager.getDoc_id());

	            if (up.isPresent()) {
	                Bamdocumentmanager bamcat = up.get();
	                bamcat.setDel_flg("Y");
	                BamDocmasRep.save(bamcat);
	                msg = "Verified Successfully";
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	        msg = "Document Upload Unsuccessful";
	    }

	    return msg;
	}
	
	private String saveFile(MultipartFile file, String docId) throws IOException {
	    String fileName = docId + "_" + file.getOriginalFilename();
	    String filePath = documentFolderPath + File.separator + fileName;
	    File destinationFile = new File(filePath);
	    file.transferTo(destinationFile);
	    return filePath;
	}
//for audit services

	public List<AuditTablePojo> getauditListLocal(Date fromDateToUse) {
		  List<BGLSBusinessTable_Entity> auditList = bGLSBusinessTable_Rep.getauditListLocalvaluesbusiness(fromDateToUse);
		  List<AuditTablePojo> auditPojoList = new ArrayList<>();

		  for (BGLSBusinessTable_Entity ipsAudit : auditList) {
		      boolean isUpdated = false;
		      
		      // Check if an entry with the same ID already exists
		      for (AuditTablePojo existingPojo : auditPojoList) {
		        String auditRefNo = existingPojo.getAudit_ref_no();
		           String remarks = existingPojo.getRemarks();
		           String ipsAuditno = ipsAudit.getAudit_ref_no();
		       
		          if (auditRefNo != null && ipsAuditno!= null && existingPojo.getAudit_ref_no().equals(ipsAudit.getAudit_ref_no()) &&   remarks != null &&  
		                  ("Login Successfully".equals(existingPojo.getRemarks())
		                    || "Logout Successfully".equals(existingPojo.getRemarks()))) {              // Update the existing entry
		              existingPojo.setAudit_date(ipsAudit.getAudit_date());
		              existingPojo.setAudit_table(ipsAudit.getAudit_table());
		              existingPojo.setFunc_code(ipsAudit.getFunc_code());
		              existingPojo.setEntry_user(ipsAudit.getEntry_user());
		              existingPojo.setEntry_time(ipsAudit.getEntry_time());
		              existingPojo.setAuth_user(ipsAudit.getAuth_user());
		              existingPojo.setAuth_time(ipsAudit.getAuth_time());
		              existingPojo.setRemarks(ipsAudit.getRemarks());

		              List<String> fieldName = new ArrayList<>();
		              List<String> oldvalue = new ArrayList<>();
		              List<String> newvalue = new ArrayList<>();
		              String[] dd = ipsAudit.getModi_details().split("\\|\\|");

		              for (String str : dd) {
		                  String[] str1 = str.split("\\+");
		                  if (str1.length > 0) {
		                      fieldName.add(str1[0]);
		                  }

		                  if (str1.length > 1) {
		                      oldvalue.add(str1[1]);
		                  }

		                  if (str1.length > 2) {
		                      newvalue.add(str1[2]);
		                  }
		              }

		              existingPojo.setFieldName(fieldName);
		              existingPojo.setOldvalue(oldvalue);
		              existingPojo.setNewvalue(newvalue);

		              isUpdated = true;
		              break;
		          }
		      }

		      // If no existing entry was updated, create a new one
		      if (!isUpdated) {
		          AuditTablePojo auditTablePojo = new AuditTablePojo();
		          auditTablePojo.setAudit_date(ipsAudit.getAudit_date());
		          auditTablePojo.setAudit_table(ipsAudit.getAudit_table());
		          auditTablePojo.setFunc_code(ipsAudit.getFunc_code());
		          auditTablePojo.setEntry_user(ipsAudit.getEntry_user());
		          auditTablePojo.setEntry_time(ipsAudit.getEntry_time());
		          auditTablePojo.setAuth_user(ipsAudit.getAuth_user());
		          auditTablePojo.setRemarks(ipsAudit.getRemarks());

		          List<String> fieldName = new ArrayList<>();
		          List<String> oldvalue = new ArrayList<>();
		          List<String> newvalue = new ArrayList<>();
		          if (ipsAudit != null && ipsAudit.getModi_details() != null) {
		        	   String[] dd = ipsAudit.getModi_details().split("\\|\\|");

				          for (String str : dd) {
				              String[] str1 = str.split("\\+");
				              if (str1.length > 0) {
				                  fieldName.add(str1[0]);
				              }

				              if (str1.length > 1) {
				                  oldvalue.add(str1[1]);
				              }

				              if (str1.length > 2) {
				                  newvalue.add(str1[2]);
				              }
				          }
		        	    // Continue with your logic
		        	} else {
		        	    // Handle the case where ipsAudit or ipsAudit.getModi_details() is null
		        	    System.out.println("No message available");
		        	}
		       

		          auditTablePojo.setFieldName(fieldName);
		          auditTablePojo.setOldvalue(oldvalue);
		          auditTablePojo.setNewvalue(newvalue);

		          auditPojoList.add(auditTablePojo);
		      }
		  }

		  

		  return auditPojoList;
		 }

}

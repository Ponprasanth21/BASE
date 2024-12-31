package com.bornfire.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Env;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bornfire.entities.BGLS_BAMAssetFlows_Entity;
import com.bornfire.entities.BGLS_BAMInventorymaster;
import com.bornfire.entities.BGLS_Bamcatcodemaintainrep;
import com.bornfire.entities.BGLS_Bamcategorycodemain_entity;
import com.bornfire.entities.GeneralLedgerEntity;
import com.bornfire.entities.GeneralLedgerWork_Entity;

import ch.qos.logback.classic.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

@Service
public class BGLS_Inventeryservice {
	
	
	@Autowired
	com.bornfire.entities.BGLS_BAMInventryMastRep BGLS_BAMInventryMastRep;
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	BGLS_Bamcatcodemaintainrep BGLS_Bamcatcodemaintainrep;
	@Autowired
	com.bornfire.entities.BGLS_BAMAssetFlows_Rep BGLS_BAMAssetFlows_Rep;
	@Autowired
	CustomerRequestService customerRequestService;
/////Inventory Master
	public String Invmastadd(BGLS_BAMInventorymaster BAMInventorymaster, String formmode, String InvMastadd, String userId, String depr_method, String depr_percent, String headcode, String categorycode, String subcategorycode) throws KeyManagementException, NoSuchAlgorithmException {

	    String msg = "";

	    if (InvMastadd.equals("InvMastadd")) {

	        if (formmode.equals("add")) {

	            Session hs = sessionFactory.getCurrentSession();
	            DecimalFormat numformate = new DecimalFormat("000000");
	            String cate_code = "0";

				/*
				 * BigDecimal billNumber = (BigDecimal)
				 * hs.createNativeQuery("SELECT NEXT VALUE FOR INVENTORY_SRL_NO AS SRL_NO;\r\n"
				 * + "") .getSingleResult();
				 */
	            BigInteger billNumberAsBigInt = (BigInteger) hs.createNativeQuery(
	            	    "SELECT NEXT VALUE FOR INVENTORY_SRL_NO AS SRL_NO;")
	            	    .getSingleResult();

	            	BigDecimal billNumber = new BigDecimal(billNumberAsBigInt);

	            String serialno = numformate.format(billNumber);

	            System.out.println("Sequence is : " + serialno);
	            if (categorycode.equals("I")) {
	                cate_code = "01";
	            } else if (categorycode.equals("II")) {
	                cate_code = "02";
	            } else if (categorycode.equals("III")) {
	                cate_code = "03";
	            } else if (categorycode.equals("IV")) {
	                cate_code = "04";
	            }

	            String AssetSrlNo = BAMInventorymaster.getSol_id() + BAMInventorymaster.getLoc_type() + headcode + cate_code + subcategorycode + serialno;

	            System.out.println("Asset serial no is : " + AssetSrlNo);

	            BGLS_BAMInventorymaster bamcat = BAMInventorymaster;
	            bamcat.setAsst_srl_no(AssetSrlNo);
	            bamcat.setEntry_user(userId);
	            bamcat.setEntity_flg("Y");
	            bamcat.setEntry_time(new Date());
	            bamcat.setDel_flg("N");
	            bamcat.setVerify_flg("N");
	            System.out.println("The ins : " + depr_method);
	            System.out.println("depr_percent: " + BAMInventorymaster.getDepr_percent());
	            if (depr_percent != null && !depr_percent.trim().isEmpty()) {
	                bamcat.setDepr_percent(BAMInventorymaster.getDepr_percent());
	                bamcat.setDepr_method(depr_method);
	            } else {
	                System.out.println("The percent is either null or empty.");
	            }
	            BGLS_BAMInventryMastRep.save(bamcat);
	            msg = "Asset " + AssetSrlNo + " Generated Successfully...";
	        }

	         else if(formmode.equals("edit")){
			
			Optional<BGLS_BAMInventorymaster> BAMInvms = BGLS_BAMInventryMastRep.findById(BAMInventorymaster.getAsst_srl_no());
			if(BAMInvms.isPresent()) {
				BGLS_BAMInventorymaster bamcat = BAMInvms.get();
				bamcat.setAsst_name(BAMInventorymaster.getAsst_name());

				bamcat.setAsset_head(BAMInventorymaster.getAsset_head());
				bamcat.setAsset_category(BAMInventorymaster.getAsset_category());
				bamcat.setAsset_sub_category(BAMInventorymaster.getAsset_sub_category());
				bamcat.setCategory_desc(BAMInventorymaster.getCategory_desc());
				bamcat.setAsset_type(BAMInventorymaster.getAsset_type());
				bamcat.setAsst_crncy(BAMInventorymaster.getAsst_crncy());

				bamcat.setDate_of_purchase(BAMInventorymaster.getDate_of_purchase());

				bamcat.setYear_of_purchase(BAMInventorymaster.getYear_of_purchase());
				bamcat.setOrg_cost(BAMInventorymaster.getOrg_cost());
				bamcat.setAsst_exp_date(BAMInventorymaster.getAsst_exp_date());

				bamcat.setAsst_exp_date(BAMInventorymaster.getAsst_exp_date());
				bamcat.setAsst_rmks(BAMInventorymaster.getAsst_rmks());
				bamcat.setDepr_flag(BAMInventorymaster.getDepr_flag());
				bamcat.setDepr_freq(BAMInventorymaster.getDepr_freq());

			    System.out.println("The");
				if (depr_percent != null && !depr_percent.trim().isEmpty()) {
				    bamcat.setDepr_percent(BAMInventorymaster.getDepr_percent());
				    System.out.println(depr_method);
				    bamcat.setDepr_method(depr_method);
				} else {
				    System.out.println("The percent is either null or empty.");
				}
				bamcat.setAcc_depr(BAMInventorymaster.getAcc_depr());
				bamcat.setLife_span_mth(BAMInventorymaster.getLife_span_mth());

				bamcat.setDate_of_last_depr(BAMInventorymaster.getDate_of_last_depr());
				bamcat.setDate_of_acqn(BAMInventorymaster.getDate_of_acqn());
				bamcat.setDate_of_last_tfr(BAMInventorymaster.getDate_of_last_tfr());
				bamcat.setCur_book_value(BAMInventorymaster.getCur_book_value());
				bamcat.setMkt_value(BAMInventorymaster.getMkt_value());
				bamcat.setLoc_type(BAMInventorymaster.getLoc_type());
				bamcat.setSol_id(BAMInventorymaster.getSol_id());
				bamcat.setEmp_id(BAMInventorymaster.getEmp_id());
				bamcat.setDept_div_name(BAMInventorymaster.getDept_div_name());
				bamcat.setLoca_addr(BAMInventorymaster.getLoca_addr());
				bamcat.setLoc_rmks(BAMInventorymaster.getLoc_rmks());
				bamcat.setGtee_amt(BAMInventorymaster.getGtee_amt());
				bamcat.setGtee_amt_percent(BAMInventorymaster.getGtee_amt_percent());
				bamcat.setNom_depr_amt(BAMInventorymaster.getNom_depr_amt());
				bamcat.setDepr_rmks(BAMInventorymaster.getDepr_rmks());
				System.out.println("Modify service "+BAMInventorymaster.getVerify_user());
				bamcat.setModify_user(userId);
				bamcat.setModify_time(new Date());
				bamcat.setDel_flg("N");
				bamcat.setModify_flg("Y");
				bamcat.setVerify_flg("N");
				BGLS_BAMInventryMastRep.save(bamcat);
				msg = "Modified Successfully";
			}else {
				msg="Not a valid id";
			}
			
			
			
		}else if(formmode.equals("verify")){
			
			Optional<BGLS_BAMInventorymaster> BAMInvms = BGLS_BAMInventryMastRep.findById(BAMInventorymaster.getAsst_srl_no());
			if(BAMInvms.isPresent()) {
				
				BGLS_BAMInventorymaster bamcat = BAMInvms.get();
				 bamcat.setVerify_user(userId); // Assuming there is a setVerify_user method
				    bamcat.setVerify_time(new Date());
				    System.out.println("verify service "+BAMInventorymaster.getVerify_user());
				bamcat.setVerify_flg("Y");
				BGLS_BAMInventryMastRep.save(bamcat);
				msg = "Verified Successfully";
			}else {
				msg="Error Occured !!!";
			}
			
		}else {
			msg = "Invalid Option Please contact Administrator";
		}
		}else if(InvMastadd.equals("InvTransadd")) {
			
		}
		return msg;
	}

	
	
	public String Catecodemaintain(BGLS_Bamcategorycodemain_entity Bamcategorycodemain, String formmode,String headcode,String categorycode,String subcategorycode) {

		String msg = "";

		if (formmode.equals("edit")) {
			System.out.println("The id is : "+Bamcategorycodemain.getSl_no());
			System.out.println("The id is : "+Bamcategorycodemain.getSl_no());
			Optional<BGLS_Bamcategorycodemain_entity> up = BGLS_Bamcatcodemaintainrep.findById(Bamcategorycodemain.getSl_no());
			
			if(up.isPresent()) {
				BGLS_Bamcategorycodemain_entity bamcat = up.get();

				bamcat.setSolid(Bamcategorycodemain.getSolid());
				//bamcat.setLocation(Bamcategorycodemain.getLocation());
				bamcat.setDepreciation_fund_account(Bamcategorycodemain.getDepreciation_fund_account());
				//bamcat.setDepreciation_method(Bamcategorycodemain.getDepreciation_method());
				bamcat.setDepreciation_pandl_account(Bamcategorycodemain.getDepreciation_pandl_account());
				//bamcat.setDepreciation_percentage(Bamcategorycodemain.getDepreciation_percentage());
				bamcat.setAsset_account_number(Bamcategorycodemain.getAsset_account_number());
				BGLS_Bamcatcodemaintainrep.save(bamcat);
			
				msg = "Modified Successfully";
			}

		}else if (formmode.equals("add")) {
			
			Session session = sessionFactory.getCurrentSession();

        	String asset_code = Bamcategorycodemain.getAsset_code();
 		    Long count = (Long) session.createQuery("SELECT COUNT(sp) FROM Bamcategorycodemain sp WHERE sp.asset_code = :asset_code")
 		                               .setParameter("asset_code", asset_code)
 		                               .uniqueResult();

 		    if (count > 0) {
 		        msg = " Asset Code already exists. Please Give different ...";
 		    } else {
			
			Session hs = sessionFactory.getCurrentSession();
			BGLS_Bamcategorycodemain_entity bamcat = new BGLS_Bamcategorycodemain_entity();
			DecimalFormat numformate = new DecimalFormat("00");
			BigDecimal billNumber = (BigDecimal) hs.createNativeQuery("SELECT GENERATE_SRL_NO.NEXTVAL AS SRL_NO FROM DUAL")
					.getSingleResult();
			String serialno = numformate.format(billNumber);

			bamcat.setSl_no(serialno);
			bamcat.setHead_code(headcode);
			bamcat.setHead_description(Bamcategorycodemain.getHead_description());
			bamcat.setCategory_code(categorycode);
			bamcat.setCategory_description(Bamcategorycodemain.getCategory_description());
			bamcat.setSub_category_code(subcategorycode);
			bamcat.setSub_category_description(Bamcategorycodemain.getSub_category_description());
			bamcat.setAsset_code(Bamcategorycodemain.getAsset_code());
			bamcat.setAsset_account_number(Bamcategorycodemain.getAsset_account_number());
			bamcat.setDepreciation_fund_account(Bamcategorycodemain.getDepreciation_fund_account());
			//bamcat.setDepreciation_method(Bamcategorycodemain.getDepreciation_method());
			bamcat.setDepreciation_pandl_account(Bamcategorycodemain.getDepreciation_pandl_account());
			//bamcat.setDepreciation_percentage(Bamcategorycodemain.getDepreciation_percentage());
			bamcat.setSolid(Bamcategorycodemain.getSolid());
			//bamcat.setLocation(Bamcategorycodemain.getLocation());
			msg = "Added Successfully";
			
			BGLS_Bamcatcodemaintainrep.save(bamcat);
 		    }
		}
		return msg;
	}public String deletesrn(String asn) {
	    // Attempt to find the entity by its ID (ASN)
	    Optional<BGLS_Bamcategorycodemain_entity> optionalEntity = BGLS_Bamcatcodemaintainrep.findById(asn);

	    if (optionalEntity.isPresent()) {
	        // If the entity exists, delete it
	    	BGLS_Bamcatcodemaintainrep.delete(optionalEntity.get());
	        return "Deleted Successfully!";
	    } else {
	        // If the entity does not exist, return an appropriate message
	        return "Deletion Failed: Entity with ASN " + asn + " does not exist.";
	    }
	}

	public ResponseEntity<String> add_Assets(List<BGLS_BAMAssetFlows_Entity> BAM_AssetFlows_Entity, String formmode) {

	    ResponseEntity<String> msg = null;
	    try {
	        if ("add".equals(formmode)) {
	            Session session = sessionFactory.getCurrentSession();

	            String asset_serial_no = BAM_AssetFlows_Entity.get(0).getAsset_serial_no();
	            Long count = (Long) session.createQuery("SELECT COUNT(sp) FROM BGLS_BAMAssetFlows_Entity sp WHERE sp.asset_serial_no = :asset_serial_no")
	                                       .setParameter("asset_serial_no", asset_serial_no)
	                                       .uniqueResult();

	            if (count > 0) {
	                msg = ResponseEntity.ok("Asset serial number " + asset_serial_no + " already exists. Please provide a different Asset.");
	            } else {
	                for (BGLS_BAMAssetFlows_Entity param : BAM_AssetFlows_Entity) {
	                	BigInteger srl_no_bigint = (BigInteger) session.createNativeQuery("SELECT NEXT VALUE FOR ASSET_SRL_NO;")
                                .getSingleResult();
BigDecimal srl_no = new BigDecimal(srl_no_bigint);
param.setSrl_no(srl_no);
System.out.println(param.getAsset_serial_no()+"param");
	                    param.setAsset_serial_no(param.getAsset_serial_no());
	                    param.setGen_roll_no(param.getGen_roll_no());
	                    param.setGen_verify_flg("N");
	                    param.setGen_modify_flg("N");
	                    
	                    // Save the entity using the repository
	                    BGLS_BAMAssetFlows_Rep.save(param);
	                }
	                msg = ResponseEntity.ok("Assets Flow added successfully.");
	            }
	        } else {
	            msg = ResponseEntity.badRequest().body("Invalid form mode: " + formmode);
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); // You may want to log the exception instead of printing the stack trace
	        msg = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
	    }

	    return msg;
	}

	
	public String Uploadgstserviceone(String screenId, MultipartFile file, String userid, GeneralLedgerWork_Entity GeneralLedgerWork_Entity)
	        throws FileNotFoundException, SQLException, IOException, NullPointerException {
	    System.out.println("first tservice testing GST EXCEL UPLOAD");
	    
	    // Create an instance of FileUploadServices
	 //   FileUploadServices fileUploadServices = new FileUploadServices();
	    
	    // Call the non-static UploadPO method on the instance
	    String msg = customerRequestService.Uploadgstservicetwo(screenId, file, userid, GeneralLedgerWork_Entity);
	    
	    return msg;
	}
	
	
	
}


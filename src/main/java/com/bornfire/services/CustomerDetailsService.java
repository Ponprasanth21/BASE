package com.bornfire.services;

import java.math.BigDecimal;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import com.bornfire.entities.BACP_CUS_PROFILE_REPO;
import com.bornfire.entities.BACP_DOC_MAN_ENTITY;
import com.bornfire.entities.BACP_DOC_MAN_REP;
import com.bornfire.entities.Bacp_Signature_master;
import com.bornfire.entities.Bacp_Signature_masterRepo;
import com.bornfire.entities.CustomerDetails;
import com.bornfire.entities.CustomerRequest;
import com.bornfire.entities.EKYCMinimalData;
import com.bornfire.entities.MinimalDataRepository;
import com.bornfire.entities.ParameterRep;
import com.bornfire.entities.ParametersDetails;

@Service
@ConfigurationProperties("output")
@Transactional
public class CustomerDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(LoginServices.class);

	@Autowired
	BACP_DOC_MAN_REP bacpRep;

	@Autowired
	Bacp_Signature_masterRepo bacp_Signature_masterRepo;

	@Autowired
	MinimalDataRepository minimaldatarepository;

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	ParameterRep parameterRep;
	@Autowired
	BACP_CUS_PROFILE_REPO bACP_CUS_PROFILE_REPO;

	@SuppressWarnings("unchecked")
	public Object getconstomerList(String appl_ref_no) {

		List<CustomerDetails> cnt1 = (List<CustomerDetails>) sessionFactory.getCurrentSession()
				.createQuery("from CustomerDetails ").getResultList();

		return cnt1;

	}

	@SuppressWarnings("unchecked")
	public CustomerDetails getUser(String appl_ref_no) {

		List<CustomerDetails> cnt1 = (List<CustomerDetails>) sessionFactory.getCurrentSession()
				.createQuery("from CustomerDetails where appl_ref_no=?1").setParameter(1, appl_ref_no).getResultList();

		if (cnt1.size() > 0) {
			return cnt1.get(0);
		} else {
			return new CustomerDetails();
		}
	}

	public String addAlert(ParametersDetails parametersde, String formmode,String userid) {
		// TODO Auto-generated method stub
		String msg = "";

		/* try { */

		if (formmode.equals("add")) {
			parametersde.getRefnumber();
			System.out.println(parametersde.getRefnumber()+"parametersde.getRefnumber()");
			ParametersDetails up = parametersde;
			
			parametersde.setEntity_cre_flg("Y");
			parametersde.setDocuments_flg("Y");
			parametersde.setAlert_flg("Y");
			parametersde.setApproval_flg("Y");
			parametersde.setModify_flg("N");
			parametersde.setVerify_flg("N");
			parametersde.setDel_flg("N");
			parametersde.setEntry_user(userid);
	        LocalDateTime now = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formattedDate = now.format(formatter);
			parametersde.setEntry_time(formattedDate);
			System.out.println("User Created Successfully" + up.getSol_id() + " with " + up.getRefnumber() + " and "
					+ up.getCheck_list());
			parameterRep.save(up);
			
			msg = "User Created Successfully";

		}
		// When the user data modifed and submitted.

		else if (formmode.equals("edit")) {
			ParametersDetails up = parametersde;

			// up.setApproval_flg("N");
			parameterRep.save(up);

			msg = "User Edited Successfully";

		}

		return msg;
	}

	public String remarks(String ApprefNO, String hold_remarks) {
		String msg = null;
		System.out.println(" ApprefNO : " + ApprefNO);
		System.out.println(" remarks : " + hold_remarks);
		Session hs = sessionFactory.getCurrentSession();
		try {
			EKYCMinimalData EY = minimaldatarepository.findByapplref(ApprefNO);
			EY.setHold_remarks(hold_remarks);
			hs.saveOrUpdate(EY);
			msg = "successfully updated";
		} catch (Exception e) {
			msg = "Error Occurred";
		}
		return msg;
	}

	public String remarkss(String ApprefNO, String hold_remarks) {
		String msg = null;
		System.out.println(" ApprefNO : " + ApprefNO);
		System.out.println(" remarks : " + hold_remarks);
		Session hs = sessionFactory.getCurrentSession();
		try {
			CustomerRequest EYs = bACP_CUS_PROFILE_REPO.findByapplrefs(ApprefNO);
			EYs.setHold_remarks(hold_remarks);
			hs.saveOrUpdate(EYs);
			msg = "successfully updated";
		} catch (Exception e) {
			msg = "Error Occurred";
		}
		return msg;
	}

	public String minimalsign(String appl_ref_no, String srcURL, String dataURL, String imgaccesscode, String group,
			String keyword, BigDecimal numberElement,String cif_id) {

		String msg = null;
		try {
			Bacp_Signature_master signatureEntity = new Bacp_Signature_master();

			Integer srlno = bacp_Signature_masterRepo.srlnum();
			signatureEntity.setSrl_no(srlno);
			signatureEntity.setAppl_ref_no(appl_ref_no);
			byte[] buff = srcURL.getBytes();
			Blob blob = new SerialBlob(buff);
			signatureEntity.setImg_access_code(imgaccesscode);
			signatureEntity.setImg_group(group);
			signatureEntity.setKeyword(keyword);
			signatureEntity.setRec_no(numberElement);
			signatureEntity.setSign(blob);
			signatureEntity.setPhoto(dataURL.getBytes());
			signatureEntity.setCif_id(cif_id);
			signatureEntity.setDel_flg("N");
			bacp_Signature_masterRepo.save(signatureEntity);

			msg = "Signature details Uploaded successfully...";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Signature details Upload Unsuccessfull...";
		}

		return msg;
	}

	public String Approve_acc(String ApprefNO, String rec_no) {
		String msg = null;
		System.out.println(" ApprefNO : " + ApprefNO);
		System.out.println(" rec_no : " + rec_no);
		Session session = sessionFactory.openSession();
		try {
			Integer cif_id = bACP_CUS_PROFILE_REPO.cif_id();
			Integer Acc_id = bACP_CUS_PROFILE_REPO.Acc_id();
			System.out.println("cif id iss" + cif_id);
			System.out.println("Acc id iss" + Acc_id);
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);
			up.setApproval_flg("Y");
			up.setCif_id("CIF" + cif_id);
			up.setAccount_id(Acc_id.toString());
			bACP_CUS_PROFILE_REPO.save(up);

			EKYCMinimalData as = minimaldatarepository.findByref_norec(ApprefNO, rec_no);
			as.setCif_id("CIF" + cif_id);
			minimaldatarepository.save(as);

			Bacp_Signature_master on = bacp_Signature_masterRepo.findByref_norec(ApprefNO, rec_no);
			on.setCif_id("CIF" + cif_id);
			bacp_Signature_masterRepo.save(on);

			List<BACP_DOC_MAN_ENTITY> Mo = bacpRep.findByref_norec(ApprefNO, rec_no);
			for (int i = 0; i < Mo.size(); i++) {
				Mo.get(i).setCif_id("CIF" + cif_id);
			}
			session.saveOrUpdate(Mo);
			msg = "CIF" + cif_id;

		} catch (Exception e) {
			msg = "";
		}
		return msg;
	}
	//for customer details
	@SuppressWarnings("unchecked")
	public Object getCustomerSchemelist(String appl_ref_no) {
		
		List<CustomerRequest> cnt1 = (List<CustomerRequest>) sessionFactory.getCurrentSession()
				.createQuery("from CustomerRequest where STATUS!='REJECT'").getResultList();
	
		return cnt1;
		
	}

}

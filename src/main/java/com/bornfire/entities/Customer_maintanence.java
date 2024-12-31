package com.bornfire.entities;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="BACP_MAIN_CUSTOMERDETAILS")
public class Customer_maintanence {
	
	
	private String	cm_gd_title;
	
	@Id
	private String	cm_gd_firstname;
	private String	cm_gd_middlename;
	private String	cm_gd_lastname;
	private String	cm_gd_fullname;
	private String	cm_gd_preferredname;
	private String	cm_gd_gender;
	@DateTimeFormat(pattern = "YYYY-MM-dd")
	private Date	cm_gd_dob;
	private String	cm_gd_mothermaidenname;
	private String	cm_gd_cob;
	private String	cm_gd_minorindicator;
	private String	cm_gd_minorturnmajoron;
	private String	cm_gd_seniorcitizen;
	private String	cm_gd_seniorcitizenapp;
	private String	cm_gd_nonresiindicator;
	private String	cm_gd_turnnonresion;
	private String	cm_gd_staffindi;
	private String	cm_gd_staffid;
	private String	cm_gd_bankswiftcodeindi;
	private String	cm_gd_custswiftcode;
	private String	cm_gd_custtype;
	private String	cm_gd_custstatus;
	@DateTimeFormat(pattern = "YYYY-MM-dd")
	private Date	cm_gd_dod;
	@DateTimeFormat(pattern = "YYYY-MM-dd")
	private Date	cm_gd_don;
	private String	cm_gd_segment;
	private String	cm_gd_subsegment;
	private String	cm_gd_chargelevcode;
	private String	cm_gd_ratedoneon;
	private String	cm_gd_healthcode;
	private String	cm_gd_priority;
	private String	cm_gd_phystate;
	private String	cm_gd_offordebitlim;
	private String	cm_gd_community;
	private String	cm_gd_custrating;
	private String	cm_gd_prefercode;
	private String	cm_gd_avalidtradeser;
	private String	cm_gd_secureid;
	private String	cm_gd_riskprofscore;
	@DateTimeFormat(pattern = "YYYY-MM-dd")
	private Date	cm_gd_riskprodexpdate;
	private String	cm_gd_credirbureauscore;
	private String	cm_gd_addinstaldet;
	private String	cm_gd_riskrating;
	private String	cm_gd_region;
	private String	cm_gd_constcode;
	private String	cm_gd_taxdebsrceid;
	private String	cm_gd_taxdebscretab;
	private String	cm_gd_assestcalssficntrl;
	private String	cm_gd_custlevprovi;
	private String	cm_gd_islamicbankcust;
	private String	cm_gd_zakatdeduction;
	private String	cm_gd_preferredcal;
	private String	cm_gd_prefecommchan;
	private String	cm_gd_baseccy;
	private String	cm_gd_remarks;
	private String	cm_gd_purgeallowed;
	private String	cm_gd_delinquentcust;
	private String	cm_gd_preflocale;
	private String	cm_gd_enablecrmalrts;
	private String	cm_gd_defchanforcrmalrts;
	private String	cm_gd_custtypebeforeconv;
	@DateTimeFormat(pattern = "YYYY-MM-dd")
	private Date	cm_gd_lastupdate;
	@DateTimeFormat(pattern = "YYYY-MM-dd")
	private Date	cm_gd_converstion;
	@DateTimeFormat(pattern = "YYYY-MM-dd")
	private Date	cm_gd_kycdate;
	@DateTimeFormat(pattern = "YYYY-MM-dd")
	private Date	cm_gd_kycrevdate;
	private String	cm_gd_subforkyc;
	private String	cm_gd_prmysolid;
	private String	cm_gd_sector;
	private String	cm_gd_subsector;
	private String	cm_eb_enableebanking;
	private BigDecimal	cm_eb_smsbankmobnum;
	private String	cm_eb_wapbanking;
	private String	cm_eb_smsbanking;
	private String	cm_rmd_prmyrelmangrid;
	private String	cm_rmd_secrelmanager;
	@DateTimeFormat(pattern = "YYYY-MM-dd")
	private Date	cm_rmd_relstartdate;
	private String	cm_rmd_relcreatedby;
	private String	cm_rmd_relationshiplevel;
	private String	cm_rmd_prmycampsource;
	private String	cm_lp_natlangcode;
	private String	cm_lp_prefnativelang;
	private String	cm_lp_titlenatlang;
	private String	cm_lp_namenatlang;
	private String	cm_lp_firstname;
	private String	cm_lp_middlename;
	private String	cm_lp_lastname;
	private String	cm_lp_shortname;
	private String	cm_lp_lastname1;
	private String	cm_lp_middlename1;
	private String	cm_lp_fisrtname1;
	private String	cm_lp_shortname1;
	private String	cont_det_addtype;
	private String	cont_det_premisename;
	private BigDecimal	cont_det_houseno;
	private BigDecimal	cont_det_streetno;
	private String	ccont_det_streetname;
	private String	cont_det_buildlevel;
	private String	cont_det_subrub;
	private String	cont_det_town;
	private String	cont_det_locality;
	private String	cont_det_city;
	private String	cont_det_state;
	private String	cont_det_country;
	private String	cont_det_postalcode;
	private String	cont_det_addvalidfrom;
	private String	cont_det_addvalidstill;
	private String	cur_mast_ccy;
	private String	cur_mast_crdispcnt;
	private String	cur_mast_drdispcnt;
	private String	cur_mast_withholdtaxpnt;
	private String	cur_mast_withholdtaxflrlimt;
	@DateTimeFormat(pattern = "YYYY-MM-dd")
	private Date	cur_mast_prefexpydate;
	private String	doc_mas_documenttype;
	private String	doc_mas_documentcode;
	private String	doc_mas_doctypedesc;
	private String	doc_mas_uniqueid;
	private String	doc_mas_placeofissues;
	@DateTimeFormat(pattern = "dd-MMM-YYYY")
	private Date	doc_mas_issuedate;
	@DateTimeFormat(pattern = "dd-MMM-YYYY")
	private Date	doc_mas_expydate;
	
	@Lob
	private byte[]	doc_mas_uploadfile;

	public String getCm_gd_title() {
		return cm_gd_title;
	}

	public void setCm_gd_title(String cm_gd_title) {
		this.cm_gd_title = cm_gd_title;
	}

	public String getCm_gd_firstname() {
		return cm_gd_firstname;
	}

	public void setCm_gd_firstname(String cm_gd_firstname) {
		this.cm_gd_firstname = cm_gd_firstname;
	}

	public String getCm_gd_middlename() {
		return cm_gd_middlename;
	}

	public void setCm_gd_middlename(String cm_gd_middlename) {
		this.cm_gd_middlename = cm_gd_middlename;
	}

	public String getCm_gd_lastname() {
		return cm_gd_lastname;
	}

	public void setCm_gd_lastname(String cm_gd_lastname) {
		this.cm_gd_lastname = cm_gd_lastname;
	}

	public String getCm_gd_fullname() {
		return cm_gd_fullname;
	}

	public void setCm_gd_fullname(String cm_gd_fullname) {
		this.cm_gd_fullname = cm_gd_fullname;
	}

	public String getCm_gd_preferredname() {
		return cm_gd_preferredname;
	}

	public void setCm_gd_preferredname(String cm_gd_preferredname) {
		this.cm_gd_preferredname = cm_gd_preferredname;
	}

	public String getCm_gd_gender() {
		return cm_gd_gender;
	}

	public void setCm_gd_gender(String cm_gd_gender) {
		this.cm_gd_gender = cm_gd_gender;
	}

	public Date getCm_gd_dob() {
		return cm_gd_dob;
	}

	public void setCm_gd_dob(Date cm_gd_dob) {
		this.cm_gd_dob = cm_gd_dob;
	}

	public String getCm_gd_mothermaidenname() {
		return cm_gd_mothermaidenname;
	}

	public void setCm_gd_mothermaidenname(String cm_gd_mothermaidenname) {
		this.cm_gd_mothermaidenname = cm_gd_mothermaidenname;
	}

	public String getCm_gd_cob() {
		return cm_gd_cob;
	}

	public void setCm_gd_cob(String cm_gd_cob) {
		this.cm_gd_cob = cm_gd_cob;
	}

	public String getCm_gd_minorindicator() {
		return cm_gd_minorindicator;
	}

	public void setCm_gd_minorindicator(String cm_gd_minorindicator) {
		this.cm_gd_minorindicator = cm_gd_minorindicator;
	}

	public String getCm_gd_minorturnmajoron() {
		return cm_gd_minorturnmajoron;
	}

	public void setCm_gd_minorturnmajoron(String cm_gd_minorturnmajoron) {
		this.cm_gd_minorturnmajoron = cm_gd_minorturnmajoron;
	}

	public String getCm_gd_seniorcitizen() {
		return cm_gd_seniorcitizen;
	}

	public void setCm_gd_seniorcitizen(String cm_gd_seniorcitizen) {
		this.cm_gd_seniorcitizen = cm_gd_seniorcitizen;
	}

	public String getCm_gd_seniorcitizenapp() {
		return cm_gd_seniorcitizenapp;
	}

	public void setCm_gd_seniorcitizenapp(String cm_gd_seniorcitizenapp) {
		this.cm_gd_seniorcitizenapp = cm_gd_seniorcitizenapp;
	}

	public String getCm_gd_nonresiindicator() {
		return cm_gd_nonresiindicator;
	}

	public void setCm_gd_nonresiindicator(String cm_gd_nonresiindicator) {
		this.cm_gd_nonresiindicator = cm_gd_nonresiindicator;
	}

	public String getCm_gd_turnnonresion() {
		return cm_gd_turnnonresion;
	}

	public void setCm_gd_turnnonresion(String cm_gd_turnnonresion) {
		this.cm_gd_turnnonresion = cm_gd_turnnonresion;
	}

	public String getCm_gd_staffindi() {
		return cm_gd_staffindi;
	}

	public void setCm_gd_staffindi(String cm_gd_staffindi) {
		this.cm_gd_staffindi = cm_gd_staffindi;
	}

	public String getCm_gd_staffid() {
		return cm_gd_staffid;
	}

	public void setCm_gd_staffid(String cm_gd_staffid) {
		this.cm_gd_staffid = cm_gd_staffid;
	}

	public String getCm_gd_bankswiftcodeindi() {
		return cm_gd_bankswiftcodeindi;
	}

	public void setCm_gd_bankswiftcodeindi(String cm_gd_bankswiftcodeindi) {
		this.cm_gd_bankswiftcodeindi = cm_gd_bankswiftcodeindi;
	}

	public String getCm_gd_custswiftcode() {
		return cm_gd_custswiftcode;
	}

	public void setCm_gd_custswiftcode(String cm_gd_custswiftcode) {
		this.cm_gd_custswiftcode = cm_gd_custswiftcode;
	}

	public String getCm_gd_custtype() {
		return cm_gd_custtype;
	}

	public void setCm_gd_custtype(String cm_gd_custtype) {
		this.cm_gd_custtype = cm_gd_custtype;
	}

	public String getCm_gd_custstatus() {
		return cm_gd_custstatus;
	}

	public void setCm_gd_custstatus(String cm_gd_custstatus) {
		this.cm_gd_custstatus = cm_gd_custstatus;
	}

	public Date getCm_gd_dod() {
		return cm_gd_dod;
	}

	public void setCm_gd_dod(Date cm_gd_dod) {
		this.cm_gd_dod = cm_gd_dod;
	}

	public Date getCm_gd_don() {
		return cm_gd_don;
	}

	public void setCm_gd_don(Date cm_gd_don) {
		this.cm_gd_don = cm_gd_don;
	}

	public String getCm_gd_segment() {
		return cm_gd_segment;
	}

	public void setCm_gd_segment(String cm_gd_segment) {
		this.cm_gd_segment = cm_gd_segment;
	}

	public String getCm_gd_subsegment() {
		return cm_gd_subsegment;
	}

	public void setCm_gd_subsegment(String cm_gd_subsegment) {
		this.cm_gd_subsegment = cm_gd_subsegment;
	}

	public String getCm_gd_chargelevcode() {
		return cm_gd_chargelevcode;
	}

	public void setCm_gd_chargelevcode(String cm_gd_chargelevcode) {
		this.cm_gd_chargelevcode = cm_gd_chargelevcode;
	}

	public String getCm_gd_ratedoneon() {
		return cm_gd_ratedoneon;
	}

	public void setCm_gd_ratedoneon(String cm_gd_ratedoneon) {
		this.cm_gd_ratedoneon = cm_gd_ratedoneon;
	}

	public String getCm_gd_healthcode() {
		return cm_gd_healthcode;
	}

	public void setCm_gd_healthcode(String cm_gd_healthcode) {
		this.cm_gd_healthcode = cm_gd_healthcode;
	}

	public String getCm_gd_priority() {
		return cm_gd_priority;
	}

	public void setCm_gd_priority(String cm_gd_priority) {
		this.cm_gd_priority = cm_gd_priority;
	}

	public String getCm_gd_phystate() {
		return cm_gd_phystate;
	}

	public void setCm_gd_phystate(String cm_gd_phystate) {
		this.cm_gd_phystate = cm_gd_phystate;
	}

	public String getCm_gd_offordebitlim() {
		return cm_gd_offordebitlim;
	}

	public void setCm_gd_offordebitlim(String cm_gd_offordebitlim) {
		this.cm_gd_offordebitlim = cm_gd_offordebitlim;
	}

	public String getCm_gd_community() {
		return cm_gd_community;
	}

	public void setCm_gd_community(String cm_gd_community) {
		this.cm_gd_community = cm_gd_community;
	}

	public String getCm_gd_custrating() {
		return cm_gd_custrating;
	}

	public void setCm_gd_custrating(String cm_gd_custrating) {
		this.cm_gd_custrating = cm_gd_custrating;
	}

	public String getCm_gd_prefercode() {
		return cm_gd_prefercode;
	}

	public void setCm_gd_prefercode(String cm_gd_prefercode) {
		this.cm_gd_prefercode = cm_gd_prefercode;
	}

	public String getCm_gd_avalidtradeser() {
		return cm_gd_avalidtradeser;
	}

	public void setCm_gd_avalidtradeser(String cm_gd_avalidtradeser) {
		this.cm_gd_avalidtradeser = cm_gd_avalidtradeser;
	}

	public String getCm_gd_secureid() {
		return cm_gd_secureid;
	}

	public void setCm_gd_secureid(String cm_gd_secureid) {
		this.cm_gd_secureid = cm_gd_secureid;
	}

	public String getCm_gd_riskprofscore() {
		return cm_gd_riskprofscore;
	}

	public void setCm_gd_riskprofscore(String cm_gd_riskprofscore) {
		this.cm_gd_riskprofscore = cm_gd_riskprofscore;
	}

	public Date getCm_gd_riskprodexpdate() {
		return cm_gd_riskprodexpdate;
	}

	public void setCm_gd_riskprodexpdate(Date cm_gd_riskprodexpdate) {
		this.cm_gd_riskprodexpdate = cm_gd_riskprodexpdate;
	}

	public String getCm_gd_credirbureauscore() {
		return cm_gd_credirbureauscore;
	}

	public void setCm_gd_credirbureauscore(String cm_gd_credirbureauscore) {
		this.cm_gd_credirbureauscore = cm_gd_credirbureauscore;
	}

	public String getCm_gd_addinstaldet() {
		return cm_gd_addinstaldet;
	}

	public void setCm_gd_addinstaldet(String cm_gd_addinstaldet) {
		this.cm_gd_addinstaldet = cm_gd_addinstaldet;
	}

	public String getCm_gd_riskrating() {
		return cm_gd_riskrating;
	}

	public void setCm_gd_riskrating(String cm_gd_riskrating) {
		this.cm_gd_riskrating = cm_gd_riskrating;
	}

	public String getCm_gd_region() {
		return cm_gd_region;
	}

	public void setCm_gd_region(String cm_gd_region) {
		this.cm_gd_region = cm_gd_region;
	}

	public String getCm_gd_constcode() {
		return cm_gd_constcode;
	}

	public void setCm_gd_constcode(String cm_gd_constcode) {
		this.cm_gd_constcode = cm_gd_constcode;
	}

	public String getCm_gd_taxdebsrceid() {
		return cm_gd_taxdebsrceid;
	}

	public void setCm_gd_taxdebsrceid(String cm_gd_taxdebsrceid) {
		this.cm_gd_taxdebsrceid = cm_gd_taxdebsrceid;
	}

	public String getCm_gd_taxdebscretab() {
		return cm_gd_taxdebscretab;
	}

	public void setCm_gd_taxdebscretab(String cm_gd_taxdebscretab) {
		this.cm_gd_taxdebscretab = cm_gd_taxdebscretab;
	}

	public String getCm_gd_assestcalssficntrl() {
		return cm_gd_assestcalssficntrl;
	}

	public void setCm_gd_assestcalssficntrl(String cm_gd_assestcalssficntrl) {
		this.cm_gd_assestcalssficntrl = cm_gd_assestcalssficntrl;
	}

	public String getCm_gd_custlevprovi() {
		return cm_gd_custlevprovi;
	}

	public void setCm_gd_custlevprovi(String cm_gd_custlevprovi) {
		this.cm_gd_custlevprovi = cm_gd_custlevprovi;
	}

	public String getCm_gd_islamicbankcust() {
		return cm_gd_islamicbankcust;
	}

	public void setCm_gd_islamicbankcust(String cm_gd_islamicbankcust) {
		this.cm_gd_islamicbankcust = cm_gd_islamicbankcust;
	}

	public String getCm_gd_zakatdeduction() {
		return cm_gd_zakatdeduction;
	}

	public void setCm_gd_zakatdeduction(String cm_gd_zakatdeduction) {
		this.cm_gd_zakatdeduction = cm_gd_zakatdeduction;
	}

	public String getCm_gd_preferredcal() {
		return cm_gd_preferredcal;
	}

	public void setCm_gd_preferredcal(String cm_gd_preferredcal) {
		this.cm_gd_preferredcal = cm_gd_preferredcal;
	}

	public String getCm_gd_prefecommchan() {
		return cm_gd_prefecommchan;
	}

	public void setCm_gd_prefecommchan(String cm_gd_prefecommchan) {
		this.cm_gd_prefecommchan = cm_gd_prefecommchan;
	}

	public String getCm_gd_baseccy() {
		return cm_gd_baseccy;
	}

	public void setCm_gd_baseccy(String cm_gd_baseccy) {
		this.cm_gd_baseccy = cm_gd_baseccy;
	}

	public String getCm_gd_remarks() {
		return cm_gd_remarks;
	}

	public void setCm_gd_remarks(String cm_gd_remarks) {
		this.cm_gd_remarks = cm_gd_remarks;
	}

	public String getCm_gd_purgeallowed() {
		return cm_gd_purgeallowed;
	}

	public void setCm_gd_purgeallowed(String cm_gd_purgeallowed) {
		this.cm_gd_purgeallowed = cm_gd_purgeallowed;
	}

	public String getCm_gd_delinquentcust() {
		return cm_gd_delinquentcust;
	}

	public void setCm_gd_delinquentcust(String cm_gd_delinquentcust) {
		this.cm_gd_delinquentcust = cm_gd_delinquentcust;
	}

	public String getCm_gd_preflocale() {
		return cm_gd_preflocale;
	}

	public void setCm_gd_preflocale(String cm_gd_preflocale) {
		this.cm_gd_preflocale = cm_gd_preflocale;
	}

	public String getCm_gd_enablecrmalrts() {
		return cm_gd_enablecrmalrts;
	}

	public void setCm_gd_enablecrmalrts(String cm_gd_enablecrmalrts) {
		this.cm_gd_enablecrmalrts = cm_gd_enablecrmalrts;
	}

	public String getCm_gd_defchanforcrmalrts() {
		return cm_gd_defchanforcrmalrts;
	}

	public void setCm_gd_defchanforcrmalrts(String cm_gd_defchanforcrmalrts) {
		this.cm_gd_defchanforcrmalrts = cm_gd_defchanforcrmalrts;
	}

	public String getCm_gd_custtypebeforeconv() {
		return cm_gd_custtypebeforeconv;
	}

	public void setCm_gd_custtypebeforeconv(String cm_gd_custtypebeforeconv) {
		this.cm_gd_custtypebeforeconv = cm_gd_custtypebeforeconv;
	}

	public Date getCm_gd_lastupdate() {
		return cm_gd_lastupdate;
	}

	public void setCm_gd_lastupdate(Date cm_gd_lastupdate) {
		this.cm_gd_lastupdate = cm_gd_lastupdate;
	}

	public Date getCm_gd_converstion() {
		return cm_gd_converstion;
	}

	public void setCm_gd_converstion(Date cm_gd_converstion) {
		this.cm_gd_converstion = cm_gd_converstion;
	}

	public Date getCm_gd_kycdate() {
		return cm_gd_kycdate;
	}

	public void setCm_gd_kycdate(Date cm_gd_kycdate) {
		this.cm_gd_kycdate = cm_gd_kycdate;
	}

	public Date getCm_gd_kycrevdate() {
		return cm_gd_kycrevdate;
	}

	public void setCm_gd_kycrevdate(Date cm_gd_kycrevdate) {
		this.cm_gd_kycrevdate = cm_gd_kycrevdate;
	}

	public String getCm_gd_subforkyc() {
		return cm_gd_subforkyc;
	}

	public void setCm_gd_subforkyc(String cm_gd_subforkyc) {
		this.cm_gd_subforkyc = cm_gd_subforkyc;
	}

	public String getCm_gd_prmysolid() {
		return cm_gd_prmysolid;
	}

	public void setCm_gd_prmysolid(String cm_gd_prmysolid) {
		this.cm_gd_prmysolid = cm_gd_prmysolid;
	}

	public String getCm_gd_sector() {
		return cm_gd_sector;
	}

	public void setCm_gd_sector(String cm_gd_sector) {
		this.cm_gd_sector = cm_gd_sector;
	}

	public String getCm_gd_subsector() {
		return cm_gd_subsector;
	}

	public void setCm_gd_subsector(String cm_gd_subsector) {
		this.cm_gd_subsector = cm_gd_subsector;
	}

	public String getCm_eb_enableebanking() {
		return cm_eb_enableebanking;
	}

	public void setCm_eb_enableebanking(String cm_eb_enableebanking) {
		this.cm_eb_enableebanking = cm_eb_enableebanking;
	}

	public BigDecimal getCm_eb_smsbankmobnum() {
		return cm_eb_smsbankmobnum;
	}

	public void setCm_eb_smsbankmobnum(BigDecimal cm_eb_smsbankmobnum) {
		this.cm_eb_smsbankmobnum = cm_eb_smsbankmobnum;
	}

	public String getCm_eb_wapbanking() {
		return cm_eb_wapbanking;
	}

	public void setCm_eb_wapbanking(String cm_eb_wapbanking) {
		this.cm_eb_wapbanking = cm_eb_wapbanking;
	}

	public String getCm_eb_smsbanking() {
		return cm_eb_smsbanking;
	}

	public void setCm_eb_smsbanking(String cm_eb_smsbanking) {
		this.cm_eb_smsbanking = cm_eb_smsbanking;
	}

	public String getCm_rmd_prmyrelmangrid() {
		return cm_rmd_prmyrelmangrid;
	}

	public void setCm_rmd_prmyrelmangrid(String cm_rmd_prmyrelmangrid) {
		this.cm_rmd_prmyrelmangrid = cm_rmd_prmyrelmangrid;
	}

	public String getCm_rmd_secrelmanager() {
		return cm_rmd_secrelmanager;
	}

	public void setCm_rmd_secrelmanager(String cm_rmd_secrelmanager) {
		this.cm_rmd_secrelmanager = cm_rmd_secrelmanager;
	}

	public Date getCm_rmd_relstartdate() {
		return cm_rmd_relstartdate;
	}

	public void setCm_rmd_relstartdate(Date cm_rmd_relstartdate) {
		this.cm_rmd_relstartdate = cm_rmd_relstartdate;
	}

	public String getCm_rmd_relcreatedby() {
		return cm_rmd_relcreatedby;
	}

	public void setCm_rmd_relcreatedby(String cm_rmd_relcreatedby) {
		this.cm_rmd_relcreatedby = cm_rmd_relcreatedby;
	}

	public String getCm_rmd_relationshiplevel() {
		return cm_rmd_relationshiplevel;
	}

	public void setCm_rmd_relationshiplevel(String cm_rmd_relationshiplevel) {
		this.cm_rmd_relationshiplevel = cm_rmd_relationshiplevel;
	}

	public String getCm_rmd_prmycampsource() {
		return cm_rmd_prmycampsource;
	}

	public void setCm_rmd_prmycampsource(String cm_rmd_prmycampsource) {
		this.cm_rmd_prmycampsource = cm_rmd_prmycampsource;
	}

	public String getCm_lp_natlangcode() {
		return cm_lp_natlangcode;
	}

	public void setCm_lp_natlangcode(String cm_lp_natlangcode) {
		this.cm_lp_natlangcode = cm_lp_natlangcode;
	}

	public String getCm_lp_prefnativelang() {
		return cm_lp_prefnativelang;
	}

	public void setCm_lp_prefnativelang(String cm_lp_prefnativelang) {
		this.cm_lp_prefnativelang = cm_lp_prefnativelang;
	}

	public String getCm_lp_titlenatlang() {
		return cm_lp_titlenatlang;
	}

	public void setCm_lp_titlenatlang(String cm_lp_titlenatlang) {
		this.cm_lp_titlenatlang = cm_lp_titlenatlang;
	}

	public String getCm_lp_namenatlang() {
		return cm_lp_namenatlang;
	}

	public void setCm_lp_namenatlang(String cm_lp_namenatlang) {
		this.cm_lp_namenatlang = cm_lp_namenatlang;
	}

	public String getCm_lp_firstname() {
		return cm_lp_firstname;
	}

	public void setCm_lp_firstname(String cm_lp_firstname) {
		this.cm_lp_firstname = cm_lp_firstname;
	}

	public String getCm_lp_middlename() {
		return cm_lp_middlename;
	}

	public void setCm_lp_middlename(String cm_lp_middlename) {
		this.cm_lp_middlename = cm_lp_middlename;
	}

	public String getCm_lp_lastname() {
		return cm_lp_lastname;
	}

	public void setCm_lp_lastname(String cm_lp_lastname) {
		this.cm_lp_lastname = cm_lp_lastname;
	}

	public String getCm_lp_shortname() {
		return cm_lp_shortname;
	}

	public void setCm_lp_shortname(String cm_lp_shortname) {
		this.cm_lp_shortname = cm_lp_shortname;
	}

	public String getCm_lp_lastname1() {
		return cm_lp_lastname1;
	}

	public void setCm_lp_lastname1(String cm_lp_lastname1) {
		this.cm_lp_lastname1 = cm_lp_lastname1;
	}

	public String getCm_lp_middlename1() {
		return cm_lp_middlename1;
	}

	public void setCm_lp_middlename1(String cm_lp_middlename1) {
		this.cm_lp_middlename1 = cm_lp_middlename1;
	}

	public String getCm_lp_fisrtname1() {
		return cm_lp_fisrtname1;
	}

	public void setCm_lp_fisrtname1(String cm_lp_fisrtname1) {
		this.cm_lp_fisrtname1 = cm_lp_fisrtname1;
	}

	public String getCm_lp_shortname1() {
		return cm_lp_shortname1;
	}

	public void setCm_lp_shortname1(String cm_lp_shortname1) {
		this.cm_lp_shortname1 = cm_lp_shortname1;
	}

	public String getCont_det_addtype() {
		return cont_det_addtype;
	}

	public void setCont_det_addtype(String cont_det_addtype) {
		this.cont_det_addtype = cont_det_addtype;
	}

	public String getCont_det_premisename() {
		return cont_det_premisename;
	}

	public void setCont_det_premisename(String cont_det_premisename) {
		this.cont_det_premisename = cont_det_premisename;
	}

	public BigDecimal getCont_det_houseno() {
		return cont_det_houseno;
	}

	public void setCont_det_houseno(BigDecimal cont_det_houseno) {
		this.cont_det_houseno = cont_det_houseno;
	}

	public BigDecimal getCont_det_streetno() {
		return cont_det_streetno;
	}

	public void setCont_det_streetno(BigDecimal cont_det_streetno) {
		this.cont_det_streetno = cont_det_streetno;
	}

	public String getCcont_det_streetname() {
		return ccont_det_streetname;
	}

	public void setCcont_det_streetname(String ccont_det_streetname) {
		this.ccont_det_streetname = ccont_det_streetname;
	}

	public String getCont_det_buildlevel() {
		return cont_det_buildlevel;
	}

	public void setCont_det_buildlevel(String cont_det_buildlevel) {
		this.cont_det_buildlevel = cont_det_buildlevel;
	}

	public String getCont_det_subrub() {
		return cont_det_subrub;
	}

	public void setCont_det_subrub(String cont_det_subrub) {
		this.cont_det_subrub = cont_det_subrub;
	}

	public String getCont_det_town() {
		return cont_det_town;
	}

	public void setCont_det_town(String cont_det_town) {
		this.cont_det_town = cont_det_town;
	}

	public String getCont_det_locality() {
		return cont_det_locality;
	}

	public void setCont_det_locality(String cont_det_locality) {
		this.cont_det_locality = cont_det_locality;
	}

	public String getCont_det_city() {
		return cont_det_city;
	}

	public void setCont_det_city(String cont_det_city) {
		this.cont_det_city = cont_det_city;
	}

	public String getCont_det_state() {
		return cont_det_state;
	}

	public void setCont_det_state(String cont_det_state) {
		this.cont_det_state = cont_det_state;
	}

	public String getCont_det_country() {
		return cont_det_country;
	}

	public void setCont_det_country(String cont_det_country) {
		this.cont_det_country = cont_det_country;
	}

	public String getCont_det_postalcode() {
		return cont_det_postalcode;
	}

	public void setCont_det_postalcode(String cont_det_postalcode) {
		this.cont_det_postalcode = cont_det_postalcode;
	}

	public String getCont_det_addvalidfrom() {
		return cont_det_addvalidfrom;
	}

	public void setCont_det_addvalidfrom(String cont_det_addvalidfrom) {
		this.cont_det_addvalidfrom = cont_det_addvalidfrom;
	}

	public String getCont_det_addvalidstill() {
		return cont_det_addvalidstill;
	}

	public void setCont_det_addvalidstill(String cont_det_addvalidstill) {
		this.cont_det_addvalidstill = cont_det_addvalidstill;
	}

	public String getCur_mast_ccy() {
		return cur_mast_ccy;
	}

	public void setCur_mast_ccy(String cur_mast_ccy) {
		this.cur_mast_ccy = cur_mast_ccy;
	}

	public String getCur_mast_crdispcnt() {
		return cur_mast_crdispcnt;
	}

	public void setCur_mast_crdispcnt(String cur_mast_crdispcnt) {
		this.cur_mast_crdispcnt = cur_mast_crdispcnt;
	}

	public String getCur_mast_drdispcnt() {
		return cur_mast_drdispcnt;
	}

	public void setCur_mast_drdispcnt(String cur_mast_drdispcnt) {
		this.cur_mast_drdispcnt = cur_mast_drdispcnt;
	}

	public String getCur_mast_withholdtaxpnt() {
		return cur_mast_withholdtaxpnt;
	}

	public void setCur_mast_withholdtaxpnt(String cur_mast_withholdtaxpnt) {
		this.cur_mast_withholdtaxpnt = cur_mast_withholdtaxpnt;
	}

	public String getCur_mast_withholdtaxflrlimt() {
		return cur_mast_withholdtaxflrlimt;
	}

	public void setCur_mast_withholdtaxflrlimt(String cur_mast_withholdtaxflrlimt) {
		this.cur_mast_withholdtaxflrlimt = cur_mast_withholdtaxflrlimt;
	}

	public Date getCur_mast_prefexpydate() {
		return cur_mast_prefexpydate;
	}

	public void setCur_mast_prefexpydate(Date cur_mast_prefexpydate) {
		this.cur_mast_prefexpydate = cur_mast_prefexpydate;
	}

	public String getDoc_mas_documenttype() {
		return doc_mas_documenttype;
	}

	public void setDoc_mas_documenttype(String doc_mas_documenttype) {
		this.doc_mas_documenttype = doc_mas_documenttype;
	}

	public String getDoc_mas_documentcode() {
		return doc_mas_documentcode;
	}

	public void setDoc_mas_documentcode(String doc_mas_documentcode) {
		this.doc_mas_documentcode = doc_mas_documentcode;
	}

	public String getDoc_mas_doctypedesc() {
		return doc_mas_doctypedesc;
	}

	public void setDoc_mas_doctypedesc(String doc_mas_doctypedesc) {
		this.doc_mas_doctypedesc = doc_mas_doctypedesc;
	}

	public String getDoc_mas_uniqueid() {
		return doc_mas_uniqueid;
	}

	public void setDoc_mas_uniqueid(String doc_mas_uniqueid) {
		this.doc_mas_uniqueid = doc_mas_uniqueid;
	}

	public String getDoc_mas_placeofissues() {
		return doc_mas_placeofissues;
	}

	public void setDoc_mas_placeofissues(String doc_mas_placeofissues) {
		this.doc_mas_placeofissues = doc_mas_placeofissues;
	}

	public Date getDoc_mas_issuedate() {
		return doc_mas_issuedate;
	}

	public void setDoc_mas_issuedate(Date doc_mas_issuedate) {
		this.doc_mas_issuedate = doc_mas_issuedate;
	}

	public Date getDoc_mas_expydate() {
		return doc_mas_expydate;
	}

	public void setDoc_mas_expydate(Date doc_mas_expydate) {
		this.doc_mas_expydate = doc_mas_expydate;
	}

	public byte[] getDoc_mas_uploadfile() {
		return doc_mas_uploadfile;
	}

	public void setDoc_mas_uploadfile(byte[] doc_mas_uploadfile) {
		this.doc_mas_uploadfile = doc_mas_uploadfile;
	}

	public Customer_maintanence(String cm_gd_title, String cm_gd_firstname, String cm_gd_middlename,
			String cm_gd_lastname, String cm_gd_fullname, String cm_gd_preferredname, String cm_gd_gender,
			Date cm_gd_dob, String cm_gd_mothermaidenname, String cm_gd_cob, String cm_gd_minorindicator,
			String cm_gd_minorturnmajoron, String cm_gd_seniorcitizen, String cm_gd_seniorcitizenapp,
			String cm_gd_nonresiindicator, String cm_gd_turnnonresion, String cm_gd_staffindi, String cm_gd_staffid,
			String cm_gd_bankswiftcodeindi, String cm_gd_custswiftcode, String cm_gd_custtype, String cm_gd_custstatus,
			Date cm_gd_dod, Date cm_gd_don, String cm_gd_segment, String cm_gd_subsegment, String cm_gd_chargelevcode,
			String cm_gd_ratedoneon, String cm_gd_healthcode, String cm_gd_priority, String cm_gd_phystate,
			String cm_gd_offordebitlim, String cm_gd_community, String cm_gd_custrating, String cm_gd_prefercode,
			String cm_gd_avalidtradeser, String cm_gd_secureid, String cm_gd_riskprofscore, Date cm_gd_riskprodexpdate,
			String cm_gd_credirbureauscore, String cm_gd_addinstaldet, String cm_gd_riskrating, String cm_gd_region,
			String cm_gd_constcode, String cm_gd_taxdebsrceid, String cm_gd_taxdebscretab,
			String cm_gd_assestcalssficntrl, String cm_gd_custlevprovi, String cm_gd_islamicbankcust,
			String cm_gd_zakatdeduction, String cm_gd_preferredcal, String cm_gd_prefecommchan, String cm_gd_baseccy,
			String cm_gd_remarks, String cm_gd_purgeallowed, String cm_gd_delinquentcust, String cm_gd_preflocale,
			String cm_gd_enablecrmalrts, String cm_gd_defchanforcrmalrts, String cm_gd_custtypebeforeconv,
			Date cm_gd_lastupdate, Date cm_gd_converstion, Date cm_gd_kycdate, Date cm_gd_kycrevdate,
			String cm_gd_subforkyc, String cm_gd_prmysolid, String cm_gd_sector, String cm_gd_subsector,
			String cm_eb_enableebanking, BigDecimal cm_eb_smsbankmobnum, String cm_eb_wapbanking,
			String cm_eb_smsbanking, String cm_rmd_prmyrelmangrid, String cm_rmd_secrelmanager,
			Date cm_rmd_relstartdate, String cm_rmd_relcreatedby, String cm_rmd_relationshiplevel,
			String cm_rmd_prmycampsource, String cm_lp_natlangcode, String cm_lp_prefnativelang,
			String cm_lp_titlenatlang, String cm_lp_namenatlang, String cm_lp_firstname, String cm_lp_middlename,
			String cm_lp_lastname, String cm_lp_shortname, String cm_lp_lastname1, String cm_lp_middlename1,
			String cm_lp_fisrtname1, String cm_lp_shortname1, String cont_det_addtype, String cont_det_premisename,
			BigDecimal cont_det_houseno, BigDecimal cont_det_streetno, String ccont_det_streetname,
			String cont_det_buildlevel, String cont_det_subrub, String cont_det_town, String cont_det_locality,
			String cont_det_city, String cont_det_state, String cont_det_country, String cont_det_postalcode,
			String cont_det_addvalidfrom, String cont_det_addvalidstill, String cur_mast_ccy, String cur_mast_crdispcnt,
			String cur_mast_drdispcnt, String cur_mast_withholdtaxpnt, String cur_mast_withholdtaxflrlimt,
			Date cur_mast_prefexpydate, String doc_mas_documenttype, String doc_mas_documentcode,
			String doc_mas_doctypedesc, String doc_mas_uniqueid, String doc_mas_placeofissues, Date doc_mas_issuedate,
			Date doc_mas_expydate, byte[] doc_mas_uploadfile) {
		super();
		this.cm_gd_title = cm_gd_title;
		this.cm_gd_firstname = cm_gd_firstname;
		this.cm_gd_middlename = cm_gd_middlename;
		this.cm_gd_lastname = cm_gd_lastname;
		this.cm_gd_fullname = cm_gd_fullname;
		this.cm_gd_preferredname = cm_gd_preferredname;
		this.cm_gd_gender = cm_gd_gender;
		this.cm_gd_dob = cm_gd_dob;
		this.cm_gd_mothermaidenname = cm_gd_mothermaidenname;
		this.cm_gd_cob = cm_gd_cob;
		this.cm_gd_minorindicator = cm_gd_minorindicator;
		this.cm_gd_minorturnmajoron = cm_gd_minorturnmajoron;
		this.cm_gd_seniorcitizen = cm_gd_seniorcitizen;
		this.cm_gd_seniorcitizenapp = cm_gd_seniorcitizenapp;
		this.cm_gd_nonresiindicator = cm_gd_nonresiindicator;
		this.cm_gd_turnnonresion = cm_gd_turnnonresion;
		this.cm_gd_staffindi = cm_gd_staffindi;
		this.cm_gd_staffid = cm_gd_staffid;
		this.cm_gd_bankswiftcodeindi = cm_gd_bankswiftcodeindi;
		this.cm_gd_custswiftcode = cm_gd_custswiftcode;
		this.cm_gd_custtype = cm_gd_custtype;
		this.cm_gd_custstatus = cm_gd_custstatus;
		this.cm_gd_dod = cm_gd_dod;
		this.cm_gd_don = cm_gd_don;
		this.cm_gd_segment = cm_gd_segment;
		this.cm_gd_subsegment = cm_gd_subsegment;
		this.cm_gd_chargelevcode = cm_gd_chargelevcode;
		this.cm_gd_ratedoneon = cm_gd_ratedoneon;
		this.cm_gd_healthcode = cm_gd_healthcode;
		this.cm_gd_priority = cm_gd_priority;
		this.cm_gd_phystate = cm_gd_phystate;
		this.cm_gd_offordebitlim = cm_gd_offordebitlim;
		this.cm_gd_community = cm_gd_community;
		this.cm_gd_custrating = cm_gd_custrating;
		this.cm_gd_prefercode = cm_gd_prefercode;
		this.cm_gd_avalidtradeser = cm_gd_avalidtradeser;
		this.cm_gd_secureid = cm_gd_secureid;
		this.cm_gd_riskprofscore = cm_gd_riskprofscore;
		this.cm_gd_riskprodexpdate = cm_gd_riskprodexpdate;
		this.cm_gd_credirbureauscore = cm_gd_credirbureauscore;
		this.cm_gd_addinstaldet = cm_gd_addinstaldet;
		this.cm_gd_riskrating = cm_gd_riskrating;
		this.cm_gd_region = cm_gd_region;
		this.cm_gd_constcode = cm_gd_constcode;
		this.cm_gd_taxdebsrceid = cm_gd_taxdebsrceid;
		this.cm_gd_taxdebscretab = cm_gd_taxdebscretab;
		this.cm_gd_assestcalssficntrl = cm_gd_assestcalssficntrl;
		this.cm_gd_custlevprovi = cm_gd_custlevprovi;
		this.cm_gd_islamicbankcust = cm_gd_islamicbankcust;
		this.cm_gd_zakatdeduction = cm_gd_zakatdeduction;
		this.cm_gd_preferredcal = cm_gd_preferredcal;
		this.cm_gd_prefecommchan = cm_gd_prefecommchan;
		this.cm_gd_baseccy = cm_gd_baseccy;
		this.cm_gd_remarks = cm_gd_remarks;
		this.cm_gd_purgeallowed = cm_gd_purgeallowed;
		this.cm_gd_delinquentcust = cm_gd_delinquentcust;
		this.cm_gd_preflocale = cm_gd_preflocale;
		this.cm_gd_enablecrmalrts = cm_gd_enablecrmalrts;
		this.cm_gd_defchanforcrmalrts = cm_gd_defchanforcrmalrts;
		this.cm_gd_custtypebeforeconv = cm_gd_custtypebeforeconv;
		this.cm_gd_lastupdate = cm_gd_lastupdate;
		this.cm_gd_converstion = cm_gd_converstion;
		this.cm_gd_kycdate = cm_gd_kycdate;
		this.cm_gd_kycrevdate = cm_gd_kycrevdate;
		this.cm_gd_subforkyc = cm_gd_subforkyc;
		this.cm_gd_prmysolid = cm_gd_prmysolid;
		this.cm_gd_sector = cm_gd_sector;
		this.cm_gd_subsector = cm_gd_subsector;
		this.cm_eb_enableebanking = cm_eb_enableebanking;
		this.cm_eb_smsbankmobnum = cm_eb_smsbankmobnum;
		this.cm_eb_wapbanking = cm_eb_wapbanking;
		this.cm_eb_smsbanking = cm_eb_smsbanking;
		this.cm_rmd_prmyrelmangrid = cm_rmd_prmyrelmangrid;
		this.cm_rmd_secrelmanager = cm_rmd_secrelmanager;
		this.cm_rmd_relstartdate = cm_rmd_relstartdate;
		this.cm_rmd_relcreatedby = cm_rmd_relcreatedby;
		this.cm_rmd_relationshiplevel = cm_rmd_relationshiplevel;
		this.cm_rmd_prmycampsource = cm_rmd_prmycampsource;
		this.cm_lp_natlangcode = cm_lp_natlangcode;
		this.cm_lp_prefnativelang = cm_lp_prefnativelang;
		this.cm_lp_titlenatlang = cm_lp_titlenatlang;
		this.cm_lp_namenatlang = cm_lp_namenatlang;
		this.cm_lp_firstname = cm_lp_firstname;
		this.cm_lp_middlename = cm_lp_middlename;
		this.cm_lp_lastname = cm_lp_lastname;
		this.cm_lp_shortname = cm_lp_shortname;
		this.cm_lp_lastname1 = cm_lp_lastname1;
		this.cm_lp_middlename1 = cm_lp_middlename1;
		this.cm_lp_fisrtname1 = cm_lp_fisrtname1;
		this.cm_lp_shortname1 = cm_lp_shortname1;
		this.cont_det_addtype = cont_det_addtype;
		this.cont_det_premisename = cont_det_premisename;
		this.cont_det_houseno = cont_det_houseno;
		this.cont_det_streetno = cont_det_streetno;
		this.ccont_det_streetname = ccont_det_streetname;
		this.cont_det_buildlevel = cont_det_buildlevel;
		this.cont_det_subrub = cont_det_subrub;
		this.cont_det_town = cont_det_town;
		this.cont_det_locality = cont_det_locality;
		this.cont_det_city = cont_det_city;
		this.cont_det_state = cont_det_state;
		this.cont_det_country = cont_det_country;
		this.cont_det_postalcode = cont_det_postalcode;
		this.cont_det_addvalidfrom = cont_det_addvalidfrom;
		this.cont_det_addvalidstill = cont_det_addvalidstill;
		this.cur_mast_ccy = cur_mast_ccy;
		this.cur_mast_crdispcnt = cur_mast_crdispcnt;
		this.cur_mast_drdispcnt = cur_mast_drdispcnt;
		this.cur_mast_withholdtaxpnt = cur_mast_withholdtaxpnt;
		this.cur_mast_withholdtaxflrlimt = cur_mast_withholdtaxflrlimt;
		this.cur_mast_prefexpydate = cur_mast_prefexpydate;
		this.doc_mas_documenttype = doc_mas_documenttype;
		this.doc_mas_documentcode = doc_mas_documentcode;
		this.doc_mas_doctypedesc = doc_mas_doctypedesc;
		this.doc_mas_uniqueid = doc_mas_uniqueid;
		this.doc_mas_placeofissues = doc_mas_placeofissues;
		this.doc_mas_issuedate = doc_mas_issuedate;
		this.doc_mas_expydate = doc_mas_expydate;
		this.doc_mas_uploadfile = doc_mas_uploadfile;
	}

	public Customer_maintanence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setEncryptedPhoto(String encryptedPhoto) {
		// TODO Auto-generated method stub
		
	}

	
	 
	
	
	
	
	
	
	
	
	
	
}
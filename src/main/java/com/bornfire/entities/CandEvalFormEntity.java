package com.bornfire.entities;

import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.Lob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BAJ_CANDI_EVALU_FORM")

public class CandEvalFormEntity {

	@Id
	private String	ref_no;
	private String	candi_name;
	private String	position_title;
	private String	grade;
	private String	completed_by;
	private String	interviewers;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	date_of_interview;
	private String	approved_by;
	private String	status;
	private String	qualification;
	private String	skill_sets;
	private BigDecimal	experience;
	private String	communication_skill;
	private String	presentation;
	private String	problem_solving_skill;
	private String	job_stability;
	private String	mobility;
	private String	additional_information;
	private BigDecimal	expected_salary;
	private BigDecimal	ctc;
	private String	joining_period;
	private String	position;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	date_of_offer;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	date_of_appointment_letter;
	private BigDecimal	contact_number;
	private String	email_id;
	private String	passport_no;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	date_of_birth;
	private String	address;
	private String	entity_flg;
	private String	del_flg;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	entry_time;
	private String	entry_user;
	private String	modify_flg;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	modify_time;
	private String	modify_user;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	verify_time;
	private String	verify_user;
	@Lob
	private byte[]	annexure_resume;
	private String	salutation;
	private String	finance_year;
	private String	verify_flg;
	@Lob
	private byte[]	offer;
	@Lob
	private byte[]	appointment;
	@Lob
	private byte[]	salarystru;
	public String getRef_no() {
		return ref_no;
	}
	public void setRef_no(String ref_no) {
		this.ref_no = ref_no;
	}
	public String getCandi_name() {
		return candi_name;
	}
	public void setCandi_name(String candi_name) {
		this.candi_name = candi_name;
	}
	public String getPosition_title() {
		return position_title;
	}
	public void setPosition_title(String position_title) {
		this.position_title = position_title;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCompleted_by() {
		return completed_by;
	}
	public void setCompleted_by(String completed_by) {
		this.completed_by = completed_by;
	}
	public String getInterviewers() {
		return interviewers;
	}
	public void setInterviewers(String interviewers) {
		this.interviewers = interviewers;
	}
	public Date getDate_of_interview() {
		return date_of_interview;
	}
	public void setDate_of_interview(Date date_of_interview) {
		this.date_of_interview = date_of_interview;
	}
	public String getApproved_by() {
		return approved_by;
	}
	public void setApproved_by(String approved_by) {
		this.approved_by = approved_by;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getSkill_sets() {
		return skill_sets;
	}
	public void setSkill_sets(String skill_sets) {
		this.skill_sets = skill_sets;
	}
	public BigDecimal getExperience() {
		return experience;
	}
	public void setExperience(BigDecimal experience) {
		this.experience = experience;
	}
	public String getCommunication_skill() {
		return communication_skill;
	}
	public void setCommunication_skill(String communication_skill) {
		this.communication_skill = communication_skill;
	}
	public String getPresentation() {
		return presentation;
	}
	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}
	public String getProblem_solving_skill() {
		return problem_solving_skill;
	}
	public void setProblem_solving_skill(String problem_solving_skill) {
		this.problem_solving_skill = problem_solving_skill;
	}
	public String getJob_stability() {
		return job_stability;
	}
	public void setJob_stability(String job_stability) {
		this.job_stability = job_stability;
	}
	public String getMobility() {
		return mobility;
	}
	public void setMobility(String mobility) {
		this.mobility = mobility;
	}
	public String getAdditional_information() {
		return additional_information;
	}
	public void setAdditional_information(String additional_information) {
		this.additional_information = additional_information;
	}
	public BigDecimal getExpected_salary() {
		return expected_salary;
	}
	public void setExpected_salary(BigDecimal expected_salary) {
		this.expected_salary = expected_salary;
	}
	public BigDecimal getCtc() {
		return ctc;
	}
	public void setCtc(BigDecimal ctc) {
		this.ctc = ctc;
	}
	public String getJoining_period() {
		return joining_period;
	}
	public void setJoining_period(String joining_period) {
		this.joining_period = joining_period;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Date getDate_of_offer() {
		return date_of_offer;
	}
	public void setDate_of_offer(Date date_of_offer) {
		this.date_of_offer = date_of_offer;
	}
	public Date getDate_of_appointment_letter() {
		return date_of_appointment_letter;
	}
	public void setDate_of_appointment_letter(Date date_of_appointment_letter) {
		this.date_of_appointment_letter = date_of_appointment_letter;
	}
	public BigDecimal getContact_number() {
		return contact_number;
	}
	public void setContact_number(BigDecimal contact_number) {
		this.contact_number = contact_number;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassport_no() {
		return passport_no;
	}
	public void setPassport_no(String passport_no) {
		this.passport_no = passport_no;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEntity_flg() {
		return entity_flg;
	}
	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public Date getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}
	public String getEntry_user() {
		return entry_user;
	}
	public void setEntry_user(String entry_user) {
		this.entry_user = entry_user;
	}
	public String getModify_flg() {
		return modify_flg;
	}
	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}
	public Date getModify_time() {
		return modify_time;
	}
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	public String getModify_user() {
		return modify_user;
	}
	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}
	public Date getVerify_time() {
		return verify_time;
	}
	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}
	public String getVerify_user() {
		return verify_user;
	}
	public void setVerify_user(String verify_user) {
		this.verify_user = verify_user;
	}
	public byte[] getAnnexure_resume() {
		return annexure_resume;
	}
	public void setAnnexure_resume(byte[] annexure_resume) {
		this.annexure_resume = annexure_resume;
	}
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	public String getFinance_year() {
		return finance_year;
	}
	public void setFinance_year(String finance_year) {
		this.finance_year = finance_year;
	}
	public String getVerify_flg() {
		return verify_flg;
	}
	public void setVerify_flg(String verify_flg) {
		this.verify_flg = verify_flg;
	}
	public byte[] getOffer() {
		return offer;
	}
	public void setOffer(byte[] offer) {
		this.offer = offer;
	}
	public byte[] getAppointment() {
		return appointment;
	}
	public void setAppointment(byte[] appointment) {
		this.appointment = appointment;
	}
	public byte[] getSalarystru() {
		return salarystru;
	}
	public void setSalarystru(byte[] salarystru) {
		this.salarystru = salarystru;
	}
	public CandEvalFormEntity(String ref_no, String candi_name, String position_title, String grade,
			String completed_by, String interviewers, Date date_of_interview, String approved_by, String status,
			String qualification, String skill_sets, BigDecimal experience, String communication_skill,
			String presentation, String problem_solving_skill, String job_stability, String mobility,
			String additional_information, BigDecimal expected_salary, BigDecimal ctc, String joining_period,
			String position, Date date_of_offer, Date date_of_appointment_letter, BigDecimal contact_number,
			String email_id, String passport_no, Date date_of_birth, String address, String entity_flg, String del_flg,
			Date entry_time, String entry_user, String modify_flg, Date modify_time, String modify_user,
			Date verify_time, String verify_user, byte[] annexure_resume, String salutation, String finance_year,
			String verify_flg, byte[] offer, byte[] appointment, byte[] salarystru) {
		super();
		this.ref_no = ref_no;
		this.candi_name = candi_name;
		this.position_title = position_title;
		this.grade = grade;
		this.completed_by = completed_by;
		this.interviewers = interviewers;
		this.date_of_interview = date_of_interview;
		this.approved_by = approved_by;
		this.status = status;
		this.qualification = qualification;
		this.skill_sets = skill_sets;
		this.experience = experience;
		this.communication_skill = communication_skill;
		this.presentation = presentation;
		this.problem_solving_skill = problem_solving_skill;
		this.job_stability = job_stability;
		this.mobility = mobility;
		this.additional_information = additional_information;
		this.expected_salary = expected_salary;
		this.ctc = ctc;
		this.joining_period = joining_period;
		this.position = position;
		this.date_of_offer = date_of_offer;
		this.date_of_appointment_letter = date_of_appointment_letter;
		this.contact_number = contact_number;
		this.email_id = email_id;
		this.passport_no = passport_no;
		this.date_of_birth = date_of_birth;
		this.address = address;
		this.entity_flg = entity_flg;
		this.del_flg = del_flg;
		this.entry_time = entry_time;
		this.entry_user = entry_user;
		this.modify_flg = modify_flg;
		this.modify_time = modify_time;
		this.modify_user = modify_user;
		this.verify_time = verify_time;
		this.verify_user = verify_user;
		this.annexure_resume = annexure_resume;
		this.salutation = salutation;
		this.finance_year = finance_year;
		this.verify_flg = verify_flg;
		this.offer = offer;
		this.appointment = appointment;
		this.salarystru = salarystru;
	}
	public CandEvalFormEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}

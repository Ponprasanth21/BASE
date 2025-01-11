package com.bornfire.entities;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TEMPLATE_TABLE")
public class Templates_Data_Entity {
	@Id
	private String template_id;
	private Blob logo;
	private String organization_name;
	private String address_line_1;
	private String address_line_2;
	private String city;
	private String state;
	private String country;
	private String customer_id;
	private String header_content_1;
	private String header_content_2;
	private String header_content_3;
	private Blob footer_logo_1;
	private String footer_content_1;
	private String footer_content_2;
	private Blob footer_logo_2;
	private String footer_content_3;
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	public Blob getLogo() {
		return logo;
	}
	public void setLogo(Blob logo) {
		this.logo = logo;
	}
	public String getOrganization_name() {
		return organization_name;
	}
	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}
	public String getAddress_line_1() {
		return address_line_1;
	}
	public void setAddress_line_1(String address_line_1) {
		this.address_line_1 = address_line_1;
	}
	public String getAddress_line_2() {
		return address_line_2;
	}
	public void setAddress_line_2(String address_line_2) {
		this.address_line_2 = address_line_2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getHeader_content_1() {
		return header_content_1;
	}
	public void setHeader_content_1(String header_content_1) {
		this.header_content_1 = header_content_1;
	}
	public String getHeader_content_2() {
		return header_content_2;
	}
	public void setHeader_content_2(String header_content_2) {
		this.header_content_2 = header_content_2;
	}
	public String getHeader_content_3() {
		return header_content_3;
	}
	public void setHeader_content_3(String header_content_3) {
		this.header_content_3 = header_content_3;
	}
	public Blob getFooter_logo_1() {
		return footer_logo_1;
	}
	public void setFooter_logo_1(Blob footer_logo_1) {
		this.footer_logo_1 = footer_logo_1;
	}
	public String getFooter_content_1() {
		return footer_content_1;
	}
	public void setFooter_content_1(String footer_content_1) {
		this.footer_content_1 = footer_content_1;
	}
	public String getFooter_content_2() {
		return footer_content_2;
	}
	public void setFooter_content_2(String footer_content_2) {
		this.footer_content_2 = footer_content_2;
	}
	public Blob getFooter_logo_2() {
		return footer_logo_2;
	}
	public void setFooter_logo_2(Blob footer_logo_2) {
		this.footer_logo_2 = footer_logo_2;
	}
	public String getFooter_content_3() {
		return footer_content_3;
	}
	public void setFooter_content_3(String footer_content_3) {
		this.footer_content_3 = footer_content_3;
	}
	public Templates_Data_Entity(String template_id, Blob logo, String organization_name, String address_line_1,
			String address_line_2, String city, String state, String country, String customer_id,
			String header_content_1, String header_content_2, String header_content_3, Blob footer_logo_1,
			String footer_content_1, String footer_content_2, Blob footer_logo_2, String footer_content_3) {
		super();
		this.template_id = template_id;
		this.logo = logo;
		this.organization_name = organization_name;
		this.address_line_1 = address_line_1;
		this.address_line_2 = address_line_2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.customer_id = customer_id;
		this.header_content_1 = header_content_1;
		this.header_content_2 = header_content_2;
		this.header_content_3 = header_content_3;
		this.footer_logo_1 = footer_logo_1;
		this.footer_content_1 = footer_content_1;
		this.footer_content_2 = footer_content_2;
		this.footer_logo_2 = footer_logo_2;
		this.footer_content_3 = footer_content_3;
	}
	public Templates_Data_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
}

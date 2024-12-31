package com.bornfire.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Td_defn_table_Idclass implements Serializable{

private static final long serialVersionUID=1L;
	
	private String acid;
	private BigDecimal srl_no;
	private BigDecimal flow_id;
	
	public String getAcid() {
		return acid;
	}

	public void setAcid(String acid) {
		this.acid = acid;
	}

	public BigDecimal getSrl_no() {
		return srl_no;
	}

	public void setSrl_no(BigDecimal srl_no) {
		this.srl_no = srl_no;
	}

	public BigDecimal getFlow_id() {
		return flow_id;
	}

	public void setFlow_id(BigDecimal flow_id) {
		this.flow_id = flow_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Td_defn_table_Idclass() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

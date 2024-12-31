package com.bornfire.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.persistence.Id;
@Embeddable

public class journalentries_embededid implements Serializable{

	private static final long serialVersionUID=1L;
	@Id
	private BigDecimal part_tran_id;
	@Id
	private String tran_id;
	
	
	public BigDecimal getPart_tran_id() {
		return part_tran_id;
	}
	public void setPart_tran_id(BigDecimal part_tran_id) {
		this.part_tran_id = part_tran_id;
	}
	public String getTran_id() {
		return tran_id;
	}
	public void setTran_id(String tran_id) {
		this.tran_id = tran_id;
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

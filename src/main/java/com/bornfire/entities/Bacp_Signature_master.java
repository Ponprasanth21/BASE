package com.bornfire.entities;

 

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Base64;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
@Entity
@Table(name = "BACP_SIGNATURE_MASTER")
public class Bacp_Signature_master {


    @Id
    private Integer srl_no;
    private String    img_access_code;
    private String    img_group;
    private String    keyword;
    @Lob
    private byte[]  photo;
    private Blob    sign;
    private String    appl_ref_no;
    private BigDecimal    rec_no;
    private String    cif_id;
    private String    del_flg;
    
    public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public Integer getSrl_no() {
        return srl_no;
    }
    public void setSrl_no(Integer srl_no) {
        this.srl_no = srl_no;
    }
    public String getImg_access_code() {
        return img_access_code;
    }
    public void setImg_access_code(String img_access_code) {
        this.img_access_code = img_access_code;
    }
    public String getImg_group() {
        return img_group;
    }
    public void setImg_group(String img_group) {
        this.img_group = img_group;
    }
    public String getKeyword() {
        return keyword;
    }
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    public byte[]  getPhoto() {
        return photo;
    }
    public void setPhoto(byte[]  photo) {
        this.photo = photo;
    }
    public Blob getSign() {
        return sign;
    }
    public void setSign(Blob sign) {
        this.sign = sign;
    }
    public String getAppl_ref_no() {
        return appl_ref_no;
    }
    public void setAppl_ref_no(String appl_ref_no) {
        this.appl_ref_no = appl_ref_no;
    }
    public BigDecimal getRec_no() {
        return rec_no;
    }
    public void setRec_no(BigDecimal rec_no) {
        this.rec_no = rec_no;
    }
    public String getCif_id() {
        return cif_id;
    }
    public void setCif_id(String cif_id) {
        this.cif_id = cif_id;
    }
    public Bacp_Signature_master( Integer srl_no,String img_access_code, String img_group, String keyword, byte[]  photo, Blob sign,
            String appl_ref_no, BigDecimal rec_no, String cif_id,String del_flg) {
        super();

        this.srl_no = srl_no;
        this.img_access_code = img_access_code;
        this.img_group = img_group;
        this.keyword = keyword;
        this.photo = photo;
        this.sign = sign;
        this.appl_ref_no = appl_ref_no;
        this.rec_no = rec_no;
        this.cif_id = cif_id;
        this.del_flg = del_flg;
    }
    

    public String getEncryptedPhoto() {
        return Base64.getEncoder().encodeToString(photo);
    }

    public String getEncryptedSign() throws SQLException, IOException {
        byte[] signBytes = sign.getBytes(1, (int) sign.length());
        return Base64.getEncoder().encodeToString(signBytes);
    }
    public Bacp_Signature_master() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void setEncryptedSign(String encryptedSignature) {
        // TODO Auto-generated method stub

    }
    public void setEncryptedPhoto(String encryptedPhoto) {
        // TODO Auto-generated method stub

    }
	@Override
	public String toString() {
		return "Bacp_Signature_master [srl_no=" + srl_no + ", img_access_code=" + img_access_code + ", img_group="
				+ img_group + ", keyword=" + keyword + ", photo=" + Arrays.toString(photo) + ", sign=" + sign
				+ ", appl_ref_no=" + appl_ref_no + ", rec_no=" + rec_no + ", cif_id=" + cif_id + ", del_flg=" + del_flg
				+ "]";
	}




 

 

}
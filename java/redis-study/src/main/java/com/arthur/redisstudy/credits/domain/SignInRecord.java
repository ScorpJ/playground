package com.arthur.redisstudy.credits.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APP_SIGN_IN_REC")
public class SignInRecord {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "USER_ID")
	private Long userId;
	@Column(name = "SEQ_NUM")
	private Long seqNum;
	@Column(name = "SIGN_IN_DTTM")
	private Long signInDttm;
	@Column(name = "SIGN_IN_DT_STR")
	private String singnInDtStr;
	@Column(name = "SIGN_IN_POINT")
	private Long signInPoint;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(Long seqNum) {
		this.seqNum = seqNum;
	}
	public Long getSignInDttm() {
		return signInDttm;
	}
	public void setSignInDttm(Long signInDttm) {
		this.signInDttm = signInDttm;
	}
	public String getSingnInDtStr() {
		return singnInDtStr;
	}
	public void setSingnInDtStr(String singnInDtStr) {
		this.singnInDtStr = singnInDtStr;
	}
	public Long getSignInPoint() {
		return signInPoint;
	}
	public void setSignInPoint(Long signInPoint) {
		this.signInPoint = signInPoint;
	}
	
	
	
	
	

}

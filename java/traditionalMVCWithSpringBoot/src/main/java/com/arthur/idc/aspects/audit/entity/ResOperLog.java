package com.arthur.idc.aspects.audit.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="IDC_AUDIT_RESOPERLOG")
public class ResOperLog {

	
	public static final String Field_OperTime = "operTime";
	public static final String Field_OperType = "operType";
	public static final String Field_CsuId = "csuId";
	
	public static final String Field_ObjId = "objId";
	public static final String Field_ObjName = "objName";
	public static final String Field_ObjType = "objType";
	
	private Long operId = 0l;
	private Long operTime = 0l;
	private String operTimeStr = "";
	private String operType = "";
	
	private String operObj = "";
	private String operMethod = "";
	
	private Long objId = 0l;
	private String objName = "";
	private String objType = "";
	private Long csuId = 0l;
	
	private String operSnapshot= "";
	
	
	private List<ResOperPara> paraList;

	
	@Id
	@Column(name="OPER_ID")
	public Long getOperId() {
		return operId;
	}

	@Column(name="OPER_TIME")
	public Long getOperTime() {
		return operTime;
	}

	@Column(name="OPER_TIME_STR")
	public String getOperTimeStr() {
		return operTimeStr;
	}

	@Column(name="OPER_TYPE")
	public String getOperType() {
		return operType;
	}

	@Column(name="OPER_OBJ")
	public String getOperObj() {
		return operObj;
	}

	@Column(name="OPER_METHOD")
	public String getOperMethod() {
		return operMethod;
	}

	@Column(name="OBJ_ID")
	public Long getObjId() {
		return objId;
	}

	@Column(name="OBJ_NAME")
	public String getObjName() {
		return objName;
	}

	@Column(name="OBJ_TYPE")
	public String getObjType() {
		return objType;
	}

	@Column(name="CSUID")
	public Long getCsuId() {
		return csuId;
	}

	@Column(name="OPER_SNAPSHOT")
	public String getOperSnapshot() {
		return operSnapshot;
	}

	public void setOperId(Long operId) {
		this.operId = operId;
	}

	public void setOperTime(Long operTime) {
		this.operTime = operTime;
	}

	public void setOperTimeStr(String operTimeStr) {
		this.operTimeStr = operTimeStr;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}

	public void setOperObj(String operObj) {
		this.operObj = operObj;
	}

	public void setOperMethod(String operMethod) {
		this.operMethod = operMethod;
	}

	public void setObjId(Long objId) {
		this.objId = objId;
	}

	public void setObjName(String objName) {
		this.objName = objName;
	}

	public void setObjType(String objType) {
		this.objType = objType;
	}

	public void setCsuId(Long csuId) {
		this.csuId = csuId;
	}

	public void setOperSnapshot(String operSnapshot) {
		this.operSnapshot = operSnapshot;
	}

	public List<ResOperPara> getParaList() {
		return paraList;
	}

	public void setParaList(List<ResOperPara> paraList) {
		this.paraList = paraList;
	}
	
	
	public void addPara(ResOperPara para){
		if(paraList == null){
			paraList = new ArrayList<ResOperPara>();
		}
		paraList.add(para);
	}

	public void addParas(List<ResOperPara> paras){
		if(paraList == null){
			paraList = new ArrayList<ResOperPara>();
		}
		paraList.addAll(paras);
	}
	
	
	
}

package com.arthur.idc.aspects.audit.entity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name="IDC_AUDIT_RESOPER_PARA")
public class ResOperPara {

	public static final String Field_OperId = "operId";
	public static final String Field_ParaName = "paraName";
	
	
	private Long operId = 0l;
	private String paraName = "";
    private String strValue = "";
    
    
    public ResOperPara(){
    	
    }
    
    public ResOperPara(Long operId,String paraName,String strValue){
    	this.operId = operId;
    	this.paraName = paraName;
    	this.strValue = strValue;
    }
    
	
    @Column(name="OPER_ID")
    public Long getOperId() {
		return operId;
	}
    @Column(name="PARA_NAME")
	public String getParaName() {
		return paraName;
	}
    @Column(name="STR_VALUE")
	public String getStrValue() {
		return strValue;
	}
	
    public void setOperId(Long accessId) {
		this.operId = accessId;
	}
	public void setParaName(String paraName) {
		this.paraName = paraName;
	}
	public void setStrValue(String strValue) {
		this.strValue = strValue;
	}
}

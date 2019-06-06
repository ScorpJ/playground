package com.arthur.idc.ipm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="APP_RES_IPSEGMENT")
public class IpSegment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "SEGMENT_ID")
	private Long segmentId = 0l;
	@Column(name = "DOMAIN_CODE")
	private String domainCode = "";
	@Column(name = "NAME")
	private String name = "";
	@Column(name="ALIAS")
	private String alias ="";
	@Column(name = "MASK")
	private String mask ="";
	@Column(name = "MASK_BIT")
	private Long maskBit =0l;
	@Column(name = "START_IP")
	private String startIp ="";
	@Column(name = "END_IP")
	private String endIp ="";
	@Column(name = "START_LONGVALUE")
	private Long startLongvalue =0l;
	@Column(name = "END_LONGVALUE")
	private Long endLongvalue =0l;
	@Column(name = "BUSSTYPE_CODE")
	private String busstypeCode = "";
	@Column(name = "USER_NAME")
	private String userName = "";
	@Column(name = "DESCR")
	private String descr = "";
	@Column(name = "ATTACH_TYPE")
	private Long attachType = 1l;
	@Column(name = "OWNER_ID")
	private long ownerId = 0l;
	@Column(name = "CREATE_TIME")
	private String createTime = "";
	@Column(name = "USED_IP_NUM")
	public Integer usedIpNum = 0;


	private Long assignedAmount = 0l;
	private Long usedAmount = 0l;
	private Long consumedAmount = 0l;
	private Long idleAmount = 0l;
	private Long amountSubNet = 0l;
	private Integer realUsedIpNum = 0;
	

	
	public Long getSegmentId() {
		return segmentId;
	}
	
	public String getDomainCode() {
		return domainCode;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCreateTime() {
		return createTime;
	}
	
	public String getMask() {
		return mask;
	}
	
	public Long getMaskBit() {
		return maskBit;
	}
	
	public String getStartIp() {
		return startIp;
	}
	
	public String getEndIp() {
		return endIp;
	}
	
	public Long getStartLongvalue() {
		return startLongvalue;
	}
	
	public Long getEndLongvalue() {
		return endLongvalue;
	}
	
	public String getBusstypeCode() {
		return busstypeCode;
	}
	
	public String getDescr() {
		return descr;
	}
	
	public Long getAttachType() {
		return attachType;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getAlias() {
		return alias;
	}
	
	public long getOwnerId() {
		return ownerId;
	}
	
	
	public Integer getUsedIpNum() {
		return usedIpNum;
	}
	
	
	
	public void setSegmentId(Long segmentId) {
		this.segmentId = segmentId;
	}
	public void setDomainCode(String domainCode) {
		this.domainCode = domainCode;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public void setStartIp(String startIp) {
		this.startIp = startIp;
	}
	public void setEndIp(String endIp) {
		this.endIp = endIp;
	}
	public void setStartLongvalue(Long startLongvalue) {
		this.startLongvalue = startLongvalue;
	}
	public void setEndLongvalue(Long endLongvalue) {
		this.endLongvalue = endLongvalue;
	}
	public void setBusstypeCode(String busstypeCode) {
		this.busstypeCode = busstypeCode;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public void setAttachType(Long attachType) {
		this.attachType = attachType;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public void setMask(String mask) {
		this.mask = mask;
	}
	public void setMaskBit(Long maskBit) {
		this.maskBit = maskBit;
	}


	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}
	public Long getIpAmount() {
		return this.getEndLongvalue()-this.getStartLongvalue()+1;
	}
	public Long getUsedAmount() {
		return usedAmount;
	}
	public void setUsedAmount(Long useCount) {
		this.usedAmount = useCount;
	}
	public Long getAssignedAmount() {
		return assignedAmount;
	}
	public void setAssignedAmount(Long assignCount) {
		this.assignedAmount = assignCount;
	}
	public Long getAmountSubNet() {
		return amountSubNet;
	}
	public void setAmountSubNet(Long amountSubNet) {
		this.amountSubNet = amountSubNet;
	}
	public Long getConsumedAmount() {
		return consumedAmount;
	}
	public void setConsumedAmount(Long consumeAmount) {
		this.consumedAmount = consumeAmount;
	}
	public Long getIdleAmount() {
		return idleAmount;
	}
	public void setIdleAmount(Long idleAmount) {
		this.idleAmount = idleAmount;
	}
	
	public void setUsedIpNum(Integer usedIpNum) {
		this.usedIpNum = usedIpNum;
	}
	public Integer getRealUsedIpNum() {
		return realUsedIpNum;
	}
	public void setRealUsedIpNum(Integer realUsedIpNum) {
		this.realUsedIpNum = realUsedIpNum;
	}
	

}

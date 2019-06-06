package com.arthur.idc.ipm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APP_RES_IP")
public class IpAddress {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name = "ID")
	private Long id = 0l;
	@Column(name = "SEGMENT_ID")
	private Long segmentId = 0l;
//	@Column(name = "IP")
	private String ip = "";
//	@Column(name = "MASK")
	private String mask = "";
	private String gateway = "";
	@Column(name = "IP_LONGVALUE")
	private Long ipLongvalue = 0l;
	//IP类型： 0：网络地址；1：广播地址；2：网关地址；3：其它地址；4：接口地址 IpManageConsts
	private Long type = 3l;
	//分配类型:按段1/零散0  IpManageConsts
	@Column(name = "ASSIGN_TYPE")
	private Long assignType = 1l;
	//分配状态位 0未分配/1已分配/2预留/3保留   IpManageConsts
	private Long assigned = 0l;
	//使用状态位   0未使用/1已使用 IpManageConsts
	private Long flag = 0l;
	//归属类型:局方/客户
	@Column(name = "ATTACH_TYPE")
	private Long attachType = 0l;
	//用户归属时的所有者用户的Id,对应
	@Column(name = "OWNER_ID")
	private Long ownerId = 0l;
	//内部资源ID,关联分配到该IP的用户
	private Long csuId = 0l;
	//占用该Ip资源的资源Id(网络设备,主机)
	@Column(name = "USERES_ID")
	private Long useResId = 0l;

	//使用该Ip资源信息,冗余字段,便于查询展示
	private String useRes = "";
	//分得该IP的用户名,冗余字段,便于查询展示
	@Column(name = "USER_NAME")
	private String userName = "";
	@Column(name = "ASSIGN_TIME")
	private String assignTime = "";
	private String descr = "";
	@Column(name = "BUSSTYPE_CODE")
	private String busstypeCode = "";
	private String lastModified = "";
	
	//对应的IP备案记录ID
//	private Long ipFiledId = 0l;
	//子网对应的Vlan信息，记录在网络号上
	@Column(name = "VLAN")
	private String vlan = "";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSegmentId() {
		return segmentId;
	}

	public void setSegmentId(Long segmentId) {
		this.segmentId = segmentId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public Long getIpLongvalue() {
		return ipLongvalue;
	}

	public void setIpLongvalue(Long ipLongvalue) {
		this.ipLongvalue = ipLongvalue;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Long getAssignType() {
		return assignType;
	}

	public void setAssignType(Long assignType) {
		this.assignType = assignType;
	}

	public Long getAssigned() {
		return assigned;
	}

	public void setAssigned(Long assigned) {
		this.assigned = assigned;
	}

	public Long getFlag() {
		return flag;
	}

	public void setFlag(Long flag) {
		this.flag = flag;
	}

	public Long getAttachType() {
		return attachType;
	}

	public void setAttachType(Long attachType) {
		this.attachType = attachType;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Long getCsuId() {
		return csuId;
	}

	public void setCsuId(Long csuId) {
		this.csuId = csuId;
	}

	public Long getUseResId() {
		return useResId;
	}

	public void setUseResId(Long useResId) {
		this.useResId = useResId;
	}

	public String getUseRes() {
		return useRes;
	}

	public void setUseRes(String useRes) {
		this.useRes = useRes;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAssignTime() {
		return assignTime;
	}

	public void setAssignTime(String assignTime) {
		this.assignTime = assignTime;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getBusstypeCode() {
		return busstypeCode;
	}

	public void setBusstypeCode(String busstypeCode) {
		this.busstypeCode = busstypeCode;
	}

	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	public String getVlan() {
		return vlan;
	}

	public void setVlan(String vlan) {
		this.vlan = vlan;
	}
	
	
	
	
	
	

}

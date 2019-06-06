package com.arthur.idc.ipm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.arthur.idc.ipm.domain.IpAddress;

public interface IpAddressRepository extends CrudRepository<IpAddress, Long> {
	
	
	public List<IpAddress> findIpAddressBySegmentId(Long segmentId);

}

package com.arthur.idc.ipm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arthur.idc.ipm.domain.IpAddress;
import com.arthur.idc.ipm.repository.IpAddressRepository;
import com.arthur.idc.ipm.repository.IpSegmentRepository;

@RestController
@RequestMapping("/api/ipres")
public class IpRestController {
	
	@Autowired
	private IpSegmentRepository ipSegmentRepository;
	@Autowired
	private IpAddressRepository ipAddressRepository;
	
	public void setIpSegmentRepository(IpSegmentRepository ipSegmentRepository) {
		this.ipSegmentRepository = ipSegmentRepository;
	}
	public void setIpAddressRepository(IpAddressRepository ipAddressRepository) {
		this.ipAddressRepository = ipAddressRepository;
	}
	
	
	@RequestMapping(value="/segments/{segmentId}",method=RequestMethod.GET)
	public  ResponseEntity<List<IpAddress>> getCourseInJson2(@PathVariable Long segmentId){		
		List<IpAddress> ips = ipAddressRepository.findIpAddressBySegmentId(segmentId);
		return new ResponseEntity<List<IpAddress>>(ips, HttpStatus.OK);
	}
	

}

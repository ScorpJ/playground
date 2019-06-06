package com.arthur.mvcdemo.service;

import org.springframework.stereotype.Service;

import com.arthur.mvcdemo.domain.Course;

@Service
public interface CourseService {
	
	
	Course getCoursebyId(Integer courseId);
	

	
	

}

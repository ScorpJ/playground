package com.arthur.redisstudy.credits.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arthur.redisstudy.credits.domain.CreditHeader;

public interface CreditHeaderRepository extends JpaRepository<CreditHeader, Long>{
	
	
	Optional<CreditHeader> findByUserId(Long userId);
	
	

}

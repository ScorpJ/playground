package com.arthur.ms.usercredit.repository;

import java.util.Optional;

import com.arthur.ms.usercredit.domain.CreditHeader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditHeaderRepository extends JpaRepository<CreditHeader, Long> {

    Optional<CreditHeader> findByUserId(Long userId);


}

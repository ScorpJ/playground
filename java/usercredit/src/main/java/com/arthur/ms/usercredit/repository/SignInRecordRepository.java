package com.arthur.ms.usercredit.repository;

import java.util.Optional;

import com.arthur.ms.usercredit.domain.SignInRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SignInRecordRepository extends JpaRepository<SignInRecord, Long> {


    @Query("SELECT t FROM SignInRecord t WHERE t.userId = :userId and t.seqNum = (SELECT max(t2.seqNum) FROM SignInRecord t2 WHERE t2.userId = :userId)")
    Optional<SignInRecord> getLastSignInRecord(@Param("userId") Long userId);
}

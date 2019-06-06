package com.arthur.redisstudy.credits.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.arthur.redisstudy.credits.domain.CreditLine;

public interface CreditLineRepository extends JpaRepository<CreditLine, Long> {

	@Query(value = "SELECT SUM(l.creditPoint) FROM CreditLine l where l.userId = :userId and changeType = :changeType and changeOnDtStr = :changeOnDtStr ")
	Long sumUserPointsOfSpeicalDayByChangeType(@Param("userId") Long userId, @Param("changeType") String changeType,
			@Param("changeOnDtStr") String changeOnDtStr);

	List<CreditLine> findByUserIdAndChangeType(Long userId, String changeType);
}

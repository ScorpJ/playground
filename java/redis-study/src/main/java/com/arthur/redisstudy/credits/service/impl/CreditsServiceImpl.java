package com.arthur.redisstudy.credits.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthur.redisstudy.credits.domain.CreditLine;
import com.arthur.redisstudy.credits.domain.CreditHeader;
import com.arthur.redisstudy.credits.repository.CreditLineRepository;
import com.arthur.redisstudy.credits.repository.CreditHeaderRepository;
import com.arthur.redisstudy.credits.service.CreditsService;
import com.arthur.redisstudy.credits.utils.CreditsConstant;
import com.arthur.redisstudy.credits.utils.DateTimeStrUtil;

@Service("creditsService")
public class CreditsServiceImpl implements CreditsService {

	@Autowired
	private CreditHeaderRepository creditHeaderRepository;
	@Autowired
	private CreditLineRepository creditChangeLineRepository;

	@Override
	public Long getUserCreditsBalance(Long userId) {
		Optional<CreditHeader> creditHdr = creditHeaderRepository.findByUserId(userId);
		if (creditHdr.isPresent()) {
			return creditHdr.get().getBalance();
		} else {
			return 0l;
		}
	}

	@Override
	public Long getEarningsOfToday(Long userId) {
		String changeOnDtStr = DateTimeStrUtil.getCurrentDateOnlyStr();
		return creditChangeLineRepository.sumUserPointsOfSpeicalDayByChangeType(userId,
				CreditsConstant.CREDITS_CHANGETYPE_EARNINGS, changeOnDtStr);
	}

	@Override
	public List<CreditLine> getEarningLines(Long userId) {
		return creditChangeLineRepository.findByUserIdAndChangeType(userId, CreditsConstant.CREDITS_CHANGETYPE_EARNINGS);
	}

	@Override
	public List<CreditLine> getConsumingLines(Long userId) {
		return creditChangeLineRepository.findByUserIdAndChangeType(userId, CreditsConstant.CREDITS_CHANGETYPE_CONSUMINGS);
	}

}

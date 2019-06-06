package com.arthur.ms.usercredit.service;

import java.util.List;

import com.arthur.ms.usercredit.domain.CreditLine;

public interface CreditsService {

    Long getUserCreditsBalance(Long userId);

    Long getEarningsOfToday(Long userId);

    /* Need to Pagination*/
    List<CreditLine> getEarningLines(Long userId);

    /* Need to Pagination*/
    List<CreditLine> getConsumingLines(Long userId);


}

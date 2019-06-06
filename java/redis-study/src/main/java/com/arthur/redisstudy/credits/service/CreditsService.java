package com.arthur.redisstudy.credits.service;

import java.util.List;

import com.arthur.redisstudy.credits.domain.CreditLine;

public interface CreditsService {
	
    public Long getUserCreditsBalance(Long userId);
    
    public Long getEarningsOfToday(Long userId);
    
    /* Need to Pagination*/
    public List<CreditLine> getEarningLines(Long userId); 
    
    /* Need to Pagination*/
    public List<CreditLine> getConsumingLines(Long userId); 
    
    

}

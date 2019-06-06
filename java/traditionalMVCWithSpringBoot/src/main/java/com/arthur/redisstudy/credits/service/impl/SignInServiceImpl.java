package com.arthur.redisstudy.credits.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthur.redisstudy.credits.domain.SignInRecord;
import com.arthur.redisstudy.credits.repository.SignInRecordRepository;
import com.arthur.redisstudy.credits.service.SignInService;
import com.arthur.redisstudy.credits.utils.DateTimeStrUtil;

@Service("signInService")
public class SignInServiceImpl implements SignInService {
	
	private static final Long MAX_SIGNIN_POINT_INUCCESSION = 5l;

	@Autowired
	private SignInRecordRepository signInRecordRepository;

	public void setSignInRecordRepository(SignInRecordRepository signInRecordRepository) {
		this.signInRecordRepository = signInRecordRepository;
	}

	@Override
	public Long signIn(Long userId) {
		

		SignInRecord lastSignIn;
		SignInRecord curSignIn = new SignInRecord();
		Long curSignPoint = 0l;

		curSignIn.setUserId(userId);
		curSignIn.setSignInDttm(System.currentTimeMillis());
		curSignIn.setSingnInDtStr(DateTimeStrUtil.convertDttm2DateOnlyStr(curSignIn.getSignInDttm()));
		
		
		Optional<SignInRecord> lastSignRecOpt = signInRecordRepository.getLastSignInRecord(userId);

		if (!lastSignRecOpt.isPresent()) {
			curSignPoint = 1l;
		} else {
			lastSignIn = lastSignRecOpt.get();
			if (lastSignIn.getSingnInDtStr().equals(curSignIn.getSingnInDtStr())) {
				/* User has signed today */
				curSignPoint = 0l;
			} else {
				if (curSignIn.getSignInDttm().longValue()
						- lastSignIn.getSignInDttm().longValue() > DateTimeStrUtil.ONE_DAY_MILLSEC) {
                   /* Not SignIn in succession  */
					curSignPoint = 1L;
				}else{
					curSignPoint =  lastSignIn.getSignInPoint().longValue() + 1;
					if(curSignPoint.longValue() > MAX_SIGNIN_POINT_INUCCESSION.longValue()){
						curSignPoint = MAX_SIGNIN_POINT_INUCCESSION;
					}
				}
			}
		}

		if (Long.valueOf(0l).equals(curSignPoint)) {
			return curSignPoint;
		} else {
			curSignIn.setSignInPoint(curSignPoint);
			curSignIn = signInRecordRepository.save(curSignIn);

			return curSignIn.getSignInPoint();
		}

	}

}
